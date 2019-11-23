package com.dfbz.dao;

import com.dfbz.dao.Impi.ExaminImpe;
import com.dfbz.entity.Examine;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ExamineMapper extends Mapper<Examine> {


    @SelectProvider(type = ExaminImpe.class,method = "selectExamin")
    List<Examine> selectExamin(Map<String, Object> map);
}