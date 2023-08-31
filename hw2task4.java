import java.util.Scanner;

    public class hw2task4 {
        public static void main(String[] args) {
            try {
                String userInput = getStringInput();
                System.out.println("Ваш ввод: " + userInput);
            } catch (EmptyInputException e) {
                System.out.println(e.getMessage());
            }
        }

        public static String getStringInput() throws EmptyInputException {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите строку: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                throw new EmptyInputException("Пустые строки вводить нельзя");
            }

            return input;
        }
    }

    class EmptyInputException extends Exception {
        public EmptyInputException(String message) {
            super(message);
        }
    }
