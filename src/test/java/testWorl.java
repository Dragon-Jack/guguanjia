import com.dfbz.config.SpringMybatis;
import com.dfbz.dao.WorkMapper;
import com.dfbz.service.WorkSrevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class testWorl {

    @Autowired
    WorkSrevice srevice;

    @Autowired
    WorkMapper mapper;

    @Test
    public void test(){


        System.out.println( mapper.order(2)+"************");
    }

}
