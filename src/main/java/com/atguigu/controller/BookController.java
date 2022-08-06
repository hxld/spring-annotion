package com.atguigu.controller;

import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author hxld
 * @create 2022-08-04 12:44
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
