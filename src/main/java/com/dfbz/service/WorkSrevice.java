package com.dfbz.service;

import com.dfbz.entity.Work;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface WorkSrevice extends Tservice<Work>{

    PageInfo<Work> selectSponsor(Map<String,Object> map);
}
