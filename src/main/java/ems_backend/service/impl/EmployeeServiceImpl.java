package ems_backend.service.impl;

import ems_backend.dto.EmployeeDto;
import ems_backend.entity.Employee;
import ems_backend.exception.ResourceNotFoundException;
import ems_backend.mapper.EmployeeMapper;
import ems_backend.repository.EmployeeRepository;
import ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + employeeId + " not found"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
