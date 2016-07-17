package stacks;

import javafx.scene.layout.StackPane;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        String[] nums = scanner.nextLine().trim().split(" ");

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(nums[i]));
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.contains(x)) {
            System.out.println("true");
        }else {
            stack.sort((a,b) -> b - a);
            try {

            }catch (Exception e) {
                System.out.println("0");
            }

        }
    }
}
