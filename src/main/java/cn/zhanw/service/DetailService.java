package cn.zhanw.service;

import cn.zhanw.entity.Detail;

import java.util.List;

public interface DetailService extends IService<Detail> {

    List<Detail> selectMax(Integer id,String component);
}
