package com.dfbz.service;

import com.dfbz.entity.Examine;
import com.github.pagehelper.PageInfo;

import java.util.Map;


public interface ExaminService extends  Tservice<Examine> {
    PageInfo<Examine> selectexamin(Map<String,Object> map);
}
