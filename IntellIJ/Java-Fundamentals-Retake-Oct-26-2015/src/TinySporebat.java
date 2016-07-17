import java.util.Scanner;

public class TinySporebat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        int health = 5800;
        int glowcaps = 0;

        while (!(input = scanner.nextLine()).equals("Sporeggar")) {
            char[] chars = input.toCharArray();

            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] != 'L') {
                    health -= chars[i];
                }else {
                    health += 200;
                }
            }

            if (health <= 0) {
                break;
            }else {
                glowcaps += Integer.parseInt(Character.toString(chars[chars.length - 1]));
            }
        }

        if (health <=0) {
            System.out.println("Died. Glowcaps: " + glowcaps);
        }else {
            System.out.println("Health left: " + health);
            if (glowcaps >= 30) {
                glowcaps -= 30;
                System.out.println("Bought the sporebat. Glowcaps left: " + glowcaps);
            }else {
                System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", 30 - glowcaps);
            }
        }
    }
}
