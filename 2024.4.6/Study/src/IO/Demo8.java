package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-25
 * Time: 11:09
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/** * @author xiaoxie
 * @date 2024年04月25日 11:09
 */
public class Demo8 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("hello.txt",true)) {
            writer.write("你好CSDN");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
