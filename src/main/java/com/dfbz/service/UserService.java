package com.dfbz.service;

import com.dfbz.entity.Sysuser;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface UserService extends Tservice<Sysuser>{


    PageInfo<Sysuser> serviceUser(Map<String,Object> map);


}
