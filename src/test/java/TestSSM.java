
import com.alibaba.druid.pool.DruidDataSource;
import com.dfbz.config.SpringMybatis;
import com.dfbz.dao.ExamineMapper;
import com.dfbz.entity.AppVersion;
import com.dfbz.entity.Qualification;
import com.dfbz.service.AppVersionService;
import com.dfbz.service.QualificationService;
import com.dfbz.service.Tservice;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class TestSSM {


    @Autowired
    AppVersionService e;

    @Autowired
    QualificationService qualificationService;



    @Test
    public void test() {
        //PageInfo<AppVersion> selectpag = e.selectpag(1, 5);
        List<AppVersion> select = e.selectAll();
        for (AppVersion a:select             ) {

        System.out.println(a);
        }
    }

    @Test
    public void testadd() {
        AppVersion appVersion = new AppVersion();
        appVersion.setCreateDate(new Date());
        appVersion.setUpdateDate(new Date());
        appVersion.setDelFlag("0");
        appVersion.setCreateBy("超级管理员");
        appVersion.setAppExplain("优化界面");
        appVersion.setDownPath("http://127.0.0.1:8080/guguanjia/manager/#/ajax/manager/app/index");
        appVersion.setForceUpdate(0);
        appVersion.setPlatform(0);
        appVersion.setSize(180F);
        appVersion.setVersionNo("1.5.3");
        e.insert(appVersion);
    }

    @Test
    public void test111() {
        List<Qualification> qualifications = qualificationService.selectAll();
        for (Qualification qualification : qualifications) {

            System.out.println(qualification);
        }
    }

    @Test
    public void testqua() {
        Map<String, Object> ma = new HashMap<String, Object>();

        System.out.println(qualificationService.selectqua(ma));
    }




}
