package com.company;

public class Calculator {

   private int[] numberArab = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
   private char[] numbersToChar = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
   private char[] operations = new char[]{'+', '-', '*', '/'};

    public String StringNumber(String stringnumber){

        char[] Rome = new char[]{'X', 'V', 'I'};
        String numberOperation = stringnumber.replaceAll("\\s+", "");
        char[] numberChar = stringnumber.toCharArray();
        int schetchik = 0;
        String result = "";
        for (int i=0; i<stringnumber.length(); i++){
            for(int j=0; j<Rome.length; j++){
                if(numberChar[i]==Rome[j]){
                    schetchik++;
                }
            }
        }
        if(schetchik==0){
            result = Integer.toString(OperationToArab(numberOperation));
        }
        else{
            result = ArabToRome(OperationToRome(numberOperation));
        }
        return result;
    }

    public int RomeToArab(String input){
        int output = 0;
        switch (input){
            case "I": output = 1; break;
            case "II": output = 2; break;
            case "III": output = 3; break;
            case "IV": output = 4; break;
            case "V": output = 5; break;
            case "VI": output = 6; break;
            case "VII": output = 7; break;
            case "VIII": output = 8; break;
            case "IX": output = 9; break;
            case "X": output = 10; break;
        }
        return output;
    }

    public String ArabToRome(int input){
        String output = "";
        while (input >= 100){
            output += "C";
            input -= 100;
        }
        while (input >= 90){
            output += "XC";
            input -= 90;
        }
        while (input >= 50){
            output += "L";
            input -= 50;
        }
        while (input >= 40){
            output += "XL";
            input -= 40;
        }
        while (input >= 10){
            output += "X";
            input -= 10;
        }
        while (input >= 9){
            output += "IX";
            input -= 9;
        }
        while (input >= 5){
            output += "V";
            input -= 5;
        }
        while (input >= 4){
            output += "IV";
            input -= 4;
        }
        while (input >= 1){
            output += "I";
            input -= 1;
        }
        return output;
    }

    public int Result(int number1, int number2, int schetchik) {

               int result = 0;
               if ((number1 >= 1 && number1 <= 10) && (number2 >= 1 && number2 <= 10)) {

                   switch (schetchik) {
                       case 1:
                           result = number1 + number2;
                           break;
                       case 2:
                           result = number1 - number2;
                           break;
                       case 3:
                           result = number1 * number2;
                           break;
                       case 4:
                           result = number1 / number2;
                           break;
                   }

               }
               else {
                   throw new ArithmeticException();
               }
               return result;
    }

    public int OperationToRome(String operationtoString) {

        int number1, number2, result = 0, schetchik = 0;
        String number1ToString = "";
        String number2ToString = "";

        char[] numberOperationToChar = operationtoString.toCharArray();

        for (int i = 0; i < numberOperationToChar.length; i++) {

            for (int j = 0; j < operations.length; j++) {

                if (numberOperationToChar[i] == operations[j]) {
                    schetchik = j + 1;
                    for (int k = 0; k < i; k++) {
                        number1ToString += Character.toString(numberOperationToChar[k]);
                    }
                    for (int s = (i + 1); s < operationtoString.length(); s++) {
                        number2ToString += Character.toString(numberOperationToChar[s]);
                    }
                    break;
                }
            }
        }

        number1 = RomeToArab(number1ToString);
        number2 = RomeToArab(number2ToString);

        result = Result(number1, number2, schetchik);
        return result;
    }

    public int OperationToArab(String operationtoString) {

            int number1, number2, result = 0, schetchik = 0;
            String number1ToString = "";
            String number2ToString = "";

            char[] numberOperationToChar = operationtoString.toCharArray();

            for (int i = 0; i < numberOperationToChar.length; i++) {

                for (int j = 0; j < operations.length; j++) {

                    if (numberOperationToChar[i] == operations[j]) {
                        schetchik = j + 1;
                        for (int k = 0; k < i; k++) {
                            for (int l = 0; l < numbersToChar.length; l++) {
                                if (numberOperationToChar[k] == numbersToChar[l]) {
                                    number1ToString += Integer.toString(numberArab[l]);
                                }
                            }
                        }
                        for (int s = (i + 1); s < operationtoString.length(); s++) {
                            for (int n = 0; n < numbersToChar.length; n++) {
                                if (numberOperationToChar[s] == numbersToChar[n]) {
                                    number2ToString += Integer.toString(numberArab[n]);
                                }
                            }
                        }
                    }
                }
            }

            number1 = Integer.parseInt(number1ToString);
            number2 = Integer.parseInt(number2ToString);

           result = Result(number1, number2, schetchik);
           return result;
    }
}
