package demo2_扑克牌;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-26
 * Time: 18:09
 */

import java.util.ArrayList;
import java.util.List;

/** * @author xiaoxie
 * @date 2023年11月26日 18:09
 */
public class Text2 {
    public static void main1(String[] args) {
        CardGame c = new CardGame();
        System.out.println("一副牌");
        List<Card> ret = c.Cards();
        System.out.println(ret);
        System.out.println("洗牌后");
        c.Shuffle(ret);
        System.out.println(ret);
        System.out.println("发牌");
        List<List<Card>> temp = c.Licensing(ret);
        System.out.println(c.Licensing(ret));
        System.out.println("比大小");
        c.Compare(temp);
    }
}
