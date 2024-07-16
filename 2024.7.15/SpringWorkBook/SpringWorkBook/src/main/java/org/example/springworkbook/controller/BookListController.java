package org.example.springworkbook.controller;

import org.example.springworkbook.dao.BookMock;
import org.example.springworkbook.model.BookInfo;
import org.example.springworkbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * program: SpringWorkBook
 * <p>
 * description: 图书列表接口
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-16 09:54
 **/
@RestController
@RequestMapping("/book")
public class BookListController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        List<BookInfo> list = bookService.getlist();
        return list;
    }
}
