package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-10
 * Time: 19:14
 */

import java.util.*;

/**
 * 力扣刷题 https://leetcode.cn/problems/invert-binary-tree/ 226 翻转二叉树
 * @author xiaoxie
 * @date 2023/12/10 19:15
 * @param
 * @return null
 */
 class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
         this.right = right;
      }
  }
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
/**
 * 力扣刷题 https://leetcode.cn/problems/valid-anagram/ 242. 有效的字母异位词
 * @author xiaoxie
 * @date 2023/12/10 19:15
 * @param
 * @return null
 */
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() != t.length()) return false;
        int[] hanum = new int[27];
        for(char ch : s.toCharArray()) {
            hanum[ch-'a']++;
        }
        for(int i = 0;i < t.length();i++) {
            hanum[t.charAt(i)-'a']--;
        }
        for (int count : hanum) {
            if(count != 0) return false;
        }
        return true;
    }
}
/**
 * 力扣刷题 https://leetcode.cn/problems/ransom-note/ 383. 赎金信
 * @author xiaoxie
 * @date 2023/12/10 19:15
 * @param
 * @return null
 */
class Solution3 {
    public boolean canConstruct(String r, String m) {
        if(m.length() < r.length() || m.length() == 0) return false;
        int[] hanum = new int[27];
        for(char ch : m.toCharArray()) {
            hanum[ch-'a']++;
        }
        for(char ch : r.toCharArray()) {
            hanum[ch-'a']--;
        }
        for(int count : hanum) {
            if(count < 0) return false;
        }
        return true;
    }
}
/**
 * 力扣刷题 https://leetcode.cn/problems/group-anagrams/ 49. 字母异位词分组
 * @author xiaoxie
 * @date 2023/12/10 19:15
 * @param
 * @return null
 */
class Solution4 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap和ArrayList应用题，排序+哈希表
        // map<单词排序后的key, 同一key的的单词集合>，遍历一次strs即可，不过每个单词仍不可避免要遍历每个字符，  O(n*maxlen*logmaxlen)
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            // 将每个单词转化为字符数组，排序后得到该单词的key
            char[] chr = str.toCharArray();
            Arrays.sort(chr);
            String key = new String(chr);
            // map的key对应value存储key相同的原始单词列表list，取出list，若没有当前单词的key则创建空list
            List<String> list = map.getOrDefault(key, new ArrayList());
            // 将当前单词加入list，并将key和更新后的list压入map
            list.add(str);
            map.put(key, list);
        }
        // 遍历完成后，map中已经存储了所有单词，获取map中所有value的list集合（相当于按key分好list组），构建List<list>
        return new ArrayList<List<String>>(map.values());
    }
}
/**
 * 力扣刷题 https://leetcode.cn/problems/find-all-anagrams-in-a-string/ 438 找到字符串中所有字母异位词
 * @author xiaoxie
 * @date 2023/12/10 19:15
 * @param
 * @return null
 */
class Solution5 {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null || s.length() < p.length()) return new ArrayList<Integer>();
        int[] hanum = new int[27];
        for(char ch : p.toCharArray()) {
            hanum[ch-'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for(int slow = 0,fast = 0;fast < s.length();++fast) {
            --hanum[s.charAt(fast)-'a'];
            while(hanum[s.charAt(fast)-'a'] < 0) {
                ++hanum[s.charAt(slow++)-'a'];
            }
            if(fast-slow+1 == p.length()) {
                list.add(slow);
            }
        }
        return list;
    }
}
/**
 * 力扣刷题 https://leetcode.cn/problems/intersection-of-two-arrays/ 349. 两个数组的交集
 * @author xiaoxie
 * @date 2023/12/10 19:15
 * @param
 * @return null
 */
class Solution6 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[]{};
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            if(set1.contains(i)){
                set2.add(i);
            }
        }
        int[] arr = new int[set2.size()];
        int j=0;
        for(int i:set2){
            arr[j++] = i;
        }
        return arr;
    }
}

public class Text {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        String strings1 = "cbaebabacd";
        String  strings2 = "abc";
        s.findAnagrams(strings1,strings2);

    }
}
