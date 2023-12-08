package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-08
 * Time: 9:36
 */

import static java.lang.Integer.MAX_VALUE;

/** 滑动窗口(第一次尝试困难题)
 *
 * * @author xiaoxie
 * @date 2023年12月08日 9:36
 */
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(),m = t.length();
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            window[c]++;
        }
        int fast = 0,slow = 0,minLen = Integer.MAX_VALUE,minStart = 0,same = m;
        while(fast < n) {
            if(window[s.charAt(fast++)] -- > 0) {
                same--;
            }
            while(same == 0) {
                if(fast - slow < minLen) {
                    minLen = fast - slow;
                    minStart = slow;
                }
                if(window[s.charAt(slow++)]++ == 0) {
                    same++;

                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "":s.substring(minStart,minStart+minLen);
    }
}
public class Text {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.minWindow("acbbaca","aba");
        System.out.println(s1);
    }
}
