package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-25
 * Time: 14:25
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年04月25日 14:25
 */
public class Demo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的目录的路径: ->");
        String rootPath = scanner.next();
        System.out.println("请输入要查询的单词: ->");
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
                machWord(f,str);
            }else if(f.isDirectory()) {
                search(f,str);
            }
        }
    }
    private static void machWord(File f,String str) {
        try(Reader reader = new FileReader(f)) {
            StringBuilder ret = new StringBuilder();
            while(true) {
                int n = reader.read();
                if(n == -1) {
                    break;
                }
                ret.append((char) n);
            }
            if(ret.indexOf(str) >= 0) {
                System.out.println("找到了" + f.getAbsolutePath());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
