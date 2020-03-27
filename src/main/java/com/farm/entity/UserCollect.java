package com.farm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户收藏
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public class UserCollect implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户id
     */
      private Integer userId;

      /**
     * 文章ID
     */
      private Integer articleId;

      /**
     * 状态 1、收藏  0、取消
     */
      private Integer status;

      /**
     * 收藏时间
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
    
    public Integer getArticleId() {
        return articleId;
    }

      public void setArticleId(Integer articleId) {
          this.articleId = articleId;
      }
    
    public Integer getStatus() {
        return status;
    }

      public void setStatus(Integer status) {
          this.status = status;
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
        return "UserCollect{" +
              "id=" + id +
                  ", userId=" + userId +
                  ", articleId=" + articleId +
                  ", status=" + status +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
