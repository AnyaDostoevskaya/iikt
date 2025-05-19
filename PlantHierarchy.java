// Уровень 1: Суперкласс
abstract class Plant {
    String name;
    String stemType;

    public Plant(String name, String stemType) {
        this.name = name;
        this.stemType = stemType;
    }

    public void describe() {
        System.out.println(name + " имеет " + stemType + " стебель.");
    }

    abstract void growthSpeed();
}

// Уровень 2: Подкласс цветковых растений
abstract class FloweringPlant extends Plant {
    int petals;
    boolean hasFragrance;

    public FloweringPlant(String name, String stemType, int petals, boolean hasFragrance) {
        super(name, stemType);
        this.petals = petals;
        this.hasFragrance = hasFragrance;
    }

    public void floralInfo() {
        System.out.println(name + " имеет " + petals + " лепестков.");
        if (hasFragrance) {
            System.out.println("Обладает приятным ароматом.");
        } else {
            System.out.println("Не имеет запаха.");
        }
    }
}

// Уровень 3: Конкретные растения
class Rose extends FloweringPlant {
    public Rose(String type) {
        super(type.equals("голландская") ? "Голландская роза" : "Российская роза",
              "колючий", 
              32, 
              true);
    }

    @Override
    void growthSpeed() {
        System.out.println(name + " растёт медленно: около 2-3 лет до полного цветения.");
    }
}

class Sunflower extends FloweringPlant {
    public Sunflower() {
        super("Подсолнух", "прямой", 20, false);
    }

    @Override
    void growthSpeed() {
        System.out.println("Подсолнух растёт быстро: около 3 месяцев до полного роста.");
    }
}

// Главный класс
public class PlantHierarchy {
    public static void main(String[] args) {
        Rose dutchRose = new Rose("голландская");
        Rose russianRose = new Rose("российская");
        Sunflower sunflower = new Sunflower();

        System.out.println("--- Информация о растениях ---\n");

        dutchRose.describe();
        dutchRose.floralInfo();
        dutchRose.growthSpeed();

        System.out.println();

        russianRose.describe();
        russianRose.floralInfo();
        russianRose.growthSpeed();

        System.out.println();

        sunflower.describe();
        sunflower.floralInfo();
        sunflower.growthSpeed();
    }
}