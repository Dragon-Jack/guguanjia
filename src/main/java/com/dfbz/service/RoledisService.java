package com.dfbz.service;

import com.dfbz.entity.Sysuser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoledisService extends Tservice<Sysuser>{

    List<Sysuser> selectrole(String srname);
}
