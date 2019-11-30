import com.dfbz.config.SpringMybatis;
import com.dfbz.dao.ExamineMapper;
import com.dfbz.entity.Examine;
import com.dfbz.service.ExaminService;
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
public class testExamin {

    @Autowired
    ExamineMapper dao;

    @Autowired
    ExaminService es;

    @Test
    public void test() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", 1);
        List<Examine> examines = dao.selectExamin(map);
        System.out.println(examines);
    }

    @Test
    public void testpageInfo(){

        HashMap<String, Object> map = new HashMap<>();
        PageInfo<Examine> selectexamin = es.selectexamin(map);

        System.out.println(selectexamin);
    }
}
