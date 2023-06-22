package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.Message;
import edu.miu.springsecurity1.entity.Offer;
import edu.miu.springsecurity1.entity.Saved;
import edu.miu.springsecurity1.entity.dto.OfferDto;
import edu.miu.springsecurity1.entity.dto.SavedDto;
import edu.miu.springsecurity1.repository.MessageRepo;
import edu.miu.springsecurity1.repository.OfferRepo;
import edu.miu.springsecurity1.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepo offerRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public void save(OfferDto p) {
        offerRepo.save( modelMapper.map(p, Offer.class));
    }

    @Override
    public void delete(int id) {
        offerRepo.deleteById(id);
    }

    @Override
    public OfferDto getById(int id) {
        return modelMapper.map(offerRepo.findById(id), OfferDto.class);
    }
    public List<OfferDto> getAll() {
        var offers = offerRepo.findAll();
        return
                offers
                        .stream()
                        .map( p -> modelMapper.map(p,OfferDto.class))
                        .collect(Collectors.toList());
    }
}