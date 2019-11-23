package com.dfbz.controller;


import com.dfbz.dao.WorkMapper;
import com.dfbz.entity.Work;
import com.dfbz.service.WorkSrevice;
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
    WorkSrevice srevice;

    @Autowired
    WorkMapper mapper;


    @RequestMapping("sponsor")
    @ResponseBody
    public PageInfo<Work> selectSponsor(@RequestBody Map<String,Object> map){
        List<Work> disposer = mapper.Disposer();
        List<Work> transporter = mapper.Transporter();
        PageInfo<Work> workPageInfo = srevice.selectSponsor(map);


        for (Work work : workPageInfo.getList()) {

            for (Work work1 : disposer) {
               work.setDisposer(work1.getDisposer());
            }
            for (Work work2 : transporter) {
               work.setTransporter(work2.getTransporter());
            }
        }

        return workPageInfo;
    }


    @RequestMapping("node")
    @ResponseBody
    public List<Work> selectnode(){
        HashMap<String, Object> map = new HashMap<>();
        return mapper.selectSponsor(map);
    }


    @RequestMapping("order")
    @ResponseBody
    public List<Work> order(@RequestParam long id){

        List<Work> order = mapper.order(id);
        System.out.println(order+"-----");
        return mapper.order(id);
    }

    @RequestMapping("waste")
    @ResponseBody
    public List<Work> waste(long id){

        return mapper.waste(id);
    }
}
