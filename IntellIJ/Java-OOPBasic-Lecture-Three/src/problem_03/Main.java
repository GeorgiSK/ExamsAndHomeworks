package problem_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Double, String> results = new LinkedHashMap<>();

        String input;

        while (!(input = reader.readLine()).equals("End")) {
            String[] line = input.trim().split(" ");
            String type = line[1];
            Double value = Double.parseDouble(line[0]);
            String result;

            if (type.equals("Celsius")) result = "Fahrenheit";
            else result = "Celsius";

            results.put(convertTemperature(type, value), result);
        }

        for (Map.Entry<Double, String> entry : results.entrySet()) {
            System.out.printf("%.2f %s\n", entry.getKey(), entry.getValue());
        }
    }

    static Double convertTemperature(String type, Double value) {
        if (type.equals("Celsius")) {
            return value * 9/5 + 32;
        }else {
            return (value - 32) * 5/9;
        }
    }
}

