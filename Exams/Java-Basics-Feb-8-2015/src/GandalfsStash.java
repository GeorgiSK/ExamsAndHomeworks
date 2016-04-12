import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GandalfsStash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moodPoints = Integer.parseInt(scanner.nextLine());
        ArrayList<String> foods = new ArrayList<>();
        String foodsUnmatched = scanner.nextLine();
        String regex = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(foodsUnmatched);

        while (matcher.find()) {
            foods.add(matcher.group());
        }


        for (String food : foods) {
            moodPoints += getFoodPoints(food);
        }

        if (moodPoints > 15) {
            System.out.println(moodPoints);
            System.out.println("Special JavaScript mood");
        }else if (moodPoints > 0 && moodPoints <= 15) {

            System.out.println(moodPoints);
            System.out.println("Happy");
        }else if(moodPoints >= -5 && moodPoints <= 0) {
            System.out.println(moodPoints);
            System.out.println("Sad");
        }else if(moodPoints < -5) {
            System.out.println(moodPoints);
            System.out.println("Angry");
        }
    }

    public static int getFoodPoints(String food) {
        int points = 0;
        switch (food.toLowerCase()) {
            case "cram":
                points = 2;
                break;
            case "lembas":
                points = 3;
                break;
            case "apple":
                points = 1;
                break;
            case "melon":
                points = 1;
                break;
            case "honeycake":
                points = 5;
                break;
            case "mushrooms":
                points = -10;
                break;
            default:
                points = -1;
                break;
        }
        return points;
    }
}
