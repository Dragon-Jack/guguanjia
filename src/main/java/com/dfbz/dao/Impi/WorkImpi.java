package com.dfbz.dao.Impi;

import com.dfbz.entity.Detail;
import org.springframework.util.StringUtils;

import java.util.Map;

public class WorkImpi {

    public String selectSponsor(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT  " +
                " wo.id, " +
                " wo.`code`, " +
                " wo.create_user_id, " +
                " wo.transport_user_id,  " +
                " wo.recipient_user_id,  " +
                " wo.`status`,  " +
                " wo.create_date,  " +
                " wo.update_date,  " +
                " wo.del_flag,  " +
                " wo.create_by, " +
                " cr.`name` crname, " +
                " tr.`name` trname,  " +
                " rec.`name` recname,  " +
                " so.`name` name  " +
                " FROM " +
                " work_order wo  " +
                "  " +
                " left join   " +
                " sys_user cr " +
                " on  " +
                " wo.create_user_id=cr.id  " +
                "  " +
                " left join   " +
                " sys_user tr " +
                " on  " +
                " wo.transport_user_id=tr.id " +
                "  " +
                " left join   " +
                " sys_user rec " +
                " on  " +
                " wo.recipient_user_id=rec.id " +
                "  " +
                " left JOIN  " +
                " sys_office so  " +
                " on  " +
                " cr.office_id=so.id " +
                " where  " +
                " wo.del_flag=0");

        if (!StringUtils.isEmpty(map.get("status"))) {
            sb.append(" and wo.`status`=#{status}");
        }
        if (!StringUtils.isEmpty(map.get("begin"))) {
            sb.append(" and wo.update_date>#{begin}");
        }
        if (!StringUtils.isEmpty(map.get("end"))) {
            sb.append(" and wo.update_date<#{end}");
        }
        if (!StringUtils.isEmpty(map.get("name"))) {
            sb.append(" and so.`name`=#{name}");
        }

        return sb.toString();
    }


    public String order(long id) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT " +
                "wo.id, " +
                "wo.`code`, " +
                "wo.create_user_id, " +
                "wo.transport_user_id, " +
                "wo.recipient_user_id, " +
                "wo.`status`, " +
                "wo.create_date, " +
                "wo.update_date, " +
                "wo.del_flag, " +
                "wo.create_by, " +
                " " +
                "cr.`name` crname, " +
                "cr.phone crphone, " +
                "tr.`name` trname, " +
                "tr.phone trphone, " +
                "rec.`name` recname, " +
                "rec.phone recphone, " +
                "so.`name` name " +
                " " +
                "FROM " +
                "work_order wo " +
                "LEFT join " +
                "sys_user cr " +
                "on " +
                "wo.create_user_id=cr.id " +
                "LEFT join " +
                "sys_user tr " +
                "on " +
                "wo.transport_user_id=tr.id " +
                "LEFT join " +
                "sys_user rec " +
                "on " +
                "wo.recipient_user_id=rec.id " +
                "LEFT join " +
                "sys_office so " +
                "on " +
                "cr.office_id=so.id " +
                " " +
                "where  " +
                "wo.id=#{id}");

        return sb.toString();
    }

    public String waste(long id) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT  " +
                "de.id,  " +
                "de.work_order_id,  " +
                "de.waste_type_id,  " +
                "de.waste_id,  " +
                "de.component,  " +
                "de.weight,  " +
                "de.morphological,  " +
                "de.packaging,  " +
                "de.plate_number,  " +
                "de.create_date,  " +
                "de.update_date,  " +
                "de.del_flag,  " +
                "de.create_by,  " +
                "wt.`name` watyname,  " +
                "wt.`code` watycode,  " +
                "wa.code wastecode  " +
                "FROM  " +
                "detail de  " +
                "left JOIN  " +
                "waste_type wt  " +
                "on  " +
                "de.waste_type_id=wt.id  " +
                "LEFT JOIN  " +
                "waste wa  " +
                "on  " +
                "de.waste_id=wa.id " +
                "where " +
                "work_order_id=#{id}");

        return sb.toString();
    }

    public String transport(long id){
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT  " +
                "tr.id,  " +
                "tr.content,  " +
                "tr.oprate_user_id,  " +
                "tr.created_at,  " +
                "tr.work_order_id,  " +
                "tr.create_date,  " +
                "tr.update_date,  " +
                "tr.del_flag,  " +
                "tr.create_by,  " +
                "su.`name` username,  " +
                "su.phone phone,  " +
                "su.mobile mobile  " +
                "FROM  " +
                "transfer tr  " +
                "LEFT JOIN  " +
                "sys_user su  " +
                "on  " +
                "tr.oprate_user_id=su.id  " +
                "where  " +
                "tr.id=#{id}");

        return sb.toString();
    }


}
