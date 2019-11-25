package com.dfbz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "work_order")
public class Work {
    @Id
    private Long id;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 创建人
     */
    @Column(name = "create_user_id")
    private Long createUserId;

    /**
     * 运输人
     */
    @Column(name = "transport_user_id")
    private Long transportUserId;

    /**
     * 接收人
     */
    @Column(name = "recipient_user_id")
    private Long recipientUserId;

    /**
     * 0：待运输            1：运输中            2：验收
     */
    private Integer status;

    /**
     * 数据创建时间,在数据新增时设置
     */
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;

    /**
     * 数据修改时间,在数据新增时和修改时设置
     */
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateDate;

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    @Column(name = "del_flag")
    private String delFlag;

    @Column(name = "create_by")
    private String createBy;



    @Transient
    private String name;    //offname
    @Transient
    private String crname;//username
    @Transient
    private String crphone;
    @Transient
    private String trname;//Disposer
    @Transient
    private String trphone;
    @Transient
    private String recname;//Transporter
    @Transient
    private String recphone;



    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    public String getCrphone() {
        return crphone;
    }

    public void setCrphone(String crphone) {
        this.crphone = crphone;
    }

    public String getTrname() {
        return trname;
    }

    public void setTrname(String trname) {
        this.trname = trname;
    }

    public String getTrphone() {
        return trphone;
    }

    public void setTrphone(String trphone) {
        this.trphone = trphone;
    }

    public String getRecname() {
        return recname;
    }

    public void setRecname(String recname) {
        this.recname = recname;
    }

    public String getRecphone() {
        return recphone;
    }

    public void setRecphone(String recphone) {
        this.recphone = recphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
     * 获取订单编号
     *
     * @return code - 订单编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置订单编号
     *
     * @param code 订单编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取创建人
     *
     * @return create_user_id - 创建人
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人
     *
     * @param createUserId 创建人
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取运输人
     *
     * @return transport_user_id - 运输人
     */
    public Long getTransportUserId() {
        return transportUserId;
    }

    /**
     * 设置运输人
     *
     * @param transportUserId 运输人
     */
    public void setTransportUserId(Long transportUserId) {
        this.transportUserId = transportUserId;
    }

    /**
     * 获取接收人
     *
     * @return recipient_user_id - 接收人
     */
    public Long getRecipientUserId() {
        return recipientUserId;
    }

    /**
     * 设置接收人
     *
     * @param recipientUserId 接收人
     */
    public void setRecipientUserId(Long recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    /**
     * 获取0：待运输            1：运输中            2：验收
     *
     * @return status - 0：待运输            1：运输中            2：验收
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0：待运输            1：运输中            2：验收
     *
     * @param status 0：待运输            1：运输中            2：验收
     */
    public void setStatus(Integer status) {
        this.status = status;
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
        return "Work{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", createUserId=" + createUserId +
                ", transportUserId=" + transportUserId +
                ", recipientUserId=" + recipientUserId +
                ", status=" + status +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", delFlag='" + delFlag + '\'' +
                ", createBy='" + createBy + '\'' +
                ", name='" + name + '\'' +
                ", crname='" + crname + '\'' +
                ", crphone='" + crphone + '\'' +
                ", trname='" + trname + '\'' +
                ", trphone='" + trphone + '\'' +
                ", recname='" + recname + '\'' +
                ", recphone='" + recphone + '\'' +
                '}';
    }
}