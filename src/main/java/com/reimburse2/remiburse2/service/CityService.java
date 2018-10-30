package com.reimburse2.remiburse2.service;

import com.reimburse2.remiburse2.repository.City;
import com.reimburse2.remiburse2.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private PopulationService populationService;
    private CityRepository cityRepository;

    public CityService(PopulationService populationService, CityRepository cityRepository) {
        this.populationService = populationService;
        this.cityRepository = cityRepository;
    }

    public City enrichAndCreateCity(City city) {

        if(city.getId() != null) {
            throw new IllegalArgumentException("City can't be created with an existing ID");
        }

        Optional<Long> population = populationService.getPopulation(city.getName());

        City enrichedCity = new City(city.getName(), population.orElse(null));

        return enrichedCity;
    }

    public List<City> getAllValidCities() {
        return null;
    }

}
