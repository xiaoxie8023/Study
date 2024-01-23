package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-22
 * Time: 15:30
 */

import java.util.*;

/** * @author xiaoxie
 * @date 2024年01月22日 15:30
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();//打印的容器
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>(); //创建一个栈
        TreeNode cur = root;//用cur来遍历二叉树
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
        return list;
    }
}
/** * @author xiaoxie
 * @date 2024年01月22日 15:30
 * 通过借助队列的方法判断两棵树是否相同
 * 力扣刷题 https://leetcode.cn/problems/same-tree/ 100. 相同的树
 */
class Solution1{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if(p == null && q == null) continue;
            if((p == null || q == null) || p.val != q.val)
                return false;
            queue.offer(p.left);
            queue.offer(q.left);
            queue.offer(p.right);
            queue.offer(q.right);
        }
        return true;
    }
}
/** * @author xiaoxie
 * @date 2024年01月22日 15:30
 *  力扣刷题 https://leetcode.cn/problems/subtree-of-another-tree/description/ 572. 另一棵树的子树
 */
class Solution2 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSameTree(root,subRoot)) return true;//判断中是否相同
        if(isSubtree(root.left,subRoot.left)) return true;//判断左子树是否相同
        if(isSubtree(root.right,subRoot.right)) return true;//判断右子树是否相同
        return false;
    }
    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null && subRoot != null ||root != null && subRoot == null) return false;
        if(root.val != subRoot.val) return false;
        return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }
}

public class Text {
    public static void selectSort(int[] array) {
        for(int i = 0; i < array.length;i++) {
            int minIndex = i;
            for ( int j = i+1;j < array.length;j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }
    public static void selectSort2(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            int minIndex = left;
            int MaxIndex = right;
            int i = left + 1;
            while (i < right) {
                if(array[i] < array[minIndex]){
                    minIndex = i;
                }
                if(array[i] > array[MaxIndex]) {
                    MaxIndex = i;
                }
                i++;
            }
            swap(array,left,minIndex);
            swap(array,right,MaxIndex);
            left++;
            right--;
        }
    }
    public static void swap(int[] array,int i ,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
