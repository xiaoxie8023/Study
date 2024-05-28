package work3;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-05-27
 * Time: 22:50
 */

import java.io.*;
/** * @author xiaoxie
 * @date 2024年05月27日 22:50
 */
public class HelloWorld {
    public static void main(String[] args) {
        String content = "hello java";
        String filePath = "HelloWorld.java";
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filePath))) {
            out.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sourceFilePath = "HelloWorld.java";
        String targetFilePath = "Test.java";

        try {
            // 创建FileInputStream对象，用于读取源文件
            FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
            // 创建FileOutputStream对象，用于写入目标文件
            FileOutputStream fileOutputStream = new FileOutputStream(targetFilePath);

            // 创建FileReader对象，用于读取字符流
            FileReader fileReader = new FileReader(sourceFilePath);
            FileWriter fileWriter = new FileWriter(targetFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // 写入换行符
                System.out.println(line); // 打印到命令提示符窗口
            }
            bufferedReader.close();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("文件未找到：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("读取或写入文件时发生错误：" + e.getMessage());
        }
    }
}
