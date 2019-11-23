package com.dfbz.controller;


import com.dfbz.dao.sysOfficeMapper;
import com.dfbz.entity.Examine;
import com.dfbz.entity.sysOffice;
import com.dfbz.service.ExaminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manager/examine/index")
public class ExaminController {

    @Autowired
    ExaminService es;

    @Autowired
    sysOfficeMapper so;

    @RequestMapping("examinePageInfo")
    @ResponseBody
    public PageInfo<Examine> selectexamin(@RequestBody Map<String,Object> pageInfo){
        return  es.selectexamin(pageInfo);
    }

    @RequestMapping("node")
    @ResponseBody
    public List<sysOffice> selectnode(){
        return so.selectAll();
    }

}
