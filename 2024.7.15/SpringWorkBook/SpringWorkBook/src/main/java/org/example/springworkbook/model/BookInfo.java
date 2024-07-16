package org.example.springworkbook.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * program: SpringWorkBook
 * <p>
 * description: 图书对象
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-16 09:56
 **/
@Data
public class BookInfo {
    private Integer bookId;
    private String bookName;
    private String author;
    private String publisher;
    private Integer count;
    private BigDecimal price;
    //设 1为可借阅 2 为不可借阅
    private Integer statusId;
    private String statusName;
}
