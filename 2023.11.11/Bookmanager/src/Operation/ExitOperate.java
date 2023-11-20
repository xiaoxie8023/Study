package Operation;

import Book.Booklist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-13
 * Time: 22:44
 */
public class ExitOperate implements IOperate {
    @Override
    public void work(Booklist booklist) {
      System.exit(0);
    }
}
