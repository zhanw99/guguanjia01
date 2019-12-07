package cn.zhanw.mapper;

import cn.zhanw.entity.Qualification;
import cn.zhanw.entity.SysArea;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class QualificationSqlProvider {

    public String  insertBatch(@Param("sysAreas") List<SysArea> sysAreas){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `guguanjia`.`sys_area`( `parent_id`, `parent_ids`, `code`, `name`, `type`, `create_by`, `create_date`, " +
                "`update_by`, `update_date`, `remarks`, `del_flag`, `icon`) VALUES ");

        for (int i = 0; i < sysAreas.size(); i++) {
            sb.append("(");
            sb.append("#{sysAreas["+i+"].parentId}," +
                    "#{sysAreas["+i+"].parentIds}," +
                    "#{sysAreas["+i+"].code}," +
                    "#{sysAreas["+i+"].name}," +
                    "#{sysAreas["+i+"].type}," +
                    "#{sysAreas["+i+"].createBy}," +
                    "#{sysAreas["+i+"].createDate}," +
                    "#{sysAreas["+i+"].updateBy}," +
                    "#{sysAreas["+i+"].updateDate}," +
                    "#{sysAreas["+i+"].remarks}," +
                    "#{sysAreas["+i+"].delFlag}," +
                    "#{sysAreas["+i+"].icon}" );
            sb.append("),");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        return sb.toString();



    }

    public String insertSelective(Qualification record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("qualification");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getUploadUserId() != null) {
            sql.VALUES("upload_user_id", "#{uploadUserId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getCheck() != null) {
            sql.VALUES("check", "#{check,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckUserId() != null) {
            sql.VALUES("check_user_id", "#{checkUserId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDelFlag() != null) {
            sql.VALUES("del_flag", "#{delFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Qualification record) {
        SQL sql = new SQL();
        sql.UPDATE("qualification");
        
        if (record.getUploadUserId() != null) {
            sql.SET("upload_user_id = #{uploadUserId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getCheck() != null) {
            sql.SET("check = #{check,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckUserId() != null) {
            sql.SET("check_user_id = #{checkUserId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDelFlag() != null) {
            sql.SET("del_flag = #{delFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}