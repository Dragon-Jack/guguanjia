package com.dfbz.service.Impi;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.dfbz.dao.AreaMapper;
import com.dfbz.entity.Area;
import com.dfbz.listener.ListenerArea;
import com.dfbz.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

@Service
@Transactional(readOnly = false)    //true是开启只读，不允许增删改
public class AreaServiceImpi extends TserviceImpi<Area> implements AreaService {

    @Autowired
    AreaMapper areaMapper;


    public void writeExcel(){       //写成Excel
        List<Area> areas = areaMapper.selectAll();

        ExcelWriter build = EasyExcel.write("D:\\excel\\text.xlsx",Area.class).build();
        WriteSheet build1 = EasyExcel.writerSheet("dragon").build();

        build.write(areas,build1);
        build.finish();
    }


    public void readExcel(InputStream inputStream){     //把excel写到数据库
        ExcelReader build = EasyExcel.read(inputStream,Area.class,new ListenerArea(areaMapper)).build();
        ReadSheet build1 = EasyExcel.readSheet(0).build();  //读第一张表,0是下标
        build.read(build1);
        build.finish();
    }
}
