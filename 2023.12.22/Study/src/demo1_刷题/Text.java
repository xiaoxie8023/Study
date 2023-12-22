package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-22
 * Time: 19:44
 */

import java.util.Stack;

/** 力扣刷题  https://leetcode.cn/problems/intersection-of-two-linked-lists/ 160.相交链表
 * 使用快慢指针
 * * @author xiaoxie
 * @date 2023年12月22日 19:44
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
  }
 class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizea = size(headA),sizeb = size(headB);
        if(sizeb > sizea) {
            return getIntersectionNode( headB, headA);
        }
        int n = sizea - sizeb;
        ListNode fast = headA;
        ListNode slow = headB;
        for(int i = 0; i < n;i++) {
            fast = fast.next;
        }
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        if(fast == slow) return fast;
        return null;
    }
    private int size(ListNode i) {
        int len = 0;
        while(i != null) {
            len++;
            i = i.next;
        }
        return len;
    }
}
/** 力扣刷题 https://leetcode.cn/problems/score-of-parentheses/ 856.括号里的分数
 * 使用栈
 * * @author xiaoxie
 * @date 2023年12月22日 19:44
 */
class Solution1 {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        int x=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(0);
            }else {
                //如果和上一个刚好组成一个括号，弹出左括号0，存1；
                if (stack.peek()==0){
                    stack.pop();
                    stack.push(1);
                }else {
                    //不能和上一个组成括号的话，把里面的值加起来再弹出左括号。再把里面的值乘2压入
                    while(!stack.empty()&&stack.peek()!=0){
                        x+=stack.pop();
                    }
                    stack.pop();
                    stack.push(x*2);
                    x=0;
                }
            }
        }
        //最后把栈里的值加起来就是答案
        while(!stack.empty()&&stack.peek()!=-1){
            res+=stack.pop();
        }
        return res;
    }
}
/** 力扣刷题 https://leetcode.cn/problems/score-of-parentheses/ 856.括号里的分数
 * 借鉴别人的 (()(())) = (()) + ((())) , 且  分数 = 2^(层数-1)
 * 出现 '(' 代表层数+1 ， 出现 ')' 代表层数 -1
 * * @author xiaoxie
 * @date 2023年12月22日 19:44
 */
class Solution2 {
    public int scoreOfParentheses(String s) {
        int deep=0,ans=0;
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i] == '(') {
                deep++;
            } else deep--;
            if(ch[i]==')' &&ch[i-1]=='(')
                ans += 1 << deep;
        }
        return ans;
    }
}
class Solution3 {
    public int scoreOfParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(0);
            }else {
                int score = stack.pop();
                stack.push(stack.pop()+Math.max(score *2,1));
            }
        }
        return stack.peek();
    }
}
public class Text {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        s.scoreOfParentheses("(()(()))");
    }
}
