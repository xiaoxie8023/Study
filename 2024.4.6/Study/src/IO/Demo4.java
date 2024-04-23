package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-22
 * Time: 22:19
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/** * @author xiaoxie
 * @date 2024年04月22日 22:19
 */
public class Demo4 {
    public static void main(String[] args)  {
      try(InputStream in = new FileInputStream("hello.txt")) {
          while (true) {
              int b = in.read();
              if(b == -1) {
                  //读取完毕
                  break;
              }
              System.out.printf("0x%X ", b);
          }
      }catch (IOException e) {
          e.printStackTrace();
      }
    }
}
