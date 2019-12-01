package com.dfbz.service.Impi;

import com.dfbz.dao.Roledis;
import com.dfbz.entity.Sysuser;
import com.dfbz.service.RoledisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoledisServiceImpi extends TserviceImpi<Sysuser> implements RoledisService {

    @Autowired
    Roledis roledis;

    @Override
    public List<Sysuser> selectrole(String srname) {

        return roledis.selectRoledis(srname);
    }
}
