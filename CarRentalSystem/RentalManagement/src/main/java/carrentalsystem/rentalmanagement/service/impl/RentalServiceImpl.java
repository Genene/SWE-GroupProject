package carrentalsystem.rentalmanagement.service.impl;


import carrentalsystem.rentalmanagement.model.Rental;
import carrentalsystem.rentalmanagement.model.enums.RentalStatus;
import carrentalsystem.rentalmanagement.repository.RentalRepository;
import carrentalsystem.rentalmanagement.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class RentalServiceImpl implements RentalService {

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }
    private final RentalRepository rentalRepository;
    @Override
    public List<Rental> getAllRentals() {
        if (rentalRepository.findAll().isEmpty())
             throw new RuntimeException("No rentals found");

        return rentalRepository.findAll();
    }

    @Override
    public Rental getRentalById(Long id) {
        Optional<Rental> rental = rentalRepository.findById(id);
        if (rental.isEmpty())
            throw new RuntimeException("Rental not found");
        return rental.get();
    }

    @Override
    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public Rental updateRental(Rental rental, Long id) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (rentalOptional.isEmpty())
            throw new RuntimeException("Rental not found");
        rental.setId(id);
        return rentalRepository.save(rental);
    }

    @Override
    public Rental bookRental(Long id) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (rentalOptional.isEmpty())
            throw new RuntimeException("Rental not found");
        Rental rental = rentalOptional.get();
        rental.setStatus(RentalStatus.BOOKED);
        return rentalRepository.save(rental);
    }

    @Override
    public Rental extendRental(Long id) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (rentalOptional.isEmpty())
            throw new RuntimeException("Rental not found");
        Rental rental = rentalOptional.get();
        rental.setStatus(RentalStatus.EXTENDED);
        return rentalRepository.save(rental);
    }

    @Override
    public Rental payRental(Long id) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (rentalOptional.isEmpty())
            throw new RuntimeException("Rental not found");
        Rental rental = rentalOptional.get();
        rental.setStatus(RentalStatus.PAID);
        return rentalRepository.save(rental);
    }

    @Override
    public Rental refundRental(Long id) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (rentalOptional.isEmpty())
            throw new RuntimeException("Rental not found");
        Rental rental = rentalOptional.get();
        rental.setStatus(RentalStatus.REFUNDED);
        return rentalRepository.save(rental);
    }

    @Override
    public Rental cancelRental(Long id) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (rentalOptional.isEmpty())
            throw new RuntimeException("Rental not found");
        Rental rental = rentalOptional.get();
        rental.setStatus(RentalStatus.CANCELLED);
        return rentalRepository.save(rental);
    }

    @Override
    public Rental returnRental(Long id) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (rentalOptional.isEmpty())
            throw new RuntimeException("Rental not found");
        Rental rental = rentalOptional.get();
        rental.setStatus(RentalStatus.RETURNED);
        return rentalRepository.save(rental);
    }


}
