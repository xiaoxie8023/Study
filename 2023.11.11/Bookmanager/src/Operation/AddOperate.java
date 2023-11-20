package Operation;

import Book.Book;
import Book.Booklist;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-12
 * Time: 0:04
 */
public class AddOperate  implements IOperate {
    @Override
    public void work(Booklist booklist) {
        System.out.println("请输入你要添加的图书书名——》");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("请输入你要添加的图书作者名字——》");
        String author = scan.nextLine();
        System.out.println("请输入你要添加的图书价格——》");
        double price = scan.nextDouble();
        System.out.println("请输入你要添加的图书类型——》");
        String type = scan.next();
        Book newbook = new Book(name, author, price, type);//请加的图书
        int User = booklist.getUser();
        // 检查图书是否已存在
        for (int i = 0; i < User; i++) {
            if (booklist.getBooks(i).getName().equals(name)) {
                System.out.println("书库里面已经有这本书了");
                return;
            }
        }
        // 添加新的图书对象到书库
        int user = booklist.getUser();
        if (user < 10) {
            booklist.getBooks()[user] = newbook;
            booklist.setUser(user + 1);
            System.out.println("添加成功!");
        } else {
            System.out.println("书库已满，无法添加新书籍");
        }
    }

}

