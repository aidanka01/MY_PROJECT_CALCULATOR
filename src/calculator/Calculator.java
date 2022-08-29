package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private int calcExp(int n1, String op, int n2) {
        return switch (op) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> throw new AssertionError();
        };
    }

    // public метод текшерет результатын чыгаруу
    public String result(String exp) throws CalcException {
        int num1;
        int num2;     //сандар
        String operator;    //оператор
        boolean isRomanExp;     // ---сандар римские
        Parse parse = new Parse();

        // пробел коюу " "
        List<String> expItems = Arrays.asList(exp.split(" "));

        // текшеруу  2 сан берилдиби
        if (expItems.size() != 3) {
            throw new CalcException("КАТА. 1-чи сан, 2-сан жана операция белгиси болуш керек + - * / (через пробел)");
        }

        // операторду текшеруу: + - * /
        if (parse.checkOperator(expItems.get(1))) {
            operator = expItems.get(1);
        } else {
            throw new CalcException("КАТА Оператор '" + expItems.get(1) + "' туура эмес, ушундай болушу керек: + - * / ");
        }

        // текшеребиз сандар экоо тен араб же рим сандары болуш керек
        if (parse.isNumeric(expItems.get(0)) && parse.isNumeric(expItems.get(2))) {      // текшеребиз сандар экоо тен араб
            num1 = Integer.parseInt(expItems.get(0));
            num2 = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (parse.isRoman(expItems.get(0)) && parse.isRoman(expItems.get(2))) {   // текшеребиз сандар экоо тен рим
            num1 = parse.romeToArabConvert(expItems.get(0));
            num2 = parse.romeToArabConvert(expItems.get(2));
            isRomanExp = true;
        } else {
            throw new CalcException("КАТА! сандар экоо тен араб же рим сандары болуш керек!");
        }

        checkNumberFrom1To10(num1);
        checkNumberFrom1To10(num2);

        int res = calcExp(num1, operator, num2);


        if (isRomanExp) {
            String sign = res < 0 ? "-" : "";
            return sign + parse.arabToRomeConvert(Math.abs(res));
        }

        return String.valueOf(res);
    }

    public static void checkNumberFrom1To10(int number) throws CalcException {
        if (!(number >= 1 && number <= 10)) {
            throw new CalcException("ОЙ КАТА! берилген сандар 1ден чон 10дон кичине болуш керек!");
        }
    }
}
