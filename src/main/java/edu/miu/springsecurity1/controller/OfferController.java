package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.entity.Offer;
import edu.miu.springsecurity1.entity.dto.OfferDto;
import edu.miu.springsecurity1.service.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    @PostMapping
    public void save(@RequestBody OfferDto o) {
        offerService.save(o);
    }

    @GetMapping
    public List<OfferDto> getAll() {
        return offerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> getById(@PathVariable int id) {
        var offer = offerService.getById(id);
        return ResponseEntity.ok(offer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        offerService.delete(id);
    }

}
