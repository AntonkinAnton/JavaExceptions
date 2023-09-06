import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class finalHw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные через пробел: \"Фамилия Имя Отчество ДатаРождения НомерТелефона Пол\"" +
                "\nВ формате: ФИО - строчный, дата рождения - дд.мм.гггг, номер телефона - только цифры, пол - f или m");
        String input = scanner.nextLine();
        scanner.close();

        try {
            String[] userData = input.split(" ");
            if (userData.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];
            String birthDateStr = userData[3];
            String phoneNumberStr = userData[4];
            char gender = userData[5].charAt(0);

            // Проверка формата ДатаРождения
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false); // Запрещаем "мягкий" режим парсинга даты
            Date birthDate = dateFormat.parse(birthDateStr);

            // Проверка валидности ДатаРождения (чтобы дата существовала)
            Date currentDate = new Date();
            if (birthDate.after(currentDate)) {
                throw new IllegalArgumentException("Дата рождения в будущем");
            }

            // Проверка формата номера телефона
            if (!phoneNumberStr.matches("\\d+")) {
                throw new NumberFormatException("Неверный формат номера телефона");
            }
            long phoneNumber = Long.parseLong(phoneNumberStr);

            // Проверка пола (должен быть 'm' или 'f')
            if (gender != 'm' && gender != 'f') {
                throw new IllegalArgumentException("Неверное значение для Пола");
            }

            // Создание или открытие файла для записи
            FileWriter fileWriter = new FileWriter(lastName + ".txt", true);

            // Запись данных в файл
            String userDataString = lastName + " " + firstName + " " + middleName + " "
                    + birthDateStr + " " + phoneNumber + " " + gender + "\n";
            fileWriter.write(userDataString);

            // Закрытие файла
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл.");
        } catch (ParseException e) {
            System.err.println("Неверный формат ДатаРождения.");
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода при работе с файлом.");
            e.printStackTrace();
        }
    }
}
