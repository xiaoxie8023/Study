package org.example.springworkbook.service;

import org.example.springworkbook.dao.BookMock;
import org.example.springworkbook.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * program: SpringWorkBook
 * <p>
 * description: 数据处理
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-16 21:20
 **/
@Component
public class BookService {
    @Autowired
    private BookMock bookMock;
    public List<BookInfo> getlist (){
        List<BookInfo> list = bookMock.bookMock();
        for(BookInfo bookInfo : list){
            if(bookInfo.getStatusId() == 1) {
                bookInfo.setStatusName("可借阅");
            }else {
                bookInfo.setStatusName("不可借阅");
            }
        }
        return list;
    }
}
