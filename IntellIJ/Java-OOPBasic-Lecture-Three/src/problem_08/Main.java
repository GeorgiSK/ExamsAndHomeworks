package problem_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!(input = reader.readLine()).equals("End")) {
            String[] line = input.trim().split(" ");
            String figure = line[0];

            if (figure.equals("Cube")) {
                System.out.printf("%.3f\n", VolumeCalculator.calculateCubeVolume(Double.parseDouble(line[1])));
            }else if (figure.equals("TrianglePrism")) {
                System.out.printf("%.3f\n", VolumeCalculator.calculateTriangularPrismVolume(Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3])));
            }else if (figure.equals("Cylinder")) {
                System.out.printf("%.3f\n", VolumeCalculator.calculateCylinderVolume(Double.parseDouble(line[1]), Double.parseDouble(line[2])));
            }
        }
    }
}

class TriangularPrism  {
    Double baseSide;
    Double heightFromBaseSide;
    Double length;

}

class Cube {
    Double sideLength;
}

class Cylinder {
    Double radius;
    Double height;
}

class VolumeCalculator {
    static Double calculateTriangularPrismVolume(Double baseHeight, Double heightFromBaseSide, Double length) {
        return 0.5 * heightFromBaseSide * baseHeight * length;
    }

    static Double calculateCubeVolume(Double sideLength) {
        return sideLength * sideLength * sideLength;
    }

    static Double calculateCylinderVolume(Double radius, Double height) {
        return Math.PI * (radius * radius) * height;
    }
}
