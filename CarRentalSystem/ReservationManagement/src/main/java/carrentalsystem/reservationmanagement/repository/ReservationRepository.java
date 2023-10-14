package carrentalsystem.reservationmanagement.repository;



import carrentalsystem.reservationmanagement.model.Reservation;
import carrentalsystem.reservationmanagement.model.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByVehicleId(String vehicleId);
    List<Reservation> findByCustomerId(String customerId);
    List<Reservation> findByEndDate(String endDate);
    List<Reservation> findByTotalPrice(String totalPrice);
    List<Reservation> findByStartDate(String startDate);
    List<Reservation> findByStatus(ReservationStatus status);




}
