package com.company;


import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Calculator calculator = new Calculator();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Привет JavaMentor! Это калькулятор\nВведите целую числу от 1 до 10 включительно, и один из операторов(+, -, *, /)");
            System.out.print("Арифметическая операция: ");
            String numbers = calculator.StringNumber(scanner.nextLine());
            System.out.println("Ответ: " + numbers);
        }
        catch (Exception ex){
            System.out.println("Произошло ошибка! Неправильная значение\nНадо было ввести целую числу от 1 до 10 включительно, и один из операторов(+, -, *, /)");
        }
    }
}
