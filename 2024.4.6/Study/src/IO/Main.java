package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-17
 * Time: 18:46
 */

/** * @author xiaoxie
 * @date 2024年04月17日 18:46
 */
import java.util.*;
import java.io.*;
class Read // 自定义快速读入
{
    //字符串分割
    StringTokenizer st = new StringTokenizer("");
    //将字节流转换成字符流全部传输到一个缓冲区
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException
    {
        while(!st.hasMoreTokens())
        {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException
    {
        return bf.readLine();
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
}
public class Main
{
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static Read in = new Read();

    public static void main(String[] args) throws IOException
    {
        // 写代码

        out.close();
    }
}

