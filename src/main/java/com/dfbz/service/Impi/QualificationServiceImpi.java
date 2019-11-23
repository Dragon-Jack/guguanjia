package com.dfbz.service.Impi;

import com.dfbz.dao.QualificationMapper;
import com.dfbz.entity.Qualification;
import com.dfbz.service.QualificationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;


@Service
@Transactional
public class QualificationServiceImpi extends TserviceImpi<Qualification> implements QualificationService {


    @Autowired
    QualificationMapper dao;

//    @Override
//    public List<Qualification> selectqua(Map<String, Object> map) {
//        List<Qualification> selectqua = dao.selectqua(map);
//        return selectqua;
//    }

    @Override
    public PageInfo<Qualification> selectqua(Map<String, Object> pageInfo) {
        if (StringUtils.isEmpty(pageInfo.get("pageNum"))){
            pageInfo.put("pageNum",1);
        }
        if (StringUtils.isEmpty(pageInfo.get("pageSize"))){
            pageInfo.put("pageSize",5);
        }

        PageHelper.startPage((Integer) pageInfo.get("pageNum"),(Integer) pageInfo.get("pageSize"));
        List<Qualification> selectqua = dao.selectqua(pageInfo);
        PageInfo<Qualification> objectPageInfo = new PageInfo<>(selectqua);
        return objectPageInfo;
    }

}
