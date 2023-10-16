package carrentalsystem.reservationmanagement.service.impl;


import carrentalsystem.reservationmanagement.dto.ReservationRequestDTO;
import carrentalsystem.reservationmanagement.dto.ReservationResponseDTO;
import carrentalsystem.reservationmanagement.model.Reservation;
import carrentalsystem.reservationmanagement.model.enums.ReservationStatus;
import carrentalsystem.reservationmanagement.repository.ReservationRepository;
import carrentalsystem.reservationmanagement.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    int reservationDailyRate = 10; // 10$ per day or can be passed as a parameter
    @Value("${gateway.url}")
    private String gatewayUrl;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public ReservationResponseDTO createReservation(ReservationRequestDTO reservation) {

        try {
            String vehicleUrl = gatewayUrl + "vehicles/" + reservation.getVehicleId();
            ResponseEntity<?> responseFromVehicleService =  restTemplate.getForEntity(vehicleUrl, Long.class);
            if (responseFromVehicleService.getStatusCode().isError())
                throw new RuntimeException("Vehicle with id: " + reservation.getVehicleId() + " not found");
            else {
                String customerUrl = gatewayUrl + "customers/" + reservation.getCustomerId();
                try{
                    ResponseEntity<?> responseFromCustomerService =  restTemplate.getForEntity(customerUrl, Long.class);
                    if (responseFromCustomerService.getStatusCode().isError())
                        throw new RuntimeException("Customer with id: " + reservation.getCustomerId() + " not found");
                    else{
                        Reservation reservationEntity = new Reservation();
                        reservationEntity.setVehicleId(reservation.getVehicleId());
                        reservationEntity.setCustomerId(reservation.getCustomerId());
                        reservationEntity.setStartDate(reservation.getStartDate());
                        reservationEntity.setEndDate(reservation.getEndDate());
                        reservationEntity.setPaymentMethod(reservation.getPaymentMethod());
                        reservationEntity.setPaymentStatus(reservation.getPaymentStatus());
                        reservationEntity.setPaymentType(reservation.getPaymentType());
                        reservationEntity.setPaymentDescription(reservation.getPaymentDescription());
                        reservationEntity.setPaymentDescription(reservation.getPaymentDescription());
                        reservationEntity.setPaymentCurrency(reservation.getPaymentCurrency());
                        reservationEntity.setPaymentReference(reservation.getPaymentReference());
                        int dateDifference = reservation.getEndDate().getDayOfMonth() - reservation.getStartDate().getDayOfMonth();
                        reservationEntity.setTotalPrice(dateDifference * reservationDailyRate);
                        reservationEntity.setStatus(ReservationStatus.BOOKED);
                        reservationEntity.setPaymentDate(LocalDate.now());
                        Reservation savedReservation = reservationRepository.save(reservationEntity);
                        restTemplate.put(gatewayUrl + "vehicles/" + reservation.getVehicleId() + "/reserved", String.class);
                        return modelMapper.map(savedReservation, ReservationResponseDTO.class);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Customer with id: " + reservation.getCustomerId() + " not found");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Vehicle with id: " + reservation.getVehicleId() + " not found");
        }
    }

    @Override
    public ReservationResponseDTO getReservationById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return null;
    }

    @Override
    public ReservationResponseDTO updateReservation(ReservationRequestDTO reservationRequestDTO, Long id) {
        Reservation reservationOptional = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation with id: " + id + " not found"));
        reservationOptional.setVehicleId(reservationRequestDTO.getVehicleId());
        reservationOptional.setCustomerId(reservationRequestDTO.getCustomerId());
        reservationOptional.setStartDate(reservationRequestDTO.getStartDate());
        reservationOptional.setEndDate(reservationRequestDTO.getEndDate());
        reservationOptional.setPaymentMethod(reservationRequestDTO.getPaymentMethod());
        reservationOptional.setPaymentStatus(reservationRequestDTO.getPaymentStatus());
        reservationOptional.setPaymentType(reservationRequestDTO.getPaymentType());
        reservationOptional.setPaymentDescription(reservationRequestDTO.getPaymentDescription());
        reservationOptional.setPaymentDescription(reservationRequestDTO.getPaymentDescription());
        reservationOptional.setPaymentCurrency(reservationRequestDTO.getPaymentCurrency());
        reservationOptional.setPaymentReference(reservationRequestDTO.getPaymentReference());
        int dateDifference = reservationRequestDTO.getEndDate().getDayOfMonth() - reservationRequestDTO.getStartDate().getDayOfMonth();
        reservationOptional.setTotalPrice(dateDifference * reservationDailyRate);
        reservationOptional.setStatus(ReservationStatus.BOOKED);
        reservationOptional.setPaymentDate(LocalDate.now());
        Reservation savedReservation = reservationRepository.save(reservationOptional);
        return modelMapper.map(savedReservation, ReservationResponseDTO.class);

    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<ReservationResponseDTO> getAllReservations() {
        return null;
    }

    @Override
    public List<ReservationResponseDTO> searchReservations(String query) {
        return null;
    }

    @Override
    public List<ReservationResponseDTO> advancedSearchReservations(String query, String sort) {
        return null;
    }

    @Override
    public List<ReservationResponseDTO> getReservationByVehicleId(long vehicleId) {
        List<ReservationResponseDTO> reservationResponseDTOList = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findByVehicleId(vehicleId);
        for (Reservation reservation : reservationList) {
            reservationResponseDTOList.add(modelMapper.map(reservation, ReservationResponseDTO.class));
        }
        return reservationResponseDTOList;
    }

    @Override
    public List<ReservationResponseDTO> getReservationByCustomerId(long customerId) {
        List<ReservationResponseDTO> reservationResponseDTOList = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findByCustomerId(customerId);
        for (Reservation reservation : reservationList) {
            reservationResponseDTOList.add(modelMapper.map(reservation, ReservationResponseDTO.class));
        }
        return reservationResponseDTOList;
    }

    @Override
    public List<ReservationResponseDTO> getReservationByStartDate(LocalDate startDate) {
        List<ReservationResponseDTO> reservationResponseDTOList = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findByStartDate(startDate);
        for (Reservation reservation : reservationList) {
            reservationResponseDTOList.add(modelMapper.map(reservation, ReservationResponseDTO.class));
        }
        return reservationResponseDTOList;
    }

    @Override
    public List<ReservationResponseDTO> getReservationByEndDate(LocalDate endDate) {
        List<ReservationResponseDTO> reservationResponseDTOList = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findByEndDate(endDate);
        for (Reservation reservation : reservationList) {
            reservationResponseDTOList.add(modelMapper.map(reservation, ReservationResponseDTO.class));
        }
        return reservationResponseDTOList;
    }

    @Override
    public List<ReservationResponseDTO> getReservationByTotalPrice(double totalPrice) {
        List<ReservationResponseDTO> reservationResponseDTOList = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findByTotalPrice(totalPrice);
        for (Reservation reservation : reservationList) {
            reservationResponseDTOList.add(modelMapper.map(reservation, ReservationResponseDTO.class));
        }
        return reservationResponseDTOList;
    }

    @Override
    public List<ReservationResponseDTO> getReservationByStatus(ReservationStatus status) {
        List<ReservationResponseDTO> reservationResponseDTOList = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findByStatus(status);
        for (Reservation reservation : reservationList) {
            reservationResponseDTOList.add(modelMapper.map(reservation, ReservationResponseDTO.class));
        }
        return reservationResponseDTOList;
    }


}
