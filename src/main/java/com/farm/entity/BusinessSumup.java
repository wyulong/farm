package com.farm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 下乡总计表
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public class BusinessSumup implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 作者id
     */
      private Integer authorId;

      /**
     * 下乡时间
     */
      private LocalDateTime time;

      /**
     * 内容
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
    
    public LocalDateTime getTime() {
        return time;
    }

      public void setTime(LocalDateTime time) {
          this.time = time;
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
        return "BusinessSumup{" +
              "id=" + id +
                  ", authorId=" + authorId +
                  ", time=" + time +
                  ", content=" + content +
                  ", status=" + status +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
