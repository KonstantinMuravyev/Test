import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Converter converter = new Converter();

        String[] operators = {"+","-", "/", "*"};
        String[] regexOperators = {"\\+","-","/","\\*"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите выражение:");
        String numberExpression = sc.nextLine();

        int operatorIndex = -1;
        for (int i = 0; i < operators.length; i++) {
            if (numberExpression.contains(operators[i])) {
                operatorIndex = i;
                break;
            }
        }

        if (operatorIndex == -1) {
            System.out.println("Некорректное значение!");
            return;
        }

        String[] data = numberExpression.split(regexOperators[operatorIndex]);
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a;
            int b;

            boolean isRoman = converter.isRoman(data[0]);

            if(isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }


            int result = switch (operators[operatorIndex]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> 0;
            };
            if (isRoman) {
                System.out.println(converter.intToRoman(result));
            } else {
                System.out.println(result);
            }
        } else System.out.println("Числа должны быть в одном формате!");
    }
}
