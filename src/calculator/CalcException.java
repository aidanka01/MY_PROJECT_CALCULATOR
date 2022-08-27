package calculator;

public class CalcException extends Exception {
        public CalcException() {
            System.out.println("Туура эмес берилген операция");
        }

        public CalcException(String message){
            this();
            System.out.println(message);
        }
    }

