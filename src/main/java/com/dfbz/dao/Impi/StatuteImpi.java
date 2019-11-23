package com.dfbz.dao.Impi;

import org.springframework.util.StringUtils;

import java.util.Map;

public class StatuteImpi {

    public String selectStatute(Map<String, Object> map){

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "sta.id, " +
                "sta.area_id, " +
                "sta.type, " +
                "sta.title, " +
                "sta.pub_date, " +
                "sta.`code`, " +
                "sta.stem_from, " +
                "sta.description, " +
                "sta.create_date, " +
                "sta.update_date, " +
                "sta.del_flag, " +
                "sta.create_by " +
                "FROM " +
                "statute AS sta " +
                "WHERE " +
                "del_flag=0 ");
        if (!StringUtils.isEmpty(map.get("type"))){
            sb.append(" and sta.type=#{type} ");
        }
        return sb.toString();
    }

}
