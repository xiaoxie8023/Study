import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-10-25
 * Time: 22:29
 */
//判断素数
public class study {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
    }

    public static void main4 (String[] args) {
        int count = 0;
        for(int num = 1;num<=100;num++) {
            if(num%10==9||num/10==9) {
                if(num%10==9&&num/10==9) {
                    count++;
                }
                count++;
            }
        }
        System.out.println("9的数量为:"+count);

    }
    public static void main3(String[] args) {
        int count = 0;
        for(int year = 1000;year<=2000;year++) {
            if(year%4==0&&year%100!=0||year%400==0) {
                System.out.println(year);
                count++;
            }
        }
        System.out.println("count="+count);
    }
        public static void main2(String[] args) {
                int count = 0;
                System.out.println(1);
                count++;
                System.out.println(2);
                count++;
            for(int num = 3;num<=100;num++){
                    int j=0;
                    if(num%2 == 0) {
                           continue;
                    }for(j = 2;j<=(num/2);j++) {
                        if(num%j==0) {
                               break;
                        }
                    }if(j>(num/2)) {
                            count++;
                            System.out.println(num);
                    }


            }
                System.out.println("count="+count);
        }
        public static void main1(String[] args) {
                int num = 101;
                int j = 0;
                if(num%2 == 0) {
                  System.out.println(num+"不是素数");

                }for( j = 3;j<=(num/2);j++){
                        if(num%j == 0){
                                continue;
                        }
                }if(j>(num/2)){
                        System.out.println(num+"是素数");

                }

        }

        }
