package stacks;

import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().trim().split(" ");

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < line.length; i++) {
            stack.push(Integer.parseInt(line[i]));
        }

        for (int i = 0; i < line.length; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}
