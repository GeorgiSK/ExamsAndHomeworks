package queues;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int curr = scanner.nextInt();
            queue.add(curr);
        }

        for (int i = 0; i < s; i++) {
            try {
                queue.poll();
            }catch (Exception e) {}
        }

        try {
            if (queue.contains(x)) {
                System.out.println("true");
            } else {
                List<Integer> asd = queue.stream().collect(Collectors.toList());

                asd.sort((a, b) -> a - b);
                System.out.println(asd.get(0));
            }
        }catch (Exception e) {
            System.out.println("0");
        }

    }
}
