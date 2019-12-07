package cn.zhanw.service;

import cn.zhanw.entity.SysArea;
import com.github.pagehelper.PageInfo;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface SysAreaService extends IService<SysArea> {

    PageInfo<SysArea> selectByPage(Map<String,Object> params);

    //分页查询全部
//    PageInfo<SysArea> selectPageAll(Map<String, Object> params);

    /*
            根据数据库查询所有SysArea
            根据excel工具转变成输出流
             */
    OutputStream getListOutputStream(OutputStream outputStream);

    /**
     * 根据输入流数据解析每一行数据进行批量插入
     * @param inputStream
     * @return
     */
    int importExcel(InputStream inputStream);

    SysArea selectByAid1(long aid);

//    int updateArea(SysArea sysArea);

    //模糊查询市
    PageInfo<SysArea> selectByPageName(Map<String, Object> params);
}
