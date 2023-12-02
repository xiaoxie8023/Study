package demo1_字符串;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-30
 * Time: 9:43
 */

/** * @author xiaoxie
 * @date 2023年11月30日 9:43
 */
public class Text {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = new String("hello");
        char[] arr = {'h','e','l','l','o'};
        String s2 = new String(arr);
        System.out.println(s.toString());
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
