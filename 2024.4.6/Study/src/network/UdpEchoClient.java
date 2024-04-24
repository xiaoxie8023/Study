package network;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-24
 * Time: 20:34
 */

/** * @author xiaoxie
 * @date 2024年04月24日 20:34
 */

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        socket = new DatagramSocket();
// 这俩信息需要额外记录下来, 以备后续使用.
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入要发送的请求: ");
// 1. 从控制台读取用户输入
            String request = scanner.next();
// 2. 构造请求并发送
// 构造请求数据报的时候, 不光要有数据, 还要有 "目标"
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), 0, request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            socket.send(requestPacket);
// 3. 读取响应数据
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
// 4. 显示响应到控制台上.
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
// UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        UdpEchoClient client = new UdpEchoClient("139.155.74.81", 9090);
        client.start();
    }
}