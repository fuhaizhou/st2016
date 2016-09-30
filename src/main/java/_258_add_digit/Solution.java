package _258_add_digit;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
   For example:
    Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

   Follow up:
    Could you do it without any loop/recursion in O(1) runtime?
 */
public class Solution {
    public int addDigits(int num) {
        // max number: 2147483647  -- 10 digits
        // max sum: 1999999999 -> 82, so at most 2 digit
        // max sum for 2 digit: 79: still two digit
        // max sum for it 16: two digit
        // max sum: 7: one digit

        num = num / 1000000000
            + num % 1000000000 / 100000000
            + num % 100000000 / 10000000
            + num % 10000000 / 1000000
            + num % 1000000 / 100000
            + num % 100000 / 10000
            + num % 10000 / 1000
            + num % 1000 / 100
            + num % 100 / 10
            + num % 10;

        num = num / 10 + num % 10;
        num = num / 10 + num % 10;

        return num;
    }

    public int addDigitsPattern(int num) {
//        We can find regular pattern by enumerate following case:
//        1=1; 2=2; 3=3; 4=4; 5=5; 6=6; 7=7; 8=8; 9=9;
//        10=1; 11=2; 12=3; 13=4; 14=5; 15=6; 16=7; 17=8; 18=9;
//        19=1; 20=2; 21=3; 22=4; 23=5; 24=6; 25=7; 26=8; 27=9;
//        ... ...
//        so, we supposed that the rule is a cycle per 9 number.
//            the math formulation:

       return (num - 1) % 9 + 1;
    }
}
