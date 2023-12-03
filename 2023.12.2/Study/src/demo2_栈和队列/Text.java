package demo2_栈和队列;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-02
 * Time: 22:15
 */

import java.util.*;

/** https://leetcode.cn/problems/min-stack/ 力扣 151 最小栈
 * * @author xiaoxie
 * @date 2023年12月02日 22:15
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    public void push(int val) {
        stack.push(val);
        if(minstack.empty()) {
            minstack.push(val);
        }else {
            if(minstack.peek() >= val) {
                minstack.push(val);
            }
        }
    }

    public void pop() {
        int temp = stack.pop();
        if(temp == minstack.peek()) {
            minstack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
/*
 * 队列表示栈 https://leetcode.cn/problems/implement-stack-using-queues/description/ 力扣 225
 * @author xiaoxie
 * @date 2023/12/2 23:25
 * @param null
 * @return null
 */

class MyStack1 {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if(empty()) {
            q1.offer(x);
            return;
        }else{
            if(!q1.isEmpty()) {
                q1.offer(x);
            } else {
                q2.offer(x);
            }
        }
    }
    public int pop() {
        if(empty()) {
            return -1;
        }else {
            if(!q1.isEmpty()) {
                int size = q1.size();
                for(int i = 0;i < size-1; i++) {
                    q2.offer(q1.poll());
                }
                return q1.poll();
            } else {
                int size = q2.size();
                for(int i = 0;i < size-1; i++) {
                    q1.offer(q2.poll());
                }
                return q2.poll();
            }
        }
    }

    public int top() {
        if(empty()) {
            return -1;
        }int temp = -1;
        int size2;
        if(!q1.isEmpty()) {
            size2 = q1.size();
            for(int i = 0; i < size2;i++) {
                temp = q1.poll();
                q2.offer(temp);
            }
        }else {
            size2 = q2.size();
            for(int i = 0;i < size2; i++) {
                temp = q2.poll();
                q1.offer(temp);
            }
        }
        return temp;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
/*
 * 栈
 * @author xiaoxie
 * @date 2023/12/3 20:11
 * @param https://leetcode.cn/problems/valid-parentheses/ 力扣 20 有效的括号
 * @return null
 */
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            if(!stack.isEmpty()) {
                char ch2 = stack.peek();
                if((ch2 == '('&& ch == ')')||( ch2 == '['&& ch == ']') ||( ch2 == '{' && ch == '}')) {
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
/*
 * 栈
 * @author xiaoxie
 * @date 2023/12/3 21:01
 * @param https://leetcode.cn/problems/evaluate-reverse-polish-notation/ 力扣 150 逆波兰表达式求值
 * @return null
 */
class Solution1 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if(!isnum(str)){
                int val = Integer.valueOf(str);
                stack.push(val);
            }else {

                int s1 = stack.pop();
                int s2 = stack.pop();
                switch(str) {
                    case "+":
                        stack.push(s1+s2);
                        break;
                    case "-":
                        stack.push(s2-s1);
                        break;
                    case "*":
                        stack.push(s2 * s1);
                        break;
                    case "/":
                        stack.push(s2 / s1);
                        break;
                }
            }
        }
        return stack.pop();
    }
    private boolean isnum(String ch) {
        if(ch.equals("+") || ch.equals("-") ||ch.equals("*")|| ch.equals("/")) {
            return true;
        }
        return false;
    }
    /*
     * 栈
     * @author xiaoxie
     * @date 2023/12/3 21:30
     * @param 牛客 JZ31 栈的压入、弹出序列
     * @return null
     */
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]);
            while(!stack.empty()&&j < popV.length && stack.peek() == popV[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
public class Text {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(11);
        s.push(12);
        s.push(13);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s1 = new Stack<>();
        Solution s2 = new Solution();
        String p = "()";
        System.out.println(s2.isValid(p));

    }
}
