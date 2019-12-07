import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.controller.QualifucationController;
import cn.zhanw.entity.Qualification;
import cn.zhanw.mapper.QualificationMapper;
import cn.zhanw.service.QualificationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestQualification {
    @Autowired
    QualificationMapper qualificationMapper;

    @Autowired
    QualificationService service;

    @Test
    public void selectOneService(){
        Qualification qualification = qualificationMapper.selectByPrimaryKey(1);
        System.out.println(qualification);
    }
    @Test
    public void PageService(){
        PageInfo<Qualification> qualificationPageInfo = service.selectAll(1, 5);
        List<Qualification> list = qualificationPageInfo.getList();
        for (Qualification qualification : list) {
            System.out.println(qualification);
        }
    }

    @Test
    public void PageService2(){
        Example example = new Example(Qualification.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("type",1);
        criteria.andEqualTo("check",0).andGreaterThan("updateDate","2013-11-14")
                .andLessThan("updateDate","2019-11-14");
        List<Qualification> qualifications = qualificationMapper.selectByExample(example);
        for (Qualification qualification1 : qualifications) {
            System.out.println(qualification1);
        }

    }
    //SELECT id,upload_user_id,type,address,'check',description,check_user_id,create_date,update_date,del_flag,create_by FROM qualification WHERE ( ( type = ? and 'check' = ? and update_date > ? and update_date < ? ) )


    @Test
    public void pageSer(){
        Map<String,Object>     params =new HashMap();
        //pageNum: 1, pageSize: 5, type: "2", check: "0", startDate: "2019-11-30", endDate: "2019-11-01"
        params.put("pageNum",1);
        params.put("pageSize",5);
        params.put("type",2);
        params.put("check",0);
        params.put("startDate","2013-11-30");
        params.put("endDate","2019-11-01");
        //默认值设置
        if(StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if(StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        //开启分页查询功能
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer) params.get("pageSize"));
        //根据Qualification字节码文件对象创建一个动态SQL对象
        //拼接sql  调用 mapper方法
        Example example = new Example(Qualification.class);
        //创建一个动态SQL 构建对象 andEqualTo（属性名，属性值）
        //select * from qualification where type = 1
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("delFlag","0");
        if(!StringUtils.isEmpty(params.get("type"))){
            criteria.andEqualTo("type",params.get("type"));
        }
        if (!StringUtils.isEmpty(params.get("check"))){
            criteria.andEqualTo("check",params.get("check"));
        }

        if (!StringUtils.isEmpty(params.get("createDate"))){
            criteria.andGreaterThan("createDate",params.get("createDate"));
        }

        if (!StringUtils.isEmpty(params.get("endDate"))){
            criteria.andLessThan("createDate",params.get("endDate"));
        }
        List<Qualification> qualifications = qualificationMapper.selectByExample(example);

        QualificationMapper qualificationMapper2 = (QualificationMapper) qualificationMapper;

        for (Qualification qualification : qualifications) {
            Map<String, Object> stringObjectMap = qualificationMapper2.selectNames(qualification.getId());
            qualification.setCheckUserName((String) stringObjectMap.get("checkUserName"));
            qualification.setUploadUserName((String) stringObjectMap.get("uploadUserName"));

        }
        PageInfo pageInfo=  new PageInfo<Qualification>(qualifications);
        System.out.println(pageInfo.getSize());
    }

}
