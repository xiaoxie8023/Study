package School;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-03
 * Time: 15:35
 */

/** * @author xiaoxie
 * @date 2024年04月03日 15:35
 */
// 父类：员工类
class Employee {
    String name;
    int yearsOfWork;

    public Employee(String name, int yearsOfWork) {
        this.name = name;
        this.yearsOfWork = yearsOfWork;
    }

    public double getSalary() {
        return 3000 + yearsOfWork * 20;
    }
}

// 经理类
class Manager extends Employee {
    public Manager(String name, int yearsOfWork) {
        super(name, yearsOfWork);
    }

    @Override
    public double getSalary() {
        return super.getSalary() + 3000;
    }
}

// 普通工人类
class Worker extends Employee {
    public Worker(String name, int yearsOfWork) {
        super(name, yearsOfWork);
    }

    @Override
    public double getSalary() {
        return super.getSalary() + 1000;
    }
}

// Test类
public class Text {
    public static void printSalary(Employee employee) {
        System.out.println(employee.name + "的工资为：" + employee.getSalary());
    }

    public static void main(String[] args) {
        Employee manager = new Manager("张经理", 5);
        Employee worker = new Worker("李工人", 3);

        printSalary(manager);
        printSalary(worker);
    }
}
