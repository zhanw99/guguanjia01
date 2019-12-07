package cn.zhanw.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "detail")
public class Detail {
    @Id
    private Long id;

    @Column(name = "work_order_id")
    private Long workOrderId;

    @Column(name = "waste_type_id")
    private Long wasteTypeId;

    @Column(name = "waste_id")
    private Long wasteId;

    //主害成分
    @Column(name = "component")
    private String component;

    //重量（吨）
    @Column(name = "weight")
    private Float weight;

    //形态
    @Column(name = "morphological")
    private String morphological;

    //包装方式
    @Column(name = "packaging")
    private String packaging;

    //车牌号
    @Column(name = "plate_number")
    private String plateNumber;

//    medicine药物名称
    @Column(name = "medicine")
    @Transient
    private String medicine;

    //型号
    @Column(name = "model")
    @Transient
    private String model;

    //编号271-001-02
    @Column(name = "number")
    @Transient
    private String number;

    //物流
    @Column(name = "content")
    @Transient
    private String content;

    //电话
    @Column(name = "phone")
    @Transient
    private String phone;

    //手机
    @Column(name = "mobile")
    @Transient
    private String mobile;

    /**
     * 数据创建时间,在数据新增时设置
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 数据修改时间,在数据新增时和修改时设置
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    @Column(name = "del_flag")
    private String delFlag;

    @Column(name = "create_by")
    private String createBy;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return work_order_id
     */
    public Long getWorkOrderId() {
        return workOrderId;
    }

    /**
     * @param workOrderId
     */
    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    /**
     * @return waste_type_id
     */
    public Long getWasteTypeId() {
        return wasteTypeId;
    }

    /**
     * @param wasteTypeId
     */
    public void setWasteTypeId(Long wasteTypeId) {
        this.wasteTypeId = wasteTypeId;
    }

    /**
     * @return waste_id
     */
    public Long getWasteId() {
        return wasteId;
    }

    /**
     * @param wasteId
     */
    public void setWasteId(Long wasteId) {
        this.wasteId = wasteId;
    }

    /**
     * @return component
     */
    public String getComponent() {
        return component;
    }

    /**
     * @param component
     */
    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    /**
     * @return weight
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * @return morphological
     */
    public String getMorphological() {
        return morphological;
    }

    /**
     * @param morphological
     */
    public void setMorphological(String morphological) {
        this.morphological = morphological == null ? null : morphological.trim();
    }

    /**
     * @return packaging
     */
    public String getPackaging() {
        return packaging;
    }

    /**
     * @param packaging
     */
    public void setPackaging(String packaging) {
        this.packaging = packaging == null ? null : packaging.trim();
    }

    /**
     * @return plate_number
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * @param plateNumber
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    /**
     * 获取数据创建时间,在数据新增时设置
     *
     * @return create_date - 数据创建时间,在数据新增时设置
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置数据创建时间,在数据新增时设置
     *
     * @param createDate 数据创建时间,在数据新增时设置
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取数据修改时间,在数据新增时和修改时设置
     *
     * @return update_date - 数据修改时间,在数据新增时和修改时设置
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置数据修改时间,在数据新增时和修改时设置
     *
     * @param updateDate 数据修改时间,在数据新增时和修改时设置
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取删除标记（0：正常；1：删除；2：审核；）
     *
     * @return del_flag - 删除标记（0：正常；1：删除；2：审核；）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记（0：正常；1：删除；2：审核；）
     *
     * @param delFlag 删除标记（0：正常；1：删除；2：审核；）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", component='" + component + '\'' +
                ", weight=" + weight +
                ", morphological='" + morphological + '\'' +
                ", packaging='" + packaging + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", medicine='" + medicine + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", content='" + content + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}