import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CrossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        long rows = scanner.nextLong();
        long cols = scanner.nextLong();
        scanner.nextLine();
        long counter = 1;
        List<List<Long>> matrix = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Long> inner = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                inner.add(counter);
                counter++;
            }
            matrix.add(inner);
        }

        while (!(input = scanner.nextLine()).equals("Nuke it from orbit")) {
            String[] nuke = input.trim().split(" ");
            long x = Long.parseLong(nuke[0]);
            long y = Long.parseLong(nuke[1]);
            int radius = Integer.parseInt(nuke[2]);

            for (int i = 0; i <= radius; i++) {
                try {
                    matrix.get((int)x).remove(matrix.get((int)x).get((int)y + i));
                }catch (Exception e) {

                }

                try {
                    matrix.get((int)x).remove(matrix.get((int)x).remove(y - i));
                }catch (Exception e) {

                }

                try {
                    matrix.get((int)x + i).remove(matrix.get((int)x + i).get((int)y));
                }catch (Exception e) {

                }

                try {
                    matrix.get((int)x - i).remove(matrix.get((int)x - i).get((int)y));
                }catch (Exception e) {

                }
            }

//            for (int i = 0; i < radius; i++) {
//                int coord = ((int)y) + i;
//                if (coord >= matrix.get((int)x).size()){
//                    continue;
//                }
//                try {
//                    matrix.get((int) x).remove(matrix.get((int) x).get((coord)));
//                }catch(Exception e) {
//
//                }
//            }
//
//            for (int i = radius; i >= 0; i--) {
//                int coord = ((int)y) - i;
//                if (coord >= matrix.get((int)x).size()){
//                    continue;
//                }
//                try {
//                matrix.get((int)x).remove(matrix.get((int)x).get(coord));
//                }catch(Exception e) {
//
//                }
//            }
//
//            for (int i = 1; i < Long.parseLong(nuke[2]); i++) {
//                int coord = ((int)x) + i;
//                if (coord >= matrix.size()){
//                    continue;
//                }
//                try {
//                matrix.get(coord).remove(matrix.get(coord).get((int)y));
//                }catch(Exception e) {
//
//                }
//            }
//
//            for (int i = radius; i >= 1; i--) {
//                int coord = ((int)x) - i;
//
//                if (coord >= matrix.size()){
//                    continue;
//                }
//                try {
//                matrix.get(coord).remove(matrix.get(coord).get((int)y));
//                }catch(Exception e) {
//
//                }
//            }
        }

        for (List<Long> longs : matrix) {
            System.out.println(longs.toString().replace('[', '\0').replace(']', '\0').replace(',', '\0').trim());
        }
    }
}
