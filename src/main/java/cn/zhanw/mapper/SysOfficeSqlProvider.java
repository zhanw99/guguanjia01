package cn.zhanw.mapper;

import cn.zhanw.entity.SysOffice;
import org.apache.ibatis.jdbc.SQL;

public class SysOfficeSqlProvider {

    public String insertSelective(SysOffice record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_office");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getParentIds() != null) {
            sql.VALUES("parent_ids", "#{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.VALUES("area_id", "#{areaId,jdbcType=BIGINT}");
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
        
        if (record.getGrade() != null) {
            sql.VALUES("grade", "#{grade,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getZipCode() != null) {
            sql.VALUES("zip_code", "#{zipCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMaster() != null) {
            sql.VALUES("master", "#{master,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            sql.VALUES("fax", "#{fax,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getWebsite() != null) {
            sql.VALUES("website", "#{website,jdbcType=VARCHAR}");
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
        
        if (record.getDelFlag() != null) {
            sql.VALUES("del_flag", "#{delFlag,jdbcType=CHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo() != null) {
            sql.VALUES("logo", "#{logo,jdbcType=VARCHAR}");
        }
        
        if (record.getRoles() != null) {
            sql.VALUES("roles", "#{roles,jdbcType=VARCHAR}");
        }
        
        if (record.getRemarks() != null) {
            sql.VALUES("remarks", "#{remarks,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysOffice record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_office");
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getParentIds() != null) {
            sql.SET("parent_ids = #{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{areaId,jdbcType=BIGINT}");
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
        
        if (record.getGrade() != null) {
            sql.SET("grade = #{grade,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getZipCode() != null) {
            sql.SET("zip_code = #{zipCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMaster() != null) {
            sql.SET("master = #{master,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            sql.SET("fax = #{fax,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getWebsite() != null) {
            sql.SET("website = #{website,jdbcType=VARCHAR}");
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
        
        if (record.getDelFlag() != null) {
            sql.SET("del_flag = #{delFlag,jdbcType=CHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo() != null) {
            sql.SET("logo = #{logo,jdbcType=VARCHAR}");
        }
        
        if (record.getRoles() != null) {
            sql.SET("roles = #{roles,jdbcType=VARCHAR}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{remarks,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}