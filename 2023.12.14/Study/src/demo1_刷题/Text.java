package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-14
 * Time: 19:37
 */

import java.util.*;

/** 双指针 + 加排序
 * 力扣  https://leetcode.cn/problems/4sum/ 18 四数之和
 * * @author xiaoxie
 * @date 2023年12月14日 19:37
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4 || nums == null) return ans;
        Arrays.sort(nums);
        for(int i = 0;i < n-3;i++) {
            int x = nums[i];
            if( i > 0 && x == nums[i-1]) continue;
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if((long)x + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;
            for(int j = i+1; j < n-2;j++) {
                int y = nums[j];
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if((long)x + y + nums[n-1] + nums[n-2] < target) continue;
                if( j > i + 1 && y == nums[j-1]) continue;
                int left = j + 1,right = n-1;
                while(left < right) {
                    if((long)x + y + nums[left] + nums[right] < target) left++;
                    else if ((long)x + y + nums[left] + nums[right] > target) right--;
                    else {
                        ans.add(List.of(x,y,nums[left],nums[right]));
                        for(++left;left < right && nums[left] == nums[left-1];++left);
                        for(--right;right > left && nums[right] == nums[right+1];--right);
                    }
                }
            }
        }
        return ans;
    }
}
/** 双指针
 * 力扣 https://leetcode.cn/problems/reverse-string/  344. 反转字符串
 * * @author xiaoxie
 * @date 2023年12月14日 19:37
 */
class Solution2 {
    public void reverseString(char[] s) {
        int left = 0,right = s.length-1;
        while(left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
/** 双指针
 * 力扣 https://leetcode.cn/problems/reverse-string-ii/ 541. 反转字符串 II
 * * @author xiaoxie
 * @date 2023年12月14日 19:37
 */
class Solution3 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length;i += 2*k) {
            int star = i;
            int end = Math.min(ch.length-1,star+k-1);
            while(star < end) {
                char tmp = ch[star];
                ch[star] = ch[end];
                ch[end] = tmp;
                star++;
                end--;
            }
        }
        return new String(ch);
    }
}
/** 用两个队列实现栈
 * 力扣 https://leetcode.cn/problems/implement-stack-using-queues/
 * * @author xiaoxie
 * @date 2023年12月14日 19:37
 */

class MyStack {
   Queue<Integer> q1;
   Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if(empty()) {
            q1.add(x);
        }if( ! q1.isEmpty()) {
            q1.add(x);
        }else {
            q2.add(x);
        }
    }

    public int pop() {
        if(empty()) return -1;
        if(!q1.isEmpty()) {
            int size1 = q1.size();
            for (int i = 0;i < size1-1;i++) {
                q2.add(q1.poll());
            }
            return q1.poll();
        }else {
            int size2 = q2.size();
            for (int i = 0; i < size2-1; i++) {
                q1.add(q2.poll());
            }
            return q2.poll();
        }
    }

    public int top() {
        if(empty()) return -1;
        if(!q1.isEmpty()) {
            int size1 = q1.size();
            for (int i = 0;i < size1-1;i++) {
                q2.add(q1.poll());
            }
            return q1.peek();
        }else {
            int size2 = q2.size();
            for (int i = 0; i < size2-1; i++) {
                q1.add(q2.poll());
            }
            return q2.peek();
        }
    }
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

public class Text {
    public static void main(String[] args) {

    }
}
