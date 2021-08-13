package DangGiaLoc.Springboot.project.ecommerceshoppingcart.service;

import java.util.List;

import DangGiaLoc.Springboot.project.ecommerceshoppingcart.model.Employee;

public interface EmployeeService {
	Employee save(Employee employee);
	List<Employee> findAll();
	Employee findById(Long id);
	Employee update(Employee employee, Long id);
	void delete(Long id);
}
