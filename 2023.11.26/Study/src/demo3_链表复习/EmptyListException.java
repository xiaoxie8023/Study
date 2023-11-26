package demo3_链表复习;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-26
 * Time: 20:50
 */

/** * @author xiaoxie
 * @date 2023年11月26日 20:50
 */
public class EmptyListException extends RuntimeException {
    public EmptyListException() {
    }
    public EmptyListException(String message) {
        super(message);
    }
}
