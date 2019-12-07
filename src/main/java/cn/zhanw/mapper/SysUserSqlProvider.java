package cn.zhanw.mapper;

import cn.zhanw.entity.SysUser;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

public class SysUserSqlProvider {

    public String insertSelective(SysUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyId() != null) {
            sql.VALUES("company_id", "#{companyId,jdbcType=BIGINT}");
        }
        
        if (record.getOfficeId() != null) {
            sql.VALUES("office_id", "#{officeId,jdbcType=BIGINT}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNo() != null) {
            sql.VALUES("no", "#{no,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUserType() != null) {
            sql.VALUES("user_type", "#{userType,jdbcType=CHAR}");
        }
        
        if (record.getDeviceCode() != null) {
            sql.VALUES("device_code", "#{deviceCode,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginIp() != null) {
            sql.VALUES("login_ip", "#{loginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginDate() != null) {
            sql.VALUES("login_date", "#{loginDate,jdbcType=TIMESTAMP}");
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
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        if (record.getHeadPicture() != null) {
            sql.VALUES("head_picture", "#{headPicture,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysUser record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_user");
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{companyId,jdbcType=BIGINT}");
        }
        
        if (record.getOfficeId() != null) {
            sql.SET("office_id = #{officeId,jdbcType=BIGINT}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNo() != null) {
            sql.SET("no = #{no,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUserType() != null) {
            sql.SET("user_type = #{userType,jdbcType=CHAR}");
        }
        
        if (record.getDeviceCode() != null) {
            sql.SET("device_code = #{deviceCode,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginIp() != null) {
            sql.SET("login_ip = #{loginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginDate() != null) {
            sql.SET("login_date = #{loginDate,jdbcType=TIMESTAMP}");
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
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getHeadPicture() != null) {
            sql.SET("head_picture = #{headPicture,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    public String selectByCondtion(Map<String,Object> parms) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT su.*,so.`name` officeName " +
                "FROM sys_user su " +
                "LEFT JOIN " +
                "sys_office so " +
                "ON " +
                "su.office_id=so.id " );
        if (parms.containsKey("rid")&& !StringUtils.isEmpty(parms.get("rid"))){
            sb.append("LEFT JOIN " +
                    "sys_user_role sur " +
                    "ON " +
                    "sur.user_id=su.id " +
                    "LEFT JOIN " +
                    "sys_role sr " +
                    "ON " +
                    "sur.role_id=sr.id " +
                    "WHERE " +
                    "su.del_flag=0 " );
            sb.append(" and sr.id=#{rid} ");
        }else {
            sb.append(" WHERE su.del_flag=0 ");
        }
        if (parms.containsKey("uid")&&!StringUtils.isEmpty(parms.get("uid"))){
            sb.append(" and su.id=#{uid} ");
        }
        if (parms.containsKey("oid")&&!StringUtils.isEmpty(parms.get("oid"))){
            sb.append(" and su.office_id=#{oid} ");
        }
        if (parms.containsKey("name")&&!StringUtils.isEmpty(parms.get("name"))){
            sb.append(" and su.`name` LIKE CONCAT('%',#{name},'%')");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

}