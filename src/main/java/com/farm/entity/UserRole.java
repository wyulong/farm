package com.farm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public class UserRole implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户ID
     */
      private Integer userId;

      /**
     * 模块名称
     */
      private String moduleName;

      /**
     * 模块URL
     */
      private String url;

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
    
    public String getModuleName() {
        return moduleName;
    }

      public void setModuleName(String moduleName) {
          this.moduleName = moduleName;
      }
    
    public String getUrl() {
        return url;
    }

      public void setUrl(String url) {
          this.url = url;
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
        return "UserRole{" +
              "id=" + id +
                  ", userId=" + userId +
                  ", moduleName=" + moduleName +
                  ", url=" + url +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
