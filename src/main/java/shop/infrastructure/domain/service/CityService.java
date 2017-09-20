package shop.infrastructure.domain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.model.City;
import shop.infrastructure.domain.repository.CityRepository;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
