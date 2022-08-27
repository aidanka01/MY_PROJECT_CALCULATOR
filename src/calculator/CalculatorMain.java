package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class CalculatorMain {

        public static void main(String[] args) {
            try {
                System.out.println("Бул Айдананын калькулятору");
                System.out.println("сандарды через пробел жазыныз!");
                System.out.print("Операцияны жазыныз: ");
                BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
                String calcString = bReader.readLine();

                Calculator calc = new Calculator();
                String result = calc.result(calcString);
                System.out.println("Жооп: " + result);
            } catch (CalcException | IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }


