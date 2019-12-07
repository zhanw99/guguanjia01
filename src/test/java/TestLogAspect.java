import cn.zhanw.config.SpringMvcConfig;
import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.controller.AppVersionController;
import cn.zhanw.controller.SysLogController;
import cn.zhanw.entity.AppVersion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMybatisConfig.class, SpringMvcConfig.class})
@WebAppConfiguration  //测试controller层
public class TestLogAspect {
    @Autowired
    AppVersionController versionController;

    @Test
    public void test1(){
        AppVersion appVersion = versionController.toUpdate((long) 1);
        System.out.println(appVersion);
    }





}
