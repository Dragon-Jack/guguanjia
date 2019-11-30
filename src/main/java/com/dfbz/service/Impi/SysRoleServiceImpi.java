package com.dfbz.service.Impi;

import com.dfbz.dao.SysRoleMapper;
import com.dfbz.dao.sysOfficeMapper;
import com.dfbz.entity.SysRole;
import com.dfbz.entity.sysOffice;
import com.dfbz.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysRoleServiceImpi extends TserviceImpi<SysRole> implements SysRoleService {

    @Autowired
    SysRoleMapper roleMapper;
    @Autowired
    sysOfficeMapper officeMapper;

    @Override
    public PageInfo<SysRole> selectSection(Map<String,Object> map) {
        if (StringUtils.isEmpty(map.get("pageNum"))){
            map.put("pageNum",1);
        }
        if (StringUtils.isEmpty(map.get("pageSize"))){
            map.put("pageSize",5);
        }
        PageHelper.startPage((Integer) map.get("pageNum"),(Integer) map.get("pageSize"));

        List<SysRole> sysRoles = roleMapper.selectSection(map);
        PageInfo<SysRole> objectPageInfo = new PageInfo<>(sysRoles);

        return objectPageInfo;
    }

    @Override
    public List<sysOffice> toselect() {
        return officeMapper.selectAll();
    }


}
