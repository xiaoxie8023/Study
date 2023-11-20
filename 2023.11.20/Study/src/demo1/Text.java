package demo1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/**
 * Created with IntelliJ IDEA.
 * Description:哈希表学习专场
 * User: 谢忠涵7
 * Date: 2023-11-18
 * Time: 23:54
 */
class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        // 一次遍历，构造哈希集合
        HashSet<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }
        // 二次遍历：匹配查找
        int rs = 0;
        for (String word : words) {
            String reverseWord = new StringBuilder(word).reverse().toString();
            if (reverseWord.equals(word)) {
                // 跳过回文，例：zz
                continue;
            }
            if (wordSet.contains(reverseWord)) {
                rs++;
                wordSet.remove(word);
                wordSet.remove(reverseWord);
            }
        }
        return rs;
    }
    public int majorityElement(int[] nums) {
        return moon(0,nums,nums[0]);
    }
    private int moon(int i,int[] nums,int major) {
        int count = 0;
        for (int j = i; j < nums.length; j++) {
            if(nums[j] == major) {
                count++;
            } else {
                count--;
            }if(count == 0)
                return moon(j,nums,nums[j]);
        }
        return major;
    }
    public int romanToInt(String s) {
        int sum = 0;
        int pernum = GetNums(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = GetNums(s.charAt(i));
            if(pernum < num) {
                sum -= pernum;
            }else {
                sum += pernum;
            }
            pernum = num;
        }
        sum += pernum;
        return sum;
    }
    private int GetNums(char ch) {
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
    //哈希表
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num) &&i-map.get(num) <= k) {
                return true;
            }
            map.put(num,i);
        }
        return false;
    }
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int[] temp = new int[100];
        for (int num : nums) {
            ans += temp[num - 1]++;
        }
        return ans;
    }

    public int maximumSum(int[] nums) {
        int[] Hmx = new int[82];
        int dex = -1;
        for (int num : nums) {
            int s = 0;
            for (int i = num; i > 0; i /= 10) {
                s += i % 10;
            }
            if (Hmx[s] > 0) {
                dex = Math.max(dex, Hmx[s] + num);
            }
            Hmx[s] = Math.max(Hmx[s], num);
        }
        return dex;
    }

    public int maxSum(int[] nums) {
        int[] mx = new int[10];
        int sum = -1;
        for (int num : nums) {
            int s = 0;
            for (int i = num; i > 0; i /= 10) {
                s = Math.max(s, i % 10);
            }
            if (mx[s] > 0) {
                sum = Math.max(sum, mx[s] + num);
            }
            mx[s] = Math.max(mx[s], num);
            s = 0;
        }
        return sum;
    }
}

public class Text {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "MCMXCIV";
        System.out.println(s.romanToInt(ss));
        //int[] num = {2,7,11,15};
        //System.out.println(s.containsNearbyDuplicate(num, k));
        //System.out.println(s.numIdenticalPairs(num));
        //System.out.println(s.maxSum(num));
        //System.out.println(s.maximumSum(num));
    }
}

