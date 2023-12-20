package demo1_图书管理系统;
/**
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 21:09
 */

import java.util.Scanner;

/** 添加图书的操作
 * * @author xiaoxie
 * @date 2023年12月17日 21:09
 */
public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        if(bookList.isFull()) {
            bookList.newLength();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你要添加的书名");
        String name = scan.nextLine();
        System.out.println("请输入你要添加图书的作者");
        String author = scan.nextLine();
        System.out.println("请输入你要添加图书的价格");
        double price = scan.nextDouble();
        scan.nextLine();
        System.out.println("请输入你要添加图书的类型");
        String type = scan.nextLine();
        Book tmp = new Book(name,author,price,type);
        int count = bookList.getSize();
        for (int i = 0; i < count; i++) {
            if(tmp.getName().equals(bookList.getList(i).getName())) {
                System.out.println("请勿重复添加");
                System.exit(0);
            }
        }
        bookList.setList(tmp,count);
        bookList.setSize(count+1);
    }
}
