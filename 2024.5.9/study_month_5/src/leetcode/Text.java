package leetcode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-05-09
 * Time: 17:23
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
     * <a href="https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
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
     * @param
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
    /** 128. 最长连续序列
     * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
     * 哈希
     * @author xiaoxie
     * @date 2024/5/20 21:57
     * @param nums
     * @return int
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int num : nums) {
            hash.add(num);
        }
        int ret = 0;
        for(int num : hash) {
            if(!hash.contains(num-1)) {//不存在num -1就说明为开头
                int currNum = num;
                int count = 1;
                while(hash.contains(currNum+ 1)) {
                    currNum++;
                    count++;
                }
                ret = Math.max(ret,count);
            }
        }
        return ret;
    }
    /** 23. 合并 K 个升序链表
     * https://leetcode.cn/problems/merge-k-sorted-lists/description/
     * 使用优先级队列
     * 时间复杂度为 O(NKlogK)
     * 空间复杂度:O(K)
     * @author xiaoxie
     * @date 2024/5/21 21:22
     * @param lists
     * @return ListNode
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> {return o1.val-o2.val;});
        for(ListNode cur : lists) {
            if(cur != null) {
                heap.add(cur);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!heap.isEmpty()) {
            ListNode tmp = heap.poll();
            cur.next = tmp;
            cur = cur.next;
            tmp = tmp.next;
            if(tmp != null) {
                heap.add(tmp);
            }
        }
        return dummy.next;
    }
    /** 23. 合并 K 个升序链表
     * https://leetcode.cn/problems/merge-k-sorted-lists/description/
     * 使用分治 => 归并排序
     * 时间复杂度为 O(NklogK)
     * 空间复杂度:O(logk)
     * @author xiaoxie
     * @date 2024/5/21 21:22
     * @param lists
     * @return ListNode
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        return merge(lists,0,n-1);
    }
    public ListNode merge(ListNode[] lists,int left,int right) {
        if(left > right) return null;
        if(left == right) return lists[left];
        int mid = (left + right) >>1;
        ListNode l1 =  merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);
        return mergeTwoList(l1,l2);
    }
    public ListNode mergeTwoList(ListNode l1,ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else {
                cur.next  = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        cur.next = (l1 != null ? l1 : l2);
        return dummy.next;
    }
    /** 25. K 个一组翻转链表
     * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
     * 模拟
     * @author xiaoxie
     * @date 2024/5/21 22:33
     * @param head
     * @param k
     * @return leetcode.ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode tmp = head;
        while(tmp != null) {
            n++;
            tmp = tmp.next;
        }
        n /= k;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode arr = head;
        for(int i = 0;i < n;i++) {
            ListNode prev = arr;
            for(int j = 0;j < k;j++) {
                ListNode next = arr.next;
                arr.next = cur.next;
                cur.next = arr;
                arr = next;
            }
            cur = prev;
        }
        if(arr != null) {
            cur.next = arr;
        }
        return dummy.next;
    }
    /** 20. 有效的括号
     * https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
     * 栈
     * @author xiaoxie
     * @date 2024/5/23 22:32
     * @param s
     * @return boolean
     */
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }else{
                if(!stack.isEmpty()) {
                    char ch2 = stack.peek();
                    if((ch2 == '('&& ch == ')')||( ch2 == '['&& ch == ']') ||( ch2 == '{' && ch == '}')) {
                        stack.pop();
                    }else {
                        return false;
                    }
                }else {return false;}
            }
        }
        return stack.isEmpty();
    }
    /** DP36 abb
     * https://www.nowcoder.com/practice/0a8bbf8b9b5b4280957849ef4f240f07?tpId=230&tqId=38957&ru=/exam/oj&toPageTab=solution
     * 这题dp+ 哈希表 + 滚动数组,
     * 特别难想,感觉代码看着简单其实要好好细想一下这题
     * @author xiaoxie 
     * @date 2024/5/24 23:46
     */
    public void abb() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        char[] ch = str.toCharArray();
        /**
         例:     abcbcc
         ret = f[i](前)0-i-1之前有多少个-x的存在.
         f[i]有两层含义
         1.f[i](前) 0-i-1之前有多少个-x的存在.
         2.f[i](后) 0 -i之前有多少个-x的存在.  
         f[i](后) = f[i](前) + (i-g[i]) (这个的意思是0-i-1之前有多少个非x的字符);
         g[i] 有两层含义    
         1.f[i](前) 0-i-1之前有多少个x的存在.
         2.f[i](后) 0 -i之前有多少个x的存在.   
         g[i](后) = g[i](之前) + 1;
         */
        long sum = 0;
        long[] f = new long[26];
        long[] g = new long[26];
        for(int i = 0;i < n;i++) {
            int index = ch[i] -'a';
            sum += f[index];
            f[index] = f[index] + (i-g[index]);
            g[index]++;
        }
        System.out.println(sum);
    }
    /** 面试题 01.02. 判定是否互为字符重排
     * https://leetcode.cn/problems/check-permutation-lcci/description/
     * 简单的哈希表问题.
     * @author xiaoxie
     * @date 2024/5/28 14:51
     * @param s1
     * @param s2
     * @return boolean
     */
    public boolean CheckPermutation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n!= m) {
            return false;
        }
        int[] hash = new int[26];
        for(char ch : s1.toCharArray()) {
            hash[ch-'a']++;
        }
        for(char ch : s2.toCharArray()) {
            if(hash[ch-'a'] <= 0) {
                return false;
            }
            hash[ch-'a']--;
        }
        return true;
    }
    /** 217. 存在重复元素
     *  https://leetcode.cn/problems/contains-duplicate/description/
     *  简单的哈希.
     * @author xiaoxie
     * @date 2024/5/28 14:58
     * @param nums
     * @return boolean
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int num : nums) {
            if(!hash.add(num)) {
                return true;
            }
        }
        return false;
    }
    /** 219. 存在重复元素 II
     * https://leetcode.cn/problems/contains-duplicate-ii/description/
     * 使用哈希表
     * @author xiaoxie
     * @date 2024/5/28 15:08
     * @param nums
     * @param k
     * @return boolean
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(nums[0],0);
        for(int i = 1;i < nums.length;i++) {
            if(hash.containsKey(nums[i])) {
                if(Math.abs(i-hash.get(nums[i])) <= k) {
                    return true;
                }
            }
            hash.put(nums[i],i);
        }
        return false;
    }
    /** LCR 033. 字母异位词分组
     * https://leetcode.cn/problems/sfvd7V/description/
     * 哈希表 + 计数
     * 时间复杂度: O(kN) K 表示的是一个字符串长度
     * 空间复杂度: O(NK)
     * @author xiaoxie
     * @date 2024/5/28 15:36
     * @param strs
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hash = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];//每个字符串字符出现的次数记录下来
            int length = str.length();
            for(int i = 0;i < length;i++) {
                count[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < 26;i++) {
                if(count[i] != 0) {
                    sb.append((char)(i+'a'));
                    sb.append(count[i]);//这一步是关键,把字符出现的次数也加到了字符后面
                }
            }
            String key = sb.toString();
            List<String> list  = hash.getOrDefault(key,new ArrayList<>());
            list.add(str);
            hash.put(key,list);
        }
        return new ArrayList<List<String>>(hash.values());
    }
    /**  LCR 033. 字母异位词分组
     * 哈希表 + 排序
     * 时间复杂度: O(NKlogK)
     * 空间复杂度: O(KN)
     * @author xiaoxie
     * @date 2024/5/28 15:39
     * @param strs
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        // 字母异位词分组
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);

        }
        return new ArrayList<>(map.values());
    }
    /** 14. 最长公共前缀
     * https://leetcode.cn/problems/longest-common-prefix/description/
     * 这题使用 starsWith讨巧了,所以还是想一个字典树的方法更好一点. 这题有五种方法需要重点掌握.
     * 时间复杂度(O(N))
     * @author xiaoxie
     * @date 2024/5/28 15:50
     * @param strs
     * @return java.lang.String
     */
    public String longestCommonPrefix1(String[] strs) {
        if(strs.length == 0) return " ";
        String ret = strs[0];//公共前缀随机选一个;
        for(String str : strs) {
            while(!str.startsWith(ret)) {
                ret = ret.substring(0,ret.length()-1);
            }
        }
        return ret;
    }
    /** 第二种方法: 纵向对比
     * Description: longestCommonPrefix2
     * Param: * @param strs
     * return: java.lang.String
     * Author: xiaoxie
     * Date: 15:49 2024/5/29
    */
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0 || strs[0] == null) return " ";
        String same = strs[0];
        int length = strs[0].length();//第一个字符串的长度
        int count = strs.length;//一共有多少个字符串
        for(int i = 0;i < length;i++) {
            char ch = strs[0].charAt(i);
            for(int j = 1;j <  count;j++) {
                if(i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    return same.substring(0,i);
                }
            }
        }
        return same;
    }
    /** 第三方法: 两两对比
     * Description: longestCommonPrefix3
     * Param: * @param strs
     * return: java.lang.String
     * Author: xiaoxie
     * Date: 16:02 2024/5/29
    */
    public String longestCommonPrefix3(String[] strs) {
        if(strs.length == 0 || strs[0] == null) return " ";
        String ret = strs[0];
        int count = strs.length;//一共有多少个字符串
        for(int i = 1;i < count;i++) {
            ret = compare(ret,strs[i]);
            if(ret.equals(" ")) return " ";
        }
        return ret;
    }
    public String compare(String s1,String s2) {
        int length = Math.min(s1.length(),s2.length());
        for(int i = 0;i < length;i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0,i);
            }
        }
        return s1.substring(0,length);
    }
    /** 第四方法:二分
     * 时间复杂度:O(MNlogN)
     * 其实时间复杂度反而增加了,但是这个思想值得借鉴学习.
     * Description: longestCommonPrefix4
     * Param: * @param strs
     * return: java.lang.String
     * Author: xiaoxie
     * Date: 16:25 2024/5/29
    */
    public String longestCommonPrefix4(String[] strs) {
        if(strs.length == 0 || strs[0] == null) return " ";
        int minlength = 0x3f3f3f3f;
        for(String str : strs) {
            minlength = Math.min(minlength,str.length());
        }
        int left = 0,right = minlength;
        while(left < right) {
            int mid = left + (right-left+1) / 2;
            if(iscomod(strs,mid)) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return strs[0].substring(0, left);
    }
    public boolean iscomod(String[] strs,int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    /** 第五种方法:分治的思想
     * 这个还是需要重点掌握的,主要也是因为时间复杂度为O(MN)空间复杂度会高一点O(MlogN).但这个思想还是得重点掌握的
     * Description: longestCommonPrefix5
     * Param: * @param strs
     * return: java.lang.String
     * Author: xiaoxie
     * Date: 16:48 2024/5/29
    */
    public String longestCommonPrefix5(String[] strs) {
        if(strs.length == 0 || strs[0] == null) return " ";
        else return merge(strs,0,strs.length-1);
    }
    public String merge(String[] strs,int start,int end) {
        if(start == end) return strs[start];
        int mid = start+(end-start) / 2;
        String left = merge(strs,start,mid);
        String right = merge(strs,mid+1,end);
        return lcp(left,right);
    }
    public String lcp(String left,String right) {
        int minLegth = Math.min(left.length(),right.length());
        for(int i = 0;i < minLegth;i++) {
            if(left.charAt(i) != right.charAt(i)) {
                return left.substring(0,i);
            }
        }
        return left.substring(0,minLegth);
    }
    /** 题目: DP40 小红取数
     * 链接: <a href="https://www.nowcoder.com/practice/6a7b2b6c9e3a4f56b1db9f8ca08d889b?tpId=230&tqId=38958&ru=/exam/oj&toPageTab=solution">...</a>
     *  a % k = x
     *  b % k = y   =>  (a+b) % k = 0  <=> (x + y) % k = 0
     * 状态表示:    dp[i][j]:表示前i个数中,总和%k等于j时,最大和为多少.
     * 状态转移方程: 不选 dp[i][j] = dp[i-1][j];
     *              选: dp[i][j] = dp[i-1][((j-a[i]) % k + k)%k]+arr[i];
     *                                    (t + a[i]) % k = j;
     *                                    t % k = j - a[i] % k ;
     * 返回值:       dp[n][0];
     * 总结来说这题还是很有难道,不光要想到这个01背包问题,还需要考虑到同余定理,这个还是个人感觉很难.
     * @Description: Count
     * @Param: * @param
     * @return: void
     * @Author: xiaoxie
     * @Date: 15:31 2024/5/29
     */
    public void Count() throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] str = bf.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            long[] arr = new long[n+1];
            String[] strs = bf.readLine().split(" ");
            for(int i = 1;i <= n;i++) {
                arr[i] = Long.parseLong(strs[i-1]);
            }
            long[][] dp = new long[n+1][k];
            for(int i = 0;i < k;i++) {
                dp[0][i] = Long.MIN_VALUE;
            }
            dp[0][0] = 0;
            for(int i = 1;i<= n;i++) {
                for(int j = 0;j < k;j++) {
                    dp[i][j] = (Math.max(dp[i-1][j],dp[i-1][(int)((j-arr[i])%k + k) % k] + arr[i]));
                }
            }
            if(dp[n][0]<=0)//初始化为最小值是负数
                System.out.println(-1);
            else
                System.out.println(dp[n][0]);
        }


}
