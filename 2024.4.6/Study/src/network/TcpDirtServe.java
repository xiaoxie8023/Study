package network;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-27
 * Time: 20:22
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** * @author xiaoxie
 * @date 2024年04月27日 20:22
 */
public class TcpDirtServe extends TcpEchoServe{
    private Map<String,String> map = null;
    public TcpDirtServe(int port) throws IOException {
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
    public String process(String result)  {
       return map.getOrDefault(result,"没找到")+"\n";
    }

    public static void main(String[] args) throws IOException{
        TcpDirtServe tcpDirtServe = new TcpDirtServe(8023);
        tcpDirtServe.start();
    }
}
