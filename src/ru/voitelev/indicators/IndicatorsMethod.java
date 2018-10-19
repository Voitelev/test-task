package ru.voitelev.indicators;

import ru.voitelev.file.File;
import ru.voitelev.method.InfoEntryAndExitInMethod;
import ru.voitelev.method.Method;

import java.util.*;

public class IndicatorsMethod {
  private File file;

  public IndicatorsMethod(File file) {
    this.file = file;
  }

  private Map<String, Method> calculationTimeFulfillmentMethod() {

    Map<Integer, InfoEntryAndExitInMethod> causedMethod = file.getMapMethod();
    Map<String, Method> mapMethod = new HashMap<>();
    for (Map.Entry entry : causedMethod.entrySet()) {

      Integer key = (Integer) entry.getKey();
      InfoEntryAndExitInMethod value = (InfoEntryAndExitInMethod) entry.getValue();
      if (!(value.timeStopMethod == null)) {
        long leadTimeMethod = value.timeStopMethod.getTime() - value.timeStartMethod.getTime();
        if (leadTimeMethod < 0) {
          System.out.println("отрицательное" + key);
        }
        if (mapMethod.containsKey(value.nameMethod)) {
          Method method = mapMethod.get(value.nameMethod);
          Map<Integer, Long> leadTime = method.getLeadTime();
          leadTime.put(key, leadTimeMethod);
          method.setLeadTime(leadTime);
        } else {
          Method method = new Method(value.nameMethod);
          Map<Integer, Long> leadTime = method.getLeadTime();
          leadTime.put(key, leadTimeMethod);
          method.setLeadTime(leadTime);
          mapMethod.put(value.nameMethod, method);
        }
      }
    }
    return mapMethod;
  }

  public void printMethodWithParameters() {
    String nameMethod;
    for (Map.Entry entry : calculationTimeFulfillmentMethod().entrySet()) {
      nameMethod = (String) entry.getKey();
      Method method = (Method) entry.getValue();
      Map<Integer, Long> methodExecutionTime = method.leadTime;
      System.out.println("OperationsImpl:" + nameMethod + " " + calculationParameters(methodExecutionTime));

    }
  }

  private String calculationParameters(Map<Integer, Long> methodExecutionTime) {
    long sum = 0;
    String result;
    long avg;
    Map.Entry<Integer, Long> minEntry = null;
    Map.Entry<Integer, Long> maxEntry = null;
    for (Map.Entry<Integer, Long> entry : methodExecutionTime.entrySet()) {
      if (minEntry == null || entry.getValue() < minEntry.getValue()) {
        minEntry = entry;
      }
      if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
        maxEntry = entry;
      }
      sum += entry.getValue();
    }

    avg = sum / methodExecutionTime.size();
    result = " min: " + minEntry.getValue()
            + " max: " + maxEntry.getValue()
            + "," + " avg: " + avg + ","
            + " maxId: " + maxEntry.getKey()
            + "," + " count: " + methodExecutionTime.size();
    return result;
  }

}
