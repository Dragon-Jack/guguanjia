package com.dfbz.controller;


import com.dfbz.entity.AppVersion;
import com.dfbz.service.AppVersionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping("manager/app/index")
public class AppVersionConteroller {

    @Autowired
    AppVersionService ne;


    @RequestMapping("all")
    @ResponseBody
    public PageInfo<AppVersion> selectalll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        return ne.selectpag(pageNum,pageSize);
    }



    @RequestMapping("toupdata")
    @ResponseBody
    public AppVersion toupdate(Integer id){
        return ne.selectByPrimaryKey(id);
    }


    //app更新数据
    @RequestMapping(value = "updata",produces = "html/text;charset=utf-8")
    @ResponseBody
    public String update(@RequestBody AppVersion appVersion){
        int i = ne.updateByPrimaryKeySelective(appVersion);
        String msg="";
        if (i>0){
            msg="修改成功";
        }else {
            msg="修改失败";
        }
        return msg;
    }

    //app逻辑删除数据
    @RequestMapping(value = "deletefalse",produces = "html/text;charset=utf-8")
    @ResponseBody
    public String delete(Long id){
        AppVersion appVersion = new AppVersion();
        appVersion.setId(id);
        appVersion.setDelFlag("1");
        appVersion.setUpdateDate(new Date());
        int i = ne.updateByPrimaryKeySelective(appVersion);
        String msg="";
        if (i>0){
            msg="修改成功";
        }else {
            msg="修改失败";
        }
        return msg;
    }

//app添加数据
    @RequestMapping(value = "appadd",produces = "html/text;charset=utf-8")
    @ResponseBody
    public String add(@RequestBody AppVersion appVersion){
        System.out.println(appVersion );
        appVersion.setCreateBy("超级管理员");
        appVersion.setDelFlag("0");
        appVersion.setUpdateDate(new Date());
        appVersion.setCreateDate(new Date());
        int i = ne.insert(appVersion);
        String msg="";
        if (i>0){
            msg="修改成功";
        }else {
            msg="修改失败";
        }
        return msg;
    }


}
