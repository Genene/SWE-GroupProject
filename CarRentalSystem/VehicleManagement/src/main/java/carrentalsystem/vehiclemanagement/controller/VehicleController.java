package carrentalsystem.vehiclemanagement.controller;



import carrentalsystem.vehiclemanagement.model.Vehicle;
import carrentalsystem.vehiclemanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicle();
        if (vehicles.isEmpty())
            return new ResponseEntity<String>("No Vehicles found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle) {
        try
        {
            Vehicle savedVehicle = vehicleService.createVehicle(vehicle);
            return new ResponseEntity<Vehicle>(savedVehicle, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id) {
        try {
            Vehicle updated = vehicleService.updateVehicle(vehicle, id);
            return new ResponseEntity<Vehicle>(updated, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {

        try {
            vehicleService.deleteVehicle(id);
            return new ResponseEntity<String>("Vehicle deleted successfully", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
}
