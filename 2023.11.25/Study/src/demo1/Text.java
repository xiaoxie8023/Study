package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-25
 * Time: 10:21
 */

import java.util.ArrayList;
import java.util.List;

/** * @author xiaoxie
 * @date 2023年11月25日 10:21
 */

public class Text {
    public static List<Character> func(String str1, String str2) {
       List<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if(!str2.contains(str1.charAt(i)+"")) {
                arrayList.add(str1.charAt(i));
        }
        }
        return arrayList;
    }
    public static void main(String[] args) {
        List<Character> it = func("welcome to vite","come");
        for (Character ch:it) {
            System.out.print(ch);
        }
    }
}
