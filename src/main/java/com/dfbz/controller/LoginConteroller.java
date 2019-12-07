package com.dfbz.controller;

import com.dfbz.entity.Sysuser;
import com.dfbz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginConteroller {

    @Autowired
    LoginService loginService;

    @RequestMapping("login")
    @ResponseBody
    public int login(@RequestBody Map<String,Object> params, HttpSession session){
        if (params.get("pic").equals(session)){
            Sysuser sysuser = loginService.toLong(params);

        }

        return 2;
    }

}
