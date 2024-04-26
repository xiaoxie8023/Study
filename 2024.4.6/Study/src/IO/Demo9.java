package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-25
 * Time: 11:20
 */

import java.io.File;
import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年04月25日 11:20
 */
public class Demo9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的目录的路径: ->");
        String rootPath = scanner.next();
        System.out.println("请输入你要查找的普通文件的单词: ->");
        String fileWord = scanner.next();
        File rootFile = new File(rootPath);
        if(!rootFile.isDirectory()) {
            System.out.println("路径非法请重新在输入");
            return;
        }
        search(rootFile,fileWord);
    }
    private static void search(File file,String str) {
        //列出当前的有哪些文件
        File[] files = file.listFiles();
        if(files == null) {
            return;
        }
        for(File f : files) {
            if(f.isFile()) {
                String fileName = f.getName();
                if(fileName.contains(str)) {
                    System.out.println("找到了" + f.getAbsolutePath());
                }
            }else if(f.isDirectory()) {
                search(f,str);
            }
        }
    }
}
