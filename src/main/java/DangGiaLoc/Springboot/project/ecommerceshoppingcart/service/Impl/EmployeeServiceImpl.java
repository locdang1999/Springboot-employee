package DangGiaLoc.Springboot.project.ecommerceshoppingcart.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DangGiaLoc.Springboot.project.ecommerceshoppingcart.exception.ResourceNotFoundException;
import DangGiaLoc.Springboot.project.ecommerceshoppingcart.model.Employee;
import DangGiaLoc.Springboot.project.ecommerceshoppingcart.repository.EmployeeRepository;
import DangGiaLoc.Springboot.project.ecommerceshoppingcart.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return repository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		// c1 viết dài
		Optional<Employee> employee = repository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "id", id);
//		}

		// c2 viết tắt
		return employee.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee update(Employee employee, Long id) {
		// TODO Auto-generated method stub
		Employee checkEmployee = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		checkEmployee.setFirstName(employee.getFirstName());
		checkEmployee.setLastName(employee.getLastName());
		checkEmployee.setEmail(employee.getEmail());
		repository.save(checkEmployee);
		return checkEmployee;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		repository.deleteById(id);
	}

}
