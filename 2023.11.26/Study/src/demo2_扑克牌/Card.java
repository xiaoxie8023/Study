package demo2_扑克牌;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-26
 * Time: 17:49
 */

/** * @author xiaoxie
 * @date 2023年11月26日 17:49
 */

public class Card {
    public String Decor;
    public int Nums;

    public Card(String decor, int nums) {
        this.Decor = decor;
        this.Nums = nums;
    }

    @Override
    public String toString() {
        String[] nums = {"J","Q","K"};
        if (Nums <= 10) {return Decor+Nums;}
        else if (Nums == 11) {return Decor+nums[0];}
        else if (Nums == 12) {return Decor+nums[1];}
        else {return Decor + nums[2];}
    }
}
