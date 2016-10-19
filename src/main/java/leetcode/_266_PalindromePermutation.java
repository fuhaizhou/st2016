package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class _266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> cntMap = new HashMap<>(s.length());
        int oddCnt = 0;
        int evenCnt = 0;
        for(char c : s.toCharArray()) {
            if(!cntMap.containsKey(c)) {
                cntMap.put(c, 1);
                oddCnt++;
            } else {
                int cnt = cntMap.get(c);
                cntMap.put(c, cnt + 1);
                if(cnt % 2 == 0) {
                    evenCnt--;
                    oddCnt++;
                } else {
                    evenCnt++;
                    oddCnt--;
                }
            }
        }
        return oddCnt <= 1;
    }
}
