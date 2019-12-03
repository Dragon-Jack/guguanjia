package com.dfbz.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.dfbz.entity.Area;
import com.dfbz.listener.ListenerArea;
import com.dfbz.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("manager/area")
public class AreaConteroller {


    @Autowired
    AreaService areaService;

    @RequestMapping("Region")
    @ResponseBody
    public List<Area> Region() {
        return areaService.selectAll();
    }

    @RequestMapping("writeExcel")
    @ResponseBody
    public void writeExcel() {
        areaService.writeExcel();
    }

    @RequestMapping("readExcel")
    @ResponseBody
    public void readExcel(@RequestParam(required = false, name = "file") MultipartFile file) throws IOException {
        if (file==null){
            System.out.println(this.getClass().getName()+":上传文件为空");
        }
        areaService.readExcel(file.getInputStream());
    }
}
