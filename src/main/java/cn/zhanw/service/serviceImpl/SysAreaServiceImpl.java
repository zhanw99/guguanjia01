package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.SysArea;
import cn.zhanw.listener.SysAreaListener;
import cn.zhanw.mapper.SysAreaMapper;
import cn.zhanw.service.SysAreaService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Service
@Transactional//开启事务管理
@CacheConfig(cacheNames = "sysAreaCache")//设置全局缓存配置
public class SysAreaServiceImpl extends IServiceImpl<SysArea> implements SysAreaService {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SysAreaMapper areaMapper;

/*   @Cacheable(key = "'SysAreaServiceImpl:selectAll'")
   @Override
   public List<SysArea> selectAll(){
       ValueOperations<String,Object> operations = redisTemplate.opsForValue();
       if (redisTemplate.hasKey("SysAreaServiceImpl:selectAll")){
           return (List<SysArea>) operations.get("SysAreaServiceImpl:selectAll");
       }
       List<SysArea> sysAreas = super.selectAll();
       operations.set("SysAreaServiceImpl:selectAll",sysAreas);
       return sysAreas;
   }*/

    @Cacheable(key = "'SysAreaServiceImpl:selectAll'")
    @Override
    public List<SysArea> selectAll(){
        return super.selectAll();
    }


    /**
     * 使用redis作为缓存，提升热点查询方法的性能和体验
     * 1.从redis中查询是否存在该数据，redis中存在则直接从redis获取
     * 2.redis中不存在，则需要从数据库查询数据，并且返回的数据需要放入redis中
     *
     * key:   SysOfficeServiceImpl:selectAll    类名:方法名:参数列表
     * @return
     */
//    @Override
//    public List<SysOffice> selectAll() {
//        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
//        if(redisTemplate.hasKey("SysOfficeServiceImpl:selectAll")) {
//            return (List<SysOffice>) opsForValue.get("SysOfficeServiceImpl:selectAll");
//        }
//        List<SysOffice> sysOffices = super.selectAll();
//        opsForValue.set("SysOfficeServiceImpl:selectAll",sysOffices);//放入redis
//        return sysOffices;
//    }


    @Cacheable(key = "'SysAreaServiceImpl:dsadsadsadas'+':'+#aid")
    @Override
    public SysArea selectByAid1 (long aid){
        return areaMapper.selectByAid(aid);
    }

/*    @Override
    public SysArea selectByAid (long aid){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey("SysAreaServiceImpl:selectByAid"+":"+aid)){
            return (SysArea) valueOperations.get("SysAreaServiceImpl:selectByAid"+aid);
        }
        SysArea sysArea = areaMapper.selectByAid(aid);
        sysArea.setOldParentIds(sysArea.getParentIds());//给区域绑定旧parentIds
        valueOperations.set("SysAreaServiceImpl:selectByAid"+aid,sysArea);
        return areaMapper.selectByAid(aid);
    }*/


    /**
     * 根据父区域id或者区域名或者不带条件查找所有区域
     *
     * @return
     */
    @Override
    public PageInfo<SysArea> selectByPage(Map<String, Object> params) {
        //{"aid":''}        {}
        //默认值设置
        if (StringUtils.isEmpty(params.get("pageNum"))) {
            params.put("pageNum", 1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))) {
            params.put("pageSize", 5);
        }
        PageInfo<SysArea> pageInfo = null;
        PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
        //根据父区域id的查询
        if (params.containsKey("aid") && !StringUtils.isEmpty(params.get("aid"))) {
            int id = (Integer) params.get("aid");
            List<SysArea> list = areaMapper.selectByPid((long) id);
            pageInfo = new PageInfo(list);
        } else if (params.containsKey("areaName") && !StringUtils.isEmpty(params.get("areaName"))) {
            //  根据区域名字查询    关联  父区域
            SysArea sysArea = new SysArea();
            sysArea.setName((String) params.get("areaName"));
            List<SysArea> list = areaMapper.select(sysArea);
            pageInfo = new PageInfo(list);
        } else {
            //TODO  查询所有数据    关联父区域
            List<SysArea> list = areaMapper.selectAll();
            pageInfo = new PageInfo(list);
        }
        return pageInfo;
    }
    //分页查询全部
//    @Override
//    public PageInfo<SysArea> selectPageAll(Map<String, Object> params) {
//        System.out.println("分页查询全部");
//        List<SysArea> sysAreas = areaMapper.selectByPageName((String) params.get("name"));
//        if (StringUtils.isEmpty(params.get("pageNum"))) {
//            params.put("pageNum", 1);
//        }
//        if (StringUtils.isEmpty(params.get("pageSize"))) {
//            params.put("pageSize", 5);
//        }
//        PageInfo<SysArea> pageInfo = null;
//        PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
//        List<SysArea> list = areaMapper.selectAll();
//        pageInfo = new PageInfo(list);
//        return pageInfo;
//    }

    /*
    根据数据库查询所有SysArea
    根据excel工具转变成输出流
     */
        @Override
        public OutputStream getListOutputStream (OutputStream outputStream){
            List<SysArea> sysAreas = areaMapper.selectAll();
            /**
             * 1.构建写excel对象，传入写入文件和每行记录对应的java类字节文件对象   如果需要自定义设置写入excel中的表头数据或数据格式，需要通过easyExcel的注解在实体类上添加设置
             */
            ExcelWriter excelWriter = EasyExcel.write(outputStream, SysArea.class).build();
            //2.操作excel对象，用于设置excel的配置
            WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
            //3.写出
            excelWriter.write(sysAreas, writeSheet);
            //4.关闭流
            excelWriter.finish();
            return outputStream;
        }

        @Override
        public int importExcel (InputStream inputStream){
            int result = 0;
            ExcelReader excelReader = EasyExcel.read(inputStream, SysArea.class, new SysAreaListener(areaMapper)).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
            excelReader.finish();
            result++;
            return result;
        }

        /**
         * 1.更新当前区域数据
         * 2.根据oldParentIds和parentIds判断是否有更新该parentIds字段，如果有则更新其所有的子级区域的parentIds字段
         *
         * @param
         * @return
         */

        //模糊查询市
        @Override
        public PageInfo<SysArea> selectByPageName (Map < String, Object > params){
            List<SysArea> sysAreas = areaMapper.selectByPageName((String) params.get("name"));
            if (StringUtils.isEmpty(params.get("pageNum"))) {
                params.put("pageNum", 1);
            }
            if (StringUtils.isEmpty(params.get("pageSize"))) {
                params.put("pageSize", 5);
            }
            PageInfo<SysArea> pageInfo = null;
            PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
            if (params.containsKey("name") && !StringUtils.isEmpty(params.get("name"))) {
                System.out.println("模糊查询市");
                String name = (String) params.get("name");
                List<SysArea> list = areaMapper.selectByPageName(name);
                pageInfo = new PageInfo(list);
            } else {
                System.out.println("模糊查询市之全部查询");
                List<SysArea> list = areaMapper.selectAll();
                pageInfo = new PageInfo(list);
            }
            return pageInfo;
        }


    }
