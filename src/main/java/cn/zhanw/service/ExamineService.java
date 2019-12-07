package cn.zhanw.service;

import cn.zhanw.entity.AppVersion;
import cn.zhanw.entity.Examine;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ExamineService extends IService<Examine> {
    //分页查询
    PageInfo<Examine> selectAll(Integer pageNum, Integer pageSize);

}
