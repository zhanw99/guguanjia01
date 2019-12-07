package cn.zhanw.mapper;

import cn.zhanw.entity.Examine;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import javax.xml.ws.WebServiceProvider;
import java.util.List;

public interface ExamineMapper extends Mapper<Examine> {
    //分页查询
    @Select("SELECT " +
            "e.*, " +
            " su.`username` userName, " +
            " so.`name` officeName " +
            " FROM " +
            " examine AS e , " +
            " sys_user AS su , " +
            " sys_office AS so " +
            " WHERE " +
            " e.examine_user_id=su.id AND " +
            " su.office_id=so.id ")
    List<Examine> selectAll();
}