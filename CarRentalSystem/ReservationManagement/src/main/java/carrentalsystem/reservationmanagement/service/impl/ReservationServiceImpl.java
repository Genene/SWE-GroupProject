package carrentalsystem.reservationmanagement.service.impl;


import carrentalsystem.reservationmanagement.model.Reservation;
import carrentalsystem.reservationmanagement.model.enums.ReservationStatus;
import carrentalsystem.reservationmanagement.repository.ReservationRepository;
import carrentalsystem.reservationmanagement.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {


    private final ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElse(null);
    }

    @Override
    public Reservation updateReservation(Reservation reservation, Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            reservation.setId(id);
            return reservationRepository.save(reservation);
        }
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> searchReservations(String query) {
        return null;
    }

    @Override
    public List<Reservation> advancedSearchReservations(String query, String sort) {
        return null;
    }

    @Override
    public List<Reservation> getReservationByVehicleId(String vehicleId) {
        return reservationRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<Reservation> getReservationByCustomerId(String customerId) {
        return reservationRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Reservation> getReservationByStartDate(String startDate) {
        return reservationRepository.findByStartDate(startDate);
    }

    @Override
    public List<Reservation> getReservationByEndDate(String endDate) {
        return reservationRepository.findByEndDate(endDate);
    }

    @Override
    public List<Reservation> getReservationByTotalPrice(String totalPrice) {
        return reservationRepository.findByTotalPrice(totalPrice);
    }

    @Override
    public List<Reservation> getReservationByStatus(ReservationStatus status) {
        return reservationRepository.findByStatus(status);
    }

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

}
