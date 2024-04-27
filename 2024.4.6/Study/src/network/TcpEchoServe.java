package network;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-27
 * Time: 18:12
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/** 基于多线程实现
 * * @author xiaoxie
 * @date 2024年04月27日 18:12
 */
public class TcpEchoServe {
    private ServerSocket socket = null;
    public TcpEchoServe(int port) throws IOException{
        socket = new ServerSocket(port);
    }
    public void start() throws IOException{
        System.out.println("服务器启动");
        //接收客户端的请求
        ExecutorService poll = Executors.newCachedThreadPool();
        while(true) {
           Socket clintSocket = socket.accept();
//            Thread t = new Thread(()-> {
//                //建立连接
//                try {
//                    connectClint(clintSocket);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            t.start();
            poll.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connectClint(clintSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
    public void connectClint(Socket clintSocket) throws IOException{
        //打印一个日志告知服务器客户端连接上了
        System.out.printf("[%s:%d,客服端上线\n",clintSocket.getInetAddress(),clintSocket.getPort());
        //使用字节流的方式来传输数据
        try(InputStream clintInput = clintSocket.getInputStream();
            OutputStream clintOutput = clintSocket.getOutputStream()) {
            Scanner scanner = new Scanner(clintInput);
            //客服端每次和服务端连接有可能有多个请求
            while(true) {
                //如果后续没有数据了,就说明断开连接了
                if(!scanner.hasNext()) {
                    System.out.printf("[%s:%d,客服端下线\n",clintSocket.getInetAddress(),clintSocket.getPort());
                    break;
                }
                String result = scanner.next();
                //把等到的请求,进行分析计算返回给响应
                String response = process(result);
                //把响应输出给客服端
                clintOutput.write(response.getBytes(),0,response.getBytes().length);
                //服务器打印结果日志
                System.out.printf("%s:%d] req=%s, resp=%s\n",clintSocket.getInetAddress(),clintSocket.getPort(),result,response);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            clintSocket.close();
        }
    }
    public String process(String result) {
        //给响应这里后面加上一个换行符, 使客户端读取响应的时候, 也有明确的分隔符
        return result + "\n";
    }

    public static void main(String[] args) throws IOException{
        TcpEchoServe tcpEchoServe = new TcpEchoServe(8023);
        tcpEchoServe.start();
    }
}
