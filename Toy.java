public class Toy {
    private Integer id;
    private String name; // Имя
    private Integer quantity; // Количество
    private Integer dropСhance; // Шанс выпадения

    // Конструктор
    public Toy(Integer id, String name, Integer quantity, Integer dropСhance) {
        this.id = id;
        this.name = name; // Имя
        this.quantity = quantity; // Количество
        this.dropСhance = dropСhance;

    }
    

    public Toy() {
    }


    // Преобразование в строку для печати
    @Override
    public String toString() {
        return String.format("%d %s %d %d",
                id, name, quantity, dropСhance);
    }

    // Геттеры
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getDropChance() {
        return dropСhance;
    }

    // Сеттеры
    public void setDropСhance(Integer dropСhance) {
        this.dropСhance = dropСhance;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
