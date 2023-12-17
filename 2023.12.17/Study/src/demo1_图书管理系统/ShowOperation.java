package demo1_图书管理系统;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 21:44
 */

/** 显示图书的操作
 * * @author xiaoxie
 * @date 2023年12月17日 21:44
 */
public class ShowOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        int count = bookList.getSize();
        System.out.println("图书信息如下: ");
        for (int i = 0; i < count; i++) {
            if (bookList.getList(i) != null) {
                System.out.println(bookList.getList(i));
            }
        }
    }
}
