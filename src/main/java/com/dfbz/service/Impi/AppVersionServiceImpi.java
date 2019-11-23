package com.dfbz.service.Impi;

import com.dfbz.dao.AppVersionMapper;
import com.dfbz.entity.AppVersion;
import com.dfbz.service.AppVersionService;
import com.dfbz.service.Tservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AppVersionServiceImpi extends TserviceImpi<AppVersion> implements AppVersionService {

    @Autowired
    AppVersionService dao;


    @Override
    public PageInfo<AppVersion> selectpag(Integer pagenum, Integer pagesize) {

        PageHelper.startPage(pagenum, pagesize);     //开启分页拦截

        AppVersion appVersion = new AppVersion();
        appVersion.setDelFlag("0");
            //List<AppVersion> appVersions = dao.selectAll();
        List<AppVersion> appVersions = dao.select(appVersion);
            //把查询出来的所有数据以分页显示
        PageInfo<AppVersion> PageInfo = new PageInfo<>(appVersions);

        return PageInfo;
    }

    @Override
    public int updateByExampleSelective(AppVersion appVersion, Object example) {
        return super.updateByExampleSelective(appVersion, example);
    }
}
