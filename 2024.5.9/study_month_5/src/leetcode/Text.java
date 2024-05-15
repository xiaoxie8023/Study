package leetcode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-05-09
 * Time: 17:23
 */

import java.util.*;

/** * @author xiaoxie
 * @date 2024年05月09日 17:23
 */
 class ListNode {
    int val;
     ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
    TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
         this.right = right;
     }
 }
public class Text {
    /** 74. 搜索二维矩阵
     * https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-interview-150
     * 二分
     * @author xiaoxie
     * @date 2024/5/9 22:50
     * @param null
     * @return null
     */
    int[][] nums;
    int n,m;
    public boolean searchMatrix(int[][] matrix, int target) {
        nums = matrix;
        n = matrix.length;
        m = matrix[0].length;
        //先判断是那一行
        int row = binary(target);
        if(row < 0) {
            return false;
        }
        int left = 0,right = nums[row].length - 1;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if( nums[row][mid] > target) {
                right = mid-1;
            }else if(target == nums[row][mid]) {
                return true;
            }else {
                left = mid+1;
            }
        }
        return false;
    }
    public int binary(int t) {
        int left = -1,right = n-1;
        while(left < right){
            int mid = (right - left + 1) / 2 + left;
            if(nums[mid][0] <= t) {
                left = mid;
            }else {
                right = mid -1;
            }
        }
        return left;
    }
    /**  74. 搜索二维矩阵
     * 使用一次二分
     * 若将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，我们可以在该数组上二分找到目标元素。
     * 代码实现时，可以二分升序数组的下标，将其映射到原矩阵的行和列上。
     * @author xiaoxie
     * @date 2024/5/9 22:51
     * @param matrix
     * @param target
     * @return boolean
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
    /** 205. 同构字符串
     * https://leetcode.cn/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
     * 哈希
     * @author xiaoxie
     * @date 2024/5/9 23:06
     * @param s
     * @param t
     * @return boolean
     */
    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] hash1 = new int[128];
        int[] hash2 = new int[128];
        for (int i = 0; i < chars.length; i++) {
            if (hash1[chars[i]] != hash2[chart[i]]) {
                return false;
            }
            hash1[chars[i]] = i + 1;
            hash2[chart[i]] = i + 1;
        }
        return true;
    }
    /** 66. 加一
     * https://leetcode.cn/problems/plus-one/description/?envType=study-plan-v2&envId=top-interview-150
     * 非常简单的数学问题
     * @author xiaoxie
     * @date 2024/5/10 22:11
     * @param digits
     * @return int[]
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    /** 69. x 的平方根
     * https://leetcode.cn/problems/sqrtx/description/?envType=study-plan-v2&envId=top-interview-150
     * 简单的二分
     * @author xiaoxie
     * @date 2024/5/10 22:13
     * @param x
     * @return int
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x / 2;
        if(x == 0 || x == 1) {
            return x;
        }
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (mid * mid == x) {
                return mid;
            } else if(mid > x / mid) {
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return left;
    }
    /** 2. 两数相加
     * https://leetcode.cn/problems/add-two-numbers/description/
     * 虚拟头结点,尾插.
     * @author xiaoxie
     * @date 2024/5/11 15:09
     * @param l1
     * @param l2
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int curry = 0;
        ListNode cur = dummy;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + curry;
            int tmp = sum % 10;
            curry = sum / 10;
            cur.next = new ListNode(tmp);
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(curry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
    /** 24. 两两交换链表中的节点
     * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
     * 递归
     * @author xiaoxie
     * @date 2024/5/11 15:33
     * @param head
     * @return ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tmp = swapPairs(head.next.next);
        ListNode newhead = head.next;
        newhead.next = head;
        head.next = tmp;
        return newhead;
    }
    /** 24. 两两交换链表中的节点
     * 虚拟头结点,尾插
     * @author xiaoxie
     * @date 2024/5/11 15:33
     * @param head
     * @return ListNode
     */
    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {
            ListNode cur1 = cur.next;
            ListNode cur2 = cur.next.next;
            //交换
            cur1.next = cur2.next;
            cur2.next = cur1;
            cur.next = cur2;
            cur = cur1;
        }
        return dummy.next;
    }
    /**143. 重排链表
     * https://leetcode.cn/problems/reorder-list/description/
     *这一题太牛逼了,考了三个知识点
     * 找链表中点
     * 反转链表
     * 合并链表
     * 感觉面试常考
     * @author xiaoxie
     * @date 2024/5/11 17:00
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode mid = middle(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        merge(l1,l2);
    }
    public ListNode middle(ListNode head) {
        ListNode fast = head,slow = head;
        while( fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
    public void merge(ListNode l1,ListNode l2) {
        ListNode cur1;
        ListNode cur2;
        while(l1 != null && l2 != null) {
            cur1 = l1.next;
            cur2 = l2.next;
            l1.next = l2;
            l1 = cur1;
            l2.next = l1;
            l2 = cur2;
        }
    }
    /** 70. 爬楼梯
     * https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150
     * 简单的dp
     * @author xiaoxie
     * @date 2024/5/11 17:06
     * @param n
     * @return int
     */
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int a = 1,b = 2,c = 0;
        for(int i = 3;i <= n;i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
    /** 226. 翻转二叉树
     * https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
     * dfs
     * @author xiaoxie
     * @date 2024/5/11 17:08
     * @param root
     * @return TreeNode
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        root.left = r;
        root.right = l;
        return root;
    }
    /** 135. 分发糖果
     * https://leetcode.cn/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
     * 贪心
     * 时间复杂度O(n);
     * 空间复杂度O(n);
     * @author xiaoxie
     * @date 2024/5/12 22:34
     * @param ratings
     * @return int
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] num = new int[n];
        Arrays.fill(num,1);
        //先从左到右遍历一遍,如果ratings[i] > ratings[i-1] nums[i] + 1;
        for(int i = 1;i < n;i++) {
            if(ratings[i] > ratings[i-1]) {
                num[i] = num[i-1] + 1;
            }
        }
        //从右往左遍历,如果ratings[i] > ratings[i-1] && nums[i] < nums[i-1],如果大于因为题目要求
        //是要最少的糖果,所以不变即可;
        int sum = 0;
        sum += num[n-1];
        for(int i = n-2;i >= 0;i--) {
            if(ratings[i] > ratings[i+1] && num[i] <= num[i+1]) {
                num[i] = num[i+1] + 1;
            }
            sum += num[i];
        }
        return sum;
    }
    /**
     * 空间复杂度为O(1)的解法.
     * @author xiaoxie
     * @date 2024/5/12 22:34
     * @param null
     * @return null
     */
    public int candy1(int[] ratings) {
        return 0;
    }



  /** 90. 子集 II
   * https://leetcode.cn/problems/subsets-ii/description/
   * 回溯
   * @author xiaoxie
   * @date 2024/5/12 23:07
   * @param null
   * @return null
   */
    List<List<Integer>> ret;
    int[] nums1;
    List<Integer> t = new ArrayList<Integer>();
    public List<List<Integer>> subsetsWithDup(int[] num) {
        ret = new ArrayList<>();
        Arrays.sort(num);
        nums1 = num;
        n = num.length;
        dfs(0);
        return ret;
    }
    public void dfs(int post) {
        if(post == n) {
            ret.add(new ArrayList<>(t));
            return;
        }
        t.add(nums1[post]);
        dfs(post+1);
        t.remove(t.size()-1);
        while(post + 1 < n && nums1[post+1] == nums1[post]) {
            post++;
        }
        dfs(post+1);
    }
    /** 100. 相同的树
     * https://leetcode.cn/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150
     * dfs
     * @author xiaoxie
     * @date 2024/5/12 23:11
     * @param p
     * @param q
     * @return boolean
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }else if(p == null || q == null) {
            return false;
        }else if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    /** 100. 相同的树
     * bfs
     * @author xiaoxie
     * @date 2024/5/12 23:20
     * @param p
     * @param q
     * @return boolean
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()) {
            TreeNode tmpp = queue.poll();
            TreeNode tmpq = queue.poll();

            if(tmpp == null && tmpq == null) continue;
            if((tmpp == null || tmpq == null) || tmpp.val != tmpq.val) {
                return false;
            }
            queue.add(tmpp.left);
            queue.add(tmpq.left);
            queue.add(tmpp.right);
            queue.add(tmpq.right);
        }
        return true;
    }
    /** 42. 接雨水
     * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
     * 双指针,非常经典的一道题
     * 要好好理解,画图
     * @author xiaoxie
     * @date 2024/5/13 16:34
     * @param height
     * @return int
     */
    public int trap(int[] height) {
        int n = height.length;
        int pre_max = 0,suf_max = 0; // 算出前后缀最大值;
        int left = 0,right = n-1,ret = 0;
        while(left < right) {
            pre_max = Math.max(pre_max,height[left]);
            suf_max = Math.max(suf_max,height[right]);
            if(pre_max < suf_max) {
                ret += pre_max - height[left];
                left++;
            }else {
                ret += suf_max - height[right];
                right--;
            }
        }
        return ret;
    }
    /** 12. 整数转罗马数字
     * https://leetcode.cn/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150
     * 两个数组
     * 贪心
     * @author xiaoxie
     * @date 2024/5/14 22:06
     * @param num
     * @return java.lang.String
     */
    public String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] rom = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(rom[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
    /** 200. 岛屿数量
     * https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150
     * 洪水泛滥
     * @author xiaoxie
     * @date 2024/5/14 22:19
     * @param null
     * @return null
     */
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int islands;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid,int i,int j) {
        grid[i][j] = '3';
        for(int k = 0;k < 4;k++) {
            int x = i + dx[k],y = j + dy[k];
            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                dfs(grid,x,y);
            }
        }
    }
    /** 101. 对称二叉树
     * https://leetcode.cn/problems/symmetric-tree/?envType=study-plan-v2&envId=top-interview-150
     * 简单的dfs
     * @author xiaoxie
     * @date 2024/5/15 22:43
     * @param root
     * @return boolean
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSameTree2(root.left,root.right);
    }
    private boolean isSameTree2(TreeNode r,TreeNode l) {
        if(r == null && l == null) return true;
        if(r == null && l!= null || r != null && l == null) return false;
        if(r.val != l.val) return false;
        return isSameTree2(r.left,l.right) && isSameTree2(r.right,l.left);
    }
    /** 222. 完全二叉树的节点个数
     * https://leetcode.cn/problems/count-complete-tree-nodes/description/?envType=study-plan-v2&envId=top-interview-150
     * dfs
     * @author xiaoxie
     * @date 2024/5/15 22:45
     * @param root
     * @return int
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
