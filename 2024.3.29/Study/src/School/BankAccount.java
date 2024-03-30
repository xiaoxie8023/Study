package School;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-30
 * Time: 22:19
 */

/**  2220562 - 2220400343 - 谢忠涵
 * * @author xiaoxie
 * @date 2024年03月30日 22:19
 */
    public class BankAccount {
        private String account_number;
        private double leftmoney;

        // 构造方法
        public BankAccount(String account_number, double leftmoney) {
            this.account_number = account_number;
            this.leftmoney = leftmoney;
        }

        // 存款
        public void savemoney(double amount) {
            leftmoney += amount;
            System.out.println("成功存入 " + amount + " 元");
        }

        // 取款
        public void getmoney(double amount) {
            if (leftmoney >= amount) {
                leftmoney -= amount;
                System.out.println("成功取出 " + amount + " 元");
            } else {
                System.out.println("余额不足，取款失败");
            }
        }

        // 查询余额
        public double getleftmoney() {
            System.out.println("当前余额为 " + leftmoney + " 元");
            return leftmoney;
        }

        public static void main(String[] args) {
            BankAccount ba = new BankAccount("123456", 500.0);
            ba.savemoney(1000.0);
            ba.getmoney(800.0);
            ba.getleftmoney();
        }
    }

