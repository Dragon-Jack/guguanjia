package com.dfbz.service.Impi;

import com.dfbz.dao.SysuserMapper;
import com.dfbz.entity.Statute;
import com.dfbz.entity.Sysuser;
import com.dfbz.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpi extends TserviceImpi<Sysuser> implements UserService {
    @Autowired
    SysuserMapper sysuserMapper;


    @Override
    public PageInfo<Sysuser> serviceUser(Map<String, Object> map) {
        if (StringUtils.isEmpty(map.get("pageNum"))){
            map.put("pageNum",1);
        }
        if (StringUtils.isEmpty(map.get("pageSize"))){
            map.put("pageSize",5);
        }
        PageHelper.startPage((Integer) map.get("pageNum"),(Integer) map.get("pageSize"));


        List<Sysuser> selectuser = sysuserMapper.selectuser(map);
        PageInfo<Sysuser> objectPageInfo = new PageInfo<>(selectuser);

        return objectPageInfo;


    }
}
