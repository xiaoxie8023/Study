package School;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-19
 * Time: 15:08
 */

/** * @author xiaoxie
 * @date 2024年04月19日 15:08
 */
public class Demo1 {
    public static void main(String[] args) {
        int i = 1,j = 2,k = 3;
        if(i++ == 1 && (++j == 3 || k++ ==3 )) {
            System.out.println("i =" + i + " j=" + j + "k =" + k);
        }

    }
}
