package com.dfbz.dao.Impi;

import org.springframework.util.StringUtils;

public class RoledisImpi {

    public String selectRoledis(String srname){
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
                "su.head_picture " +
                "FROM " +
                "sys_user AS su " +
                "LEFT JOIN " +
                "sys_user_role sur " +
                "on " +
                "su.id=sur.user_id " +
                "LEFT JOIN " +
                "sys_role sr " +
                "on " +
                "sur.role_id=sr.id ");

        if (!StringUtils.isEmpty("srname")){
            sb.append("where sr.`name`=#{srname}");
        }
        return sb.toString();
    }
}
