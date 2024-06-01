package org.example.service;

import org.example.model.office.City;
import org.example.model.office.Office;
import org.example.repository.OfficeRepository;

import java.util.ArrayList;
import java.util.List;

public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office getOfficeByEmployeeId(int idEmployeeToSearch){
        List<Office> offices = officeRepository.findAll();
        return offices.stream().filter(office -> office.getEmployeesId().stream().anyMatch(id ->id == idEmployeeToSearch)).findFirst().orElse(null);
    }
    public long getQuantityEmployeesByOfficeId(int officeId){
       Office office = officeRepository.findById(String.valueOf(officeId)).orElse(new Office(0, "", City.CALI, new ArrayList<>()));
        return office.getEmployeesId().size();
    }
}
