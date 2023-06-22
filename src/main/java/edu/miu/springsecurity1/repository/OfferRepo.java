package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.Message;
import edu.miu.springsecurity1.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Integer> {
    List<Offer> findAll();

    Offer findById(int id);

    void deleteById(int id);
}
