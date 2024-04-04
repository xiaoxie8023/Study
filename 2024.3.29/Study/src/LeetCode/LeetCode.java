package LeetCode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-29
 * Time: 11:24
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归,dfs,回溯,剪枝问题专题
 * * @author xiaoxie
 *
 * @date 2024年03月29日 11:24
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}

public class LeetCode {
    /**
     * 面试题 08.06. 汉诺塔问题
     * https://leetcode.cn/problems/hanota-lcci/description/
     *
     * @param A
     * @param B
     * @param C
     * @author xiaoxie
     * @date 2024/3/29 16:16
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        dfs(A, B, C, A.size());
    }

    public void dfs(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        dfs(A, C, B, n - 1);
        C.add(A.remove(A.size() - 1));
        dfs(B, A, C, n - 1);
    }

    /**
     * 21. 合并两个有序链表
     * https://leetcode.cn/problems/merge-two-sorted-lists/description/
     * 使用递归
     *
     * @param list1
     * @param list2
     * @return LeetCode.ListNode
     * @author xiaoxie
     * @date 2024/3/29 19:50
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }

    /**
     * LCR 024. 反转链表
     * https://leetcode.cn/problems/UHnkqh/description/
     * 递归
     *
     * @param head
     * @return LeetCode.ListNode
     * @author xiaoxie
     * @date 2024/3/29 20:32
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        //找到最后一个节点
        ListNode newhead = reverseList(head.next);
        //修改指针变量;
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    /**
     * 24. 两两交换链表中的节点
     * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
     * 递归
     *
     * @param head
     * @return LeetCode.ListNode
     * @author xiaoxie
     * @date 2024/3/29 20:51
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = swapPairs(head.next.next);
        ListNode newhead = head.next;
        newhead.next = head;
        head.next = tmp;
        return newhead;
    }

    /**
     * 257. 二叉树的所有路径
     * https://leetcode.cn/problems/binary-tree-paths/description/
     * 全局变量 + 回溯(恢复现场) + 剪枝
     *
     * @author xiaoxie
     * @date 2024/3/30 20:50
     * @param null
     * @return null
     */
    List<String> ret;

    public List<String> binaryTreePaths(TreeNode root) {
        ret = new ArrayList<>();
        dfs(root, new StringBuilder());
        return ret;
    }

