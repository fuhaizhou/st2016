package leetcode;


import leetcode._258_AddDigit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _258_AddDigitTest {

    _258_AddDigit solution = new _258_AddDigit();

    @Test
    public void test() {
        Assert.assertEquals(solution.addDigits(1), 1);
        Assert.assertEquals(solution.addDigits(11), 2);
        Assert.assertEquals(solution.addDigits(99), 9);
        Assert.assertEquals(solution.addDigits(100), 1);
        Assert.assertEquals(solution.addDigits(123456789), 9);
        Assert.assertEquals(solution.addDigits(1999999999), 1);
    }

    @Test
    public void testPattern() {
        Assert.assertEquals(solution.addDigitsPattern(1), 1);
        Assert.assertEquals(solution.addDigitsPattern(11), 2);
        Assert.assertEquals(solution.addDigitsPattern(99), 9);
        Assert.assertEquals(solution.addDigitsPattern(100), 1);
        Assert.assertEquals(solution.addDigitsPattern(123456789), 9);
        Assert.assertEquals(solution.addDigitsPattern(1999999999), 1);
    }
}
