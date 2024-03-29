/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-29
 * Time: 20:57
 */

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
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * @author xiaoxie
 * @date 2024年03月29日 20:57
 */
public class Text {
    public static void main(String[] args) {
        int x = 2024;
        int n = 2024;
        int ans = 1;
        int Mod = 10000;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
                ans %= Mod;
            }
            x *= x;
            x %= Mod;
            n >>= 1;
        }
        System.out.println(ans);
    }

    /**
     * 50. Pow(x, n)
     * 迭代
     *
     * @param x
     * @param n
     * @return double
     * @author xiaoxie
     * @date 2024/3/29 21:46
     */
    public double myPow(double x, int n) {
        long N = (long) n;
        return N >= 0 ? pow1(x, N) : pow1(1 / x, -N);
    }

    private double pow1(double x, long n) {
        if (x == 0 || x == 1) return x;
        double ans = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    /**
     * 50. Pow(x, n)
     * https://leetcode.cn/problems/powx-n/description/
     * 递归
     *
     * @param x
     * @param n
     * @return double
     * @author xiaoxie
     * @date 2024/3/29 21:46
     */
    private double pow2(double x, long n) {
        if (n == 0) return 1.0;
        double tmp = pow2(x, n / 2);
        return n % 2 == 1 ? tmp * tmp * x : tmp * tmp;
    }
    /** 2331. 计算布尔二叉树的值
     * https://leetcode.cn/problems/evaluate-boolean-binary-tree/description/
     * dfs
     * @author xiaoxie
     * @date 2024/3/29 22:12
     * @param root
     * @return boolean
     */
    public boolean evaluateTree(TreeNode root) {
        if(root.left == null) return root.val == 1 ? true : false;
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        return root.val == 2 ? left || right : left && right;
    }
    /** 129. 求根节点到叶节点数字之和
     * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/
     * dfs
     * @author xiaoxie
     * @date 2024/3/29 22:36
     * @param root
     * @return int
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode root,int presum) {
        presum =  presum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return presum;
        }
        int ret = 0;
        if(root.left != null) ret += dfs(root.left,presum);
        if(root.right != null) ret += dfs(root.right,presum);
        return ret;
    }
    /** 814. 二叉树剪枝
     * https://leetcode.cn/problems/binary-tree-pruning/description/
     * dfs
     * @author xiaoxie
     * @date 2024/3/29 22:59
     * @param root
     * @return TreeNode
     */
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0 )
            return root = null;
        return root;
    }
    public long pre = Long.MIN_VALUE;
    /** 98. 验证二叉搜索树
     * https://leetcode.cn/problems/validate-binary-search-tree/description/
     * 中序遍历二叉搜索树,是有序的
     *  采用全局变量 + 回溯 + 剪枝
     * @author xiaoxie
     * @date 2024/3/29 23:43
     * @param root
     * @return boolean
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        //剪枝
        if (!isValidBST(root.left)||root.val <= pre) {
            return false;
        }
        pre = root.val;
        return  isValidBST(root.right);
    }
}
