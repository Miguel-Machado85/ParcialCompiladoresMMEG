package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.AirportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.dto.CelebrityDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.dto.FlightsDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.*;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.ICelebrityRepository;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IFlightsRepository;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IPrivateJetRepository;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.ISecurityReportRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FlightsService implements IFlightsService {

    @Autowired
    private IFlightsRepository flightsRepository;

    @Autowired
    private ICelebrityRepository celebrityRepository;

    @Autowired
    private IPrivateJetRepository privateJetRepository;

    @Autowired
    private ISecurityReportRepository securityReportRepository;

    private FlightsDTO EntityToDTO(Flights flights) {
        return FlightsDTO.builder()
                .setId(flights.getId())
                .setDepartureAirport(flights.getDepartureAirport())
                .setArrivalAirport(flights.getArrivalAirport())
                .setDepartureTime(flights.getDepartureTime())
                .setArrivalTime(flights.getArrivalTime())
                .setCelebrity_Id(flights.getCelebrity().getId())
                .setJet_Id(flights.getPrivateJet().getId())
                .setPurpose(flights.getPurpose())
                .build();
    }

    private Flights DTOtoEntity(FlightsDTO flightsDTO) {
        Celebrity celebrity= celebrityRepository.findById(flightsDTO.getCelebrity_Id()).get();

        PrivateJet privateJet = privateJetRepository.findById(flightsDTO.getJet_Id()).get();

        return Flights.builder()
                .setId(flightsDTO.getId())
                .setDepartureAirport(flightsDTO.getDepartureAirport())
                .setArrivalAirport(flightsDTO.getArrivalAirport())
                .setDepartureTime(flightsDTO.getDepartureTime())
                .setArrivalTime(flightsDTO.getArrivalTime())
                .setCelebrity(celebrity)
                .setPrivateJet(privateJet)
                .setPurpose(flightsDTO.getPurpose())
                .build();
    }

    @Override
    public FlightsDTO registerFlight(@Valid FlightsDTO flightsDTO) {
        Flights flights = DTOtoEntity(flightsDTO);
        Flights savedFlights = flightsRepository.save(flights);
        return EntityToDTO(savedFlights);
    }

    @Override
    public Optional<FlightsDTO> flightById(Long id) {
        Optional<Flights> flightFound = flightsRepository.findById(id);
        return flightFound.map(this::EntityToDTO);
    }

    @Override
    public void deleteFlightById(Long id) {
        flightsRepository.deleteById(id);
    }

    @Override
    public List<FlightsDTO> retrieveFlaggedFlights() {
        List<FlightsDTO> flaggedFlights= flightsRepository.findFlightsByPurpose(Flights.Purpose.Suspicious).stream().map(this::EntityToDTO).collect(Collectors.toList());
        return flaggedFlights;
    }
}
