package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.model.City;
import shop.infrastructure.domain.repository.CityRepository;

import java.util.List;

/**
 * Created by Witold on 2017-05-30.
 */
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
