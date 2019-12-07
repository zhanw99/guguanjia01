package cn.zhanw.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;


@Configuration//用于定义配置类，可替换xml配置文件
//映射
@MapperScan(basePackages = "cn.zhanw.mapper")
//包扫描
@ComponentScan(basePackages ={ "cn.zhanw.service","cn.zhanw.utils","cn.zhanw.Interceptor","cn.zhanw.log"})
@EnableTransactionManagement//事务管理，注解启用了事务管理功能
@PropertySource(value = "classpath:sys.properties",encoding = "utf-8")
@Import({SpringRedis.class,SpringCache.class})//引入其他需要用到的配置类
public class SpringMybatisConfig {

    //数据源
    @Bean
    public static DataSource getDataSource() {
        Properties properties = new Properties();
        InputStream resource = SpringMybatisConfig.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setConnectProperties(properties);//自动配置
        return dataSource;
    }

    //设置数据源
    @Bean
    public static SqlSessionFactory getSqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //设置数据源
        factoryBean.setDataSource(dataSource);
        //设置分页插件   分页拦截器  类似过滤器
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(new Properties());//调用设置属性方法，进行方言设置
        factoryBean.setPlugins(new Interceptor[]{pageInterceptor});

        //设置驼峰命名转换
        //第一步测试 替换掉
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //第二步测试sql
        tk.mybatis.mapper.session.Configuration configuration = new tk.mybatis.mapper.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    配置事务
    @Bean
    public static DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }



    //    测试
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = getDataSource();
        System.out.println(getSqlSessionFactoryBean(dataSource));
        System.out.println(getDataSourceTransactionManager(dataSource));
        System.out.println(dataSource.getConnection());
    }
}
//spring和mybatis整合

