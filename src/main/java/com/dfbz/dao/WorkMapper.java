package com.dfbz.dao;

import com.dfbz.dao.Impi.WorkImpi;
import com.dfbz.entity.Work;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface WorkMapper extends Mapper<Work> {

    //查询页

    @SelectProvider(type = WorkImpi.class,method = "selectSponsor")
    List<Work> selectSponsor(Map<String,Object> map);

    @SelectProvider(type = WorkImpi.class,method = "Transporter")
    List<Work> Transporter();

    @SelectProvider(type = WorkImpi.class,method = "Disposer")
    List<Work> Disposer();



//    订单页

    @SelectProvider(type = WorkImpi.class,method = "order")
    List<Work> order(long id);

    @SelectProvider(type = WorkImpi.class,method = "waste")
    List<Work> waste(long id);

    @SelectProvider(type = WorkImpi.class,method = "transport")
    List<Work> transport();


}