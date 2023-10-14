package carrentalsystem.reservationmanagement.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import carrentalsystem.reservationmanagement.model.Reservation;
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation(@RequestBody Reservation reservation, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return null;
    }

    @GetMapping("/search")
    public Iterable<Reservation> searchReservations(@RequestParam String query) {
        return null;
    }

    @GetMapping("/search/advanced")
    public Iterable<Reservation> advancedSearchReservations(@RequestParam String query, @RequestParam String sort) {
        return null;
    }


}
