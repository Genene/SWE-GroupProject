package carrentalsystem.rentalmanagement.controller;




import org.springframework.web.bind.annotation.*;
import carrentalsystem.rentalmanagement.model.Rental;

@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController {

    @GetMapping
    public String getAllRentals() {
        return "getAllRentals";
    }

    @GetMapping("/{id}")
    public String getRentalById(@PathVariable Long id) {
        return "getRentalById";
    }

    @PostMapping
    public String createRental() {
        return "createRental";
    }

    @PutMapping("/{id}")
    public String updateRental(@PathVariable Long id) {
        return "updateRental";
    }

    @PostMapping("/{id}/book")
    public String bookRental(@PathVariable Long id) {
        return "bookRental";
    }

    @PostMapping("/{id}/extend")
    public String extendRental(@PathVariable Long id) {
        return "extendRental";
    }

    @PostMapping("/{id}/pay")
    public String payRental(@PathVariable Long id) {
        return "payRental";
    }
    @PostMapping("/{id}/refund")
    public String refundRental(@PathVariable Long id) {
        return "refundRental";
    }


    @PostMapping("/{id}/cancel")
    public String cancelRental(@PathVariable Long id) {
        return "cancelRental";
    }

    @PostMapping("/{id}/return")
    public String returnRental(@PathVariable Long id) {
        return "returnRental";
    }

}
