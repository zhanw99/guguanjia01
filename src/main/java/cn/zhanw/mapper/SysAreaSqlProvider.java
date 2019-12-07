package cn.zhanw.mapper;

import cn.zhanw.entity.SysArea;
import org.apache.ibatis.jdbc.SQL;

public class SysAreaSqlProvider {

    public String insertSelective(SysArea record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_area");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getParentIds() != null) {
            sql.VALUES("parent_ids", "#{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=CHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.VALUES("update_by", "#{updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            sql.VALUES("remarks", "#{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getDelFlag() != null) {
            sql.VALUES("del_flag", "#{delFlag,jdbcType=CHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysArea record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_area");
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getParentIds() != null) {
            sql.SET("parent_ids = #{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=CHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getDelFlag() != null) {
            sql.SET("del_flag = #{delFlag,jdbcType=CHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}