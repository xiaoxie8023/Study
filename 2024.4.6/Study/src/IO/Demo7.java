package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-25
 * Time: 10:58
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/** * @author xiaoxie
 * @date 2024年04月25日 10:58
 */
public class Demo7 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("hello.txt")) {
            while(true) {
                int n = reader.read();
                if(n == -1) {
                    break;
                }
                char ch = (char)n;
                System.out.println(ch);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
