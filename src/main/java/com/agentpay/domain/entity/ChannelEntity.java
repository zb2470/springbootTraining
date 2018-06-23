package com.agentpay.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ChannelEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String channelNo;
    private String channelName;
    private String aesKey;
    private String aesIv;
    private String md5Key;
    private BigDecimal balance;
    private Date createTime;
    private boolean isDeletel;

    @Override
    public String toString() {
        return "ChannelEntity{" +
                "id=" + id +
                ", channelNo='" + channelNo + '\'' +
                ", channelName='" + channelName + '\'' +
                ", aesKey='" + aesKey + '\'' +
                ", aesIv='" + aesIv + '\'' +
                ", md5Key='" + md5Key + '\'' +
                ", balance=" + balance +
                ", createTime=" + createTime +
                ", isDeletel=" + isDeletel +
                '}';
    }

    public ChannelEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getAesIv() {
        return aesIv;
    }

    public void setAesIv(String aesIv) {
        this.aesIv = aesIv;
    }

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isDeletel() {
        return isDeletel;
    }

    public void setDeletel(boolean deletel) {
        isDeletel = deletel;
    }
}
