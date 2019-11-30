package com.dfbz.controller;


import com.dfbz.dao.WorkMapper;
import com.dfbz.entity.Detail;
import com.dfbz.entity.Transfer;
import com.dfbz.entity.Work;
import com.dfbz.service.WorkService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manager/company/work")
public class WorkConteroller {

    @Autowired
    WorkService srevice;

    @Autowired
    WorkMapper mapper;


    @RequestMapping("sponsor")
    @ResponseBody
    public PageInfo<Work> selectSponsor(@RequestBody Map<String,Object> map){


        return srevice.selectSponsor(map);
    }


    @RequestMapping("node")
    @ResponseBody
    public List<Work> selectnode(){
        HashMap<String, Object> map = new HashMap<>();
        return mapper.selectSponsor(map);
    }


    @RequestMapping("order")
    @ResponseBody
    public Work order(@RequestParam long id){

        return srevice.order(id);
    }

    @RequestMapping("waste")
    @ResponseBody
    public Detail waste(long id){

        return srevice.waste(id);
    }


    @RequestMapping("transport")
    @ResponseBody
    public Transfer transport(long id){

        return srevice.transport(id);
    }
}
