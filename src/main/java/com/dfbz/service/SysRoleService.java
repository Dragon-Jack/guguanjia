package com.dfbz.service;

import com.dfbz.entity.SysRole;
import com.dfbz.entity.sysOffice;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface SysRoleService extends Tservice<SysRole>{

    PageInfo<SysRole> selectSection(Map<String,Object> map);

   List<sysOffice> toselect();

}
