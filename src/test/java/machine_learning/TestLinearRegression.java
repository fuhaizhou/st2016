package machine_learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLinearRegression {

    @Test
    public void test1() {
        double [][] exampleMatrix =
            {{1, 2104, 5, 1, 45},
             {1, 1416, 3, 2, 40},
             {1, 1534, 3, 2, 30},
             {1, 852, 2, 1, 36},
             {1, 3000, 4, 1, 38}};
        double [] labelVector = {460, 232, 315, 178, 540};
        double [] thetaVector = LinearRegression.gradientDescent(exampleMatrix, labelVector);
        double [][] labelVectorCol = {{460}, {232}, {315}, {178}, {540}};
        double [] thetaVectorNE = LinearRegression.normalEquation(exampleMatrix, labelVectorCol);
        double cost1 = LinearRegression.costFunction(thetaVector, exampleMatrix, labelVector);
        double cost2 = LinearRegression.costFunction(thetaVectorNE, exampleMatrix, labelVector);
        //Assert.assertEquals(thetaVector, new double[]{1.0, 2.0});
    }

    @Test
    public void test2() {
        double [][] exampleMatrix =
            {{1, 2104, 3},
                {1, 1600, 3},
                {1, 2400, 3},
                {1, 1416, 2},
                {1, 3000, 4},
                {1, 1985, 4},
                {1, 1534, 3},
                {1, 1427, 3},
                {1, 1380, 3},
                {1, 1494, 3}};
        double [] labelVector = {399900,
            329900,
            369000,
            232000,
            539900,
            299900,
            314900,
            198999,
            212000,
            242500};
        double [] thetaVector = LinearRegression.gradientDescent(exampleMatrix, labelVector);
        double [][] labelVectorCol = {{399900},
            {329900},
            {369000},
            {232000},
            {539900},
            {299900},
            {314900},
            {198999},
            {212000},
            {242500}};
        double [] thetaVectorNE = LinearRegression.normalEquation(exampleMatrix, labelVectorCol);
        double cost1 = LinearRegression.costFunction(thetaVector, exampleMatrix, labelVector);
        double cost2 = LinearRegression.costFunction(thetaVectorNE, exampleMatrix, labelVector);
    }

    @Test
    public void testCostFunction() {
        double [][] exampleMatrix =
            {{1, 3},
             {1, 2},
             {1, 4},
             {1, 0}};
        double [] labelVector = {4, 1, 3, 1};
        double [] thetaVector = {0, 1};
        double cost = LinearRegression.costFunction(thetaVector, exampleMatrix, labelVector);
        Assert.assertEquals(cost, 0.5);
    }
}
