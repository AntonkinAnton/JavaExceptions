public class hw2task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(223, 23);
            int[] abc = { 1, 2 };
            abc[3] = 9; //контролируемое исключение
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так..."); //хотя нет возможности получить это исключение изменением чисел
        }
    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }
}
