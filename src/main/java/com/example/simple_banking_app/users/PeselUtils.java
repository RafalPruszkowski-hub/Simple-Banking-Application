package com.example.simple_banking_app.users;

import java.time.LocalDate;

class PeselUtils {
    private PeselUtils(){}
    static LocalDate getBirthDate(String pesel) {
        int[] peselArray = convertToIntArray(pesel);
        var day = getBirthDay(peselArray);
        var month = getBirthMonth(peselArray);
        var year = getBirthYear(peselArray);
        return LocalDate.of(year, month, day);
    }

    private static int[] convertToIntArray(String pesel) {
        String[] string = pesel.split("");
        int[] arr = new int[string.length];

        for (int i = 0; i < string.length; i++) {
            arr[i] = Integer.parseInt(string[i]);
        }
        return arr;
    }

    private static int getBirthYear(int[] pesel) {
        int year;
        int month;
        year = 10 * pesel[0];
        year += pesel[1];
        month = 10 * pesel[2];
        month += pesel[3];
        if (month > 80 && month < 93) {
            year += 1800;
        } else if (month > 0 && month < 13) {
            year += 1900;
        } else if (month > 20 && month < 33) {
            year += 2000;
        } else if (month > 40 && month < 53) {
            year += 2100;
        } else if (month > 60 && month < 73) {
            year += 2200;
        }
        return year;
    }

    private static int getBirthMonth(int[] pesel) {
        int month;
        month = 10 * pesel[2];
        month += pesel[3];
        if (month > 80 && month < 93) {
            month -= 80;
        } else if (month > 20 && month < 33) {
            month -= 20;
        } else if (month > 40 && month < 53) {
            month -= 40;
        } else if (month > 60 && month < 73) {
            month -= 60;
        }
        return month;
    }


    private static int getBirthDay(int[] pesel) {
        int day;
        day = 10 * pesel[4];
        day += pesel[5];
        return day;
    }
}
