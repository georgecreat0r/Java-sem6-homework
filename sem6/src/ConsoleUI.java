import java.util.HashSet;
import java.util.Set;

/**
 * Этот класс описывает обработку ввода от пользователя и предоставление результатов работы программы
 */
public class ConsoleUI {

    private ConsoleInputOutput io = new ConsoleInputOutput();
    private LaptopService service = new LaptopService();


    public void run() {

        int param; // Переменная, в которую помещается число, введённое пользователем для выбора.
        io.prntWlcm();

        while (true) { // бесконечный цикл, обеспечивающий работу программы, пока пользователь не решит выйти
            // создание копии оригинальной коллекции, которая будет использоваться для фильтрации
            Set<Laptop> resultLaptops = new HashSet<>(service.getAll());
            io.prntMsg1();
            param = io.checkInput1();
            if (param == 1) { // если пользователь выберет просмотреть весь каталог ноутбуков
                io.print(service.getAll());
            }

            if (param == 2) { // если пользователь выберет фильтровать каталог
                io.prntMsg2();
                param = io.checkInput1();
                if (param == 1) { // если пользователь выберет фильтровать каталог только по одному параметру
                    io.prntMsg3();
                    param = io.checkInput4();

                    switch (param) {
                        case 1: // по цене
                            choosePrice(resultLaptops);

                            if (resultLaptops.isEmpty()) { // если нет результатов, соответствующих параметрам поиска
                                io.prntNtFnd();
                            } else {
                                io.print(resultLaptops);
                            }
                            break;
                        case 2: // по цвету
                            chooseColor(resultLaptops);
                            io.print(resultLaptops);
                            break;
                        case 3: // по операционной системе
                            chooseOS(resultLaptops);
                            io.print(resultLaptops);
                            break;
                        case 4: // по процессору
                            chooseProcessor(resultLaptops);
                            io.print(resultLaptops);
                            break;
                        case 5: // по объёму памяти
                            chooseRAM(resultLaptops);
                            io.print(resultLaptops);
                            break;
                        case 6: // по объёму хранилища
                            chooseMemory(resultLaptops);
                            io.print(resultLaptops);
                            break;
                        case 7: // по видеокарте
                            chooseGraphicProcessor(resultLaptops);
                            io.print(resultLaptops);
                            break;
                    }

                } else { // Если пользователь выберет фильтровать каталог сразу по нескольким параметрам.
                    // Ниже созданы логические переменные, регулирующие ограничение предоставления выбора пользователю параметров,
                    // которые он уже выбрал. А так же эти переменные регулируют печать сообщений с параметрами,
                    // которые пользователь ещё не выбрал, и заход в цикл.
                    boolean isDone = false;
                    boolean isDone1 = false;
                    boolean isDone2 = false;
                    boolean isDone3 = false;
                    boolean isDone4 = false;
                    boolean isDone5 = false;
                    boolean isDone6 = false;
                    boolean isDone7 = false;
                    boolean isDone0 = false;
                    boolean isPrinted = false;
                    io.prntMsg3();
                    param = io.checkInput4();

                    for (int i = 0; i < 7 && !isDone; i++) {

                        switch (param) {
                            case 0: // Печать результатов по решению пользователя.
                                // Логические переменные ограничат ненужную печать и завершат цикл.
                                io.print(resultLaptops);
                                isDone = true;
                                isDone1 = true;
                                isDone2 = true;
                                isDone3 = true;
                                isDone4 = true;
                                isDone5 = true;
                                isDone6 = true;
                                isDone7 = true;
                                isDone0 = true;
                                isPrinted = true;
                                break;
                            case 1: // выбор по цене
                                // Проверка, выбирал ли пользователь этот случай.
                                // Если нет, то программа выполнит фильтрацию.
                                // Если да - сообщит от этом пользователю.
                                // Все случаи ниже аналогичны этому.
                                if (!isDone1) {
                                    choosePrice(resultLaptops);
                                    isDone1 = true;
                                } else {
                                    i--;
                                    io.prntDn();
                                }
                                break;
                            case 2: // по цвету
                                if (!isDone2) {
                                    chooseColor(resultLaptops);
                                    isDone2 = true;
                                } else {
                                    i--;
                                    io.prntDn();
                                }
                                break;
                            case 3: // по операционной системе
                                if (!isDone3) {
                                    chooseOS(resultLaptops);
                                    isDone3 = true;
                                } else {
                                    i--;
                                    io.prntDn();
                                }
                                break;
                            case 4: // по процессору
                                if (!isDone4) {
                                    chooseProcessor(resultLaptops);
                                    isDone4 = true;
                                } else {
                                    i--;
                                    io.prntDn();
                                }
                                break;
                            case 5: // оп объёму оперативной памяти
                                if (!isDone5) {
                                    chooseRAM(resultLaptops);
                                    isDone5 = true;
                                } else {
                                    i--;
                                    io.prntDn();
                                }
                                break;
                            case 6: // по объёму хранилища
                                if (!isDone6) {
                                    chooseMemory(resultLaptops);
                                    isDone6 = true;
                                } else {
                                    i--;
                                    io.prntDn();
                                }
                                break;
                            case 7: // по видеокарте
                                if (!isDone7) {
                                    chooseGraphicProcessor(resultLaptops);
                                    isDone7 = true;
                                } else {
                                    i--;
                                    io.prntDn();
                                }
                                break;
                        }

                        // Если после фильтрации каталог пустой, то выведется сообщение об этом.
                        // А так же завершится цикл.
                        if (resultLaptops.isEmpty()) {
                            io.prntNtFnd();
                            isDone = true;
                            isDone1 = true;
                            isDone2 = true;
                            isDone3 = true;
                            isDone4 = true;
                            isDone5 = true;
                            isDone6 = true;
                            isDone7 = true;
                            isDone0 = true;
                            isPrinted = true;
                        }

                        if (i == 6) { // Если итераций было 7, то печать сообщений ниже не произойдет.
                            isDone = true;
                            isDone0 = true;
                        }

                        // Конструктор печати сообщений.
                        // Если пользователь уже выбирал какой-либо параметр, то программа не будет предлагать выбрать его вновь.
                        if (!isDone) {
                            io.prntEntrNmbr();
                        }
                        if (!isDone1) {
                            io.prntChsPrc();
                        }
                        if (!isDone2) {
                            io.prntChsClr();
                        }
                        if (!isDone3) {
                            io.prntChsOS();
                        }
                        if (!isDone4) {
                            io.prntChsPrcssr();
                        }
                        if (!isDone5) {
                            io.prntChsRAM();
                        }
                        if (!isDone6) {
                            io.prntChsMmry();
                        }
                        if (!isDone7) {
                            io.prntChsGrphc();
                        }
                        if (!isDone0) {
                            io.prntRsltOrExt();
                        }
                        if (!isDone) {
                            param = io.checkInput5();
                        }
                    }

                    // Если пользователь не выбирал случай 0, то программа распечатает каталог, если он не пустой, после цикла.
                    if (!isPrinted) {
                        io.print(resultLaptops);
                    }
                }
            }
            io.prntMsg4();
        }
    }

