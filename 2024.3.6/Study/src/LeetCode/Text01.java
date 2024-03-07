package LeetCode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-07
 * Time: 19:55
 */

import java.util.PriorityQueue;

/** * @author xiaoxie
 * @date 2024年03月07日 19:55
 */
public class Text01 {
    /**
     * 力扣 2208. 将数组和减半的最少操作次数
     * https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/description/
     * 使用贪心+大根堆
     * 贪心策略为每次把数组中最大的元素除于2,基于最大的元素这个前置条件
     * 所以可以使用大根堆的方法
     *  这题还是比较简单的
     * @author xiaoxie
     * @date 2024/3/7 19:56
     * @param nums
     * @return int
     */
    public int HalveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b)->b.compareTo(a));
        double sum = 0.0;
        for(int num : nums) {
            heap.offer((double)num);
            sum += num;
        }
        sum = sum / 2;
        int count = 0;
        while(sum > 0.0) {
            double t = heap.remove();
            t /= 2;
            sum -= t;
            heap.offer(t);
            count++;
        }
        return count;
    }
}
