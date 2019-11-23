package com.dfbz.service.Impi;

import com.dfbz.dao.WorkMapper;
import com.dfbz.entity.Work;
import com.dfbz.service.WorkSrevice;
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
public class WorkServiceImpi extends TserviceImpi<Work> implements WorkSrevice {

    @Autowired
    WorkMapper workMapper;

    @Override
    public PageInfo<Work> selectSponsor(Map<String, Object> map) {
        if (StringUtils.isEmpty(map.get("pageNum"))){
            map.put("pageNum",1);
        }
        if (StringUtils.isEmpty(map.get("pageSize"))){
            map.put("pageSize",5);
        }


        PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
        List<Work> works = workMapper.selectSponsor(map);
        PageInfo<Work> objectPageInfo = new PageInfo<>(works);

        return objectPageInfo;
    }
}
