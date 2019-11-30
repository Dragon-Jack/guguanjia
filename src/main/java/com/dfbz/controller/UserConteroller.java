package com.dfbz.controller;

import com.dfbz.dao.sysOfficeMapper;
import com.dfbz.entity.Sysuser;
import com.dfbz.entity.sysOffice;
import com.dfbz.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manager/sysuser")
public class UserConteroller {

    @Autowired
    UserService userService;

    @Autowired
    sysOfficeMapper officeMapper;

    @RequestMapping("serviceall")
    @ResponseBody
    public PageInfo<Sysuser> serviceAll(Map<String,Object> map){

        return userService.serviceUser(map);

    }
    @RequestMapping("nodes")
    @ResponseBody
    public List<sysOffice> nodes(Map<String,Object> map){
        return officeMapper.selectAll();
    }
}