    /**
     * Метод принимает копию оригинальной коллекции и обеспечивает логику её фильтрации по цене.
     * @param resultLaptops копия оригинальной коллекции.
     */
    private void choosePrice(Set<Laptop> resultLaptops) {
        double price1;
        double price2;

        System.out.println("В нашем ассортименте есть модели ценой от 200$ до 2000$.");
        System.out.print("Укажите нижнюю границу цены: ");
        price1 = io.checkInputPrice();
        System.out.print("Укажите верхнюю границу цены: ");
        price2 = io.checkInputPrice();

        while (price1 >= price2) {
            System.out.println("Нижняя граница должна быть меньше верхней.");
            System.out.print("Укажите нижнюю границу цены: ");
            price1 = io.checkInputPrice();
            System.out.print("Укажите верхнюю границу цены: ");
            price2 = io.checkInputPrice();
        }
        System.out.println();

        service.findByPrice(resultLaptops, price1, price2);
    }

    /**
     * Метод принимает копию оригинальной коллекции и обеспечивает логику её фильтрации по цвету.
     * @param resultLaptops копия оригинальной коллекции.
     */
    private void chooseColor(Set<Laptop> resultLaptops) {

        System.out.println("В нашем ассортименте представлены модели несколько цветов.\n" +
                "Введите число соответствующее интересующему Вас цвету.\n" +
                "1 - красный\n" +
                "2 - чёрный\n" +
                "3 - серебристый");

        int param = io.checkInput2();

        switch (param) {
            case 1:
                service.findByColor(resultLaptops, "Красный");
                break;
            case 2:
                service.findByColor(resultLaptops, "Чёрный");
                break;
            case 3:
                service.findByColor(resultLaptops, "Серебристый");
                break;
        }
    }

