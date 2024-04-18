package IO;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-17
 * Time: 21:15
 */

import java.io.*;
import java.util.*;

/** * @author xiaoxie
 * @date 2024年04月17日 21:15
 */
class read {
   StringTokenizer st = new StringTokenizer("");
   BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   String next() throws IOException{
       while(!st.hasMoreTokens()) {
           st =  new StringTokenizer(bf.readLine());
       }
       return bf.readLine();
   }
   String nextLine() throws IOException{
       return bf.readLine();
   }
   int nextInt() throws IOException{
       return Integer.parseInt(bf.readLine());
   }
   long nextLong() throws IOException{
       return Long.parseLong(bf.readLine());
   }
   double nextDouble() throws IOException{
       return Double.parseDouble(bf.readLine());
   }
}
public class Demo2 {
  private static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  private static read in = new read();
    public static void main(String[] args) throws IOException{
        out.println(3);
    }
}
