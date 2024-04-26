package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-25
 * Time: 14:06
 */

import java.io.*;
import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年04月25日 14:06
 */
public class Demo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要复制的文件路径");
        String rootPath = scanner.next();
        System.out.println("请输入你要复制到那个文件的目标路径");
        String destPath = scanner.next();
        File rootFile = new File(rootPath);
        if(!rootFile.isFile()){
            System.out.println("复制的文件路径非法");
            return;
        }
        File destFile = new File(destPath);
        if(destFile.getParentFile().isDirectory()) {
            System.out.println("输入的复制目标路径非法");
            return;
        }
        try(InputStream inputStream = new FileInputStream(rootPath);
            OutputStream outputstream = new FileOutputStream(destPath)) {
            while (true) {
                byte[] bytes = new byte[1024];
                int n = inputStream.read(bytes);
                if(n == -1) {
                    break;
                }
                outputstream.write(bytes,0,n);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
}
