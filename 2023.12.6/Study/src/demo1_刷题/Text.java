package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-06
 * Time: 16:01
 * 因为生病发烧的原因，头很疼，今天先休息。
 */

import static java.lang.Integer.MAX_VALUE;

/** 字符串相加以及不考虑正负数的情况
 * * @author xiaoxie
 * @date 2023年12月06日 16:01
 */

class Solution {
    public String addStrings(String num1, String num2) {
        boolean isNegative1 = num1.charAt(0) == '-';
        boolean isNegative2 = num2.charAt(0) == '-';
        // 去掉负号
        num1 = isNegative1 ? num1.substring(1) : num1;
        num2 = isNegative2 ? num2.substring(1) : num2;
        //去除正号
        boolean isNegative3 = num1.charAt(0) == '+';
        boolean isNegative4 = num2.charAt(0) == '+';
        num1 = isNegative3 ? num1.substring(1) : num1;
        num2 = isNegative4 ? num2.substring(1) : num2;

        boolean isNegativeResult = false;
        if ((isNegative1 && !isNegative2) || (!isNegative1 && isNegative2)) {
            // 如果两个数的符号不同，则结果的符号与数值大的那个相同
            if (isNegative1) {
                return subtract(num2, num1);
            } else {
                return subtract(num1, num2);
            }
        } else if (isNegative1 && isNegative2) {
            // 如果两个数都是负数，则结果的符号为负
            isNegativeResult = true;
        }

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
        }

        if (carry > 0) {
            result.append(carry);
        }

        return (isNegativeResult ? "-" : "") + result.reverse().toString();
    }

    private String subtract(String num1, String num2) {
        if(num1.equals(num2)) {
            return "0";
        }
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        int result = n1-n2;
        return Integer.toString(result);
    }
}
/** 二叉树的创建
 * * @author xiaoxie
 * @date 2023年12月06日 16:01
 */
class BinaryTree {
    static class BNode {
        BNode left;
        BNode right;
        char val;

        public BNode(char val) {
            this.val = val;
        }
    }
    private BNode root;
    public BNode CreateTree() {
        BNode node1 = new BNode('A');
        BNode node2 = new BNode('B');
        BNode node3 = new BNode('C');
        BNode node4 = new BNode('D');
        BNode node5 = new BNode('E');
        BNode node6 = new BNode('F');
        BNode node7 = new BNode('G');

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        return node1;
    }
    //先序遍历
    public void  preOrder(BNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    public void  inOrder(BNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    //后序遍历
    public void postOrder(BNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

}
/** 双指针（滑动窗口）
 * 力扣 https://leetcode.cn/problems/fruit-into-baskets/ 904 水果成篮
 * * @author xiaoxie
 * @date 2023年12月06日 16:01
 */
class Solution1 {
    public int totalFruit(int[] fruits) {
        int[] window = new int[fruits.length];
        int star = 0,end = 0,same = 0,max = 0;
        //窗口只可以有两个元素
        while ( end < fruits.length ) {
            if(++window[fruits[end++]] == 1) {
                same++;
            }
            while(same > 2) {
                if(--window[fruits[star++]] == 0) {
                    same--;
                }
            }
           max = Math.max(max,end-star);
        }
        return max;
    }
}

public class Text {
    public static void main(String[] args) {
      BinaryTree b = new BinaryTree();
      BinaryTree.BNode r = b.CreateTree();
      b.preOrder(r);
      System.out.println();
      b.inOrder(r);
      System.out.println();
      b.postOrder(r);
      Solution1 s = new Solution1();
      int[] num = {1,2,1};
        System.out.println(s.totalFruit(num));

    }
}
