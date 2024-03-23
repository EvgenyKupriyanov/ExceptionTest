import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Введите данные " +
//                "(Фамилия Имя Отчество дата _ рождения(числами) " +
//                "номер _ телефона(без пробелов и тире) " +
//                "пол(f или m):");
//        Scanner scanner = new Scanner(System.in);
//        String inputData = scanner.nextLine().toUpperCase();

        String[] data = inputData().split(" ");
        contolLength(data);
        contolDate(data[3]);
        contolNumber(data[4]);
        contolGender(data[5]);
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
            //throw new RuntimeException();
        }
    }

    public static String inputData() {
        System.out.println("Введите данные " +
                "(Фамилия Имя Отчество дата _ рождения(числами) " +
                "номер _ телефона(без пробелов и тире) " +
                "пол(f или m):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }

    public static void contolLength(String[] data) {
        if (data.length != 6) {
            System.out.println("Ввели неверно данные");
        }
    }

    public static void contolDate(String info) {
        String[] date = info.split("\\.");


        try {
            int day = Integer.parseInt(date[0]);
            if (day > 31) {
                System.out.println("Число ввели не верно");
            }
        } catch (NumberFormatException e) {
            System.out.println("Число ввели не верно");
        }
        try {
            int month = Integer.parseInt(date[1]);
            if (month > 12) {
                System.out.println("Месяц ввели не верно");
            }
        } catch (NumberFormatException e) {
            System.out.println("Месяц ввели не верно");
        }
        try {
            int year = Integer.parseInt(date[2]);
        } catch (NumberFormatException e) {
            System.out.println("Год ввели не верно");
        }
    }

    public static void contolNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("Телефон ввели не верно");
        }
    }

    public static void contolGender(String data) {
        if (!data.equals("M")) {
            if (!data.equals("F")) {
                System.out.println("Ввели неверно пол");
            }
        }
    }
    public static String makeString(String[] data) {
        String nameInBook = "<" + data[0] + ">" + "<" + data[1] + ">" + "<" + data[2] + ">" + "<" + data[3] + ">" + "<" + data[4] + ">" + "<" + data[5] + ">";
        System.out.println(nameInBook);

        return nameInBook;
    }
}