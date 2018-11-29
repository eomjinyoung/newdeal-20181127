import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    
    Lesson[] lessons = new Lesson[LENGTH];
    
    int i = 0;
    while (i < LENGTH) {
      System.out.print("명령> ");
      String command = keyboard.nextLine();
      
      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equals("/lesson/add")) {
        Lesson lesson = new Lesson();
        System.out.print("번호? ");
        lesson.no = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("수업명? ");
        lesson.title = keyboard.nextLine();
        
        System.out.print("설명? ");
        lesson.contents = keyboard.nextLine();
        
        System.out.print("시작일? ");
        lesson.startDate = Date.valueOf(keyboard.nextLine());
        
        System.out.print("종료일? ");
        lesson.endDate = Date.valueOf(keyboard.nextLine());
        
        System.out.print("총수업시간? ");
        lesson.totalHours = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("일수업시간? ");
        lesson.dayHours = Integer.parseInt(keyboard.nextLine());
        
        lessons[i] = lesson;
        i++;
        
      } else if (command.equals("/lesson/list")) {
        for (int j = 0; j < i; j++) {
          System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
              lessons[j].no, lessons[j].title, lessons[j].startDate, 
              lessons[j].endDate, lessons[j].totalHours);
        }
        
      } else {
        System.out.println("유효하지 않은 명령입니다.");
      }

      System.out.println();
    }
    
    keyboard.close();
  }
}
