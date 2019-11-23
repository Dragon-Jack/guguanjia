package com.dfbz.service;

import com.dfbz.entity.AppVersion;
import com.dfbz.entity.Qualification;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface QualificationService extends Tservice<Qualification> {





    PageInfo<Qualification> selectqua(Map<String,Object> map);
}
