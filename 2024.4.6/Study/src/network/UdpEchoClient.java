package network;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-24
 * Time: 20:34
 */

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年04月24日 20:34
 */


public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serveIp;
    private int servePort;
    public UdpEchoClient(String serveIp,int servePort) throws SocketException {
        socket = new DatagramSocket(0);
        this.serveIp = serveIp;
        this.servePort = servePort;
    }
    public void start() throws IOException {
        System.out.println("客服端启动");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //输入请求
            System.out.println("请输入你要发送的请求:");
            String request = scanner.next();
            //将请求封装成数据报
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),0,request.getBytes().length,
                    InetAddress.getByName(serveIp),servePort);
            //发送请求
            socket.send(requestPacket);
            //接收响应,因为接收的是数据报,所以要先创建一个数据报
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            //将这个接收的数据报转化为字符串
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",8023);
        udpEchoClient.start();
    }

}