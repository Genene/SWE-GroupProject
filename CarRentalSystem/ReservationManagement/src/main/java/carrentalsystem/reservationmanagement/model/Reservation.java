package carrentalsystem.reservationmanagement.model;


import carrentalsystem.reservationmanagement.model.enums.PaymentStatus;
import carrentalsystem.reservationmanagement.model.enums.PaymentType;
import carrentalsystem.reservationmanagement.model.enums.ReservationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;

    private long vehicleId;
    private long customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;//
    private ReservationStatus status;//
    private String paymentMethod;
    private PaymentStatus paymentStatus;
    private LocalDate paymentDate;//
    private PaymentType paymentType;
    private String paymentDescription;
    private String paymentCurrency;
    private String paymentReference;

}
