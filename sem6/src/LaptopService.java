import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Этот класс содержит коллекцию в качестве базы данных. И предоставляет методы для её копирования и последующей обработки этой копии.
 */
public class LaptopService {

    // создание экземпляров класса Laptop
    private Laptop laptop1 = new Laptop("msi10", 399.99, "Красный", "Windows", "AMD", "16", "1", "AMD");
    private Laptop laptop2 = new Laptop("Acer1", 299.99, "Серебристый", "Linux", "Intel", "8", "1", "без видеокарты");
    private Laptop laptop3 = new Laptop("AsusMega", 1999.99, "Чёрный", "Windows", "AMD", "64", "4", "nVidia");
    private Laptop laptop4 = new Laptop("Samsung11", 599.99, "Серебристый", "Windows", "AMD", "16", "2", "AMD");
    private Laptop laptop5 = new Laptop("Machenike Nova", 1999.99, "Серебристый", "Windows", "Intel", "32", "2", "nVidia");
    private Laptop laptop6 = new Laptop("Machrevo Pro", 1999.99, "Чёрный", "Windows", "AMD", "64", "4", "AMD");
    private Laptop laptop7 = new Laptop("Xiaomi Lite", 299.99, "Чёрный", "без операционной системы", "AMD", "8", "1", "без видеокарты");
    private Laptop laptop8 = new Laptop("HP 7", 499.99, "Чёрный", "Windows", "AMD", "16", "2", "без видеокарты");
    private Laptop laptop9 = new Laptop("MackBook Air", 1599.99, "Серебристый", "MacOS", "Intel", "8", "1", "без видеокарты");
    private Laptop laptop10 = new Laptop("MackBook Pro", 1999.99, "Серебристый", "MacOS", "Intel", "16", "1", "без видеокарты");
    private Laptop laptop11 = new Laptop("msi black", 699.99, "Чёрный", "Windows", "AMD", "16", "2", "nVidia");
    private Laptop laptop12 = new Laptop("Xiaomi pro", 1199.99, "Красный", "Windows", "Intel", "32", "2", "AMD");
    private Laptop laptop13 = new Laptop("Asus8", 999.99, "Серебристый", "без операционной системы", "AMD", "32", "2", "nVidia");
    private Laptop laptop14 = new Laptop("Samsung M", 499.99, "Красный", "Windows", "Intel", "16", "2", "AMD");
    private Laptop laptop15 = new Laptop("Machenike 16", 1399.99, "Чёрный", "без операционной системы", "Intel", "32", "2", "AMD");
    private Laptop laptop16 = new Laptop("Acer Lite 4", 299.99, "Серебристый", "Windows", "AMD", "8", "1", "без видеокарты");
    private Laptop laptop17 = new Laptop("AlienWare", 1999.99, "Чёрный", "Windows", "AMD", "64", "2", "AMD");
    private Laptop laptop18 = new Laptop("HP X", 999.99, "Красный", "Windows", "AMD", "16", "2", "nVidia");
    private Laptop laptop19 = new Laptop("HP Z", 1899.99, "Красный", "Linux", "Intel", "32", "4", "AMD");
    private Laptop laptop20 = new Laptop("Lenovo G", 599.99, "Чёрный", "Windows2", "AMD", "8", "2", "AMD");

    // помещение созданных выше экземпляров в коллекцию Set, для того, чтобы работать с ней как с базой данных
    private final Set<Laptop> laptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6, laptop7, laptop8, laptop9, laptop10,
laptop11, laptop12, laptop13, laptop14, laptop15, laptop16, laptop17, laptop18, laptop19, laptop20));

    /* Ниже описаны 7 методов, позволяющих перебрать коллекцию для фильтрации. Методы работают с копией оригинально коллекции.
     *  Они удаляют элементы, если те не соответствуют параметрам поиска.
     */

    /**
     * Метод сортировки по цене
     *
     * @param resultLaptops копия оригинальной коллекции предназначенная для обработки.
     * @param price1        нижняя граница цены.
     * @param price2        верхняя граница цены.
     */
    public void findByPrice(Set<Laptop> resultLaptops, double price1, double price2) {

        double pr;

        for (Laptop laptop : laptops) {
            pr = laptop.getPrice();
            if (pr < price1 || pr > price2) {
                resultLaptops.remove(laptop);
            }
        }
    }

    /**
     * Метод сортировки по цвету
     *
     * @param resultLaptops копия оригинальной коллекции предназначенная для обработки.
     * @param param         параметр для сортировки.
     */
    public void findByColor(Set<Laptop> resultLaptops, String param) {

        for (Laptop laptop : laptops) {
            if (!laptop.getColor().equals(param)) {
                resultLaptops.remove(laptop);
            }
        }
    }

    /**
     * Метод сортировки по операционной системе.
     *
     * @param resultLaptops копия оригинальной коллекции предназначенная для обработки.
     * @param param         – параметр для сортировки.
     */
    public void findByOS(Set<Laptop> resultLaptops, String param) {

        for (Laptop laptop : laptops) {
            if (!laptop.getOS().equals(param)) {
                resultLaptops.remove(laptop);
            }
        }
    }

    /**
     * Метод сортировки по процессорам.
     *
     * @param resultLaptops копия оригинальной коллекции предназначенная для обработки.
     * @param param         – параметр для сортировки.
     */
    public void findByProcessor(Set<Laptop> resultLaptops, String param) {

        for (Laptop laptop : laptops) {
            if (!laptop.getProcessor().equals(param)) {
                resultLaptops.remove(laptop);
            }
        }
    }

    /**
     * Метод сортировки по объёму оперативной памяти.
     *
     * @param resultLaptops копия оригинальной коллекции предназначенная для обработки.
     * @param param         – параметр для сортировки.
     */
    public void findByRAM(Set<Laptop> resultLaptops, String param) {

        for (Laptop laptop : laptops) {
            if (!laptop.getRAM().equals(param)) {
                resultLaptops.remove(laptop);
            }
        }
    }

    /**
     * Метод сортировки по объёму хранилища.
     *
     * @param resultLaptops копия оригинальной коллекции предназначенная для обработки.
     * @param param         – параметр для сортировки.
     */
    public void findByMemory(Set<Laptop> resultLaptops, String param) {

        for (Laptop laptop : laptops) {
            if (!laptop.getMemory().equals(param)) {
                resultLaptops.remove(laptop);
            }
        }
    }

    /**
     * Метод сортировки по видеокарте.
     *
     * @param resultLaptops копия оригинальной коллекции предназначенная для обработки.
     * @param param         – параметр для сортировки.
     */
    public void findByGraphicProcessor(Set<Laptop> resultLaptops, String param) {

        for (Laptop laptop : laptops) {
            if (!laptop.getGraphicProcessor().equals(param)) {
                resultLaptops.remove(laptop);
            }
        }
    }

    /**
     * Метод возвращает изначальную коллекцию для создания копии,
     * чтобы с ней можно было работать в методах класса LaptopService.
     */
    public Set<Laptop> getAll() {
        return laptops;
    }
}
