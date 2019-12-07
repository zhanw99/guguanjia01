package cn.zhanw.mapper;

import cn.zhanw.entity.WorkOrder;
import org.apache.ibatis.jdbc.SQL;

public class WorkOrderSqlProvider {

    public String insertSelective(WorkOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("work_order");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.VALUES("create_user_id", "#{createUserId,jdbcType=BIGINT}");
        }
        
        if (record.getTransportUserId() != null) {
            sql.VALUES("transport_user_id", "#{transportUserId,jdbcType=BIGINT}");
        }
        
        if (record.getRecipientUserId() != null) {
            sql.VALUES("recipient_user_id", "#{recipientUserId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
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

    public String updateByPrimaryKeySelective(WorkOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("work_order");
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.SET("create_user_id = #{createUserId,jdbcType=BIGINT}");
        }
        
        if (record.getTransportUserId() != null) {
            sql.SET("transport_user_id = #{transportUserId,jdbcType=BIGINT}");
        }
        
        if (record.getRecipientUserId() != null) {
            sql.SET("recipient_user_id = #{recipientUserId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
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