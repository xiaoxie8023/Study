package demo1_图书管理系统;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 19:18
 */

/** User类
 * * @author xiaoxie
 * @date 2023年12月17日 19:18
 */

public abstract class User {
 public IOperation[] iOperations;
 public String name;
    public User(String name) {
        this.name = name;
    }
    public abstract int menu();
    public void doOperation(int choice,BookList bookList) {
        IOperation operation = this.iOperations[choice];
        operation.work(bookList);
    }
}
