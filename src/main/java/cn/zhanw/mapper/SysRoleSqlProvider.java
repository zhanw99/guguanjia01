package cn.zhanw.mapper;

import cn.zhanw.entity.SysRole;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

public class SysRoleSqlProvider {

    public String insertSelective(SysRole record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_role");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOfficeId() != null) {
            sql.VALUES("office_id", "#{officeId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDataScope() != null) {
            sql.VALUES("data_scope", "#{dataScope,jdbcType=CHAR}");
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
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysRole record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role");
        
        if (record.getOfficeId() != null) {
            sql.SET("office_id = #{officeId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDataScope() != null) {
            sql.SET("data_scope = #{dataScope,jdbcType=CHAR}");
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
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    public String selectByAndAll(Map<String,Object> params){
        StringBuilder sb= new StringBuilder();
        sb.append("select  sr.*,so.name officeName  " +
                " from  " +
                " sys_role sr,sys_office so  " +
                " where  " +
                " sr.office_id=so.id  " +
                " and " +
                " sr.del_flag=0 ");
        if(params.containsKey("dataScope")&&!StringUtils.isEmpty(params.get("dataScope"))){

            sb.append(" and sr.data_scope=#{dataScope}  ");
        }
        if(params.containsKey("remarks")&&!StringUtils.isEmpty(params.get("remarks"))){
            sb.append(" and sr.remarks=#{remarks} ");
        }

        if(params.containsKey("oid")&&!StringUtils.isEmpty(params.get("oid"))){
            sb.append(" and so.id=#{oid} ");
        }

        if(params.containsKey("name")&&!StringUtils.isEmpty(params.get("name"))){
            sb.append(" AND sr.name like CONCAT('%',#{name},'%') ");
        }
        return sb.toString();
    }
}