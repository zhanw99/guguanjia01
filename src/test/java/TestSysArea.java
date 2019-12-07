import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.Examine;
import cn.zhanw.entity.SysArea;
import cn.zhanw.listener.SysAreaListener;
import cn.zhanw.mapper.ExamineMapper;
import cn.zhanw.mapper.SysAreaMapper;
import cn.zhanw.service.ExamineService;
import cn.zhanw.service.SysAreaService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestSysArea {
    @Autowired
    SysAreaMapper mapper;

    @Autowired
    SysAreaService service;


    @Test
    public void selectAll(){
        List<SysArea> sysAreas = mapper.selectAll();
        for (SysArea sysArea : sysAreas) {
            System.out.println(sysArea.toString());
        }
    }

    //测试mapper
    @Test
    public void PageMapper(){
        List<SysArea> sysAreas = service.selectAll();
        for (SysArea sysArea : sysAreas) {
            System.out.println(sysArea);
        }
    }
    @Test
    public void testSelectPage(){
       HashMap<String, Object> map = new HashMap();
        map.put("aid", 1);
//       map.put("areaName", "中国");
       PageInfo<SysArea> pageInfo = service.selectByPage(map);
       System.out.println(pageInfo);
   }
//
//
//    /**
//     * excel读写测试
//     */
//
//    /**
//     * excel写操作
//     */
    @Test
    public void testWrite(){
        List<SysArea> sysAreas = mapper.selectByPid(1L);
        System.out.println("**************************");
        /**
         * 1.构建写excel对象，传入写入文件和每行记录对应的java类字节文件对象   如果需要自定义设置写入excel中的表头数据或数据格式，需要通过easyExcel的注解在实体类上添加设置
         */
        ExcelWriter excelWriter = EasyExcel.write("D:\\area.xlsx", SysArea.class).build();
        //2.操作excel对象，用于设置excel的配置
        WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
        //3.写出
        excelWriter.write(sysAreas,writeSheet);

        //4.关闭流
        excelWriter.finish();
    }

//
//    /**
//     * 1.由于读取操作会涉及到读取大量数据，并且插入到数据库的操作问题，easyExcel提供了监听器机制解决该问题
//     * 2.每次读取一行，会自动的调用设置的监听器，在监听器中的指定函数会自动将读取到该数据转换的java对象传入，可以处理自定义批量插入逻辑
//     * 3.官方文档介绍监听器对象不应该由spring容器管理创建，需要自己new，如果需要用到spring的dao层等进行插入处理，可以通过构造方法传递
//     */

    @Test
    public void testRead(){
        ExcelReader excelReader = EasyExcel.read("D:\\area.xlsx", SysArea.class, new SysAreaListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }
//
    @Test
    public void testInsert(){
        List<SysArea> sysAreas = mapper.selectAll();
        int i = mapper.insertBatch(sysAreas);

    }
//
//    /**
//     * 添加保存功能
//     */
    @Test
    public void testRead2(){
        ExcelReader excelReader = EasyExcel.read("D:\\area.xlsx", SysArea.class, new SysAreaListener(mapper)).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }
//
    @Test
    public void testUpdateIds(){
        SysArea sysArea = mapper.selectByPrimaryKey(6L);
        sysArea.setOldParentIds(sysArea.getParentIds());
        sysArea.setParentIds("0,1,3,");
        int i = mapper.updateParentIds(sysArea);
    }


    @Test
    public void toUpdate(){
        SysArea sysArea1 = service.selectByAid1(2L);
        System.out.println(sysArea1);
    }
    //模糊查询市名
    @Test
    public void toUpdate1(){
        List<SysArea> list = mapper.selectByPageName("市");
        for (SysArea sysArea : list) {
            System.out.println(sysArea.toString());
        }
    }
    //模糊查询市名
    @Test
    public void toUpdate2(){
        Map map = new HashMap();
        map.put("name","中");
        System.out.println( map.containsKey("name"));
        System.out.println(!StringUtils.isEmpty(map.get("name")));
        PageInfo pageInfo = service.selectByPageName(map);
        System.out.println(pageInfo.getSize());
    }





}
