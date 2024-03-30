package LeetCode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-29
 * Time: 11:24
 */

import java.util.ArrayList;
import java.util.List;

/**  递归,dfs,回溯,剪枝问题专题
 * * @author xiaoxie
 * @date 2024年03月29日 11:24
 */
 class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}
public class LeetCode {
    /** 面试题 08.06. 汉诺塔问题
     * https://leetcode.cn/problems/hanota-lcci/description/
     * @author xiaoxie
     * @date 2024/3/29 16:16
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        dfs(A,B,C,A.size());
    }
    public void dfs(List<Integer> A, List<Integer> B, List<Integer> C,int n) {
        if(n == 1) {
            C.add(A.remove(A.size()-1));
            return;
        }
        dfs(A,C,B,n-1);
        C.add(A.remove(A.size()-1));
        dfs(B,A,C,n-1);
    }
    /** 21. 合并两个有序链表
     *  https://leetcode.cn/problems/merge-two-sorted-lists/description/
     *  使用递归
     * @author xiaoxie
     * @date 2024/3/29 19:50
     * @param list1
     * @param list2
     * @return LeetCode.ListNode
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1,list2.next);
        return list2;
    }
    /** LCR 024. 反转链表
     * https://leetcode.cn/problems/UHnkqh/description/
     * 递归
     * @author xiaoxie
     * @date 2024/3/29 20:32
     * @param head
     * @return LeetCode.ListNode
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        //找到最后一个节点
        ListNode newhead =  reverseList(head.next);
        //修改指针变量;
        head.next.next =  head;
        head.next = null;
        return newhead;
    }
    /**24. 两两交换链表中的节点
     * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
     * 递归
     * @author xiaoxie 
     * @date 2024/3/29 20:51
     * @param head 
     * @return LeetCode.ListNode 
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tmp = swapPairs(head.next.next);
        ListNode newhead = head.next;
        newhead .next = head;
        head.next = tmp;
        return newhead;
    }
    /** 257. 二叉树的所有路径
     * https://leetcode.cn/problems/binary-tree-paths/description/
     * 全局变量 + 回溯(恢复现场) + 剪枝
     * @author xiaoxie
     * @date 2024/3/30 20:50
     * @param null
     * @return null
     */
    List<String> ret;
    public List<String> binaryTreePaths(TreeNode root) {
        ret = new ArrayList<>();
        dfs(root,new StringBuilder());
        return ret;
    }
    public void dfs(TreeNode root, StringBuilder pathSb) {
        //回溯的恢复现场的关键
        StringBuilder path = new StringBuilder(pathSb);
        path.append(Integer.toString(root.val));
        if(root.left == null && root.right == null) {
            ret.add(path.toString());
            return;
        }
        path.append("->");
        //剪枝
        if(root.left != null)  dfs(root.left,path);
        if(root.right!= null) dfs(root.right,path);
    }
    List<List<Integer>> ret1;
    List<Integer> path2;
    boolean[] check;//剪枝
    /** 46. 全排列
     * https://leetcode.cn/problems/permutations/description/
     * dfs  + 回溯 + 剪枝 + 全局变量
     * @author xiaoxie
     * @date 2024/3/30 21:40
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        path2 = new ArrayList<>();
        check = new boolean[nums.length];
        dfs(nums);
        return ret1;
    }
    public void dfs(int[] nums) {
        if(path2.size() == nums.length) {
            ret1.add(new ArrayList<>(path2));
            return;
        }
        for(int i = 0; i < nums.length;i++) {
            //剪枝
            if(check[i] == false) {
                path2.add(nums[i]);
                check[i] = true;
                dfs(nums);
                //回溯
                path2.remove(path2.size()-1);
                check[i] = false;
            }
        }
    }
    List<List<Integer>> ret3;
    List<Integer> path3;
    /** 78. 子集
     * https://leetcode.cn/problems/subsets/description/
     * @author xiaoxie
     * @date 2024/3/30 22:42
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> subsets(int[] nums) {
        ret3 = new ArrayList<>();
        path3 = new ArrayList<>();
        dfs(nums,0);
        return ret3;
    }
    /** 解法二:即根据子集的元素个数来dfs
     * @author xiaoxie
     * @date 2024/3/30 22:42
     * @param nums
     * @param post
     */
    public void dfs(int[] nums,int post) {
        ret3.add(new ArrayList<>(path3));
        if(post == nums.length) {
            return;
        }
        for(int i = post;i < nums.length; i++) {
            path3.add(nums[i]);
            dfs(nums,i + 1);
            path3.remove(path3.size() - 1);//恢复现场
        }
    }
    /** 解法一:枚举每一个数,看他是选还是不选,最后把叶子节点返回给ret
     *  类似与前序遍历
     *  解法二优于解法一
     * @author xiaoxie
     * @date 2024/3/30 22:48
     * @param nums
     * @param post
     */
    public void dfs1(int[] nums,int post) {
        if(post == nums.length) {
            ret3.add(new ArrayList<>(path3));
            return;
        }
        //选
        path3.add(nums[post]);
        dfs(nums,post + 1);
        //恢复现场
        path3.remove(path3.size() - 1);
        //不选
        dfs(nums,post + 1);
    }
    /** 1863. 找出所有子集的异或总和再求和
     *  https://leetcode.cn/problems/sum-of-all-subset-xor-totals/description/
     *  回溯
     * @author xiaoxie
     * @date 2024/3/30 23:20
     * @param null
     * @return null
     */
    int path;
    int sum;
    public int subsetXORSum(int[] nums) {
        dfs3(nums,0);
        return sum;
    }
    public void dfs3(int[] nums,int post) {
        sum += path;
        for(int i = post;i < nums.length;i++) {
            path ^= nums[i];
            dfs(nums,i + 1);
            //恢复现场 异或操作的消消乐操作
            path ^= nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LeetCode l = new LeetCode();
        l.permute(nums);
    }
}
