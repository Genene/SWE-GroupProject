package carrentalsystem.customermanagement.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    String street;
    String city;
    String state;
    String zipCode;
    String country;

}
