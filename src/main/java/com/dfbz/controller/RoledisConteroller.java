package com.dfbz.controller;

import com.dfbz.entity.Sysuser;
import com.dfbz.service.RoledisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("manager/role")
public class RoledisConteroller {

    @Autowired
    RoledisService roledisService;

    @RequestMapping("roledis")
    @ResponseBody
    public List<Sysuser> roledis(@RequestParam String srname) throws UnsupportedEncodingException {
        return roledisService.selectrole(srname);
    }
}
