package com.dfbz.controller;


import com.dfbz.entity.SysRole;
import com.dfbz.entity.sysOffice;
import com.dfbz.service.SysRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manager/role")
public class SysRoleConteroller {

    @Autowired
    SysRoleService roleService;

    @RequestMapping("section")
    @ResponseBody
    public PageInfo<SysRole> selectSection(Map<String,Object> map){
        return roleService.selectSection(map);
    }
    @RequestMapping("toselect")
    @ResponseBody
    public List<sysOffice> toselect(){
        return roleService.toselect();
    }
}
