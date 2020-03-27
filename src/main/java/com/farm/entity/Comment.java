package com.farm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 评论人
     */
      private Integer userId;

      /**
     * 评论内容
     */
      private String content;

      /**
     * 状态
     */
      private Integer status;

      /**
     * 评论时间
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
    
    public String getContent() {
        return content;
    }

      public void setContent(String content) {
          this.content = content;
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
        return "Comment{" +
              "id=" + id +
                  ", userId=" + userId +
                  ", content=" + content +
                  ", status=" + status +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
