package com.dfbz.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "detail")
public class Detail {
    @Id
    private Long id;

    /**
     * 要求
     */
    @Column(name = "work_order_id")
    private Long workOrderId;

    /**
     * 废物类型
     */
    @Column(name = "waste_type_id")
    private Long wasteTypeId;

    /**
     * 废物id
     */
    @Column(name = "waste_id")
    private Long wasteId;

    /**
     * 组成部分
     */
    private String component;

    /**
     * 重量
     */
    private Float weight;

    /**
     * 形态
     */
    private String morphological;

    /**
     * 包装
     */
    private String packaging;

    /**
     * 车牌
     */
    @Column(name = "plate_number")
    private String plateNumber;

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


    @Transient
    private String watyname;
    @Transient
    private String watycode;
    @Transient
    private String wastecode;


    public String getWatyname() {
        return watyname;
    }

    public void setWatyname(String watyname) {
        this.watyname = watyname;
    }

    public String getWatycode() {
        return watycode;
    }

    public void setWatycode(String watycode) {
        this.watycode = watycode;
    }

    public String getWastecode() {
        return wastecode;
    }

    public void setWastecode(String wastecode) {
        this.wastecode = wastecode;
    }

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
     * 获取要求
     *
     * @return work_order_id - 要求
     */
    public Long getWorkOrderId() {
        return workOrderId;
    }

    /**
     * 设置要求
     *
     * @param workOrderId 要求
     */
    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    /**
     * 获取废物类型
     *
     * @return waste_type_id - 废物类型
     */
    public Long getWasteTypeId() {
        return wasteTypeId;
    }

    /**
     * 设置废物类型
     *
     * @param wasteTypeId 废物类型
     */
    public void setWasteTypeId(Long wasteTypeId) {
        this.wasteTypeId = wasteTypeId;
    }

    /**
     * 获取废物id
     *
     * @return waste_id - 废物id
     */
    public Long getWasteId() {
        return wasteId;
    }

    /**
     * 设置废物id
     *
     * @param wasteId 废物id
     */
    public void setWasteId(Long wasteId) {
        this.wasteId = wasteId;
    }

    /**
     * 获取组成部分
     *
     * @return component - 组成部分
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置组成部分
     *
     * @param component 组成部分
     */
    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    /**
     * 获取重量
     *
     * @return weight - 重量
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * 设置重量
     *
     * @param weight 重量
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * 获取形态
     *
     * @return morphological - 形态
     */
    public String getMorphological() {
        return morphological;
    }

    /**
     * 设置形态
     *
     * @param morphological 形态
     */
    public void setMorphological(String morphological) {
        this.morphological = morphological == null ? null : morphological.trim();
    }

    /**
     * 获取包装
     *
     * @return packaging - 包装
     */
    public String getPackaging() {
        return packaging;
    }

    /**
     * 设置包装
     *
     * @param packaging 包装
     */
    public void setPackaging(String packaging) {
        this.packaging = packaging == null ? null : packaging.trim();
    }

    /**
     * 获取车牌
     *
     * @return plate_number - 车牌
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * 设置车牌
     *
     * @param plateNumber 车牌
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
                ", workOrderId=" + workOrderId +
                ", wasteTypeId=" + wasteTypeId +
                ", wasteId=" + wasteId +
                ", component='" + component + '\'' +
                ", weight=" + weight +
                ", morphological='" + morphological + '\'' +
                ", packaging='" + packaging + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", delFlag='" + delFlag + '\'' +
                ", createBy='" + createBy + '\'' +
                ", watyname='" + watyname + '\'' +
                ", watycode='" + watycode + '\'' +
                ", wastecode='" + wastecode + '\'' +
                '}';
    }
}