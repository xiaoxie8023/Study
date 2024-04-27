package network;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-27
 * Time: 19:32
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年04月27日 19:32
 */
public class TcpEchoClient {
    private Socket socket = null;
    public TcpEchoClient(String serveIp,int servePort)throws IOException {
        //和服务端连接
       socket = new Socket(serveIp,servePort);
    }
    public void start(){
        System.out.println("服务器启动!");
        Scanner scanner = new Scanner(System.in);

        //从服务端读取数据和输入数据
        try(InputStream serveInput = socket.getInputStream();
            OutputStream serveOutput = socket.getOutputStream()) {
            //从服务端接收数据
            Scanner serveScanner = new Scanner(serveInput);
           while (true){
                System.out.println("输入你要传输的数据");
                String result = scanner.next();
                //加换行
                result += "\n";
                //将数据传输给客服端
                serveOutput.write(result.getBytes(), 0, result.getBytes().length);
                if (!serveScanner.hasNext()) {
                    break;
                }
                String response = serveScanner.next();
               System.out.println(response);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",8023);
        tcpEchoClient.start();
    }
}
