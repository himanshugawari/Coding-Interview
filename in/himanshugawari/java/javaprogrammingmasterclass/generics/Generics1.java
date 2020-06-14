package in.himanshugawari.java.javaprogrammingmasterclass.generics;

import java.util.ArrayList;

public class Generics1 {
  public static void main(String[] args) {
    ArrayList items = new ArrayList();
    items.add(1);
    items.add(2);
    items.add(3);
    items.add(4);
    items.add(5);

    printDoubled(items);
  }

  private static void printDoubled(ArrayList items) {
    for (Object i : items) {
      System.out.println((Integer) i * 2);
    }
  }
}