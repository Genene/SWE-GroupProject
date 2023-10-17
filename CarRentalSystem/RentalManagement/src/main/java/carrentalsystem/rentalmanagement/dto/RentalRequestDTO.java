package carrentalsystem.rentalmanagement.dto;

import carrentalsystem.rentalmanagement.model.enums.PaymentStatus;
import carrentalsystem.rentalmanagement.model.enums.PaymentType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class RentalRequestDTO {
    private long reservation_id;
    private PaymentType paymentType;
    private String paymentDescription;
    private String paymentCurrency;
}
