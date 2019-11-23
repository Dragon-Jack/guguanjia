package com.dfbz.dao.Impi;

import org.springframework.util.StringUtils;
import java.util.Map;

public class QualificationiImpi {


    public String selectqua(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "qu.id, " +
                "qu.upload_user_id, " +
                "qu.type, " +
                "qu.address, " +
                "qu.`check`, " +
                "qu.description, " +
                "qu.check_user_id, " +
                "qu.create_date, " +
                "qu.update_date, " +
                "qu.del_flag, " +
                "qu.create_by, " +
                "su.name " +
                "FROM " +
                "qualification qu, sys_user su " +
                " " +
                "where " +
                "qu.del_flag=0 "
        );
        if (!StringUtils.isEmpty(map.get("type"))) {
            sb.append(" and qu.type=#{type}");
        }
        if (!StringUtils.isEmpty(map.get("check"))){
            sb.append(" and qu.`check`=#{check}");
        }
        if (!StringUtils.isEmpty(map.get("begin"))){
            sb.append(" and qu.update_date>=#{begin}");
        }
        if (!StringUtils.isEmpty(map.get("end"))){
            sb.append(" and qu.update_date<=#{end}");
        }
        sb.append("and qu.check_user_id=su.id");

    return sb.toString();
    }

}
