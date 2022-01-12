package xyz.wildx.commons.entity;

import lombok.EqualsAndHashCode;
import java.util.Date;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseEntity {
    //这里有时候前端需要参数小于后端提供参数数量，将多余参数提取到父类中，方便后面使用
    private Date createTime;
    private Date updateTime;

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
