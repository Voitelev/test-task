package ru.voitelev.file;

import ru.voitelev.method.InfoEntryAndExitInMethod;

import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class File {

  private final String METHOD_ENTRY = "entry";
  private final String METHOD_EXIT = "exit";
  private Map<Integer, InfoEntryAndExitInMethod> causedMethod = new HashMap<>();

  public void readFile(String pathName) throws IOException, ParseException {
    java.io.File file = new java.io.File(pathName);
    FileReader fr = new FileReader(file);
    BufferedReader reader = new BufferedReader(fr);
    String line = reader.readLine();
    while (line != null) {
      parsingString(line);
      line = reader.readLine();
    }
  }

  public Map<Integer, InfoEntryAndExitInMethod> getMapMethod() {
    return causedMethod;
  }

  private void parsingString(String str) throws ParseException {
    String nameMethod;
    Date timeStartMethod;
    Date timeStopMethod;
    int idMethod;
    ParsedString parsedString = new ParsedString();
    nameMethod = parsedString.parsingNameCallMethod(str);
    idMethod = parsedString.parsingIdCallMethod(str);

    if (str.contains(METHOD_ENTRY)) {
      timeStartMethod = parsedString.parsingDate(str);
      InfoEntryAndExitInMethod infoEntryAndExitInMethod = new InfoEntryAndExitInMethod(nameMethod, timeStartMethod, idMethod);
      causedMethod.put(idMethod, infoEntryAndExitInMethod);
    } else if (str.contains(METHOD_EXIT)) {
      timeStopMethod = parsedString.parsingDate(str);
      InfoEntryAndExitInMethod currentInfoEntryAndExitInMethod = causedMethod.get(idMethod);
      currentInfoEntryAndExitInMethod.setTimeStopMethod(timeStopMethod);
      causedMethod.put(idMethod, currentInfoEntryAndExitInMethod);
    }

  }


}
