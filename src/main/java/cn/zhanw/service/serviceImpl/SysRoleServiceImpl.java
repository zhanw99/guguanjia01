package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.SysRole;
import cn.zhanw.mapper.SysRoleMapper;
import cn.zhanw.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysRoleServiceImpl extends IServiceImpl<SysRole> implements SysRoleService {

    @Autowired
    SysRoleMapper mapper;

    @Override
    public PageInfo<SysRole> selectByAndAll(Map<String, Object> params){
        if (params.get("pageNum")==null||"".equals(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if (params.get("pageSize")==null||"".equals(params.get("pageSize"))){
            params.put("pageSize",10);
        }
        PageHelper.startPage((Integer)params.get("pageNum"),(Integer) params.get("pageSize"));
        List<SysRole> sysRoles = mapper.selectByAndAll(params);
        return new  PageInfo<SysRole>(sysRoles);
    }
    @Override
    public List<String> selectByDataScope(){
       return  mapper.selectByDataScope();
    }

    /**
     * 角色管理页面的归属机构
     * @return
     */
    @Override
    public List<String> officeName(){
       return  mapper.officeName();
    }



}