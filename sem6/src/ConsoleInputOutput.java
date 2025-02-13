import java.util.Scanner;
import java.util.Set;

/**
 * Этот класс предоставляет методы для печати сообщений в консоль и обработки ввода от пользователя.
 */
public class ConsoleInputOutput {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Метод для проверки ввода на соответствие ожидаемым числам.
     * Если ожидаемого ввода нет, то запрашивается ввод повторно.
     * Может вернуть целые числа от 1 до 2.
     */
    public int checkInput1() {
        int res = readInt(); // вызов метода для считывания с консоли

        while (res != 1 && res != 2) {
            System.out.println("Введите число из указанных выше.");
            res = readInt();
        }

        return res;
    }

    /**
     * Метод для проверки ввода на соответствие ожидаемым числам.
     * Если ожидаемого ввода нет, то запрашивается ввод повторно.
     * Может вернуть целые числа от 1 до 3.
     */
    public int checkInput2() {
        int res = readInt();

        while (res < 1 || res > 3) {
            System.out.println("Введите число из указанных выше.");
            res = readInt();
        }

        return res;
    }

    /**
     * Метод для проверки ввода на соответствие ожидаемым числам.
     * Если ожидаемого ввода нет, то запрашивается ввод повторно.
     * Может вернуть целые числа от 1 до 4.
     */
    public int checkInput3() {
        int res = readInt();

        while (res < 1 || res > 4) {
            System.out.println("Введите число из указанных выше.");
            res = readInt();
        }

        return res;
    }

    /**
     * Метод для проверки ввода на соответствие ожидаемым числам.
     * Если ожидаемого ввода нет, то запрашивается ввод повторно.
     * Может вернуть целые числа от 1 до 7.
     */
    public int checkInput4() {
        int res = readInt();

        while (res < 1 || res > 7) {
            System.out.println("Введите число из указанных выше.");
            res = readInt();
        }

        return res;
    }

    /**
     * Метод для проверки ввода на соответствие ожидаемым числам.
     * Если ожидаемого ввода нет, то запрашивается ввод повторно.
     * Может вернуть целые числа от 0 до 7.
     */
    public int checkInput5() {
        int res = readInt();

        while (res < 0 || res > 7) {
            System.out.println("Введите число из указанных выше.");
            res = readInt();
        }

        return res;
    }

    /**
     * Самый часто-используемый метод. Предназначен для считывания числа с консоли и обработки неправильного ввода.
     * Обеспечивает выход из программы при вводе q. Перед завершением программы закрывает сканер.
     */
    private int readInt() {
        String input; // для считывания с консоли строки, чтобы проверить, является ли q (для возможности выхода)
        int number; // для преобразования строки в число

        while (true) { // цикл длится пока нет ввода целого числа или q
            System.out.print("\nВведите число: ");
            input = scanner.nextLine();
            System.out.println();

            if (input.equalsIgnoreCase("q")) { // проверка является ли строка q для возможного выхода
                scanner.close();
                System.out.println("\nЖдём Вас снова.");
                System.exit(0); // выход из программы
            }

            try {
                number = Integer.parseInt(input); // попытка преобразование строки в число
                return number;
            } catch (NumberFormatException e) { // обработка неправильного ввода
                System.out.println("Неправильный ввод. Пожалуйста введите целое число. Если желайте выйти - нажмите q.");
            }
        }
    }

    /**
     * Метод для проверки ввода на соответствие ожидаемым значениям вещественных чисел типа double.
     * Если ожидаемого ввода нет, то запрашивается ввод повторно.
     * Может вернуть числа типа double от 200 до 2000.
     */
    public double checkInputPrice() {
        double res = readDouble(); // вызов метода для чтения с консоли

        while (res < 200 || res > 2000) {
            System.out.println("Введите в диапазоне от 200 до 2000.");
            res = readDouble();
        }

        return res;
    }

    /**
     * Предназначен для считывания числа типа double с консоли и обработки неправильного ввода.
     * Обеспечивает выход из программы при вводе q. Перед завершением программы закрывает сканер.
     */
    private double readDouble() {
        String input; // для считывания с консоли строки, чтобы проверить, является ли q (для возможности выхода)
        double number; // для преобразования строки в число

        while (true) { // цикл длится пока нет ввода числа или q
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) { // проверка является ли строка q для возможного выхода
                scanner.close();
                System.out.println("Ждём Вас снова.");
                System.exit(0); // выход из программы
            }

            try {
                number = Double.parseDouble(input); // попытка преобразование строки в число
                return number;
            } catch (NumberFormatException e) { // обработка неправильного ввода
                System.out.println("Неправильный ввод. Пожалуйста введите цену. Если желайте выйти - нажмите q.");
            }
        }
    }

    /**
     * Метод принимает и печатает коллекцию типа Set< Laptop>.
     */
    public void print(Set<Laptop> laptops) {
        System.out.println();
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
    }

    /**
     * Печать приветственного сообщения.
     */
    public void prntWlcm() {
        System.out.println("Вас приветствует консольная программа для вывода моделей ноутбуков.\n" +
                "Вам будет представлен модельный ряд ноутбуков.");
    }

    /**
     * Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntMsg1() {
        System.out.println("Нажмите 1, чтобы просмотреть весь каталог, либо 2,\n" +
                "чтобы выбрать ноутбуки по интересующим вас параметрам.\n" +
                "Чтобы выйти - нажмите q");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntMsg2() {
        System.out.println("Вы можете отфильтровать ноутбуки по одному параметру - для этого нажмите 1, " +
                "либо же по нескольким - нажмите 2");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntMsg3() {
        System.out.println("Введите число соответсвующее интересующему Вас параметру.\n" +
                "1 - цена\n" +
                "2 - цвет\n" +
                "3 - операционная система\n" +
                "4 - процессор\n" +
                "5 - оперативная память\n" +
                "6 - объём хранилища\n" +
                "7 - графический процессор");
    }

    /**
     *  Печать сообщения перед повторным использованием программы поиска.
     */
    public void prntMsg4() {
        System.out.println("Если желаете выбрать повторно.");
    }

    /**
     *  Печать сообщения, что модель не найдена.
     */
    public void prntNtFnd() {
        System.out.println("К сожалению у нас нет подходящей модели.");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntEntrNmbr() {
        System.out.println("Введите число соответсвующее интересующему Вас параметру.");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntChsPrc() {
        System.out.println("1 - цена");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntChsClr() {
        System.out.println("2 - цвет");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntChsOS() {
        System.out.println("3 - операционная система");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntChsPrcssr() {
        System.out.println("4 - процессор");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntChsRAM() {
        System.out.println("5 - оперативная память");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntChsMmry() {
        System.out.println("6 - объём хранилища");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntChsGrphc() {
        System.out.println("7 - графический процессор");
    }

    /**
     *  Печать сообщения, предлагающего выбор пользователю.
     */
    public void prntRsltOrExt() {
        System.out.println("0 - показать результаты\n" +
                "q - выйти");
    }

    /**
     *  Печать сообщения о том, что данный параметр уже выбран.
     */
    public void prntDn() {
        System.out.println("Вы уже выбрали этот параметр.\n");
    }
}
