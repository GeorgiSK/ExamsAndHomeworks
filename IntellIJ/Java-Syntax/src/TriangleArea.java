import java.util.Scanner;

/**
 * Created by Windows on 3/17/2016.
 */
public class TriangleArea {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        /*Creating an array that will hold the coordinates as follows:  */
        /*--------------- Ax = points[0]; Ay = points[1] ---------------*/
        /*--------------- Bx = points[2]; By = points[3] ---------------*/
        /*--------------- Cx = points[4]; Cy = points[5] ---------------*/
        int[] points = new int[6];
        int triangleArea;

        //Saving the coordinates in the array
        for (int i = 0; i < 6; i++) {
            points[i] = scanner.nextInt();
        }

        //Implementing the formula for area of a triangle with coordinates of points
        triangleArea = Math.abs((points[0] * (points[3] - points[5]) + points[2] * (points[5] - points[1]) + points[4] * (points[1] - points[3])) / 2);

        System.out.println(triangleArea);

    }
}
