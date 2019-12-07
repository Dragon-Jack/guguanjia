package com.dfbz.service;

import com.dfbz.entity.Sysuser;

import java.util.Map;

public interface LoginService extends Tservice<Sysuser>{
    Sysuser toLong(Map<String, Object> params);
}
