package demo;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-20
 * Time: 19:17
 */

import java.util.*;

/** * @author xiaoxie
 * @date 2024年01月20日 19:17
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
 /** * @author xiaoxie
  * 使用非递归的方法中序遍历
  * @date 2024年01月20日 19:17
  * 力扣刷题 https://leetcode.cn/problems/binary-tree-inorder-traversal/ 94. 二叉树的中序遍历
  */
 class Solution {
     public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<>();
         TreeNode cur = root;
         Stack<TreeNode> stack = new Stack<>();
         while(cur != null || !stack.isEmpty()){
             while(cur != null) {
                 stack.push(cur);
                 cur = cur.left;
             }
             TreeNode top = stack.pop();
             list.add(top.val);
             cur = top.right;
         }
         return list;
     }
 }
/** * @author xiaoxie
 * 使用非递归的方法后序遍历
 * @date 2024年01月20日 19:17
 * 力扣刷题 https://leetcode.cn/problems/binary-tree-postorder-traversal/ 145. 二叉树的后序遍历
 */
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || ! stack.isEmpty()) {
            while(cur!= null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();//左孩子为空————左子树遍历完成，弹出根节点
            if(cur.right == null ||cur.right == prev) {//如果右孩子为空或者右孩子已经遍历过了
                list.add(cur.val);//右孩子为空，输出根节点
                prev = cur;//标记
                cur = null;//cur重新置为空，防止死循环
            }else {//右孩子不为空
                stack.push(cur);
                cur = cur.right;
            }
        }
        return list;
    }
}
/** * @author xiaoxie
 * 使用非递归的方法后序遍历
 * @date 2024年01月20日 19:17
 * 力扣刷题 https://leetcode.cn/problems/construct-string-from-binary-tree/ 606. 根据二叉树创建字符串
 */
class Solution3 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(root,sb);
        return sb.toString();
    }
    private void tree2strChild(TreeNode root,StringBuilder sb) {
        if(root == null) {
            return;
        }
        sb.append(root.val);
        //先递归左树
        if(root.left!=null) {
            sb.append("(");
            tree2strChild(root.left,sb);
            sb.append(")");
        }else {//如果左树为空的话
            if(root.right != null) {
                sb.append("()");
            }else {
                return;
            }
        }
        //递归右树
        if(root.right != null) {
            sb.append("(");
            tree2strChild(root.right,sb);
            sb.append(")");
        }
    }
}
/** * @author xiaoxie
 * 使用非递归的方法前序遍历
 * @date 2024年01月20日 19:17
 * 力扣刷题 https://leetcode.cn/problems/binary-tree-preorder-traversal/ 144.二叉树的前序遍历
 */
class Solution4{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }
}
/** * @author xiaoxie
 * 使用快慢指针来判断
 * @date 2024年01月20日 19:17
 * 力扣刷题
 * 参考英文网站热评第一。这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
 * 如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
 * 两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
 */
class Solution5 {
    public boolean isHappy(int n) {
        int slow = n,fast = getSum(n);
        while(slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
            if(slow == 1) break;
        }
        return slow == 1;
    }
    private int getSum(int n) {
        int temp = 0,sum = 0;
        while(n > 0) {
            temp = n % 10;
            sum += temp*temp;
            n/=10;
        }
        return sum;
    }
}
/** * @author xiaoxie
 * 利用优先级队列来解
 * @date 2024年01月20日 19:17
 * 力扣刷题 https://leetcode.cn/problems/smallest-k-lcci/description/ 面试题 17.14. 最小K个数
 */
class comparator1 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
class Solution6 {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if(k == 0) return res;
        comparator1 comparator = new comparator1();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        for(int i = 0;i < k;i++) {
            priorityQueue.offer(arr[i]);
        }
        int end = k;
        while(end < arr.length) {
            int tmp = priorityQueue.peek();
            if(arr[end] < tmp) {
                priorityQueue.poll();
                priorityQueue.offer(arr[end]);
            }
            end++;
        }
        for(int i = 0;i < k;i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}
public class Text {
    public static void main(String[] args) {

    }
}
