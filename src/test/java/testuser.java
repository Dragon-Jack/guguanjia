import com.dfbz.config.SpringMybatis;
import com.dfbz.dao.SysRoleMapper;
import com.dfbz.dao.SysuserMapper;
import com.dfbz.entity.SysRole;
import com.dfbz.entity.Sysuser;
import com.dfbz.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class testuser {
    @Autowired
    SysuserMapper sysuserMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    UserService userService;


    @Test
    public void testuser(){
        HashMap<String, Object> map = new HashMap<>();
//        map.put("offname","固管家产废方测试机构");
        map.put("uid",26);
//        map.put("name","产废");
//        map.put("srname","单位管理员");
        List<Sysuser> selectuser = sysuserMapper.selectuser(map);
        for (Sysuser sysuser : selectuser) {
            System.out.println(sysuser);
        System.out.println(sysuser.getSrname());
        }

    }

    @Test
    public void selectrole(){
        List<SysRole> selectrole = sysRoleMapper.selectrole(26);
        for (SysRole sysRole : selectrole) {

        System.out.println(sysRole);
        }
    }

    @Test
    public void selectservice(){
        HashMap<String, Object> map = new HashMap<>();
        PageInfo<Sysuser> sysuserPageInfo = userService.serviceUser(map);
        System.out.println(sysuserPageInfo);
    }
}
