package com.dfbz.dao.Impi;

import org.springframework.util.StringUtils;

import java.util.Map;

public class ExaminImpe {

    public String selectExamin(Map<String, Object> map) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT   " +
                "ex.id,   " +
                "ex.examine_user_id,   " +
                "ex.score,   " +
                "ex.score_info,   " +
                "ex.type,   " +
                "ex.create_date,   " +
                "ex.update_date,   " +
                "ex.del_flag,   " +
                "ex.create_by,   " +
                "su.name username,   " +
                "so.name officename   " +
                "FROM   " +
                "examine ex left JOIN sys_user su   " +
                "on   " +
                "su.id=ex.examine_user_id   " +
                "left join   " +
                "sys_office so   " +
                "on   " +
                "su.office_id=so.id   " +
                "where   " +
                "ex.del_flag=0");

        if (!StringUtils.isEmpty(map.get("username"))) {
            sb.append(" and su.name=#{username}");
        }
        if (!StringUtils.isEmpty(map.get("type"))) {
            sb.append(" and ex.type=#{type}");
        }
        if (!StringUtils.isEmpty(map.get("name"))){
            sb.append("and so.name=#{name}");
        }
        return sb.toString();

    }
}
