public class Laptop {

    // поля с параметрами сущности Laptop
    private String model;
    private Double price;
    private String color;
    private String OS;
    private String processor;
    private String RAM;
    private String memory;
    private String graphicProcessor;

    // конструктор
    public Laptop(String model, Double price, String color, String OS, String processor, String RAM, String memory, String graphicProcessor) {
        this.model = model;
        this.price = price;
        this.color = color;
        this.OS = OS;
        this.processor = processor;
        this.RAM = RAM;
        this.memory = memory;
        this.graphicProcessor = graphicProcessor;
    }

    // ниже приведены 7 методов, позволяющие получить параметры экземпляра Laptop
    public Double getPrice() { // цена
        return price;
    }

    public String getColor() { // цвет
        return color;
    }

    public String getOS() { // операционная система
        return OS;
    }

    public String getProcessor() { // марка процессора
        return processor;
    }

    public String getRAM() { // объём оперативной памяти
        return RAM;
    }

    public String getMemory() { // объём хранилища
        return memory;
    }

    public String getGraphicProcessor() { // марка видеокарты или отсутствие таковой
        return graphicProcessor;
    }

    // переопределение метода toString для удобного отображения при печати
    @Override
    public String toString() {
        return "Модель " + model +
                "\nЦена " + price + "$" +
                "\nЦвет " + color +
                "\nОперационная система " + OS +
                "\nПроцессор " + processor +
                "\nОперативная память " + RAM + "GB" +
                "\nХранилище " + memory + "TB" +
                "\nВидеокарта " + graphicProcessor +
                "\n";
    }
}
