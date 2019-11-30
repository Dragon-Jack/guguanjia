package com.dfbz.dao;

import com.dfbz.dao.Impi.SysUserImpi;
import com.dfbz.entity.Sysuser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysuserMapper extends Mapper<Sysuser> {

    @SelectProvider(type = SysUserImpi.class,method = "selectuser")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "srname",many = @Many(select = "com.dfbz.dao.SysRoleMapper.selectrole"))
    })
    List<Sysuser> selectuser(Map<String,Object> map);


}