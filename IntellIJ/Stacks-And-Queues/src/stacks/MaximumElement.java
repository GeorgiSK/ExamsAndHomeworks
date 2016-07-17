package stacks;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().trim().split(" ");

            if (input.length > 1) {
                stack.push(Integer.parseInt(input[1]));
            }else {
                if (input[0].equals("2")) {
                    try {
                        stack.pop();
                    }catch (Exception e) {

                    }
                }else if (input[0].equals("3")) {
                    try {
                        List<Integer> asd = stack.stream().collect(Collectors.toList());
                        asd.sort((a,b) -> b - a);
                        System.out.println(asd.get(0));
                    }catch (Exception e) {

                    }
                }
            }
        }

    }
}
