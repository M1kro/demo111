package com.mikro.controller;

import com.mikro.domain.Account;
import com.mikro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//web层 账户
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired//类型注入
    private AccountService accountService;
    //查询
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户信息");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    //保存
    @RequestMapping("/save")
    public void save(Account account, HttpServletResponse response, HttpServletRequest request) throws IOException {
        accountService.saveAccount(account);
        //重定向 再次查询保存后的数据库数据
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
