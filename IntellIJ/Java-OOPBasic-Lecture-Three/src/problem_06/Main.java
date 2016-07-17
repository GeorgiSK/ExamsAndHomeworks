package problem_06;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Calculation.reducePlankConstant());
    }
}

class Calculation {
    static final Double plankConstant = 6.62606896e-34;
    static final Double pi = 3.14159;

    static Double reducePlankConstant() {
        return plankConstant / (2 * pi);
    }
}
