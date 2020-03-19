package test;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String msgContent = in. nextLine();
    String[] msgSplit = msgContent.split("\\s+");
    switch (msgSplit[0]) {
      case "\\createuser":
        System.out.println("asdfasdf");
    }
  }
}
