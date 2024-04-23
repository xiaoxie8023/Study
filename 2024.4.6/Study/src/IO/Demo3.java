package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-22
 * Time: 16:25
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年04月22日 16:25
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("./work.txt");
        file.deleteOnExit();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());
    }

}
