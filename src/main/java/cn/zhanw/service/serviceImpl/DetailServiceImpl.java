package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.Detail;
import cn.zhanw.mapper.DetailMapper;
import cn.zhanw.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DetailServiceImpl extends IServiceImpl<Detail> implements DetailService {
    @Autowired
    DetailMapper mapper;

    @Override
    public List<Detail> selectMax(Integer id,String component) {
        return mapper.selectMax(id,component);
    }
}
