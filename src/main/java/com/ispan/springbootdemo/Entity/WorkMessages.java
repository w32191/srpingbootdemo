package com.ispan.springbootdemo.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "work_meassage")
public class WorkMessages {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  //用columnDefinition指定欄位的型別
  @Size(min = 2, max = 199, message = "請輸入2~199")
  @Column(name = "text", columnDefinition = "nvarchar(200)")
  private String text;

  @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
  @Temporal(TemporalType.TIMESTAMP)
  // @Temporal可指定從資料庫中取出的資料內容
  // 如果在某類中有Date類型的屬性，數據庫中存儲可能是'yyyy-MM-dd hh:MM:ss'要在查詢時獲得年月日，在該屬性上標註@Temporal(TemporalType.DATE) 會得到形如'yyyy-MM-dd' 格式的日期。
  @Column(name = "added", columnDefinition = "datetime")
  private Date added;

  public WorkMessages() {
  }

  @PrePersist   // 再轉換到 Persist 狀態以前去做以下方法
  public void onCreate() {
    if (added == null) {
      added = new Date();
    }
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getAdded() {
    return added;
  }

  public void setAdded(Date added) {
    this.added = added;
  }

  @Override
  public String toString() {
    return "WorkMessages [id=" + id + ", text=" + text + ", added=" + added + "]";
  }

}
