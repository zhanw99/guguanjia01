package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.Qualification;
import cn.zhanw.mapper.QualificationMapper;
import cn.zhanw.service.QualificationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
@Transactional  //这个方法的事务由spring处理，即是方法里面对数据库操作
public class QualificationServiceImpl extends IServiceImpl<Qualification> implements QualificationService {

    @Override
    public PageInfo<Qualification> selectAll(Integer pageNum, Integer pageSize) {
        //开启分页查询功能
        PageHelper.startPage(pageNum,pageSize);
        //根据Qualification字节码文件对象创建一个动态SQL对象
        //拼接sql  调用 mapper方法
        Example example = new Example(Qualification.class);
        //创建一个动态SQL 构建对象 andEqualTo（属性名，属性值）
        //select * from qualification where type = 1
        Example.Criteria criteria = example.createCriteria();
        //andEqualTo("type", "0");//条件相等
        criteria.andEqualTo("delFlag","0");

        List<Qualification> qualifications = mapper.selectByExample(example);

        QualificationMapper qualificationMapper = (QualificationMapper) mapper;

        //根据qualifications中的uploadUserId和checkUserId查询数据
        for (Qualification qualification : qualifications) {
            Map<String, Object> names = qualificationMapper.selectNames(qualification.getId());
            qualification.setCheckUserName((String) names.get("checkUserName"));
            qualification.setUploadUserName((String)names.get("uploadUserName"));
        }
        return new PageInfo<Qualification>(qualifications);

    }
    /**
     * 根据条件判断，进行动态sql
     *
     * params：
     * pageNum、pageSize、type、check、begin、end
     *
     * @param params
     * @return
     */
    @Override
    public PageInfo<Qualification> selectByCondition(Map<String, Object> params) {
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
        //andEqualTo("type", "0");//条件相等
        criteria.andEqualTo("delFlag","0");
        if(!StringUtils.isEmpty(params.get("type"))){
            //andEqualTo("type", "0");//条件相等
            criteria.andEqualTo("type",params.get("type"));
        }
        if (!StringUtils.isEmpty(params.get("check"))){
            //andEqualTo("type", "0");//条件相等
            criteria.andEqualTo("check",params.get("check"));
        }

        if (!StringUtils.isEmpty(params.get("createDate"))){
           // andGreaterThan("updateDate", "2018-01-11");//大于
            criteria.andGreaterThan("createDate",params.get("createDate"));
        }

        if (!StringUtils.isEmpty(params.get("endDate"))){
            //.andLessThan("updateDate", "2019-11.14");//小于
            criteria.andLessThan("createDate",params.get("endDate"));
        }
        List<Qualification> qualifications = mapper.selectByExample(example);

        QualificationMapper qualificationMapper = (QualificationMapper) mapper;

        //根据qualifications中的uploadUserId和checkUserId查询数据
        for (Qualification qualification : qualifications) {
            Map<String, Object> names = qualificationMapper.selectNames(qualification.getId());
            qualification.setCheckUserName((String) names.get("checkUserName"));
            qualification.setUploadUserName((String)names.get("uploadUserName"));
        }
        return new PageInfo<Qualification>(qualifications);

    }
}
