public class hw2task2 {
        public static void main(String[] args) {
            try {
                int[] intArray = new int[9];  //добавлено объявление массива
                int d = 0;
                double catchedRes1 = intArray[8] / d;
                System.out.println("catchedRes1 = " + catchedRes1);
            } catch (ArithmeticException e) {
                System.out.println("Catching exception: " + e); //контролируемое исключение
            }
        }
    }
