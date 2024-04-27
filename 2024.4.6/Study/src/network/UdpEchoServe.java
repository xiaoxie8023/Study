package network;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-25
 * Time: 14:43
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServe {
    private DatagramSocket socket = null;
    public UdpEchoServe(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动!");
        while(true){
            //1.接收请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);//从客服端接收请求,如果没有请求,即阻塞等待
            //将请求解析成字符串
            String request = new String(requestPacket.getData(),0, requestPacket.getLength());
            //经过process方法计算请求得出响应
            String response = this.process(request);
            //将响应传给客服端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),0,response.getBytes().length,
                    requestPacket.getAddress(), requestPacket.getPort());
            socket.send(responsePacket);
            System.out.printf("[%s:%d],req = %s,resp = %s\n",requestPacket.getAddress(),requestPacket.getPort(),request,response);
        }
    }

    //这个请求的响应为回显
  public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException{
        UdpEchoServe udpEchoServe = new UdpEchoServe(8023);
        udpEchoServe.start();

    }
}
