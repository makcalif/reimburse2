package com.reimburse2.remiburse2.repository;

public class City {

    Long Id;
    String name;
    Long population;

    public City() {
    }

    public City( String name, Long population) {
        this.name = name;
        this.population = population;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }


    public Long getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        return !(population != null ? !population.equals(city.population) : city.population != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (population != null ? population.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
