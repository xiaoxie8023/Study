package demo1_图书管理系统;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 19:17
 */

/** BookList类，是整个操作系统的对象
 * * @author xiaoxie
 * @date 2023年12月17日 19:17
 */
public class BookList {
    public Book[] List;
    public int size;
    public BookList() {
       List = new Book[10];
       List[0] = new Book("西游记", "吴承恩", 10.25, "小说");
       List[1] = new Book("三国演义","罗贯中",20.50,"小说");
       List[2] = new Book("红楼梦","曹雪芹",50.9,"小说");
       List[3] = new Book("水浒传","施耐庵",15.5,"小说");
       List[4] = new Book("c++","谢",999.9,"学习");
        size = 5;
    }
    public boolean isFull() {
        return size >= List.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void newLength() {
        List = new Book[size+10];
    }

    public Book getList(int i) {
        return List[i];
    }

    public int getSize() {
        return size;
    }

    public void setList(Book book , int pos) {
        List[pos] = book;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
