package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 */
public class _267_PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> cntMap = new HashMap<>(s.length());
        for(char c : s.toCharArray()) {
            if(!cntMap.containsKey(c)) {
                cntMap.put(c, 1);
            } else {
                int cnt = cntMap.get(c);
                cntMap.put(c, cnt + 1);
            }
        }
        int odd = 0;
        int [][] alphabet = new int[cntMap.size()][2];
        int i = 0;
        char center = 0;
        for(Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            char c = entry.getKey();
            int cnt = entry.getValue();
            if(cnt % 2 == 1) {
                if(odd == 1)
                    return Collections.emptyList();
                odd++;
                center = c;
            }
            alphabet[i][0] = c;
            alphabet[i][1] = cnt / 2;
            i++;
        }

        List<String> permutations = permute(alphabet, -1);
        List<String> palindromes = new ArrayList<>(permutations.size() + odd % 2);
        if(permutations.isEmpty() && odd == 1) {
            palindromes.add(center + "");
            return palindromes;
        }

        for(String perm : permutations) {
            String reverse = new StringBuilder(perm).reverse().toString();
            if(odd == 1)
                palindromes.add(perm + center + reverse);
            else
                palindromes.add(perm + reverse);
        }
        return palindromes;
    }

    List<String> permute(int [][] alphabet, int prev) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < alphabet.length; i++) {
            char c = (char)alphabet[i][0];
            if(c == prev)
                continue;
            int cnt = alphabet[i][1];
            if(cnt == 0)
                continue;
            String s = "";
            List<String> resultWithStartingC = new ArrayList<>();
            for(int j = 0; j < cnt; j++) {
                alphabet[i][1]--;
                s += c;
                List<String> perms = permute(alphabet, c);
                if(perms.isEmpty() && alphabet[i][1] == 0) {
                    resultWithStartingC.add(s);
                } else {
                    for (String perm : perms) {
                        resultWithStartingC.add(s + perm);
                    }
                }
            }
            alphabet[i][1] = cnt;
            result.addAll(resultWithStartingC);
        }
        return result;
    }
}
