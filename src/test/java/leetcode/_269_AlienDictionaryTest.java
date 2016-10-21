package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _269_AlienDictionaryTest {
    _269_AlienDictionary solution = new _269_AlienDictionary();

    @Test
    public void test() {
        String [] strs = {"wrt", "wrf", "er", "ett", "rftt"};
        String s = solution.alienOrder(strs);
        Assert.assertEquals(s, "wertf");
    }

    @Test
    public void test2() {
        String [] strs = {"a", "a", "a"};
        String s = solution.alienOrder(strs);
        Assert.assertEquals(s, "a");
    }

    @Test
    public void test3() {
        String [] strs = {"za", "z"};
        String s = solution.alienOrder(strs);
        Assert.assertEquals(s, "");
    }

    @Test
    public void test4() {
        String [] strs = {"a", "az"};
        String s = solution.alienOrder(strs);
        Assert.assertEquals(s, "az");
    }

    @Test
    public void test5() {
        String [] strs = {"za","zb","ca","cb"};
        String s = solution.alienOrder(strs);
        Assert.assertEquals(s, "azbc");
    }

    @Test
    public void test6() {
        String [] strs = {"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        String s = solution.alienOrder(strs);
        Assert.assertEquals(s, "");
    }

    @Test
    public void test7() {
        String [] strs = {"abcdefg"};
        String s = solution.alienOrder(strs);
        Assert.assertEquals(s, "cdfaebg");
    }
}
