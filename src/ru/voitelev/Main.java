package ru.voitelev;

import ru.voitelev.file.File;
import ru.voitelev.indicators.IndicatorsMethod;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    String putToFile = args[0];
    System.out.println("Вы ввели путь:" + putToFile);
    System.out.println("Ожидайте...");
    File file = new File();
    try {
      file.readFile(putToFile);
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
    IndicatorsMethod indicatorsMethod = new IndicatorsMethod(file);
    indicatorsMethod.printMethodWithParameters();

  }
}