    public void dfs(TreeNode root, StringBuilder pathSb) {
        //回溯的恢复现场的关键
        StringBuilder path = new StringBuilder(pathSb);
        path.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            ret.add(path.toString());
            return;
        }
        path.append("->");
        //剪枝
        if (root.left != null) dfs(root.left, path);
        if (root.right != null) dfs(root.right, path);
    }

    List<List<Integer>> ret1;
    List<Integer> path2;
    boolean[] check;//剪枝

    /**
     * 46. 全排列
     * https://leetcode.cn/problems/permutations/description/
     * dfs  + 回溯 + 剪枝 + 全局变量
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author xiaoxie
     * @date 2024/3/30 21:40
     */
    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        path2 = new ArrayList<>();
        check = new boolean[nums.length];
        dfs(nums);
        return ret1;
    }

    public void dfs(int[] nums) {
        if (path2.size() == nums.length) {
            ret1.add(new ArrayList<>(path2));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (check[i] == false) {
                path2.add(nums[i]);
                check[i] = true;
                dfs(nums);
                //回溯
                path2.remove(path2.size() - 1);
                check[i] = false;
            }
        }
    }

    List<List<Integer>> ret3;
    List<Integer> path3;

    /**
     * 78. 子集
     * https://leetcode.cn/problems/subsets/description/
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author xiaoxie
     * @date 2024/3/30 22:42
     */
    public List<List<Integer>> subsets(int[] nums) {
        ret3 = new ArrayList<>();
        path3 = new ArrayList<>();
        dfs(nums, 0);
        return ret3;
    }

    /**
     * 解法二:即根据子集的元素个数来dfs
     *
     * @param nums
     * @param post
     * @author xiaoxie
     * @date 2024/3/30 22:42
     */
    public void dfs(int[] nums, int post) {
        ret3.add(new ArrayList<>(path3));
        if (post == nums.length) {
            return;
        }
        for (int i = post; i < nums.length; i++) {
            path3.add(nums[i]);
            dfs(nums, i + 1);
            path3.remove(path3.size() - 1);//恢复现场
        }
    }

    /**
     * 解法一:枚举每一个数,看他是选还是不选,最后把叶子节点返回给ret
     * 类似与前序遍历
     * 解法二优于解法一
     *
     * @param nums
     * @param post
     * @author xiaoxie
     * @date 2024/3/30 22:48
     */
    public void dfs1(int[] nums, int post) {
        if (post == nums.length) {
            ret3.add(new ArrayList<>(path3));
            return;
        }
        //选
        path3.add(nums[post]);
        dfs(nums, post + 1);
        //恢复现场
        path3.remove(path3.size() - 1);
        //不选
        dfs(nums, post + 1);
    }

    /**
     * 1863. 找出所有子集的异或总和再求和
     * https://leetcode.cn/problems/sum-of-all-subset-xor-totals/description/
     * 回溯
     *
     * @author xiaoxie
     * @date 2024/3/30 23:20
     * @param null
     * @return null
     */
    int path;
    int sum;

    public int subsetXORSum(int[] nums) {
        dfs3(nums, 0);
        return sum;
    }

    public void dfs3(int[] nums, int post) {
        sum += path;
        for (int i = post; i < nums.length; i++) {
            path ^= nums[i];
            dfs(nums, i + 1);
            //恢复现场 异或操作的消消乐操作
            path ^= nums[i];
        }
    }

    /**
     * 47. 全排列 II
     * https://leetcode.cn/problems/permutations-ii/description/
     * 这一题和全排序的框架其实是一样的只不过是剪枝不同
     * 注意: 要先排序
     * 剪枝:
     * 1.同一层节点中,不能出现和上一个相同的节点
     * 2.同一个数,不能重复用两次
     * 思考:
     * 两种方法
     * 1.考虑"合法" 的节点
     * (check[i] == false || (i == 0 || nums[i] != nums[i-1] || check[i-1] == true))
     * 2.考虑不合法的节点
     * (check[i] == true || (i != 0 && nums[i] == nums[i-1] && check[i-1] == false))
     *
     * @author xiaoxie
     * @date 2024/3/31 0:21
     * @param null
     * @return null
     */
    List<List<Integer>> ret4;
    List<Integer> path4;
    boolean[] check4;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ret4 = new ArrayList<>();
        path4 = new ArrayList<>();
        check4 = new boolean[nums.length];
        Arrays.sort(nums);
        dfs3(nums);
        return ret4;
    }

    public void dfs3(int[] nums) {
        if (path4.size() == nums.length) {
            ret4.add(new ArrayList<>(path4));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (check4[i] == false && (i == 0 || nums[i] != nums[i - 1] || check4[i - 1] == true)) {
                path4.add(nums[i]);
                check4[i] = true;
                dfs3(nums);
                //恢复现场
                path4.remove(path4.size() - 1);
                check4[i] = false;
            }
        }
    }

    /**
     * 17. 电话号码的字母组合
     * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
     * dfs + 全局变量 + 回溯
     *
     * @author xiaoxie
     * @date 2024/3/31 19:03
     * @param null
     * @return null
     */
    String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ret5;
    StringBuilder path5;

    public List<String> letterCombinations(String digits) {
        ret = new ArrayList<>();
        path5 = new StringBuilder();
        if (digits.length() == 0) return ret;
        dfs(digits, 0);
        return ret;
    }

    public void dfs(String digits, int post) {
        if (post == digits.length()) {
            ret5.add(path5.toString());
            return;
        }
        String str = strs[digits.charAt(post) - '0'];
        for (int i = 0; i < str.length(); i++) {
            path5.append(str.charAt(i));
            dfs(digits, post + 1);
            path5.deleteCharAt(path5.length() - 1);//恢复现场
        }
    }

    /**
     * 22. 括号生成
     * https://leetcode.cn/problems/generate-parentheses/description/
     * 回溯 + 全局变量 + 剪枝
     *
     * @author xiaoxie
     * @date 2024/3/31 19:45
     * @param null
     * @return null
     */
    List<String> ret6;
    StringBuilder path6;

    public List<String> generateParenthesis(int n) {
        ret6 = new ArrayList<>();
        path6 = new StringBuilder();
        dfs(0, 0, n);
        return ret;
    }

    public void dfs(int open, int close, int post) {
        if (path6.length() == 2 * post) {
            ret6.add(path6.toString());
            return;
        }
        //剪枝
        if (open < post) {
            path6.append('(');
            dfs(open + 1, close, post);
            path6.deleteCharAt(path6.length() - 1);
        }
        //剪枝
        if (close < open) {
            path6.append(')');
            dfs(open, close + 1, post);
            path6.deleteCharAt(path6.length() - 1);
        }
    }

    /**
     * 77. 组合
     * https://leetcode.cn/problems/combinations/description/
     * n-(k-path.size()) + 1 ->
     * 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
     * 剪枝操作
     * 这个剪枝要好好总结
     *
     * @author xiaoxie
     * @date 2024/3/31 21:55
     * @param null
     * @return null
     */
    List<List<Integer>> ret7;
    List<Integer> path7;
    int n;
    int k;

    public List<List<Integer>> combine(int _n, int _k) {
        ret7 = new ArrayList<>();
        path7 = new ArrayList<>();
        n = _n;
        k = _k;
        dfs(1);
        return ret7;
    }

    public void dfs(int begin) {
        if (path7.size() == k) {
            ret7.add(new ArrayList<>(path7));
            return;
        }
        // n-(k-path.size()) + 1 ->搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        //剪枝操作
        for (int i = begin; i <= n - (k - path7.size()) + 1; i++) {
            path7.add(i);
            dfs(i + 1);
            path7.remove(path7.size() - 1);
        }
    }

    /**
     * 494. 目标和
     * https://leetcode.cn/problems/target-sum/description/
     * 简单的回溯问题,这题的最优解是转换成01背包问题
     *
     * @author xiaoxie
     * @date 2024/3/31 22:35
     * @param null
     * @return null
     */
    int ret8;
    int aim;

    public int findTargetSumWays(int[] nums, int target) {
        aim = target;
        dfs(nums, 0, 0);
        return ret8;
    }

    public void dfs(int[] nums, int begin, int path0) {
        if (begin == nums.length) {
            if (path == aim) ret8++;
            return;
        }
        //选
        dfs(nums, begin + 1, path + nums[begin]);
        //不选
        dfs(nums, begin + 1, path - nums[begin]);
    }

    /**
     * 39. 组合总和
     * https://leetcode.cn/problems/combination-sum/description/
     * dfs + 回溯 + 剪枝 + 全局变量
     *
     * @author xiaoxie
     * @date 2024/4/1 10:29
     * @param null
     * @return null
     */
    List<List<Integer>> ret9;
    List<Integer> path9;
    int ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret9 = new ArrayList<>();
        path9 = new ArrayList<>();
        ans = target;
        dfs12(candidates, 0, 0);
        return ret9;
    }

    public void dfs12(int[] nums, int post, int sum) {
        if (sum == ans) {
            ret9.add(new ArrayList<>(path9));
            return;
        }
        for (int i = post; i < nums.length; i++) {
            if (sum + nums[i] <= ans) {//剪枝操作
                path9.add(nums[i]);
                dfs(nums, i, sum + nums[i]);//因为可以出现重复的数,所有这里要为i
                path9.remove(path9.size() - 1);
            }
        }
    }

    /**
     * 784. 字母大小写全排列
     * https://leetcode.cn/problems/letter-case-permutation/description/
     * dfs + 回溯 + 剪枝 + 全局变量
     *
     * @author xiaoxie
     * @date 2024/4/1 16:15
     * @param null
     * @return null
     */
    List<String> ret10;
    StringBuilder path10;

    public List<String> letterCasePermutation(String s) {
        ret10 = new ArrayList<>();
        path10 = new StringBuilder();
        dfs3(s, 0);
        return ret;
    }

    public void dfs3(String s, int post) {
        if (post == s.length()) {
            ret10.add(path10.toString());
            return;
        }
        //不变大写
        char tmp = s.charAt(post);
        path10.append(tmp);
        dfs(s, post + 1);
        path10.deleteCharAt(path10.length() - 1);
        if (tmp < '0' || tmp > '9') {
            tmp = change(tmp);
            path10.append(tmp);
            dfs3(s, post + 1);
            path10.deleteCharAt(path10.length() - 1);
        }
    }

    private char change(char ch) {
        if (ch >= 'a' && ch <= 'z') return ch -= 32;
        else return ch += 32;
    }

    /**
     * 526. 优美的排列
     * https://leetcode.cn/problems/beautiful-arrangement/
     *
     * @author xiaoxie
     * @date 2024/4/1 16:36
     * @param null
     * @return null
     */
    int ret11;
    boolean[] check1;

    public int countArrangement(int n) {
        check1 = new boolean[n + 1];
        dfs(1, n);
        return ret11;
    }

    public void dfs(int p, int n) {
        if (p == n + 1) {
            ret11++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (check1[i] == false && (p % i == 0 || i % p == 0)) {
                check1[i] = true;
                dfs(p + 1, n);
                check1[i] = false;
            }
        }
    }

    /**
     * 51. N 皇后
     * https://leetcode.cn/problems/n-queens/description/
     * 一行一行的遍历,一定要画图
     *
     * @author xiaoxie
     * @date 2024/4/2 11:29
     * @param null
     * @return null
     */
    List<List<String>> ret12;
    List<String> path12;
    boolean[] arrange;
    boolean[] straight;
    boolean[] reverse;

    public List<List<String>> solveNQueens(int n) {
        ret12 = new ArrayList<>();
        path12 = new ArrayList<>();
        arrange = new boolean[n];
        straight = new boolean[2 * n];
        reverse = new boolean[2 * n];
        dfs6(n, 0);
        return ret12;
    }

    public void dfs6(int n, int post) {
        if (post == n) {
            ret12.add(new ArrayList<>(path12));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (arrange[i] == false && straight[post - i + n] == false && reverse[post + i] == false) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                arrange[i] = true;
                straight[post - i + n] = true;
                reverse[post + i] = true;
                path12.add(sb.toString());
                dfs6(n, post + 1);
                path12.remove(path12.size() - 1);
                arrange[i] = false;
                straight[post - i + n] = false;
                reverse[post + i] = false;
            }
        }
    }

    /**
     * 36. 有效的数独
     * https://leetcode.cn/problems/valid-sudoku/description/
     * 使用哈希的思想
     *
     * @param board
     * @return boolean
     * @author xiaoxie
     * @date 2024/4/2 15:38
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][][] hash = new boolean[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - '0';
                if (board[i][j] != '.') {
                    if (row[i][num] || col[j][num] || hash[i / 3][j / 3][num]) {
                        return false;
                    }
                    row[i][num] = col[j][num] = hash[i / 3][j / 3][num] = true;
                }
            }
        }
        return true;
    }

    /**
     * 37. 解数独
     * https://leetcode.cn/problems/sudoku-solver/
     *
     * @author xiaoxie
     * @date 2024/4/2 17:38
     * @param null
     * @return null
     */
    boolean[][] cow, rol;
    boolean[][][] hash;

    public void solveSudoku(char[][] board) {
        cow = new boolean[9][10];
        rol = new boolean[9][10];
        hash = new boolean[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    cow[i][num] = true;
                    rol[j][num] = true;
                    hash[i / 3][j / 3][num] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int i, int j) {
        while (board[i][j] != '.') {
            if (++j == 9) {
                i++;
                j = 0;
            }
            if (i == 9) {
                return true;
            }
        }
        for (int num = 1; num <= 9; num++) {
            if (!cow[i][num] && !rol[j][num] && !hash[i / 3][j / 3][num]) {
                board[i][j] = (char) ('0' + num);
                cow[i][num] = true;
                rol[j][num] = true;
                hash[i / 3][j / 3][num] = true;
                if (dfs(board, i, j)) {
                    return true;
                } else {
                    board[i][j] = '.';
                    cow[i][num] = false;
                    rol[j][num] = false;
                    hash[i / 3][j / 3][num] = false;
                }
            }
        }
        return false;
    }

    /**
     * 79. 单词搜索
     * https://leetcode.cn/problems/word-search/description/
     * 一个小技巧,利用向量数组,一个for循环搞定上下左右的情况
     *
     * @author xiaoxie
     * @date 2024/4/4 17:42
     * @param null
     * @return null
     */
    boolean[][] visit;
    int n1, m;
    char[] word;

    public boolean exist(char[][] board, String _word) {
        n1 = board.length;
        m = board[0].length;
        word = _word.toCharArray();
        visit = new boolean[n1][m];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word[0]) {
                    visit[i][j] = true;
                    if (dfs(board, i, j, 1)) {
                        return true;
                    }
                    visit[i][j] = false;
                }
            }
        }
        return false;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public boolean dfs(char[][] board, int i, int j, int post) {
        if (post == word.length) {
            return true;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < m && !visit[x][y] && board[x][y] == word[post]) {
                visit[x][y] = true;
                if (dfs(board, x, y, post + 1)) return true;
                visit[x][y] = false;
            }
        }
        return false;
    }

    /**
     * 1219. 黄金矿工
     * https://leetcode.cn/problems/path-with-maximum-gold/description/
     *
     * @author xiaoxie
     * @date 2024/4/4 18:14
     * @param null
     * @return null
     */
    int m2, n2;
    int ret13;
    int[] dx1 = {0, 0, 1, -1};
    int[] dy1 = {1, -1, 0, 0};
    int[][] grid;

    public int getMaximumGold(int[][] _grid) {
        m = _grid.length;
        n = _grid[0].length;
        grid = _grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    dfs7(i, j, 0);
                }
            }
        }
        return ret13;
    }

    public void dfs7(int i, int j, int gold) {
        gold += grid[i][j];
        ret13 = Math.max(ret13, gold);
        int tmp = grid[i][j];
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx1[k];
            int y = j + dy1[k];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0) {
                dfs7(x, y, gold);
            }
        }
        grid[i][j] = tmp;
    }

    /**
     * 980. 不同路径 III
     * https://leetcode.cn/problems/unique-paths-iii/description/
     *
     * @author xiaoxie
     * @date 2024/4/4 19:14
     * @param null
     * @return null
     */
    boolean[][] vis;
    int ret14, m3, n3, step;

    public int uniquePathsIII(int[][] grid) {
        m3 = grid.length;
        n3 = grid[0].length;
        int sx = 0, sy = 0;
        vis = new boolean[m3][n3];
        for (int i = 0; i < m3; i++) {
            for (int j = 0; j < n3; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 0) {
                    step++;
                }
            }
        }
        vis[sx][sy] = true;
        dfs(grid, sx, sy, 1);
        return ret14;
    }

    public void dfs(int[][] g, int i, int j, int count) {
        if (g[i][j] == 2) {
            if (count == step + 2) {
                ret14++;
            }
            return;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m3 && y >= 0 && y < n3 && !vis[x][y] && g[x][y] != -1) {
                vis[x][y] = true;
                dfs(g, x, y, count + 1);
                vis[x][y] = false;
            }
        }
    }

    /**
     * 733. 图像渲染
     * https://leetcode.cn/problems/flood-fill/description/
     * 洪水泛滥算法
     *
     * @author xiaoxie
     * @date 2024/4/4 21:39
     * @param null
     * @return null
     */
    int newcolor, m5, n5, t;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m5 = image.length;
        n5 = image[0].length;
        newcolor = color;
        t = image[sr][sc];
        if (t == newcolor) return image;
        image[sr][sc] = newcolor;
        dfs(image, sr, sc);
        return image;
    }

    public void dfs(int[][] image, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m5 && y >= 0 && y < n5 && image[x][y] == t) {
                image[x][y] = newcolor;
                dfs(image, x, y);
            }
        }
    }

    /**
     * 200. 岛屿数量
     * https://leetcode.cn/problems/number-of-islands/description/
     *
     * @author xiaoxie
     * @date 2024/4/4 22:22
     * @param null
     * @return null
     */
    int islands, m6, n6;

    public int numIslands(char[][] grid) {
        m6 = grid.length;
        n6 = grid[0].length;
        vis = new boolean[m6][n6];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs10(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs10(char[][] grid, int i, int j) {
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m6 && y >= 0 && y < n6 && grid[x][y] == '1' && !vis[x][y]) {
                dfs10(grid, x, y);
            }
        }
    }

    /**
     * 695. 岛屿的最大面积
     * https://leetcode.cn/problems/max-area-of-island/description/
     *
     * @author xiaoxie
     * @date 2024/4/4 23:00
     * @param null
     * @return null
     */
    int islandA, m7, n7;

    public int maxAreaOfIsland(int[][] grid) {
        m7 = grid.length;
        n7 = grid[0].length;
        int islandT = 0;
        vis = new boolean[m7][n7];
        for (int i = 0; i < m7; i++) {
            for (int j = 0; j < n7; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    islandA = Math.max(islandA, dfs11(grid, i, j));
                }
            }
        }
        return islandA;
    }

    public int dfs11(int[][] grid, int i, int j) {
        vis[i][j] = true;
        int ans = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m7 && y >= 0 && y < n7 && !vis[x][y] && grid[x][y] == 1) {
                ans += dfs11(grid, x, y);
            }
        }
        return ans;
    }
    /** 130. 被围绕的区域
     * https://leetcode.cn/problems/surrounded-regions/description/
     * @author xiaoxie
     * @date 2024/4/4 23:47
     * @param board
     */
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        // 把与边界'O'相连的'O'置为'.'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs8(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs8(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs8(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs8(board, m - 1, j);
            }
        }
        // 还原
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs8(char[][] board, int i, int j) {
        board[i][j] = '.';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                dfs8(board, x, y);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LeetCode l = new LeetCode();
        l.permute(nums);
        System.out.println();
    }
}
