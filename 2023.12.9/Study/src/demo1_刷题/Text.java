package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-09
 * Time: 11:00
 */

import java.util.ArrayList;
import java.util.List;

/** * @author xiaoxie
 * @date 2023年12月09日 11:00
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int t = 0,b = m-1,l = 0,r = n-1,count = m*n;
        List<Integer> ans = new ArrayList<>();
        while(count > 0) {
            for(int i = l;i <= r; i++) {
                ans.add(matrix[t][i]);
                count--;
            }t++;
            for(int i = t;i <= b; i++) {
                ans.add(matrix[i][r]);
                count--;

            }r--;
            for(int i = r;i >= l; i--) {
                ans.add(matrix[b][i]);
                count--;

            }b--;
            for(int i = b;i >= t; i--) {
                ans.add(matrix[i][l]);
                count--;

            };l++;
        }
        return ans;
    }
}
public class Text {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] num = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        s.spiralOrder(num);



    }
}
