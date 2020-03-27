package com.farm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 操作记录表
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public class OperationRecord implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer id;

      /**
     * 操作人
     */
      private Integer userId;

      /**
     * 操作描述
     */
      private String describe;

      /**
     * 操作类型 1、施肥 2、打药 
     */
      private Integer type;

      /**
     * 用量
     */
      private String usedAomut;

      /**
     * 操作时间
     */
      private LocalDateTime operationTime;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 更新时间
     */
      private LocalDateTime updateTime;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public Integer getUserId() {
        return userId;
    }

      public void setUserId(Integer userId) {
          this.userId = userId;
      }
    
    public String getDescribe() {
        return describe;
    }

      public void setDescribe(String describe) {
          this.describe = describe;
      }
    
    public Integer getType() {
        return type;
    }

      public void setType(Integer type) {
          this.type = type;
      }
    
    public String getUsedAomut() {
        return usedAomut;
    }

      public void setUsedAomut(String usedAomut) {
          this.usedAomut = usedAomut;
      }
    
    public LocalDateTime getOperationTime() {
        return operationTime;
    }

      public void setOperationTime(LocalDateTime operationTime) {
          this.operationTime = operationTime;
      }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }

      public void setCreateTime(LocalDateTime createTime) {
          this.createTime = createTime;
      }
    
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

      public void setUpdateTime(LocalDateTime updateTime) {
          this.updateTime = updateTime;
      }

    @Override
    public String toString() {
        return "OperationRecord{" +
              "id=" + id +
                  ", userId=" + userId +
                  ", describe=" + describe +
                  ", type=" + type +
                  ", usedAomut=" + usedAomut +
                  ", operationTime=" + operationTime +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
