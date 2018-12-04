package com.eomcs.lms.domain;
import java.sql.Date;

public class Board {
  private int no;
  private String contents;
  private Date createdDate;
  private int viewCount;
  private int writerNo;
  private int lessonNo;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getWriterNo() {
    return writerNo;
  }
  public void setWriterNo(int writerNo) {
    this.writerNo = writerNo;
  }
  public int getLessonNo() {
    return lessonNo;
  }
  public void setLessonNo(int lessonNo) {
    this.lessonNo = lessonNo;
  }
  
  
}
