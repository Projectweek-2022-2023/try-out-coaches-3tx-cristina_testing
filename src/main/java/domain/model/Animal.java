package domain.model;

public class Animal {
    private int id;
    private String name;
    private String type;
    private int food;


    public Animal(String name) {
        this.setName(name);
    }

    public Animal(int id, String name, String type, int food) {
        this.setId(id);
        this.setName(name);
        this.setType(type);
        this.setFood(food);
    }

    public Animal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Geen geldige naam");
        }
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Geen geldige soort");
        }
        this.type = type;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food <= 0) {
            throw new IllegalArgumentException("Geen geldige hoeveelheid voor voedsel");
        }
        this.food = food;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", food=" + food +
                '}';
    }
}
