package network;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-27
 * Time: 17:39
 */
import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/** * @author xiaoxie
 * @date 2024年04月27日 17:39
 */
public class UdpDerServe extends UdpEchoServe {
    private Map<String,String> map = null;
    public UdpDerServe(int port) throws SocketException {
        super(port);
        map = new HashMap<>();
        map.put("hello","你好");
        map.put("cat","小猫");
        map.put("dog","小狗");
        map.put("cow","牛");
        map.put("apple","苹果");
        System.out.println("词典服务器启动");
    }
    @Override
    public String process(String result) {
       return map.getOrDefault(result,"没有找到");
    }

    public static void main(String[] args) throws IOException {
        UdpDerServe udpDerServe = new UdpDerServe(8023);
        udpDerServe.start();
    }
}
