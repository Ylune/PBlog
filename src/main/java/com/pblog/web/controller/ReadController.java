package com.pblog.web.controller;

import com.google.common.collect.Maps;
import com.pblog.domain.BookTable;
import com.pblog.service.book.BookInfoService;
import com.pblog.service.book.BookInfoVO;
import com.pblog.service.book.BookTableService;
import com.pblog.service.book.BookTableVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ReadController {

    @Resource(name = "bookInfoService")
    private BookInfoService bookInfoService;

    @Resource(name = "bookTableService")
    private BookTableService bookTableService;

    @RequestMapping(value = "/read/layout", method = RequestMethod.GET)
    public String layout(HttpServletRequest request, Model model) {

        return "web/book/layout";
    }

    @RequestMapping(value = "/book/list", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request) {
        Map<String, Object> map = Maps.newHashMap();

        List<BookInfoVO> bookInfoVOList = bookInfoService.findList();
        List<BookTableVO> bookTableVOList = bookTableService.findList();
        map.put("bookInfoVOList", bookInfoVOList);
        map.put("bookTableVOList", bookTableVOList);

        return map;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {

        return "";
    }
}