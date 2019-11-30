package com.dfbz.dao.Impi;

import org.springframework.util.StringUtils;

import java.util.Map;

public class sysRoleImpi {

    public String selectSection(Map<String,Object> map){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "sr.id, " +
                "sr.office_id, " +
                "sr.`name`, " +
                "sr.data_scope, " +
                "sr.create_by, " +
                "sr.create_date, " +
                "sr.update_by, " +
                "sr.update_date, " +
                "sr.remarks, " +
                "sr.del_flag, " +
                " " +
                "so.`name` offname " +
                "FROM " +
                "sys_role AS sr " +
                "LEFT JOIN " +
                "sys_office so " +
                "on " +
                "sr.office_id=so.id " +
                "WHERE " +
                "sr.del_flag=0 ");
        if (map.containsKey("offname")&&!StringUtils.isEmpty("offname")){
            sb.append("and so.`name`=#{offname}");
        }
        if (map.containsKey("srname")&&!StringUtils.isEmpty("srname")){
            sb.append(" and sr.`name` LIKE CONCAT('%',#{srname},'%')");
        }
        return sb.toString();
    }
}
