package ru.voitelev.method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Method {
  public String nameMethod;
  public Map<Integer, Long> leadTime = new HashMap<>();

  public void setLeadTime(Map<Integer, Long> leadTime) {
    this.leadTime = leadTime;
  }

  public Map<Integer, Long> getLeadTime() {

    return leadTime;
  }

  public Method(String nameMethod) {
    this.nameMethod = nameMethod;
  }

}
