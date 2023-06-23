package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.Message;
import edu.miu.springsecurity1.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Integer> {
    List<Offer> findAll();

    Offer findById(int id);

    void deleteById(int id);

    Offer findByCustomer_IdAndAndProperty_Id(int customerId, int propertyId);

    List<Offer> findByCustomer_Id(int customerId);

    @Modifying
    @Query("UPDATE Offer o SET o.status = edu.miu.springsecurity1.entity.OfferStatus.SOLD WHERE o.id = :id and o.status = edu.miu.springsecurity1.entity.OfferStatus.CONTINGENT")
    void updateStatusByID(int id);

    @Modifying
    @Query("UPDATE Offer o SET o.status = edu.miu.springsecurity1.entity.OfferStatus.CONTINGENT WHERE o.id = :id and o.status = edu.miu.springsecurity1.entity.OfferStatus.PENDING")
    void updateStatusToContingent(int id);

    @Modifying
    @Query("UPDATE Offer o SET o.status = edu.miu.springsecurity1.entity.OfferStatus.AVAILABLE WHERE o.id = :id and o.status = edu.miu.springsecurity1.entity.OfferStatus.CONTINGENT")
    void cancelContingent(int id);
}
