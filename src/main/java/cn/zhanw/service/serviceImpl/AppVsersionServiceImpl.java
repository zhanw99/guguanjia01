package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.AppVersion;
import cn.zhanw.service.AppVersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 通用实现类    实现通用接口方法
 */
@Service
@Transactional
public class AppVsersionServiceImpl extends IServiceImpl<AppVersion> implements AppVersionService {


    @Override
    public PageInfo<AppVersion> selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);//开启分页拦截功能

        List<AppVersion> appVersions = mapper.selectAll();//自动分页
        PageInfo<AppVersion> pageInfo = new PageInfo<AppVersion>(appVersions);//生成分页对象
//        System.out.println(pageInfo.getList());//获取集合
        return pageInfo;
    }
}
