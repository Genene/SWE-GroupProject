package carrentalsystem.paymentprocessing.model;


import carrentalsystem.paymentprocessing.model.enums.PaymentStatus;
import carrentalsystem.paymentprocessing.model.enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int paymentId;
        private int bookingId;
        private String paymentMethod;
        private PaymentStatus paymentStatus;
        private double amount;
        private LocalDate paymentDate;
        private LocalDateTime paymentTime;
        private PaymentType paymentType;
        private String paymentDescription;
        private String paymentCurrency;
        private String paymentReference;
        private String paymentMode;
        private String paymentChannel;
        private String paymentChannelProvider;
        private String paymentChannelProviderCountry;
}
