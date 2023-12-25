package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-25
 * Time: 21:40
 */

import java.lang.reflect.Array;
import java.util.*;

/** 因为hashset 有自动去重的功能所以使用hashset 的方法来解
 * 力扣刷题 https://leetcode.cn/problems/intersection-of-two-arrays/ 349.两个数组的交集
 * * @author xiaoxie
 * @date 2023年12月25日 21:40
 */
class Solution1{
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> commonNumSet = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                commonNumSet.add(num);
            }
        }
        return commonNumSet.stream().mapToInt(Integer::valueOf).toArray();
    }
}
/** 哈希数组来解这题用空间换时间
 * 力扣刷题 https://leetcode.cn/problems/intersection-of-two-arrays/ 349.两个数组的交集
 * * @author xiaoxie
 * @date 2023年12月25日 21:40
 */
class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] flags = new boolean[1001];
        List<Integer> temp = new ArrayList<>();
        for (int i : nums1) {
            flags[i] = true;
        }
        for (int i : nums2) {
            if (flags[i]) {
                flags[i] = false;
                temp.add(i);
            }
        }
        int[] ans = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}
/** 使用排序加双指针来解
 * 力扣刷题 https://leetcode.cn/problems/intersection-of-two-arrays/ 349.两个数组的交集
 * * @author xiaoxie
 * @date 2023年12月25日 21:40
 */
class Solution3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] ans = new int[length1 + length2];
        int index = 0,index1 = 0,index2 = 0;
        while (index1 < length1 && index2 < length2) {
            if(nums1[index1] == nums2[index]) {
                if(index == 0 || nums1[index1] != ans[index-1]) {
                    ans[index++] = nums1[index1];
                }
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            }else {
                index1++;
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }
}
/** 使用简单的递归来解 时间复杂度为O(n) 对于面试来说不够
 * 力扣刷题 https://leetcode.cn/problems/count-complete-tree-nodes/ 222.完全二叉树的节点个数
 * * @author xiaoxie
 * @date 2023年12月25日 21:40
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
class Solution4 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
/** 完全二叉树的定义：它是一棵空树或者它的叶子节点只出在最后两层，若最后一层不满则叶子节点只在最左侧。
 * 满二叉的节点个数怎么计算，如果满二叉树的层数为h，则总节点数为：2^h - 1.
 * 那么我们来对 root 节点的左右子树进行高度统计，分别记为 left 和 right，有以下两种结果：
 * left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。
 * 所以左子树的节点总数我们可以直接得到，是 2^left - 1，加上当前这个 root 节点，则正好是 2^left。再对右子树进行递归统计。
 * left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。
 * 同理，右子树节点 +root 节点，总数为 2^right。再对左子树进行递归查找。
 * 二分查找 + 位运算 时间复杂度为（log2n）这个方法才可以达到面试的要求
 * 力扣刷题 https://leetcode.cn/problems/count-complete-tree-nodes/ 222.完全二叉树的节点个数
 * * @author xiaoxie
 * @date 2023年12月25日 21:40
 */
class Solution5 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1<<left);
        }else{
            return countNodes(root.left) + (1<<right);
        }
    }
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
/** 力扣官解
 * 二分查找 + 位运算 时间复杂度为（log2n）这个方法才可以达到面试的要求
 * 力扣刷题 https://leetcode.cn/problems/count-complete-tree-nodes/ 222.完全二叉树的节点个数
 * * @author xiaoxie
 * @date 2023年12月25日 21:40
*/
class Solution6 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
public class Text {
    public static void main(String[] args) {

    }
}
