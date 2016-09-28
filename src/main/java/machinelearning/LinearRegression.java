package machinelearning;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class LinearRegression {

    private static final StandardDeviation standardDeviation = new StandardDeviation();
    private static final Mean mean = new Mean();

    private static final double ALPHA = 0.01;

    List<Double> scaleFeature(double [] featureVector) {
        final double meanVal = mean.evaluate(featureVector);
        final double stdVal = standardDeviation.evaluate(featureVector, meanVal);
        List<Double> list =  DoubleStream.of(featureVector)
            .map(x -> (x - meanVal) / stdVal)
            .boxed()
            .collect(Collectors.toList());
        return list;
    }

    double descent(int index, double [] T, double [][] M, double [] Y) {
        if(M.length != Y.length)
            throw new RuntimeException("Size of the example and the output has to be the same!");

        if(M[0].length != T.length)
            throw new RuntimeException("Size of the theta vector and the dimension of the output has to be the same!");

        double theta = T[index];
        double sum = 0;
        for(int i = 0; i < M.length; i++) {
            double [] X = M[i]; // ith example
            double y = Y[i]; // ith actual output

            double yHead = IntStream.range(0, X.length)
                .parallel()
                .mapToDouble(j -> T[j] * X[j])
                .sum();
            sum += (yHead - y) * X[index];
        }
        double avg = sum / M.length;
        return theta - ALPHA * avg;
    }

    double [] gradientDescent(double [] T, double [][] M, double [] Y) {

        boolean isConverged = false;
        while(!isConverged) {
            final double [] t = T;
            double[] newT = IntStream.range(0, T.length)
                .parallel()
                .mapToDouble(i -> descent(i, t, M, Y))
                .toArray();
            isConverged = isConverged(T, newT);
            T = newT;
        }
        return T;
    }

    boolean isConverged(double [] T, double [] newT) {
        for(int i = 0; i < T.length; i++) {
            if(Math.abs(newT[i] - T[i]) > ALPHA)
                return false;
        }
        return true;
    }
}
