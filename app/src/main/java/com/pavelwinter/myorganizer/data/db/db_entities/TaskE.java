package com.pavelwinter.myorganizer.data.db.db_entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TaskE {

    @Id
    private Long _id;
    private String title;
    private Integer priority;
    private int percentDone;
    private String describing;
    private Long endTime;
    private Long startTime;

    // for one-to -many to projects
    private Long projectId;

    // for one-to -many to quotas
    private Long quotaId;

    @Generated(hash = 526650167)
    public TaskE(Long _id, String title, Integer priority, int percentDone,
            String describing, Long endTime, Long startTime, Long projectId,
            Long quotaId) {
        this._id = _id;
        this.title = title;
        this.priority = priority;
        this.percentDone = percentDone;
        this.describing = describing;
        this.endTime = endTime;
        this.startTime = startTime;
        this.projectId = projectId;
        this.quotaId = quotaId;
    }

    @Generated(hash = 1059400135)
    public TaskE() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public int getPercentDone() {
        return this.percentDone;
    }

    public void setPercentDone(int percentDone) {
        this.percentDone = percentDone;
    }

    public String getDescribing() {
        return this.describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getQuotaId() {
        return this.quotaId;
    }

    public void setQuotaId(Long quotaId) {
        this.quotaId = quotaId;
    }

}
