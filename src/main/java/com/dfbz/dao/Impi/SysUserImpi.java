package com.dfbz.dao.Impi;

import org.springframework.util.StringUtils;

import java.util.Map;

public class SysUserImpi {

    public String selectuser(Map<String,Object> map){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "su.id, " +
                "su.company_id, " +
                "su.office_id, " +
                "su.username, " +
                "su.`password`, " +
                "su.`no`, " +
                "su.`name`, " +
                "su.email, " +
                "su.phone, " +
                "su.mobile, " +
                "su.user_type, " +
                "su.device_code, " +
                "su.login_ip, " +
                "su.login_date, " +
                "su.create_by, " +
                "su.create_date, " +
                "su.update_by, " +
                "su.update_date, " +
                "su.remarks, " +
                "su.del_flag, " +
                "su.`status`, " +
                "su.head_picture, " +
                "so.`name` offname " +
                "FROM " +
                "sys_user su " +
                "LEFT JOIN " +
                "sys_office so " +
                "on " +
                "su.office_id=so.id ");
        if (map.containsKey("srname")&&!StringUtils.isEmpty("srname")){
            sb.append("LEFT JOIN " +
                    "sys_user_role sur " +
                    "on " +
                    "su.id=sur.user_id " +
                    "LEFT JOIN " +
                    "sys_role sr " +
                    "on " +
                    "sur.role_id=sr.id " +
                    " " +
                    "where " +
                    "su.del_flag=0 ");
            sb.append(" and sr.`name`=#{srname} ");
        }else {
            sb.append(" where su.del_flag=0 ");
        }
        if (map.containsKey("offname")&&!StringUtils.isEmpty("offname")){
            sb.append("and so.`name`=#{offname}");
        }
        if (map.containsKey("username")&&!StringUtils.isEmpty("username")){
            sb.append("and su.`name`LIKE CONCAT('%',#{username},'%')");
        }
        if (map.containsKey("uid")&&!StringUtils.isEmpty("uid")){
            sb.append(" and su.id=#{uid}");
        }
        return sb.toString();
    }
}
