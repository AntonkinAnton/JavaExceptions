 import java.util.Scanner;

    public class hw2task1 {
        public static void main(String[] args) {
            float userInput = getFloatInput();
            System.out.println("Вы ввели: " + userInput);
        }

        public static float getFloatInput() {
            Scanner scanner = new Scanner(System.in);
            float input = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Введите дробное число: ");
                try {
                    input = scanner.nextFloat();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите дробное число (разделитель - запятая)");
                    scanner.next();
                }
            }

            return input;
        }
    }


