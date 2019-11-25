package com.dfbz.dao;

import com.dfbz.dao.Impi.WorkImpi;
import com.dfbz.entity.Detail;
import com.dfbz.entity.Transfer;
import com.dfbz.entity.Work;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface WorkMapper extends Mapper<Work> {

    //查询页

    @SelectProvider(type = WorkImpi.class,method = "selectSponsor")
    List<Work> selectSponsor(Map<String,Object> map);



//    查看订单页

    @SelectProvider(type = WorkImpi.class,method = "order")
    Work order(long id);

    @SelectProvider(type = WorkImpi.class,method = "waste")
    Detail waste(long id);

    @SelectProvider(type = WorkImpi.class,method = "transport")
    Transfer transport(long id);


}