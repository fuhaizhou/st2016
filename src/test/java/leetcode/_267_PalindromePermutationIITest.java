package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _267_PalindromePermutationIITest {

    _267_PalindromePermutationII solution = new _267_PalindromePermutationII();

    @Test
    public void testPermutation() {
        int [][] array = {{'1',1}, {'2',1}, {'3',1}, {'4',1}, {'5',1}};
        List<String> permutations = solution.permute(array, -1);
        Assert.assertEquals(permutations.size(), 120);

        array = new int[][]{{'1',3}, {'2', 1}};
        permutations = solution.permute(array, -1);
        Assert.assertEquals(permutations.size(), 4);
    }

    @Test
    public void testGeneratePalindromes() {
        List<String> perms = solution.generatePalindromes("aabb");
        Assert.assertEquals(perms.size(), 2);

        perms = solution.generatePalindromes("a");
        Assert.assertEquals(perms.size(), 1);
    }
}
