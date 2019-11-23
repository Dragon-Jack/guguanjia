package com.dfbz.dao.Impi;

import org.springframework.util.StringUtils;

import java.util.Map;

public class WorkImpi {

    public String selectSponsor(Map<String, Object> map) {
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
                "su.`name` username, " +
                "so.`name` name " +
                "FROM " +
                "work_order wo " +
                "join  " +
                "sys_user su " +
                "on " +
                "wo.create_user_id=su.id " +
                "JOIN " +
                "sys_office so " +
                "on " +
                "so.id=su.office_id " +
                "where " +
                "wo.del_flag=0");

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

    public String Transporter() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT  " +
                "wo.id,  " +
                "wo.`code`,  " +
                "wo.create_user_id,  " +
                "wo.transport_user_id,  " +
                "wo.recipient_user_id,  " +
                "wo.`status`,  " +
                "wo.create_date,  " +
                "wo.update_date,  " +
                "wo.del_flag,  " +
                "wo.create_by,  " +
                "su.`name` Transporter  " +
                "FROM  " +
                "work_order wo  " +
                "join   " +
                "sys_user su  " +
                "on  " +
                "wo.recipient_user_id=su.id  ");

        return sb.toString();

    }

    public String Disposer() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT   " +
                "wo.id,   " +
                "wo.`code`,   " +
                "wo.create_user_id,   " +
                "wo.transport_user_id,   " +
                "wo.recipient_user_id,   " +
                "wo.`status`,   " +
                "wo.create_date,   " +
                "wo.update_date,   " +
                "wo.del_flag,   " +
                "wo.create_by,   " +
                "su.`name` Disposer   " +
                "FROM   " +
                "work_order wo   " +
                "join    " +
                "sys_user su   " +
                "on   " +
                "wo.transport_user_id=su.id  ");

        return sb.toString();
    }


    public String order(long id) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT  " +
                "wo.id,  " +
                "wo.`code`,  " +
                "wo.create_user_id,  " +
                "wo.transport_user_id,  " +
                "wo.recipient_user_id,  " +
                "wo.`status`,  " +
                "wo.create_date,  " +
                "wo.update_date,  " +
                "wo.del_flag,  " +
                "wo.create_by,  " +
                "su.`name`  username,  " +
                "tr.`name`  trname,  " +
                "rec.`name`  recname  " +
                "  " +
                "FROM  " +
                "work_order wo  " +
                "join   " +
                "sys_user su  " +
                "on  " +
                "wo.transport_user_id=su.id  " +
                "  " +
                "join   " +
                "sys_user tr  " +
                "on  " +
                "wo.create_user_id=tr.id  " +
                "  " +
                "join   " +
                "sys_user rec  " +
                "on  " +
                "wo.recipient_user_id=rec.id  ");

        if (!StringUtils.isEmpty(id)) {
            sb.append(" where wo.id=#{id}");
        }

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
                "de.waste_id=wa.id ");

        if (StringUtils.isEmpty(id)) {
            sb.append(" where de.work_order_id=#{id}");
        }
        return sb.toString();
    }

    public String transport() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }


}
