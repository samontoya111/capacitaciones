package org.example.service;

import org.example.exception.CustomException;
import org.example.model.office.City;
import org.example.model.office.Office;
import org.example.repository.OfficeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public String getNameOffice(Optional<Office> office) throws CustomException {
        if(office.isEmpty()){
            throw new CustomException("No se encontro resultado");
        } else {
            return office.get().name;
        }

    }
    public String getOfficeByEmployeeId(int idEmployeeToSearch) throws CustomException {
        List<Office> offices = officeRepository.findAll();
        return getNameOffice(offices.stream().filter(office -> office.getEmployeesId().stream().anyMatch(id ->id == idEmployeeToSearch)).findFirst());
    }
    public long getQuantityEmployeesByOfficeId(int officeId){
       Office office = officeRepository.findById(String.valueOf(officeId)).orElse(new Office(0, "", City.CALI, new ArrayList<>()));
        return office.getEmployeesId().size();
    }
}
