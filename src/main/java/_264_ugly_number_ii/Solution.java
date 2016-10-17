package _264_ugly_number_ii;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */
public class Solution {
    public int nthUglyNumberOneHeap(int n) {

        Queue<Integer> heap = new PriorityQueue<>();
        heap.offer(1);
        Set<Integer> visited = new HashSet<>(n);

        int top = 1;
        for(int i = 0; i < n; i++) {
            top = heap.poll();
            int two = top * 2;
            if(Integer.MAX_VALUE / top >= 2 && !visited.contains(two)) {
                heap.offer(two);
                visited.add(two);
            }
            int three = top * 3;
            if(Integer.MAX_VALUE / top >= 3 && !visited.contains(three)) {
                heap.offer(three);
                visited.add(three);
            }
            int five = top * 5;
            if(Integer.MAX_VALUE / top >= 5 && !visited.contains(five)) {
                heap.offer(five);
                visited.add(five);
            }
        }
        return top;
    }

    public int nthUglyNumber(int n) {

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; i++) {
            // generate ugly number by multiply all the factors
            uglyNumbers[i] = Math.min(uglyNumbers[index2] * 2, Math.min(uglyNumbers[index3] * 3, uglyNumbers[index5] * 5));

            // bump up index for the current minimum ugly number
            if (uglyNumbers[i] == uglyNumbers[index2] * 2) index2++;
            if (uglyNumbers[i] == uglyNumbers[index3] * 3) index3++;
            if (uglyNumbers[i] == uglyNumbers[index5] * 5) index5++;
        }

        return uglyNumbers[n - 1];
    }
}
