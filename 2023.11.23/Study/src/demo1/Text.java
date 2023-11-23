package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-23
 * Time: 19:01
 */

import java.util.*;

/**
 * @author xiaoxie
 * @date 2023年11月23日 19:01
 */
class Solution {
    /*
     * 力扣刷题之字符串和哈希表
     * @author xiaoxie
     * @date 2023/11/23 19:04
     * @param https://leetcode.cn/problems/html-entity-parser/ 力扣 1410 HTML解析器
     * @return null
     */
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        int n = text.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == '&') {
                int j = i + 1;
                while (j < n && text.charAt(j) != ';')
                    j++;
                String s = text.substring(i, j + 1 < n ? j + 1 : n);
                if (map.containsKey(s)) {
                    sb.append(map.get(s));
                    i = j;
                    continue;
                }
            }
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }
}
class Solution1 {
    /*
     * 二分查找的灵活运用
     * @author xiaoxie
     * @date 2023/11/23 22:17
     * @param https://leetcode.cn/problems/count-the-number-of-fair-pairs/ 力扣的 2563 统计公平数对的数目
     * @return null
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        return LowerRound(nums,upper) - LowerRound(nums,lower+1);
    }
    private int LowerRound(int[] nums,int target) {
        int l = 0;
        int r = nums.length;
        int ans = 0;
        while(l < r) {
            if(nums[l] + nums[r] <= target) {
                ans += r-l;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

}
class Solution2 {
    /*
     * 消失的数字
     * @author xiaoxie
     * @date 2023/11/23 22:49
     * @param https://leetcode.cn/problems/missing-number-lcci/  面试 17.04.消失的数字
     * @return null
     */
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int missNum = -1;
        for(int i = 0;i < nums.length;i++) {
            if(!set.contains(i)) {
                missNum = i;
                break;
            }
        }
        return missNum;
    }
}

public class Text {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "&amp; is an HTML entity but &ambassador; is not.";
        //System.out.println(s.entityParser(str));
        Solution1 s1 = new Solution1();
        int[] nums = {0};
        int a = 3;
        int b = 6;
        //s1.countFairPairs(nums,a,b);
        Solution2 s2 = new Solution2();
        System.out.println(s2.missingNumber(nums));

    }
}
