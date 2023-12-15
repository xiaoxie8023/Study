/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-15
 * Time: 12:22
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/** * @author xiaoxie
 * @date 2023年12月15日 12:22
 */
//这是栈内存储Integer的模拟，当然栈是泛型，这里只是Integer的模拟
class MyStack {
    public int[] arr;
    public int size;
    public MyStack() {
     arr = new int[10];
    }
    //入栈
    public int push(int e) {
        ensureCapacity();
        arr[size++] = e;
        return e;
    }
    //判断栈是否满
    private void ensureCapacity() {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, size * 2);
        }
    }
    //栈顶元素
    public int peek() {
        if(empty()) {
            System.out.println("栈为空，无元素");
            return -1;
        }
        return arr[size-1];
    }
    //出栈
    public int pop() {
        if (empty()) {
            System.out.println("栈为空，无元素");
            return -1;
        }
        int tmp = peek();
        size--;
        return tmp;
    }
    //判断栈是否为空
    public boolean empty() {
        return this.size == 0;
    }

}
/** 用两个栈模拟实现最小栈
 * 力扣 155. 最小栈 https://leetcode.cn/problems/min-stack/
 * * @author xiaoxie
 * @date 2023年12月15日 12:22
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
        int tmp = stack.pop();
        if(tmp == minstack.peek()) {
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
/** 不用辅助栈模拟实现最小栈
 * 力扣 155. 最小栈 https://leetcode.cn/problems/min-stack/
 * * @author xiaoxie
 * @date 2023年12月15日 12:22
 */
class MinStack1 {
    // 记录每个元素与【未压入】该元素时栈中最小元素的差值
    LinkedList<Long> stack;
    // 当前【已压入】栈中元素的最小值
    private long min;
    public MinStack1() {
        stack = new LinkedList();
    }

    public void push(int val) {
        // 压入第一个元素
        if(stack.isEmpty()){
            min = val;
            stack.addFirst(0L);
            return;
        }
        // 栈不为空时，每次压入计算与min的差值后压入结果
        stack.push((long)val-min);
        // 更新min
        min = Math.min((long)val,min);
        // 上面两个语句是不能颠倒的！一定是先压入，在更新，因为min一定是当前栈中的最小值
    }

    public void pop() {
        long pop = stack.removeFirst();
        // 当弹出元素小于0时，说明弹出元素是当前栈中的最小值，要更新最小值
        if(pop<0){
            // 因为对于当前弹出的元素而言，计算压入栈中的值时，计算的是该元素与【未压入】该元素时
            // 栈中元素的最小值的差值，故弹出该元素后栈中的最小值就是未压入该元素时的最小值
            // 即当前元素的值（min）减去两者的差值
            long lastMin = min;
            min = lastMin - pop;
        }
        // 若大于等于0，不会对min有影响
    }

    public int top() {
        long peek = stack.peek();
        // 若当前栈顶小于等于0，说明最小值就是栈顶元素
        if(peek<=0) return (int)min;
        // 否则就是min+peek
        return (int)(min+peek);
    }

    public int getMin() {
        return (int)min;
    }
}
/** 栈实现队列
 * 力扣 https://leetcode.cn/problems/implement-queue-using-stacks/ 232.用栈实现队列
 * * @author xiaoxie
 * @date 2023年12月15日 12:22
 */
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public void push(int x) {
        s1.push(x);
    }
    public int pop() {
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
public class Text {
    public static void main(String[] args) {
    }
}

