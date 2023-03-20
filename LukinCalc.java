package calcRA;

import java.util.InputMismatchException;
import java.util.Scanner;


public class LukinCalc {
    static Scanner scanner = new Scanner(System.in);
    static int numb1, numb2;
    static char oper;
    static int outcome;

    public static void main (String[] args) {
        System.out.println("Что хотите подсчитать? Вводите уравнение. "); //Считываем строку каторую ввели
        String userInput = scanner.nextLine();    //Делаем пустой массив для чисел, которые ввели
        char[] under_char = new char[10];      // Заполняем массив числом, которое вписали и определяем знак для операции
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                oper = '+';
            }
            if (under_char[i] == '-') {
                oper = '-';
            }
            if (under_char[i] == '*') {
                oper = '*';
            }
            if (under_char[i] == '/') {
                oper = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[]  blacks = under_charString.split("[+-/*]");
        String  stable00 =  blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        numb1 = romanToNumber(stable00);
        numb2 = romanToNumber(string03);
        if (numb1 < 0 && numb2 < 0) {    //
            outcome = 0;
        } else {
            outcome = calculated(numb1, numb2, oper);
            System.out.println(" Получилось ");
            String resultRoman = convertNumToRoman(outcome);
            System.out.println(stable00 + " " + oper + " " + string03 + " = " + resultRoman);
        }
        numb1 = Integer.parseInt(stable00);
        numb2 = Integer.parseInt(string03);
        outcome = calculated(numb1, numb2, oper);
        System.out.println(" Получилось ");
        System.out.println(numb1 + " " + oper + " " + numb2 + " = " + outcome);
    }

    private static String convertNumToRoman (int numArabian) {   // прописываем римский алфавит
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {  // сокращаем и делаем редирект к прошлым операциям, чтобы не писать дважды
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");   // проверка на правильность ввода цифр
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {  // прописываем операции с числами
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Исключение : " + e);  // проверка согласно требованиям задания
                    System.out.println("Допускаются только целочисленные ненулевые параметры"); // проверка согласно требованиям задания

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не тот знак, давай лучше поставим +"); // проверка на корявость ввода операции

        }
        return result;
    }
}