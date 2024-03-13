package School;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-13
 * Time: 15:10
 */

import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年03月13日 15:10
 */

public class shop {
    public static void main(String[] args) {
            /*     * 模拟商城购物小系统：1.用户选择商品后，后台计算商品价格；     *                 2.使用while循环实现用户多次购买商品。     */
                double toothbrush = 8.8;   //牙刷价格
                double towel = 10.0;        //毛巾价格
                double cup = 18.8;            //水杯价格
                double apple = 12.5;        //苹果价格
                double banana = 15.5;       //香蕉价格
                int i = 0;        String a = "Y";
                System.out.println("2220400343 X");
                System.out.println("-------------黑马小商城-------------");
                System.out.println("1.牙刷的价格为：" + toothbrush + "元");
                System.out.println("2.毛巾的价格为：" + towel + "元");
                System.out.println("3.水杯的价格为：" + cup + "元");
                System.out.println("4.苹果的价格为：" + apple + "元");
                System.out.println("5.香蕉的价格为：" + banana + "元");
                while (a.equals("Y")) {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("请输入你需要购买商品的序列号：");
                    i = sc1.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println("请输入你需要购买牙刷的数量:");
                            int toothbrushnnumber = sc1.nextInt();
                            double toothbrushnnum = toothbrushnnumber * toothbrush;
                            System.out.println("你购买了牙刷" + toothbrushnnumber + "支，需要花费" + toothbrushnnum + "元");
                            System.out.println("需要继续购买请输入Y，否则输入N");
                            a = sc1.next();
                            break;

                        case 2:
                            System.out.println("请输入你需要购买毛巾的数量:");
                            int towelnumber = sc1.nextInt();
                            double towelnum = towelnumber * towel;
                            System.out.println("你购买了毛巾" + towelnumber + "个，需要花费" + towelnum + "元");
                            System.out.println("需要继续购买请输入Y，否则输入N");
                            a = sc1.next();
                            break;

                        case 3:
                            System.out.println("请输入你需要购买水杯的数量:");
                            int cupnumber = sc1.nextInt();
                            double cupnum = cupnumber * cup;
                            System.out.println("你购买了水杯" + cupnumber + "个，需要花费" + cupnum + "元");
                            System.out.println("需要继续购买请输入Y，否则输入N");
                            a = sc1.next();
                            break;

                        case 4:
                            System.out.println("请输入你需要购买苹果的数量:");
                            int applenumber = sc1.nextInt();
                            double applenum = applenumber * apple;
                            System.out.println("你购买了苹果" + applenumber + "斤，需要花费" + applenum + "元");
                            System.out.println("需要继续购买请输入Y，否则输入N");
                            a = sc1.next();
                            break;

                        case 5:
                            System.out.println("请输入你需要购买香蕉的数量:");
                            int banananumber = sc1.nextInt();
                            double banananum = banananumber * banana;
                            System.out.println("你购买了香蕉" + banananumber + "斤，需要花费" + banananum + "元");
                            System.out.println("需要继续购买请输入Y，否则输入N");
                            a = sc1.next();                    break;            }        }
                System.out.println("期待您的下次光临！");    }

        }
