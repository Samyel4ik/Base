
public class Sweetness {
    String name;
    int calories;
    int prise;

    public Sweetness(String name, int calories, int prise) {
        this.name = name;
        this.calories = calories;
        this.prise = prise;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getPrise() {
        return prise;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }

    @Override
    public String toString() {
        return "Sweetness{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", prise=" + prise +
                '}';
    }
}
