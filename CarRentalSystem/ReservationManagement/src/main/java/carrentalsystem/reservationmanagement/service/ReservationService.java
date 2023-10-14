package carrentalsystem.reservationmanagement.service;

import carrentalsystem.reservationmanagement.model.Reservation;
import carrentalsystem.reservationmanagement.model.enums.ReservationStatus;

import java.util.List;

public interface ReservationService {

    Reservation createReservation(Reservation reservation);

    Reservation getReservationById(Long id);

    Reservation updateReservation(Reservation reservation, Long id);

    void deleteReservation(Long id);

    List<Reservation> getAllReservations();

    List<Reservation> searchReservations(String query);

    List<Reservation> advancedSearchReservations(String query, String sort);

    List<Reservation> getReservationByVehicleId(String vehicleId);

    List<Reservation> getReservationByCustomerId(String customerId);

    List<Reservation> getReservationByStartDate(String startDate);

    List<Reservation> getReservationByEndDate(String endDate);

    List<Reservation> getReservationByTotalPrice(String totalPrice);

    List<Reservation> getReservationByStatus(ReservationStatus status);
}
