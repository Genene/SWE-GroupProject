package carrentalsystem.rentalmanagement.model;

import carrentalsystem.rentalmanagement.model.enums.PaymentStatus;
import carrentalsystem.rentalmanagement.model.enums.RentalStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Vehicle is required")

    private String vehicle_id;

    @NotNull(message = "Customer is required")

    private String customer_id;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotNull(message = "Total price is required")
    private Double totalPrice;

    @NotNull(message = "Status is required")
    private RentalStatus status;

    @NotNull(message = "Payment method is required")
    private String paymentMethod;

    @NotNull(message = "Payment status is required")
    private PaymentStatus paymentStatus;

    @NotNull(message = "Payment date is required")
    private LocalDate paymentDate;

    @NotNull(message = "Payment amount is required")
    private Double paymentAmount;

    @NotNull(message = "Payment reference is required")
    private String paymentReference;

    @NotNull(message = "Payment type is required")
    private String paymentType;

    @NotNull(message = "Payment description is required")
    private String paymentDescription;

    @NotNull(message = "Payment currency is required")
    private String paymentCurrency;

    @NotNull(message = "Payment receipt is required")
    private String paymentReceipt;

    @NotNull(message = "Payment card number is required")
    private String paymentCardNumber;

    @NotNull(message = "Payment card expiry is required")
    private String paymentCardExpiry;

    @NotNull(message = "Payment card cvv is required")
    private String paymentCardCvv;

    @NotNull(message = "Payment card holder name is required")
    private String paymentCardHolderName;

    @NotNull(message = "Payment card type is required")
    private String paymentCardType;

    @NotNull(message = "Payment card bank is required")
    private String paymentCardBank;

    @NotNull(message = "Payment card country is required")
    private String paymentCardCountry;

    @NotNull(message = "Payment card zip is required")
    private String paymentCardZip;

    @NotNull(message = "Payment card state is required")
    private String paymentCardState;

    @NotNull(message = "Payment card city is required")
    private String paymentCardCity;

    @NotNull(message = "Payment card address is required")
    private String paymentCardAddress;


}