package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-25
 * Time: 10:43
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/** * @author xiaoxie
 * @date 2024年04月25日 10:43
 */
public class Demo6 {
    public static void main(String[] args) {
        try(OutputStream outputStream = new FileOutputStream("hello.txt")) {
            outputStream.write(97);
            outputStream.write(100);
            outputStream.write(99);
            outputStream.write(98);
            System.out.println("读取完毕");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
