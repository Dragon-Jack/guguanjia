package com.dfbz.controller;


import com.dfbz.dao.SysuserMapper;
import com.dfbz.entity.AppVersion;
import com.dfbz.entity.Qualification;
import com.dfbz.entity.Sysuser;
import com.dfbz.service.QualificationService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.Map;

@Controller
@RequestMapping("manager/qualification/index")
public class QualificationConteroller {



    @Autowired
    QualificationService tservice;

    @Autowired
    SysuserMapper user;

    @Value("${imgpath}")
    String imgpath;

    @RequestMapping("toselect")
    @ResponseBody
    public PageInfo<Qualification> select(@RequestBody Map<String,Object> pageInfo){
        return  tservice.selectqua(pageInfo);
    }

    @RequestMapping("toupdata")
    @ResponseBody
    public Qualification toupdata(Integer id){
        Qualification qualification = tservice.selectByPrimaryKey(id);
        Sysuser sysuser = user.selectByPrimaryKey(qualification.getUploadUserId());

        //File.separator  等于斜线  /
        qualification.setAddress(imgpath+sysuser.getOfficeId()+File.separator+qualification.getAddress());

        return qualification;
    }


    @RequestMapping(value = "updata",produces = "html/text;charset=utf-8")
    @ResponseBody
    public String update(@RequestBody Qualification appVersion){
        System.out.println(appVersion);
        appVersion.setAddress(null);
        int i = tservice.updateByPrimaryKeySelective(appVersion);
        String msg="";
        if (i>0){
            msg="修改成功";
        }else {
            msg="修改失败";
        }
        return msg;
    }
}
