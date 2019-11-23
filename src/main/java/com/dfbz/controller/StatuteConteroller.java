package com.dfbz.controller;

import com.dfbz.entity.AppVersion;
import com.dfbz.entity.Statute;
import com.dfbz.service.StatuteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manager/statute/index")
public class StatuteConteroller {

    @Autowired
    StatuteService statuteService;

    @RequestMapping("statute")
    @ResponseBody
    public PageInfo<Statute> selectAll(@RequestBody Map<String, Object> map) {

        return statuteService.selectstatute(map);
    }

    @RequestMapping(value = "staadd",produces = "html/text;charset=utf-8")
    @ResponseBody
    public String add(@RequestBody Statute statute) {

        statute.setDelFlag("0");
        statute.setUpdateDate(new Date());
        statute.setCreateDate(new Date());
        statute.setCreateBy("超级管理员");

        int i = statuteService.insert(statute);
        String msg = "";
        if (i > 0) {
            msg = "修改成功";
        } else {
            msg = "修改失败";
        }
        return msg;
    }

    @RequestMapping("toupdata")
    @ResponseBody
    public Statute toupdate(Integer id){
        return statuteService.selectByPrimaryKey(id);
    }


    @RequestMapping(value = "updata",produces = "html/text;charset=utf-8")
    @ResponseBody
    public String update(@RequestBody Statute statute){
        int i = statuteService.updateByPrimaryKeySelective(statute);
        String msg="";
        if (i>0){
            msg="修改成功";
        }else {
            msg="修改失败";
        }
        return msg;
    }

    @RequestMapping(value = "delete",produces = "html/text;charset=utf-8")
    @ResponseBody
    public String delete(Long id){
        Statute statute = new Statute();
        statute.setId(id);
        statute.setDelFlag("1");
        statute.setUpdateDate(new Date());
        int i = statuteService.updateByPrimaryKeySelective(statute);
        String msg="";
        if (i>0){
            msg="修改成功";
        }else {
            msg="修改失败";
        }
        return msg;
    }
}
