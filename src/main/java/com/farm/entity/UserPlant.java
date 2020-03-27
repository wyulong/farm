package com.farm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户种植记录
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public class UserPlant implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户ID
     */
      private Integer userId;

      /**
     * 种植时间
     */
      private LocalDateTime plantTime;

      /**
     * 种植方式
     */
      private String plantType;

      /**
     * 产量
     */
      private String yield;

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
    
    public LocalDateTime getPlantTime() {
        return plantTime;
    }

      public void setPlantTime(LocalDateTime plantTime) {
          this.plantTime = plantTime;
      }
    
    public String getPlantType() {
        return plantType;
    }

      public void setPlantType(String plantType) {
          this.plantType = plantType;
      }
    
    public String getYield() {
        return yield;
    }

      public void setYield(String yield) {
          this.yield = yield;
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
        return "UserPlant{" +
              "id=" + id +
                  ", userId=" + userId +
                  ", plantTime=" + plantTime +
                  ", plantType=" + plantType +
                  ", yield=" + yield +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
