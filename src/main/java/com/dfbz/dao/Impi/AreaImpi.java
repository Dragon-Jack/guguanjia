package com.dfbz.dao.Impi;

import com.dfbz.entity.Area;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public class AreaImpi {

    public String insertBatch(@Param("list") ArrayList<Area> list) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO " +
                "`guguanjia`.`sys_area`" +
                "(`parent_id`, `parent_ids`, `code`, `name`, `type`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `icon`) VALUES ");

        for (int i = 0; i < list.size(); i++) {
            sb.append("(");
               sb.append("#{list[" + i + "].parentId}," +
                        "#{list[" + i + "].parentIds}," +
                        "#{list[" + i + "].code}," +
                        "#{list[" + i + "].name}," +
                        "#{list[" + i + "].type}," +
                        "#{list[" + i + "].createBy}," +
                        "#{list[" + i + "].createDate}," +
                        "#{list[" + i + "].updateBy}," +
                        "#{list[" + i + "].updateDate}," +
                        "#{list[" + i + "].remarks}," +
                        "#{list[" + i + "].delFlag}," +
                        "#{list[" + i + "].icon}");


            sb.append("),");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
