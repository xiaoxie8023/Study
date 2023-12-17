package demo1_图书管理系统;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 21:55
 */

import java.util.Scanner;

/**
 * 删除书籍的操作
 * @author xiaoxie
 * @date 2023/12/17 21:55
 * @param //底层为数组
 * @return null
 */
public class DeleteOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        if(bookList.isEmpty()) {
          throw  new NullException("书架为空");
        }
        Scanner san = new Scanner(System.in);
        System.out.println("请输入你要删除的图书名字");
        String name = san.nextLine();
        int count = bookList.getSize();
        int i = 0;
        for (; i < count; i++) {
            if(bookList.getList(i).getName().equals(name)) {
               break;
            }
        }
        if(i == count) {
            System.out.println("没有找到这本书");

        } else {
            while (i < count) {
                bookList.List[i++] = bookList.List[i+1];
            }
            System.out.println("删除成功");
            bookList.setSize(count-1);
        }
    }
}
