import com.dfbz.config.SpringMybatis;
import com.dfbz.dao.WorkMapper;
import com.dfbz.entity.Transfer;
import com.dfbz.service.WorkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class testWorl {

    @Autowired
    WorkService srevice;

    @Autowired
    WorkMapper mapper;

    @Test
    public void test(){
        Transfer transport = srevice.transport(1);

        System.out.println("***"+transport);

    }

}
