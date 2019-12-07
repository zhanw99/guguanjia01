package cn.zhanw.mapper;

import cn.zhanw.entity.SysResource;
import org.apache.ibatis.jdbc.SQL;

public class SysResourceSqlProvider {

    public String insertSelective(SysResource record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_resource");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCommon() != null) {
            sql.VALUES("common", "#{common,jdbcType=CHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=CHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        if (record.getParentIds() != null) {
            sql.VALUES("parent_ids", "#{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.VALUES("update_by", "#{updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getDelFlag() != null) {
            sql.VALUES("del_flag", "#{delFlag,jdbcType=CHAR}");
        }
        
        if (record.getPermissionStr() != null) {
            sql.VALUES("permission_str", "#{permissionStr,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysResource record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_resource");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCommon() != null) {
            sql.SET("common = #{common,jdbcType=CHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=CHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getParentIds() != null) {
            sql.SET("parent_ids = #{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getDelFlag() != null) {
            sql.SET("del_flag = #{delFlag,jdbcType=CHAR}");
        }
        
        if (record.getPermissionStr() != null) {
            sql.SET("permission_str = #{permissionStr,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}