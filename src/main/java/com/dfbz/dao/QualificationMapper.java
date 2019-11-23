package com.dfbz.dao;

import com.dfbz.dao.Impi.QualificationiImpi;
import com.dfbz.entity.Qualification;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface QualificationMapper extends Mapper<Qualification> {


    @SelectProvider(type = QualificationiImpi.class,method = "selectqua")
    List<Qualification> selectqua(Map<String, Object> map);

}