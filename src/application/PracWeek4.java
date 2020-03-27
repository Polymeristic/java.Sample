package application;

public class PracWeek4 {
    public static void main(String[] args) {

    }
}


class Species {
    private String name;
    private int population;
    private double growth;

    public Species(String name, int population, double growth) {
        this.name = name;
        this.population = population;
        this.growth = growth;
    }

    public boolean isEndangered() {
        return growth < 0;
    }

    public boolean validatePopulation(int population) {
        return population >= 0;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public int getPopulation() {
        return population;
    }

    public boolean setPopulation(int population) {
        if (!validatePopulation(population)) {
            return true;
        } else {
            this.population = population;
            return false;
        }
    }

    public double getGrowth() {
        return growth;
    }

    public boolean setGrowth(double growth) {
        this.growth = growth;
        return true;
    }
}
