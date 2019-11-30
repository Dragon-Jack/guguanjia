import com.dfbz.config.SpringMybatis;
import com.dfbz.service.SysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class testRole {

    @Autowired
    SysRoleService sysRoleService;


    @Test
    public void testrole(){

        HashMap<String, Object> map = new HashMap<>();
//        map.put("offname","固管家服务平台");
//        map.put("srname","超级");
        System.out.println(sysRoleService.selectSection(map));
    }

}
