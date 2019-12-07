package cn.zhanw.mapper;

import cn.zhanw.entity.Examine;
import org.apache.ibatis.jdbc.SQL;

public class ExamineSqlProvider {

    public String insertSelective(Examine record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("examine");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getExamineUserId() != null) {
            sql.VALUES("examine_user_id", "#{examineUserId,jdbcType=BIGINT}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getScoreInfo() != null) {
            sql.VALUES("score_info", "#{scoreInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
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

    public String updateByPrimaryKeySelective(Examine record) {
        SQL sql = new SQL();
        sql.UPDATE("examine");
        
        if (record.getExamineUserId() != null) {
            sql.SET("examine_user_id = #{examineUserId,jdbcType=BIGINT}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getScoreInfo() != null) {
            sql.SET("score_info = #{scoreInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
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