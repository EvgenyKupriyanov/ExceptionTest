import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DataException, NumberMonthException, NumberDayException {

//        System.out.println("Введите данные " +
//                "(Фамилия Имя Отчество дата _ рождения(числами) " +
//                "номер _ телефона(без пробелов и тире) " +
//                "пол(f или m):");
//        Scanner scanner = new Scanner(System.in);
//        String inputData = scanner.nextLine().toUpperCase();

        String[] data = inputData().split(" ");
        controlLength(data);
        controlPersonData(data[0], data[1], data[2]);
        controlDate(data[3]);
        controlNumber(data[4]);
        controlGender(data[5]);
        makeString(data);



        String file = data[0] + ".txt";

        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(file, true));
            fw.write(makeString(data));
            fw.newLine();
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println("Проблема с записью файла " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static String inputData() {
        System.out.println("Введите данные " +
                "(Фамилия Имя Отчество дата_рождения(числами) " +
                "номер _ телефона(без пробелов и тире) " +
                "пол(f или m):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }

    public static void controlLength(String[] data) throws DataException {
        if (data.length != 6) {
            throw new DataException(String.format("Ввели неверно данные - %s", Arrays.toString(data)));
        }
    }

    public static void controlDate(String info) throws NumberDayException, NumberMonthException {
        String[] date = info.split("\\.");


        try {
            Integer.parseInt(date[0]);
        } catch (NumberFormatException e) {
            System.out.println("Число ввели не верно");
        }
        if (Integer.parseInt(date[0]) > 31) {
            throw new NumberDayException(Integer.parseInt(date[0]));
        }
        try {
            Integer.parseInt(date[1]);
        } catch (NumberFormatException e) {
            System.out.println("Месяц ввели не верно");
        }
        if (Integer.parseInt(date[1]) > 12) {
            throw new NumberMonthException(Integer.parseInt(date[1]));
        }

        try {
            Integer.parseInt(date[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Год ввели не верно");
        }
    }

    public static void controlNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Телефон ввели не верно");
        }
    }

    public static void controlGender(String data) throws DataException {
        if (!data.equals("M")) {
            if (!data.equals("F")) {
                throw new DataException("Ввели неверно пол");
            }
        }
    }
    public static String makeString(String[] data) {
        String nameInBook = "<" + data[0] + ">" + "<" + data[1] + ">" + "<" + data[2] + ">" + "<" + data[3] + ">" + "<" + data[4] + ">" + "<" + data[5] + ">";
        System.out.println(nameInBook);
        return nameInBook;
    }

    public static void controlPersonData(String surname, String name, String lastname) throws DataException{
        String[] surnameForm = surname.split("");
        String[] nameForm = name.split("");
        String[] lastnameForm = lastname.split("");
        for (String s : surnameForm) {
            if (s.equals("1") || s.equals("2")
                    || s.equals("3") || s.equals("4")
                    || s.equals("5") || s.equals("6")
                    || s.equals("7") || s.equals("8")
                    || s.equals("9")) {
                throw new DataException(String.format("Ввели неверно фамилию - %s", surname));
            }
        }
        for (String s : nameForm) {
            if (s.equals("1") || s.equals("2")
                    || s.equals("3") || s.equals("4")
                    || s.equals("5") || s.equals("6")
                    || s.equals("7") || s.equals("8")
                    || s.equals("9")) {
                throw new DataException(String.format("Ввели неверно имя - %s", name));
            }
        }
        for (String s : lastnameForm) {
            if (s.equals("1") || s.equals("2")
                    || s.equals("3") || s.equals("4")
                    || s.equals("5") || s.equals("6")
                    || s.equals("7") || s.equals("8")
                    || s.equals("9")) {
                throw new DataException(String.format("Ввели неверно отчество - %s", lastname));
            }
        }
    }
}