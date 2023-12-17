package demo1_图书管理系统;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 22:27
 */

/** 退出操作
 * * @author xiaoxie
 * @date 2023年12月17日 22:27
 */
public class ExitOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.exit(0);
    }
}
