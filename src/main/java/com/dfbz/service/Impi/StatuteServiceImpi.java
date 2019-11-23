package com.dfbz.service.Impi;

import com.dfbz.dao.StatuteMapper;
import com.dfbz.entity.Examine;
import com.dfbz.entity.Statute;
import com.dfbz.service.StatuteService;
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
public class StatuteServiceImpi extends TserviceImpi<Statute> implements StatuteService {

    @Autowired
    StatuteMapper selectstatute;

    @Override
    public PageInfo<Statute> selectstatute(Map<String, Object> map)  {
        if (StringUtils.isEmpty(map.get("pageNum"))){
            map.put("pageNum",1);
        }
        if (StringUtils.isEmpty(map.get("pageSize"))){
            map.put("pageSize",5);
        }

        PageHelper.startPage((Integer) map.get("pageNum"),(Integer) map.get("pageSize"));
        List<Statute> statutes = selectstatute.selectStatute(map);
        PageInfo<Statute> objectPageInfo = new PageInfo<>(statutes);

        return objectPageInfo;
    }


}
