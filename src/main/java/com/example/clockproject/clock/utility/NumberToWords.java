package com.example.clockproject.clock.utility;

public class NumberToWords {
    private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String convertNumberToWords(int number) {
        if (number < 0 || number > 59) {
            throw new IllegalArgumentException("Invalid number provided.");
        }

        if (number < 10) {
            return units[number];
        } else if (number < 20) {
            return teens[number - 10];
        } else {
            int tensDigit = number / 10;
            int unitsDigit = number % 10;

            StringBuilder sb = new StringBuilder();
            sb.append(tens[tensDigit]);
            if (unitsDigit > 0) {
                sb.append(" ");
                sb.append(units[unitsDigit]);
            }

            return sb.toString();
        }
    }
}
