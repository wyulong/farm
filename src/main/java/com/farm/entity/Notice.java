package com.farm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 公告表
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public class Notice implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 作者ID
     */
      private Integer authorId;

      /**
     * 公告标题
     */
      private String title;

      /**
     * 公告内容
     */
      private String content;

      /**
     * 公告状态
     */
      private Integer status;

      /**
     * 发布时间
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
    
    public Integer getAuthorId() {
        return authorId;
    }

      public void setAuthorId(Integer authorId) {
          this.authorId = authorId;
      }
    
    public String getTitle() {
        return title;
    }

      public void setTitle(String title) {
          this.title = title;
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
        return "Notice{" +
              "id=" + id +
                  ", authorId=" + authorId +
                  ", title=" + title +
                  ", content=" + content +
                  ", status=" + status +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
