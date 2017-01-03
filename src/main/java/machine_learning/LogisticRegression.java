package machine_learning;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.ejml.simple.SimpleMatrix;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class LogisticRegression {

    private static final StandardDeviation standardDeviation = new StandardDeviation();
    private static final Mean mean = new Mean();
    private static final Random random = new Random(System.currentTimeMillis());

    private static final double ALPHA = 0.00001;
    private static final double DELTA = 0.000001;

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

    static double descent(int ithDimension, double [] thetaVector, double [][] exampleMatrix, boolean [] labelVector) {

        double theta = thetaVector[ithDimension];
        double sum = IntStream.range(0, exampleMatrix.length)
            .parallel()
            .mapToDouble(i -> {
                double [] ithExampleVector = exampleMatrix[i]; // ith example
                double ithLabel = labelVector[i] ? 1.0 : 0.0; // ith actual output
                double yHead = hypothesis(thetaVector, ithExampleVector);
                return (yHead - ithLabel) * ithExampleVector[ithDimension];
            })
            .sum();

        return theta - ALPHA * sum;
    }

    public static double hypothesis(double [] thetaVector, double [] exampleVector) {
        double z = IntStream.range(0, exampleVector.length)
            .parallel()
            .mapToDouble(i -> thetaVector[i] * exampleVector[i])
            .sum();
        return 1 / (1 + Math.pow(Math.E, -z));
    }

    public static double costFunction(double [] thetaVector, double [][] exampleMatrix, boolean [] labelVector) {
        double totalSquareErrSum = 0;
        for(int i = 0; i < exampleMatrix.length; i++) {
            double [] ithExampleVector = exampleMatrix[i]; // ith example
            boolean ithLabel = labelVector[i]; // ith actual output
            double yHead = hypothesis(thetaVector, ithExampleVector);
            double err = ithLabel ? -Math.log(yHead) : -Math.log(1 - yHead);
            totalSquareErrSum += err;
        }
        return totalSquareErrSum / labelVector.length;
    }

    /**
     * Gradient Descent Algorithm
     * @param exampleMatrix
     * @param labelVector
     * @return
     */
    public static double [] gradientDescent(double [][] exampleMatrix, boolean [] labelVector) {
        if(exampleMatrix.length == 0)
            throw new RuntimeException("No examples as input!");

        if(exampleMatrix.length != labelVector.length)
            throw new RuntimeException("Size of the example and the dimension of the label vector has to be the same!");

        final double [][] scaledExampleMatrix = scaleExamples(exampleMatrix);

        double [] thetaVector = new double[exampleMatrix[0].length];
        for(int i = 0; i < thetaVector.length; i++)
            thetaVector[i] = random.nextDouble();
        double cost = costFunction(thetaVector, exampleMatrix, labelVector);
        while(true) {
            final double [] finalThetaVectorCopy = thetaVector;
            double[] newThetaVector = IntStream.range(0, thetaVector.length)
                .parallel()
                .mapToDouble(i -> descent(i, finalThetaVectorCopy, scaledExampleMatrix, labelVector))
                .toArray();
            double newCost = costFunction(newThetaVector, exampleMatrix, labelVector);
            if(cost - newCost < DELTA)
                break;
            cost = newCost;
            thetaVector = newThetaVector;
        }
        return thetaVector;
    }

    static boolean isConverged(double [] T, double [] newT) {
        for(int i = 0; i < T.length; i++) {
            if(Math.abs(newT[i] - T[i]) > 0.0001)
                return false;
        }
        return true;
    }

    /**
     * Normal equation
     * ((X^T)(X))^-1)(X^T)Y
     * @param exampleMatrix  (N + 1) * M matrix, where N is the number of features, M is the number of examples
     * @param labelVector  M * 1 matrix, where M is the number of examples
     * @return
     */
    public static double [] normalEquation(double [][] exampleMatrix, double [][] labelVector) {
        if(exampleMatrix.length == 0)
            throw new RuntimeException("No examples as input!");

        if(exampleMatrix.length != labelVector.length)
            throw new RuntimeException("Size of the example and the dimension of the label vector has to be the same!");

        if(1 != labelVector[0].length)
            throw new RuntimeException("The label vector has to be one column!");

        SimpleMatrix X = new SimpleMatrix(exampleMatrix);
        SimpleMatrix Y = new SimpleMatrix(labelVector);

        SimpleMatrix XT = X.transpose();
        SimpleMatrix theta = XT.mult(X).invert().mult(XT).mult(Y);
        return theta.getMatrix().getData();
    }
}
