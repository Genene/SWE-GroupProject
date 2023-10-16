package carrentalsystem.reservationmanagement.dto;

import carrentalsystem.reservationmanagement.model.enums.PaymentStatus;
import carrentalsystem.reservationmanagement.model.enums.PaymentType;
import carrentalsystem.reservationmanagement.model.enums.ReservationStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ReservationResponseDTO {
    private long reservationId;
    private long vehicleId;
    private long customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private ReservationStatus status;
    private String paymentMethod;
    private PaymentStatus paymentStatus;
    private LocalDate paymentDate;
    private PaymentType paymentType;
    private String paymentDescription;
    private String paymentCurrency;
    private String paymentReference;
}
