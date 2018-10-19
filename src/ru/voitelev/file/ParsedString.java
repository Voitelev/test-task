package ru.voitelev.file;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParsedString {
  String parsingNameCallMethod(String str) {
    Pattern patternName = Pattern.compile("([a-zA-Z])+(?=[^a-zA-Z]*$)");
    Matcher matcherName = patternName.matcher(str);
    if (matcherName.find()) {
      return matcherName.group();

    }
    return null;
  }

  int parsingIdCallMethod(String str) {
    Pattern patternId = Pattern.compile("\\d+(?=\\D*$)");
    Matcher matcherId = patternId.matcher(str);
    if (matcherId.find()) {

      return Integer.parseInt(matcherId.group());
    }
    return 0;
  }

  Date parsingDate(String str) throws ParseException {
    String dateTime = str.split(" ")[0];
    dateTime = dateTime.replace('T', ' ');
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
    return ft.parse(dateTime);
  }
}
