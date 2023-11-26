package demo1_力扣刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-25
 * Time: 22:50
 */

import java.util.ArrayList;
import java.util.List;

/** * @author xiaoxie
 * @date 2023年11月25日 22:50
 */
/*
 * 杨辉三角
 * @author xiaoxie
 * @date 2023/11/26 17:37
 * @param null
 * @return null
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ret.add(list);
        //一行
        for (int i = 1; i < numRows ; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);//第一个数字
            List<Integer> prevRow = ret.get(i-1);
            for (int j = 1; j < i ; j++) {
                int x = prevRow.get(j)+prevRow.get(j-1);
                temp.add(x);
            }
            temp.add(1);
            ret.add(temp);
        }
        return ret;
    }
}
class Solution1 {
    public int removeElement(int[] nums, int val) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != val) {
                list.add(nums[i]);
            }
        }
        return list.size();
    }
}
public class Text {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(5);
        Solution1 solution1 = new Solution1();
        int[] num = {3,2,2,3};
        System.out.println(solution1.removeElement(num, 3));
    }

}
