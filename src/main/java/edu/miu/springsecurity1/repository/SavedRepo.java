package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.Offer;
import edu.miu.springsecurity1.entity.Saved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedRepo extends JpaRepository<Saved, Integer> {
    List<Saved> findAll();

    Saved findById(int id);

    void deleteById(int id);
}
