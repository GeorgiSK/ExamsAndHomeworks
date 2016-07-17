package queues;

import java.util.*;

public class SequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> sequence = new ArrayDeque<>();
        List<Integer> next = new ArrayList<>();

        int i = 1;
        int n = scanner.nextInt();
        sequence.add(n);
        int current = n;
        next.add(n);

        while (sequence.size() < 50) {
            sequence.add(current + 1);
            next.add(sequence.getLast());
            sequence.add((current * 2) + 1);
            next.add(sequence.getLast());
            sequence.add(current + 2);
            next.add(sequence.getLast());
            current = next.get(i++);
        }

        for (int j = 0; j < 50; j++) {
            System.out.print(sequence.remove() + " ");
        }

        System.out.println(next.size());

    }
}
