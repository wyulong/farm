package com.farm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public class Article implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer id;

      /**
     * 作者ID
     */
      private Integer authorId;

      /**
     * 文章类别
     */
      private Integer type;

      /**
     * 文章标题
     */
      private String title;

      /**
     * 文章内容
     */
      private String content;

      /**
     * 状态
     */
      private Integer status;

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
    
    public Integer getAuthorId() {
        return authorId;
    }

      public void setAuthorId(Integer authorId) {
          this.authorId = authorId;
      }
    
    public Integer getType() {
        return type;
    }

      public void setType(Integer type) {
          this.type = type;
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
        return "Article{" +
              "id=" + id +
                  ", authorId=" + authorId +
                  ", type=" + type +
                  ", title=" + title +
                  ", content=" + content +
                  ", status=" + status +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
