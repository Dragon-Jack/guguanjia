package com.dfbz.dao;

import com.dfbz.dao.Impi.sysRoleImpi;
import com.dfbz.entity.SysRole;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import javax.xml.ws.WebServiceProvider;
import java.util.List;
import java.util.Map;

public interface SysRoleMapper extends Mapper<SysRole> {


    @Select("SELECT " +
            "sr.name " +
            "from " +
            "sys_user su " +
            "LEFT JOIN " +
            "sys_user_role sur " +
            "on " +
            "sur.user_id=su.id " +
            "LEFT JOIN " +
            "sys_role sr " +
            "on " +
            "sur.role_id=sr.id " +
            "where " +
            "su.id=#{uid}")
    List<SysRole> selectrole(long uid);


    @SelectProvider(type = sysRoleImpi.class,method = "selectSection")
    List<SysRole> selectSection(Map<String,Object> map);
}