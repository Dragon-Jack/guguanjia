package com.dfbz.service.Impi;

import com.dfbz.dao.SysuserMapper;
import com.dfbz.entity.Sysuser;
import com.dfbz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class LoginServiceImpl extends TserviceImpi<Sysuser> implements LoginService {
    @Autowired
    SysuserMapper sysuserMapper;

    public Sysuser toLong(Map<String, Object> params) {
        Sysuser sysuser = new Sysuser();
        sysuser.setUsername((String) params.get("account"));
        sysuser.setPassword((String) params.get("pw"));


        return sysuserMapper.selectOne(sysuser);
    }
}
