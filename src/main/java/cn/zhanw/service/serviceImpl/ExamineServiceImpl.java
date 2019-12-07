package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.AppVersion;
import cn.zhanw.entity.Examine;
import cn.zhanw.mapper.ExamineMapper;
import cn.zhanw.service.ExamineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional//开启事务管理
public class ExamineServiceImpl extends IServiceImpl<Examine> implements ExamineService {
    @Autowired
    ExamineMapper mapper;

    @Override
    public PageInfo<Examine> selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);//开启分页拦截功能
        List<Examine> examines = mapper.selectAll();
        PageInfo<Examine> pageInfo = new PageInfo<Examine>(examines);//生成分页对象
        System.out.println(pageInfo.getList());
        return pageInfo;
    }
}
