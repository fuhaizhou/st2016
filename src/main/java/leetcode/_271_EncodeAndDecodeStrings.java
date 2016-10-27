package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *     string encode(vector<string> strs) {
 *         // ... your code
 *         return encoded_string;
 *     }
 *
 * Machine 2 (receiver) has the function:
 *     vector<string> decode(string s) {
 *         //... your code
 *         return strs;
 *     }
 *
 * So Machine 1 does:
 *     string encoded_string = encode(strs);
 *
 * and Machine 2 does:
 *     vector<string> strs2 = decode(encoded_string);
 *
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * Note:
 * The string may contain any possible characters out of 256 valid ascii characters.
 * Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states.
 * Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods.
 * You should implement your own encode/decode algorithm.
 */
public class _271_EncodeAndDecodeStrings {

    public _271_EncodeAndDecodeStrings() {}

    public class Codec {

        public Codec() {}

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for(String str : strs) {
                int len = str.length();
                String lenStr = len + "";
                sb.append(len);
                int lenOfLen = lenStr.length();
                for(int i = 0; i < 10 - lenOfLen; i++)
                    sb.append(" ");
                sb.append(str);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            if(s.length() == 0)
                return Collections.emptyList();

            List<String> strs = new ArrayList<>();
            int cur = 0;
            while(cur < s.length()) {
                String lenStr = s.substring(cur, cur + 10);
                lenStr = lenStr.trim();
                int len = Integer.valueOf(lenStr);
                cur += 10;
                String str = s.substring(cur, cur + len);
                strs.add(str);
                cur += len;
            }
            return strs;
        }
    }
}


