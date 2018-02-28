package com.xin.lemontree.common.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author creator mafh 2018/2/28 17:59
 * @author updater mafh
 * @version 1.0.0
 * @description Entity的所有基类，任何Entity均要继承该类
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    @Column(name = "createTime", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建人ip
     */
    private String creatorIP;
    /**
     * 修改时间
     */
    @Column(name = "createTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 修改人ip
     */
    private String modifierIP;

}
