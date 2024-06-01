package Work;

/**
 * program: 2024.5.9
 * description: 借书卡类
 * author: xiaoxie
 * create: 2024-05-30 10:36
 **/
public class BorrowCard {

    private Student cardHolder; // 持卡人
    private int borrowedBooksCount; // 已借出书数量

    public BorrowCard(Student cardHolder) {
        this.cardHolder = cardHolder;
        this.borrowedBooksCount = 0;
    }

    public void setCardHolder(Student cardHolder) {
        this.cardHolder = cardHolder;
    }
    public Student getCardHolder() {
        return cardHolder;
    }

    public void setBorrowedBooksCount(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }
    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }

    public void displayCardInfo() {
        System.out.println("持卡人姓名: " + cardHolder.getName());
        System.out.println("持卡人电子邮件: " + cardHolder.getEmail());
        System.out.println("已借出书籍数量: " + borrowedBooksCount);
    }
}
