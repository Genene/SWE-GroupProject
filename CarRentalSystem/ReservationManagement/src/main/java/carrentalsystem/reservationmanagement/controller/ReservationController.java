package carrentalsystem.reservationmanagement.controller;


import carrentalsystem.reservationmanagement.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import carrentalsystem.reservationmanagement.model.Reservation;
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {
        try{
            Reservation createdReservation = reservationService.createReservation(reservation);
            return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to create reservation");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long id) {
        try{
            Reservation reservation = reservationService.getReservationById(id);
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to get reservation");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation(@RequestBody Reservation reservation, @PathVariable Long id) {
        try{
            Reservation updatedReservation = reservationService.updateReservation(reservation, id);
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to update reservation");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        try{
            reservationService.deleteReservation(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to delete reservation");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllReservations() {
        try{
            Iterable<Reservation> reservations = reservationService.getAllReservations();
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to get reservations");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchReservations(@RequestParam String query) {
        try{
            Iterable<Reservation> reservations = reservationService.searchReservations(query);
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to search reservations");
        }
    }

    @GetMapping("/search/advanced")
    public ResponseEntity<?> advancedSearchReservations(@RequestParam String query, @RequestParam String sort) {
        try{
            Iterable<Reservation> reservations = reservationService.advancedSearchReservations(query, sort);
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to advanced search reservations");
        }
    }




}
