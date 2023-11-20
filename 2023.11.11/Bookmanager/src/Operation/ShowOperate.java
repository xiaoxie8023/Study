package Operation;

import Book.Booklist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-12
 * Time: 10:22
 */
public class ShowOperate implements IOperate{
    @Override
    public void work(Booklist booklist) {
        int User = booklist.getUser();
        System.out.println("现在的书库信息如下");
        for (int i = 0; i < User; i++) {
            System.out.println(booklist.getBooks(i).toString());
        }
    }
}
