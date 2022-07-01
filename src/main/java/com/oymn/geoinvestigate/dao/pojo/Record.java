package com.oymn.geoinvestigate.dao.pojo;

import java.util.Date;

public class Record {
    
    private Long id;
    
    private Long userId;
    
    private String landMsg;
    
    private String disasterMsg;
    
    private String position;
    
    private Date startTime;
    
    private Date endTime;
    
    private Double latitude;
    
    private Double longitude;
    
    private String note;
    
    private String imgUrl;
    
    private Date createTime;
    
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLandMsg() {
        return landMsg;
    }

    public void setLandMsg(String landMsg) {
        this.landMsg = landMsg;
    }

    public String getDisasterMsg() {
        return disasterMsg;
    }

    public void setDisasterMsg(String disasterMsg) {
        this.disasterMsg = disasterMsg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
}
