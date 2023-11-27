package demo1_JavaSE总结;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-27
 * Time: 8:00
 */

/** * @author xiaoxie
 * @date 2023年11月27日 8:00
 */
public class Text {
    public static void main(String[] args) {
        int num = 15;
        System.out.println(countOnes(num)); // 输出 4
    }

    public static int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
