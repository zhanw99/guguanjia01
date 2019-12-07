package cn.zhanw.service;


import cn.zhanw.entity.Qualification;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface QualificationService extends IService<Qualification> {
    //查询全部
    PageInfo<Qualification> selectAll(Integer pageNum, Integer pageSize);
    //条件查询
    public PageInfo<Qualification> selectByCondition(Map<String,Object> params);

}
