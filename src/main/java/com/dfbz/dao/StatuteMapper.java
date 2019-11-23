package com.dfbz.dao;

import com.dfbz.dao.Impi.StatuteImpi;
import com.dfbz.entity.Examine;
import com.dfbz.entity.Statute;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface StatuteMapper extends Mapper<Statute> {

    @SelectProvider(type = StatuteImpi.class,method = "selectStatute")
    List<Statute> selectStatute(Map<String, Object> map);
}