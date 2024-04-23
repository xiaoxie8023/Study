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
            int n = 0;
            while ((n = in.read(bytes)) != -1) {
                // 将读取的字节转换为字符串，注意只转换实际读取的字节数
                String data = new String(bytes, 0, n);
                System.out.println(data);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
