package com.reimburse2.remiburse2.service;

import com.reimburse2.remiburse2.repository.City;
import com.reimburse2.remiburse2.repository.CityRepository;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest extends TestCase {

    public static final String KARACHI = "KARACHI";
    public static final Long POPULATION = 500000L;

    @Mock
    CityRepository cityRepository;

    @Mock
    PopulationService populationService;

    CityService cityService;

    @Before
    public void setUp() throws Exception {
        cityService = new CityService(populationService, cityRepository);
    }

    @Test
    public void should_enrich_and_save_city() {
        City expectedCity = new City(KARACHI, 50000L);
        City city = new City(KARACHI, 50000L);

        City savedCity = cityService.enrichAndCreateCity(city);

        Assertions.assertThat(savedCity.equals(expectedCity));
    }

    @Test(expected=IllegalArgumentException.class)
    public void should_throw_illegal_arg_exeception_when_id_present() {
        City expectedCity = new City(KARACHI, 50000L);
        City city = new City(KARACHI, 50000L);
        city.setId(2L);
        City savedCity = cityService.enrichAndCreateCity(city);

    }

    @Test
    public void should_call_service_getPopulation_once() {
        City expectedCity = new City(KARACHI, 50000L);
        City city = new City(KARACHI, 50000L);
         City savedCity = cityService.enrichAndCreateCity(city);

        Mockito.verify(populationService, Mockito.times(1)).getPopulation(KARACHI);

        Assertions.assertThat(savedCity.equals(expectedCity));
    }
}