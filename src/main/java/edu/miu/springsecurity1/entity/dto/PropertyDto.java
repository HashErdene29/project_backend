package edu.miu.springsecurity1.entity.dto;

import edu.miu.springsecurity1.entity.Message;
import edu.miu.springsecurity1.entity.Offer;
import edu.miu.springsecurity1.entity.User;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    private int id;
    private String name;
    private int bedNo;
    private int bathNo;
    private float sqft;
    private int garageNo;
    private AddressDto address;
    private UserDto owner;
//    private List<OfferDto> offers;
//    private List<MessageDto> messages;
}
