package com.doerit.model;

import java.util.Date;

public interface InsertUpdate {
  
  public void setInsertUserId(String insertUserId); 
  public void setInsertDatetime(Date insertDatetime);
  public void setUpdateUserId(String updateUserId); 
  public void setUpdateDatetime(Date updateDatetime);
  
}
