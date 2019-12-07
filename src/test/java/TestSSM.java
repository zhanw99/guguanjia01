import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.controller.AppVersionController;
import cn.zhanw.entity.AppVersion;
import cn.zhanw.mapper.AppVersionMapper;
import cn.zhanw.service.AppVersionService;
import cn.zhanw.service.IService;
import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestSSM {

    @Autowired
    DruidDataSource druidDataSource;

    @Autowired
    SqlSessionFactory factoryBean;

    @Autowired
    AppVersionMapper mapper;


    @Autowired
    AppVersionService appVersionService;





    @Test
    public void testConn() throws SQLException {
        System.out.println(druidDataSource.getConnection());

    }

    @Test
    public void testFactory() throws Exception {
        System.out.println(factoryBean.openSession().getConnection());

    }

    @Test
    public void testSelectOne() {
        AppVersion appVersion = mapper.selectByPrimaryKey(1);
        System.out.println(appVersion);

    }

    @Test
    public void testServiceKey() {
        AppVersion appVersion = (AppVersion) appVersionService.selectByPrimaryKey(1);
        System.out.println(appVersion);
    }

    @Test
    public void testService(){
        List<AppVersion> appVersions = appVersionService.selectAll();
        for (AppVersion appVersion : appVersions) {
            System.out.println(appVersion);
        }
    }

    @Test
    public void testUpdateSeletive(){
        AppVersion appVersion = new AppVersion();
        appVersion.setId(1L);
        appVersion.setUpdateDate(new Date());
        appVersion.setSize(200.0F);
        int i = mapper.updateByPrimaryKeySelective(appVersion);
    }

    /***
     * 插入一条记录并返回自增主键
     */
    @Test
    public void testInsert(){
        AppVersion appVersion = new AppVersion();

        appVersion.setUpdateDate(new Date());
        appVersion.setSize(200.0F);
        appVersion.setPlatform(0);
        appVersion.setVersionNo("1.8.0");
        appVersion.setDownPath("http://127.0.0.1:8080/guguanjia/manager/#/ajax/manager/app/index");
        appVersion.setCreateDate(new Date());
        appVersion.setCreateBy("admin");
        appVersion.setDelFlag("0");
        int i = mapper.insertSelective(appVersion);
        System.out.println(appVersion);
    }


    @Test
    public  void testPageHelper(){
        PageHelper.startPage(2,3);
        List<AppVersion> appVersions = mapper.selectAll();
        PageInfo<AppVersion> pageInfo = new PageInfo<AppVersion>(appVersions);
        System.out.println(pageInfo.getList());//获取集合
    }
    @Test
    public  void testPageHelperAll(){
        appVersionService.selectAll(2,3);
    }

    //跟新
    @Test
    public  void updateKey(){
        AppVersion appVersion = new AppVersion();
        appVersion.setId(1L);
        appVersion.setSize(1.0F);
        int i = mapper.updateByPrimaryKeySelective(appVersion);
    }

    @Test
    public  void toUpdate(){
        AppVersion appVersion = (AppVersion) appVersionService.selectByPrimaryKey(1);
        System.out.println(appVersion);

    }




}
