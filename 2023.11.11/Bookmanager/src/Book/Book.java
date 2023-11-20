package Book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 22:28
 */
public class Book {
    private String name;
    private String author;
    private double price;
    private String type;
    private boolean isborrow;
    public Book(String name, String author, double price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "书籍信息为：{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
               ( (getisIsborrow() == false)? ",未被借出":",已被借出")+
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getisIsborrow() {
        return isborrow;
    }

    public void setIsborrow(boolean isborrow) {
        this.isborrow = isborrow;
    }
}
