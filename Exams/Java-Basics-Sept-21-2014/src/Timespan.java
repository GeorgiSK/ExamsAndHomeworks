import java.util.Scanner;

public class Timespan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] start = scanner.nextLine().split(":");
        String[] end = scanner.nextLine().split(":");
        String result = new String();

        int startSeconds = Integer.parseInt(start[2]);
        int startMinutes = Integer.parseInt(start[1]);
        int startHours = Integer.parseInt(start[0]);

        int endSeconds = Integer.parseInt(end[2]);
        int endMinutes = Integer.parseInt(end[1]);
        int endHours = Integer.parseInt(end[0]);

        int resultHours = startHours - endHours;
        int resultMinutes = startMinutes - endMinutes;
        int resultSeconds = startSeconds - endSeconds;


        if (resultSeconds < 0) {
            resultSeconds += 60;
            resultMinutes -= 1;
        }

        if (resultMinutes < 0) {
            resultMinutes += 60;
            resultHours -= 1;
        }

        result += resultHours + ":";
        if (resultMinutes < 10) result += "0" + resultMinutes + ":";
        else result += resultMinutes + ":";
        if (resultSeconds < 10) result += "0" + resultSeconds;
        else result += resultSeconds;

        System.out.println(result);

    }
}
