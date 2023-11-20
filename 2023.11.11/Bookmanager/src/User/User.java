package User;

import Book.Booklist;
import Operation.IOperate;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 22:33
 */
public abstract class User {
    protected String name;
    protected IOperate[] iOperates;
    public String getName() {
        return name;
    }

    public IOperate[] getiOperates() {
        return iOperates;
    }
    public void setName(String name) {
        this.name = name;
    }
    public User(String name) {
        this.name = name;
    }
    public abstract int menu();
    public void DoWork(Booklist booklist , int choice) {
        this.iOperates[choice].work(booklist);
    }
}

