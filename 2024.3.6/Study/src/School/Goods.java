package School;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-13
 * Time: 15:14
 */

/** * @author xiaoxie
 * @date 2024年03月13日 15:14
 */
public class Goods {
    public double price;
    public int NO;
    public String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Goods(double price, int NO, String name) {
        this.price = price;
        this.NO = NO;
        this.name = name;
    }
}
