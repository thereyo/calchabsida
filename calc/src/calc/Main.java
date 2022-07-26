package calc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while (true){
            String expression = scanner.nextLine();
            System.out.println(calculator.calculate(expression));
        }
    }
}
