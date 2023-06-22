package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.entity.Offer;
import edu.miu.springsecurity1.entity.dto.OfferDto;

import java.util.List;

public interface OfferService {
    void save(OfferDto p);

    void delete(int id);

    OfferDto getById(int id);

    List<OfferDto> getAll();
}
