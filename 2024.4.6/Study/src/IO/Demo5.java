package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-22
 * Time: 22:56
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/** * @author xiaoxie
 * @date 2024年04月22日 22:56
 */
public class Demo5 {
    public static void main(String[] args) {
        try(InputStream in = new FileInputStream("hello.txt")) {
            byte[] bytes = new byte[1024];
            int n = in.read(bytes);
            for (int i = 0; i < n; i++) {
                System.out.printf("0x%x ", bytes[i]);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
