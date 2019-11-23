package com.dfbz.service;

import com.dfbz.entity.Statute;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface StatuteService extends Tservice<Statute> {

    PageInfo<Statute> selectstatute(Map<String,Object> map);
}
