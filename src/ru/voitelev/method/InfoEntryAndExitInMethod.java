package ru.voitelev.method;

import java.util.Date;

public class InfoEntryAndExitInMethod {


  public String nameMethod;
  public Date timeStartMethod;
  public Date timeStopMethod;
  public int idCallMethod;

  public InfoEntryAndExitInMethod(String nameMethod, Date timeStartMethod, int idCallMethod) {
    this.nameMethod = nameMethod;
    this.timeStartMethod = timeStartMethod;
    this.idCallMethod = idCallMethod;
  }

  public void setTimeStopMethod(Date timeStopMethod) {
    this.timeStopMethod = timeStopMethod;
  }
}