    /**
     * Метод принимает копию оригинальной коллекции и обеспечивает логику её фильтрации по операционной системе.
     * @param resultLaptops копия оригинальной коллекции.
     */
    private void chooseOS(Set<Laptop> resultLaptops) {

        System.out.println("В нашем ассортименте представлены модели с различными операционными системами.\n" +
                "Введите число соответствующее интересующей Вас ОС.\n" +
                "1 - Windows\n" +
                "2 - Linux\n" +
                "3 - MacOS\n" +
                "4 - без операционной системы");

        int param = io.checkInput3();

        switch (param) {
            case 1:
                service.findByOS(resultLaptops, "Windows");
                break;
            case 2:
                service.findByOS(resultLaptops, "Linux");
                break;
            case 3:
                service.findByOS(resultLaptops, "MacOS");
                break;
            case 4:
                service.findByOS(resultLaptops, "без операционной системы");
                break;
        }
    }

    /**
     * Метод принимает копию оригинальной коллекции и обеспечивает логику её фильтрации по процессору.
     * @param resultLaptops копия оригинальной коллекции.
     */
    private void chooseProcessor(Set<Laptop> resultLaptops) {

        System.out.println("В нашем ассортименте представлены модели с разными процессорами.\n" +
                "Введите число соответствующее интересующему Вас процессору.\n" +
                "1 - Intel\n" +
                "2 - AMD");

        int param = io.checkInput1();

        switch (param) {
            case 1:
                service.findByProcessor(resultLaptops, "Intel");
                break;
            case 2:
                service.findByProcessor(resultLaptops, "AMD");
                break;
        }
    }

    /**
     * Метод принимает копию оригинальной коллекции и обеспечивает логику её фильтрации по объёму оперативной памяти.
     * @param resultLaptops копия оригинальной коллекции.
     */
    private void chooseRAM(Set<Laptop> resultLaptops) {

        System.out.println("В нашем ассортименте представлены модели с разным объёмом памяти.\n" +
                "Введите число соответствующее интересующему Вас объёму памяти.\n" +
                "1 - 8GB\n" +
                "2 - 16GB\n" +
                "3 - 32GB\n" +
                "4 - 64GB");

        int param = io.checkInput3();

        switch (param) {
            case 1:
                service.findByRAM(resultLaptops, "8");
                break;
            case 2:
                service.findByRAM(resultLaptops, "16");
                break;
            case 3:
                service.findByRAM(resultLaptops, "32");
                break;
            case 4:
                service.findByRAM(resultLaptops, "64");
                break;
        }
    }

    /**
     * Метод принимает копию оригинальной коллекции и обеспечивает логику её фильтрации по объёму хранилища.
     * @param resultLaptops копия оригинальной коллекции.
     */
    private void chooseMemory(Set<Laptop> resultLaptops) {

        System.out.println("В нашем ассортименте представлены модели с разным объёмом хранилища.\n" +
                "Введите число соответствующее интересующему Вас объёму хранилища.\n" +
                "1 - 1TB\n" +
                "2 - 2TB\n" +
                "3 - 4TB");

        int param = io.checkInput2();

        switch (param) {
            case 1:
                service.findByMemory(resultLaptops, "1");
                break;
            case 2:
                service.findByMemory(resultLaptops, "2");
                break;
            case 3:
                service.findByMemory(resultLaptops, "4");
        }
    }

    /**
     * Метод принимает копию оригинальной коллекции и обеспечивает логику её фильтрации по видеокарте.
     * @param resultLaptops копия оригинальной коллекции.
     */
    private void chooseGraphicProcessor(Set<Laptop> resultLaptops) {

        System.out.println("В нашем ассортименте представлены модели с разными графическими процессорами.\n" +
                "Введите число соответствующее интересующему Вас процессору.\n" +
                "1 - nVidia\n" +
                "2 - AMD\n" +
                "3 - без видеокарты");

        int param = io.checkInput2();

        switch (param) {
            case 1:
                service.findByGraphicProcessor(resultLaptops, "nVidia");
                break;
            case 2:
                service.findByGraphicProcessor(resultLaptops, "AMD");
                break;
            case 3:
                service.findByGraphicProcessor(resultLaptops, "без видеокарты");
        }
    }
}