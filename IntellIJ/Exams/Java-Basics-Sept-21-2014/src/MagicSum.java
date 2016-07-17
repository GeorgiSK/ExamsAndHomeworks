import java.util.ArrayList;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int d = Integer.parseInt(scanner.nextLine());
        String num;
        ArrayList<Integer> numbers = new ArrayList<>();
        while (!(num = scanner.nextLine()).equalsIgnoreCase("end")) {
            numbers.add(Integer.parseInt(num));
        }

        ArrayList<ArrayList<Integer>> sums = new ArrayList<>();


        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                for (int k = 0; k < numbers.size(); k++) {
                    if (i != j && i != k && k != j) {
                        int sum = numbers.get(i) + numbers.get(j) + numbers.get(k);
                        ArrayList<Integer> tempList = new ArrayList<>();
                        if (sum % d == 0) {
                            tempList.add(numbers.get(i));
                            tempList.add(numbers.get(j));
                            tempList.add(numbers.get(k));

                            if (sums.size() > 0) {
                                ArrayList<Integer> innerTemp = sums.get(0);
                                int innerSum = innerTemp.get(0) + innerTemp.get(1) + innerTemp.get(2);
                                if (sum == innerSum) {
                                    if (!sums.get(0).containsAll(tempList)) {
                                        sums.add(tempList);
                                    }
                                } else if (sum > innerSum) {
                                    sums.clear();
                                    sums.add(tempList);
                                }
                            } else {
                                sums.add(tempList);
                            }
                        }
                    }
                }
            }
        }

        if (sums.size() == 0) {
            System.out.println("No");
        }else {
            for (ArrayList<Integer> sum : sums) {
                int elementOne = sum.get(0);
                int elementTwo = sum.get(1);
                int elementThree = sum.get(2);

                System.out.println("(" + elementOne + " + " + elementTwo + " + " + elementThree + ") " + "% " + d + " = 0");
            }
            //System.out.println("(" + numbers.get(i) + " + " + numbers.get(j) + " + " + numbers.get(k) + ") " + "% " + d + " = 0");
        }
    }
}
