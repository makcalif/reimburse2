package com.reimburse2.remiburse2.service;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PopulationService {

    public Optional<Long> getPopulation(String cityName);

}
