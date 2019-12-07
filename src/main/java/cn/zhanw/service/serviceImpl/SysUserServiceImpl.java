package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.SysUser;
import cn.zhanw.mapper.SysUserMapper;
import cn.zhanw.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional//开启事务管理
public class SysUserServiceImpl extends IServiceImpl<SysUser> implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public PageInfo<SysUser> selectPage(Map<String, Object> parms) {
        if (parms.get("pageNum")==null||"".equals(parms.get("pageNum"))){
            parms.put("pageNum",1);
        }
        if (parms.get("pageSize")==null||"".equals(parms.get("pageSize"))){
            parms.put("pageSize",5);
        }
        PageHelper.startPage((Integer)parms.get("pageNum"),(Integer) parms.get("pageSize"));
        List<SysUser> sysUsers = sysUserMapper.selectByCondtion(parms);
        return new PageInfo<SysUser>(sysUsers);
    }

    @Override
    public SysUser selectByRid(long rid){
        return sysUserMapper.selectByRid(rid);
    }
}
