package com.dfbz.dao;

import com.dfbz.dao.Impi.AreaImpi;
import com.dfbz.entity.Area;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;

public interface AreaMapper extends Mapper<Area> {


    @SelectProvider(type = AreaImpi.class,method = "insertBatch")
    String insertBatch(@Param("list") ArrayList<Area> list);
}