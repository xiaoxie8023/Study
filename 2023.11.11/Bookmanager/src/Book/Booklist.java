package Book;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-12
 * Time: 0:08
 */
public class Booklist {
    private Book[] books;
    private int user ;
    public Booklist(){
        this.books = new Book[10];
        books[0] = new Book("三国演义","罗贯中",9.5,"小说");
        books[1] = new Book("西游记","吴承恩",10.6,"小说");
        books[2] = new Book("红楼梦","曹雪芹",50.5,"小说");
         this.user = 3;
    }

    public Book[] getBooks() {
        return books;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getUser() {
        return this.user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    public Book getBooks(int pos) {
        return this.books[pos];
    }

    public void setBooks(Book[] books,int pos) {
        this.books[pos] = books[pos+1];
    }

}