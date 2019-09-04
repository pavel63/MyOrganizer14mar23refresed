package com.pavelwinter.myorganizer.data.db.db_entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class QuotaE {

    @Id
    private Long _id;
    private String title;
    private Integer priority;
    private int percentDone;
    private Long endTime;
    private Long startTime;


    @ToMany(referencedJoinProperty = "quotaId")
    private List<TaskE> tasks;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 661904826)
    private transient QuotaEDao myDao;


    @Generated(hash = 1782781350)
    public QuotaE(Long _id, String title, Integer priority, int percentDone,
            Long endTime, Long startTime) {
        this._id = _id;
        this.title = title;
        this.priority = priority;
        this.percentDone = percentDone;
        this.endTime = endTime;
        this.startTime = startTime;
    }


    @Generated(hash = 545571544)
    public QuotaE() {
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


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 643707917)
    public List<TaskE> getTasks() {
        if (tasks == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TaskEDao targetDao = daoSession.getTaskEDao();
            List<TaskE> tasksNew = targetDao._queryQuotaE_Tasks(_id);
            synchronized (this) {
                if (tasks == null) {
                    tasks = tasksNew;
                }
            }
        }
        return tasks;
    }


    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 668181820)
    public synchronized void resetTasks() {
        tasks = null;
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1830880661)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getQuotaEDao() : null;
    }
}
