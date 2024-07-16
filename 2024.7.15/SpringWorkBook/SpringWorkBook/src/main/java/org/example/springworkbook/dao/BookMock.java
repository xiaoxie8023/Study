package org.example.springworkbook.dao;

import org.example.springworkbook.model.BookInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * program: SpringWorkBook
 * <p>
 * description: mock数据
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-16 21:13
 **/
@Component
public class BookMock {
    public List<BookInfo> bookMock() {
        List<BookInfo> list = new ArrayList<>();
        for(int i = 1; i <= 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setBookId(i);
            bookInfo.setAuthor("Author"+i);
            bookInfo.setBookName("Book"+i);
            bookInfo.setPrice(new BigDecimal(5 * i - 0.5*i));
            bookInfo.setCount(i*2-i+4);
            bookInfo.setPublisher("Publisher"+i);
            bookInfo.setStatusId(i % 5 == 0 ? 1 : 2);
            list.add(bookInfo);
        }
        return list;
    }
}
