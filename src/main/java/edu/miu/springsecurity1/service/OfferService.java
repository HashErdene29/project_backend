package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.entity.Offer;
import edu.miu.springsecurity1.entity.dto.OfferDto;

import java.util.List;

public interface OfferService {
    void save(OfferDto p);

    void delete(int id);

    OfferDto getById(int id);

    List<OfferDto> getAll();

    OfferDto completeOffer(int id);

    OfferDto getByCustomerIdandPropertyId(int customerid, int propertyId);

    List<OfferDto> getOffersByCustomerId(int customerId);
    List<OfferDto> getOffersByPropertyId(int propertyId);

    OfferDto updateOffertoCont(int id);

    OfferDto cancelOfferByOwner(int id);

}
