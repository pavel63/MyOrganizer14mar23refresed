package com.pavelwinter.myorganizer.data.db.db_entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class ProjectE {

    @Id
    private Long _id;

    private String title;
    private String describing;
    private Integer priority;
    private Integer percentDone;
    private Long endTime;
    private Long startTime;

    //for one-to-many
    private Long categoryId;

    @ToMany(referencedJoinProperty = "projectId")
    private List<TaskE> streets;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1752121443)
    private transient ProjectEDao myDao;

    @Generated(hash = 173686554)
    public ProjectE(Long _id, String title, String describing, Integer priority,
            Integer percentDone, Long endTime, Long startTime, Long categoryId) {
        this._id = _id;
        this.title = title;
        this.describing = describing;
        this.priority = priority;
        this.percentDone = percentDone;
        this.endTime = endTime;
        this.startTime = startTime;
        this.categoryId = categoryId;
    }

    @Generated(hash = 385646747)
    public ProjectE() {
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

    public String getDescribing() {
        return this.describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPercentDone() {
        return this.percentDone;
    }

    public void setPercentDone(Integer percentDone) {
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

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1182185881)
    public List<TaskE> getStreets() {
        if (streets == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TaskEDao targetDao = daoSession.getTaskEDao();
            List<TaskE> streetsNew = targetDao._queryProjectE_Streets(_id);
            synchronized (this) {
                if (streets == null) {
                    streets = streetsNew;
                }
            }
        }
        return streets;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1519402831)
    public synchronized void resetStreets() {
        streets = null;
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
    @Generated(hash = 796953650)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getProjectEDao() : null;
    }


}
