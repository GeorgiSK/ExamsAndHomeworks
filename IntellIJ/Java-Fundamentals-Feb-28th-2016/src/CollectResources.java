import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectResources {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String field = scanner.nextLine();
        int numOfPaths = Integer.parseInt(scanner.nextLine());
        List<Integer> resourcesTotal = new ArrayList<>();

        for (int i = 0; i < numOfPaths; i++) {
            int start = scanner.nextInt();
            int step = scanner.nextInt();
            int currentPosition = start;
            boolean isOver = false;
            String[] resources = field.trim().split("[ ]+");
            boolean[] isUsed = new boolean[resources.length];
            int resourceQuantity = 0;
            String currentResource = resources[currentPosition];

            if (currentResource.indexOf('_') > 0) {
                if (isResourceValid(currentResource.trim().split("_")[0]))
                    resourceQuantity += Integer.parseInt(currentResource.trim().split("_")[1]);
            }else {
                if (isResourceValid(currentResource))
                    resourceQuantity += 1;
            }

            isUsed[start] = true;

            while (!isOver) {
                for (int j = 0; j < step; j++) {
                    currentPosition++;
                    if (currentPosition > resources.length - 1) {
                        currentPosition = 0;
                    }
                }

                currentResource = resources[currentPosition];

                if (!(isUsed[currentPosition])) {
                    if (currentResource.indexOf('_') > 0) {
                        if (isResourceValid(currentResource.trim().split("_")[0]))
                            resourceQuantity += Integer.parseInt(currentResource.trim().split("_")[1]);
                        isUsed[currentPosition] = true;
                    } else {
                        if (isResourceValid(currentResource))
                            resourceQuantity += 1;
                        isUsed[currentPosition] = true;
                    }
                }else {
                    isOver = true;
                }
            }

            resourcesTotal.add(resourceQuantity);
        }

        resourcesTotal.sort((a, b) -> b - a);

        System.out.println(resourcesTotal.get(0));

    }

    static boolean isResourceValid(String resource) {
        switch (resource) {
            case "stone":
                return true;
            case "gold":
                return true;
            case "wood":
                return  true;
            case "food":
                return true;
        }
        return false;
    }
}
