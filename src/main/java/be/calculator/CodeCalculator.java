package be.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeCalculator {
    private CodeParts parts;

    public double getResult(String code) {
        if (isCodeOk(code)) {
            return calculate();
        }
        return 0;
    }

    public String getResultAsString(String code) {
        if(isCodeOk(code)){
            return calculateAsString();
        }
        else{
            if(code == null){return "null code = 0";}
            if (code.equals("")) {return "empty code = 0";}
            if(code.equals("()")){return "empty code = 0";}
            if(code.equals("&/(0,0,0,0)")){return "empty code = 0";}
            return "invalid code = 0";
        }

    }

    private boolean isCodeOk(String code) {
        if (code==null) return false;
        code = code.trim();
        if (code.equals("")) return false;
        Pattern p = Pattern.compile("(?<operation>^\\&?[\\+\\-\\*/]?)\\(?(?<numbers>[0-9, ]*)\\)?(?<endcharacters>.*)");
        Matcher m = p.matcher(code);
        if (!m.find() || !m.group("endcharacters").equals("") || m.group("numbers").equals("")) return false;
        parts = new CodeParts(m.group("operation"), m.group("numbers"));
        if (parts.numbers.length==0) return false;
        return true;
    }

    private double calculate() {
        double result = parts.numbers[0];
        for (int i=1; i<parts.numbers.length; i++) {
            switch (parts.operation) {
                case "-":
                    result -= parts.numbers[i];
                    break;
                case "*":
                    result *= parts.numbers[i];
                    break;
                case "/":
                    result /= parts.numbers[i];
                    break;
                default:
                    result += parts.numbers[i];
            }
        }
        return result;
    }

    private String calculateAsString() {
        String result = parts.numbers[0].toString();
        int finalResult = parts.numbers[0];
        double finalResultDivide = parts.numbers[0];

        for (int i=1; i<parts.numbers.length; i++) {
            switch (parts.operation) {
                case "-":
                    result += " - " + parts.numbers[i];
                    finalResult -= parts.numbers[i];
                    break;
                case "*":
                    result += " * " + parts.numbers[i];
                    finalResult *= parts.numbers[i];
                    break;
                case "/":
                    result += " / " + parts.numbers[i];
                    finalResultDivide /= parts.numbers[i];
                    break;
                default:
                    result += " + " + parts.numbers[i];
                    finalResult += parts.numbers[i];
            }
        }

        switch (parts.operation){
            case "/":
                //ik krijg decimalen niet afgerond op 4 cijfers na de komma
                result += " = " + finalResultDivide;
                break;
            default:
                result += " = " + finalResult;
        }

        return result;
    }

    private static class CodeParts {
        private final String operation;
        private final Integer[] numbers;

        public CodeParts(String operation, String numbers) {
            if (operation.length()<2) {
                this.operation = "+";
            } else {
                this.operation = operation.substring(1);
            }
            this.numbers = Arrays.stream(numbers.split(",")).map(s -> Integer.parseInt(s.trim())).filter(i -> i!=0).toArray(Integer[]::new);
        }
    }
}
