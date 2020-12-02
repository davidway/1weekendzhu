package com.weekendzhu.demo.controller;

import com.weekendzhu.demo.domain.User;
import com.weekendzhu.demo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;
@Controller
public class LoginController {

    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin",username)||!Objects.equals("123456",requestUser.getPassword())){
            String message = "帐号密码错误";
            System.out.println("test");
            return new Result(400);
        }else{
            return new Result(200);
        }
    }
}
