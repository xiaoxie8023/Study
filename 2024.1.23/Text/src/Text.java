/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-28
 * Time: 19:50
 */

import org.w3c.dom.Node;

import java.util.*;

/** * @author xiaoxie
 * @date 2024年01月28日 19:50
 */
public class Text {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /** 1.用哈希Map的 key 和 value 一一映射的思想来解这题，真的牛
     *  力扣 https://leetcode.cn/problems/copy-list-with-random-pointer/ 138. 随机链表的复制
     * @author xiaoxie
     * @date 2024/1/28 20:01
     * @return null
     */
    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node,Node> map = new HashMap<>();
            Node cur = head;
            //先遍历一遍链表
            while(cur != null) {
                Node node = new Node(cur.val);
                map.put(cur,node);
                cur = cur.next;
            }
            cur = head;
            //把关系一一对应
            while(cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
        /** 2.拼接加拆分来解这题，想法也很牛逼
         *  力扣 https://leetcode.cn/problems/copy-list-with-random-pointer/ 138. 随机链表的复制
         * @author xiaoxie
         * @date 2024/1/28 20:01
         * @return null
         */
        public Node copyRandomList2(Node head) {
            if(head == null) {
                return null;
            }
            Node cur = head;
            //拼接： A->A′->B->B′
            while( cur != null) {
                Node newhead = new Node(cur.val);
                newhead.next = cur.next;
                cur.next = newhead;
                cur = newhead.next;
            }
            cur = head;
            //拼接random
            while(cur != null) {
                if(cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            //拆分；A->A′->B->B′ 分为： A→B  A′->B′
            cur = head.next;
            Node pre = head, newhead = head.next;
            while(cur.next != null) {
                pre.next = pre.next.next;
                cur.next = cur.next.next;
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = null;
            return newhead;
        }
    }
    /**使用哈希Map和优先级队列（小根堆因为要求前k个最大的）
     * 力扣刷题：https://leetcode.cn/problems/top-k-frequent-words/
     *  692. 前K个高频单词
     * @author xiaoxie
     * @date 2024/1/28 21:38
     * @return null
     */
    class Solution1 {
        public List<String> topKFrequent(String[] words, int k) {
            //先用Map储存每个单词的频率
            Map<String,Integer> map = new HashMap<>();
            for(String str : words) {
                if(map.get(str) == null) {
                    map.put(str,1);
                }else {
                    int index = map.get(str);
                    map.put(str,index+1);
                }
            }
            //在使用小根堆来输出
            PriorityQueue<Map.Entry<String,Integer>> minheap = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
                public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2) {
                    //如果频率相同就要创建大根堆
                    if(o1.getValue().compareTo(o2.getValue()) == 0) {
                        return o2.getKey().compareTo(o1.getKey());
                    }
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            for(Map.Entry<String,Integer> entry : map.entrySet()) {
                if(minheap.size() < k) {
                    minheap.offer(entry);
                }else {
                    Map.Entry<String,Integer> top = minheap.peek();
                    if(top.getValue().compareTo(entry.getValue()) < 0) {
                        minheap.poll();
                        minheap.offer(entry);
                    }else {
                        if(top.getValue().compareTo(entry.getValue())== 0) {
                            if(top.getKey().compareTo(entry.getKey()) > 0) {
                                minheap.poll();
                                minheap.offer(entry);
                            }
                        }
                    }
                }
            }
            List<String> ret = new ArrayList<>();
            for(int i = 0; i < k;i++) {
                Map.Entry<String,Integer> tmp = minheap.poll();
                ret.add(tmp.getKey());
            }
            Collections.reverse(ret);
            return ret;
        }
    }
    /**使用哈希Set去重的特性来解这题
     * 当然还一种方法是用异或 （这个方法近期找时间去搞懂它）
     * 力扣刷题：https://leetcode.cn/problems/contains-duplicate/
     *  217。存在重复的元素
     * @author xiaoxie
     * @date 2024/1/28 21:38
     * @return null
     */
    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(Integer tmp :nums) {
                if(!set.add(tmp)) {
                    return true;
                }
            }
            return false;
        }
    }
    /**使用哈希Map的 Key和 Value 的特性来解这题
     * 力扣刷题：
     *  219.存在重复的元素||
     * @author xiaoxie
     * @date 2024/1/28 21:38
     * @return null
     */
    class Solution3 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < nums.length; i++) {
                int num = nums[i];
                if(map.containsKey(num) &&i-map.get(num) <= k) {
                    return true;
                }
                map.put(num,i);
            }
            return false;
        }
         //使用滑动窗口来解这题
        public boolean containsNearbyDuplicate2(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length;i++) {
                if(i > k) {
                    set.remove(nums[i-k-1]);
                }
                if(!set.add(nums[i])) {
                    return true;
                }
            }
            return false;
        }
    }


}
