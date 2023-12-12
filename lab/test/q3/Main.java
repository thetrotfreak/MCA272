package q3;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      // 1
      final int OBJECTS = 3f;
      Commercial_Add[] cads = new Commercial_Add[OBJECTS];
      Free_Add[] fads = new Free_Add[OBJECTS];

      // 3.1
      for (int i = 0; i < OBJECTS; i++) {
        System.out.println("Commercial Client name?");
        String name = scan.next();
        System.out.println("Start date?");
        String date = scan.next();
        System.out.println("Advertisement Size?");
        int size = scan.nextInt();
        System.out.println("Advertisement Prize?");
        int prize = scan.nextInt();
        cads[i] = new Commercial_Add(name, date, size, prize);
      }

      // 3.1
      for (int i = 0; i < OBJECTS; i++) {
        System.out.println("Free Client name?");
        String name = scan.next();
        System.out.println("Start date?");
        String date = scan.next();
        System.out.println("Advertisement duration?");
        int duration = scan.nextInt();
        fads[i] = new Free_Add(name, date, duration);
      }

      // 3.2
      for (Commercial_Add cad : cads) {
        System.out.println(cad);
      }

      // 3.2
      for (Free_Add fad : fads) {
        System.out.println(fad);
      }

      // 3.3
      for (Commercial_Add cad : cads) {
        System.out.println(cad.add_Cost());
      }

      // 3.4
      System.out.println("Free ads of duration more than 3 months");
      for (Free_Add fad : fads) {
        if (fad.ofDuration(3)) {
          System.out.println(fad);
        }
      }

      // 3.5
      int total_income = 0;
      for (Commercial_Add cad : cads) {
        total_income += cad.add_Cost();
      }
      System.out.println("Total income is " + total_income);
    }
  }
}
