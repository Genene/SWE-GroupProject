package carrentalsystem.rentalmanagement.service;

import carrentalsystem.rentalmanagement.model.Rental;
import java.util.List;
import java.util.Optional;

public interface RentalService {
    List<Rental> getAllRentals();
    Rental getRentalById(Long id);
    Rental createRental(Rental rental);
    Rental updateRental(Rental rental, Long id);
    Rental bookRental(Long id);
    Rental extendRental(Long id);
    Rental payRental(Long id);
    Rental refundRental(Long id);
    Rental cancelRental(Long id);
    Rental returnRental(Long id);


}
