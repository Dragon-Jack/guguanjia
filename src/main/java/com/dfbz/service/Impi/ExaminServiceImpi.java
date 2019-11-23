package com.dfbz.service.Impi;

import com.dfbz.dao.ExamineMapper;
import com.dfbz.entity.Examine;
import com.dfbz.service.ExaminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class ExaminServiceImpi extends TserviceImpi<Examine> implements ExaminService {

    @Autowired
    ExamineMapper dao;

    @Override
    public PageInfo<Examine> selectexamin(Map<String, Object> pageInfo) {
        if (StringUtils.isEmpty(pageInfo.get("pageNum"))){
            pageInfo.put("pageNum",1);
        }
        if (StringUtils.isEmpty(pageInfo.get("pageSize"))){
            pageInfo.put("pageSize",5);
        }

        PageHelper.startPage((Integer) pageInfo.get("pageNum"),(Integer) pageInfo.get("pageSize"));
        List<Examine> examines = dao.selectExamin(pageInfo);
        PageInfo<Examine> objectPageInfo = new PageInfo<>(examines);

        return objectPageInfo;

    }
}
