package machine_learning;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class LinearRegression {

    private static final StandardDeviation standardDeviation = new StandardDeviation();
    private static final Mean mean = new Mean();

    private static final double ALPHA = 0.0001;

    static double [] scaleFeature(double [] featureVector) {
        final double meanVal = mean.evaluate(featureVector);
        final double stdVal = standardDeviation.evaluate(featureVector, meanVal);
        return DoubleStream.of(featureVector)
            .map(x -> stdVal < 0.00000001 ? x : (x - meanVal) / stdVal)
            .toArray();
    }

    static double [][] scaleExamples(double [][] exampleMatrix) {
        RealMatrix rm = new Array2DRowRealMatrix(exampleMatrix);
        RealMatrix scaledRM = new Array2DRowRealMatrix(exampleMatrix.length, exampleMatrix[0].length);
        for(int i = 0; i < exampleMatrix[0].length; i++) {
            double [] col = rm.getColumn(i);
            double [] scaledCol = scaleFeature(col);
            scaledRM.setColumn(i, scaledCol);
        }
        return scaledRM.getData();
    }

    static double descent(int ithDimension, double [] thetaVector, double [][] exampleMatrix, double [] labelVector) {
        if(exampleMatrix.length != labelVector.length)
            throw new RuntimeException("Size of the example and the label has to be the same!");

        if(exampleMatrix[0].length != thetaVector.length)
            throw new RuntimeException("Size of the theta vector and the dimension of the output has to be the same!");

        double theta = thetaVector[ithDimension];
        double sum = 0;
        for(int i = 0; i < exampleMatrix.length; i++) {
            double [] ithExampleVector = exampleMatrix[i]; // ith example
            double ithLabel = labelVector[i]; // ith actual output

            double yHead = IntStream.range(0, ithExampleVector.length)
                .parallel()
                .mapToDouble(j -> thetaVector[j] * ithExampleVector[j])
                .sum();
            sum += (yHead - ithLabel) * ithExampleVector[ithDimension];
        }
        double avg = sum / exampleMatrix.length;
        return theta - ALPHA * avg;
    }

    public static double [] gradientDescent(double [][] exampleMatrix, double [] labelVector) {

        final double [][] scaledExampleMatrix = scaleExamples(exampleMatrix);
        boolean isConverged = false;
        double [] thetaVector = new double[exampleMatrix[0].length];
        while(!isConverged) {
            final double [] finalThetaVectorCopy = thetaVector;
            double[] newThetaVector = IntStream.range(0, thetaVector.length)
                .parallel()
                .mapToDouble(i -> descent(i, finalThetaVectorCopy, scaledExampleMatrix, labelVector))
                .toArray();
            isConverged = isConverged(thetaVector, newThetaVector);
            thetaVector = newThetaVector;
        }
        return thetaVector;
    }

    static boolean isConverged(double [] T, double [] newT) {
        for(int i = 0; i < T.length; i++) {
            if(Math.abs(newT[i] - T[i]) > ALPHA)
                return false;
        }
        return true;
    }
}
