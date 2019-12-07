package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.SysLog;
import cn.zhanw.service.SysLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysLogServiceImpl extends IServiceImpl<SysLog> implements SysLogService {

}
