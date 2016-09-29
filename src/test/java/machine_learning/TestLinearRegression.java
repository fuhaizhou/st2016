package machine_learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLinearRegression {

    @Test
    public void test1() {
        double [][] exampleMatrix = {{1, 2104, 5, 1, 45},
            {1, 1416, 3, 2, 40},
            {1, 1534, 3, 2, 30},
            {1, 852, 2, 1, 36},
            {1, 3000, 4, 1, 38}};
        double [] labelVector = {460, 232, 315, 178, 540};
        double [] thetaVector = LinearRegression.gradientDescent(exampleMatrix, labelVector);
        Assert.assertEquals(thetaVector, new double[]{1.0, 2.0});
    }
}
