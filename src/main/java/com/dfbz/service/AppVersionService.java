package com.dfbz.service;


import com.dfbz.entity.AppVersion;
import com.github.pagehelper.PageInfo;


public interface AppVersionService extends Tservice<AppVersion>{


PageInfo<AppVersion> selectpag(Integer pagename, Integer pagesize);



}
