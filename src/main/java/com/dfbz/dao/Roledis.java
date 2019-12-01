package com.dfbz.dao;

import com.dfbz.dao.Impi.RoledisImpi;
import com.dfbz.entity.Sysuser;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface Roledis {


    @SelectProvider(type = RoledisImpi.class,method = "selectRoledis")
    List<Sysuser> selectRoledis(String srname);

}
