package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color 0;
 * costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Find the minimum cost to paint all houses.
 *
 * Note: All costs are positive integers.
 *
 * Follow up:  Could you solve it in O(nk) runtime?
 */
public class _265_PaintHouseII {
    public int minCostII(int[][] costs) {

        if(costs.length == 0)
            return 0;

        if(costs[0].length == 0)
            return Integer.MAX_VALUE;

        if(costs.length == 1 && costs[0].length == 1)
            return costs[0][0];

        MinTwo minTwo = new MinTwo();
        for(int i = 0; i < costs[0].length; i++) {
            minTwo.add(costs[0][i]);
        }

        for(int i = 1; i < costs.length; i++) {
            MinTwo curMinTwo = new MinTwo();
            int first = minTwo.first();
            int second = minTwo.second();
            for(int j = 0; j < costs[i].length; j++) {
                if(costs[i - 1][j] == first)
                    costs[i][j] += second;
                else
                    costs[i][j] += first;
                curMinTwo.add(costs[i][j]);
            }

            minTwo = curMinTwo;
        }
        return minTwo.first();
    }

    class MinTwo {
        List<Integer> two;

        MinTwo() {
            two = new ArrayList<>();
        }

        void add(int x) {
            if(two.size() < 2) {
                two.add(x);
                return;
            }

            if(x > two.get(0) && x > two.get(1))
                return;

            two.set(0, Math.min(two.get(0), two.get(1)));
            two.set(1, x);
        }

        int first() {
            return Math.min(two.get(0), two.get(1));
        }

        int second() {
            return Math.max(two.get(0), two.get(1));
        }
    }
}
