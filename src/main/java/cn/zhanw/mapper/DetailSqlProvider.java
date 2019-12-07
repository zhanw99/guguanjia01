package cn.zhanw.mapper;

import cn.zhanw.entity.Detail;
import org.apache.ibatis.jdbc.SQL;

public class DetailSqlProvider {

    public String insertSelective(Detail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("detail");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getWorkOrderId() != null) {
            sql.VALUES("work_order_id", "#{workOrderId,jdbcType=BIGINT}");
        }
        
        if (record.getWasteTypeId() != null) {
            sql.VALUES("waste_type_id", "#{wasteTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getWasteId() != null) {
            sql.VALUES("waste_id", "#{wasteId,jdbcType=BIGINT}");
        }
        
        if (record.getComponent() != null) {
            sql.VALUES("component", "#{component,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.VALUES("weight", "#{weight,jdbcType=REAL}");
        }
        
        if (record.getMorphological() != null) {
            sql.VALUES("morphological", "#{morphological,jdbcType=VARCHAR}");
        }
        
        if (record.getPackaging() != null) {
            sql.VALUES("packaging", "#{packaging,jdbcType=VARCHAR}");
        }
        
        if (record.getPlateNumber() != null) {
            sql.VALUES("plate_number", "#{plateNumber,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(Detail record) {
        SQL sql = new SQL();
        sql.UPDATE("detail");
        
        if (record.getWorkOrderId() != null) {
            sql.SET("work_order_id = #{workOrderId,jdbcType=BIGINT}");
        }
        
        if (record.getWasteTypeId() != null) {
            sql.SET("waste_type_id = #{wasteTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getWasteId() != null) {
            sql.SET("waste_id = #{wasteId,jdbcType=BIGINT}");
        }
        
        if (record.getComponent() != null) {
            sql.SET("component = #{component,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.SET("weight = #{weight,jdbcType=REAL}");
        }
        
        if (record.getMorphological() != null) {
            sql.SET("morphological = #{morphological,jdbcType=VARCHAR}");
        }
        
        if (record.getPackaging() != null) {
            sql.SET("packaging = #{packaging,jdbcType=VARCHAR}");
        }
        
        if (record.getPlateNumber() != null) {
            sql.SET("plate_number = #{plateNumber,jdbcType=VARCHAR}");
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