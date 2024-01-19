package demo1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-19
 * Time: 15:18
 */

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
/** * @author xiaoxie
 * @date 2024年01月19日 15:18
 * 力扣刷题 https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/ 236. 二叉树的最近公共祖先
 */
//使用递归的方法
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left =  lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}
//使用链表的形式来写
class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        getway(root,p,s1);
        getway(root,q,s2);
        int len1 = s1.size();
        int len2 = s2.size();
        for(int i = 0;i < Math.abs(len1-len2);i++) {
            if(len1 > len2) {
                s1.pop();
            }else {
                s2.pop();
            }
        }
        while(len1 > 0) {
            if(s1.peek() == s2.peek()) {
                return s1.pop();
            }
            s1.pop();
            s2.pop();
        }
        return null;
    }
    private boolean getway(TreeNode root,TreeNode target,Stack<TreeNode> stack) {
        if(root == null) return false;
        stack.push(root);
        if(root == target) return true;
        boolean left = getway(root.left,target,stack);
        if(left) return true;
        boolean right = getway(root.right,target,stack);
        if(right) return true;
        stack.pop();
        return false;
    }
}
/** * @author xiaoxie
 * @date 2024年01月19日 15:18
 * 判断一棵树是不是完全二叉树
 */
 class SSolution2 {
    public boolean isTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean end = false;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur == null) {
                end = true;
            }else {
                if(end) {
                        return false;
                    }
                }
            q.offer(root.left);
            q.offer(root.right);
        }
        return true;
    }
 }
/** * @author xiaoxie
 * @date 2024年01月19日 15:18
 * 力扣刷题 https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ 105. 从前序与中序遍历序列构造二叉树
 */
class Solution3 {
    public int preindex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode buildTreeChild(int[]preorder,int[]inorder,int biger,int end) {
        if(biger > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preindex]);
        int rootindex = find(inorder,biger,end,preorder[preindex]);
        preindex++;
        root.left = buildTreeChild(preorder,inorder,biger,rootindex-1);
        root.right = buildTreeChild(preorder,inorder,rootindex+1,end);
        return root;
    }
    private int find(int[]arr,int biger,int end,int key) {
        for(int i = biger;i <= end;i++) {
            if(arr[i] == key) return i;
        }
        return -1;
    }
}
/** * @author xiaoxie
 * @date 2024年01月19日 15:18
 * 力扣刷题 https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 106. 从中序与后序遍历序列构造二叉树
 */
class Solution4 {
    public int postindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex = postorder.length-1;
        return buildTreepostChild(inorder,postorder,0,inorder.length-1);
    }
    private TreeNode buildTreepostChild(int[] inorder,int[] postorder,int beiger,int end) {
        if(beiger > end) return null;
        TreeNode root = new TreeNode(postorder[postindex]);
        int rootindex = findindex(inorder,beiger,end,postorder[postindex]);
        postindex--;
        root.right = buildTreepostChild(inorder,postorder,rootindex+1,end);
        root.left = buildTreepostChild(inorder,postorder,beiger,rootindex-1);
        return root;
    }
    private int findindex(int[]arr,int beiger,int end,int key) {
        for(int i = beiger;i <= end;i++) {
            if(arr[i] == key) return i;
        }
        return -1;
    }
}
/** * @author xiaoxie
 * @date 2024年01月19日 15:18
 * 力扣刷题 https://leetcode.cn/problems/remove-element/
 * 27.移除元素
 */
class Solution5 {
    public int removeElement(int[] nums, int val) {
        int star = 0,end = nums.length-1;
        while(star <= end) {
            if(nums[star] == val) {
                nums[star] = nums[end];
                end--;
            }
            else star++;
        }
        return star;
    }
}
public class Text {
    public static void main(String[] args) {
        /*Double o1 = true ? new Integer(1) : new Double(2.0);
        Object o2;
        if(true){
            o2 = new Integer(1);
        }else{
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);*/
        //System.out.println(14^3);
        //在Java中，对于byte、short和char类型的操作数，进行算术运算时会自动将它们提升为int类型
        /*byte a = 3;
        byte b = 6;
        b = a + b;*/
        //System.out.println(b);
    }
}
