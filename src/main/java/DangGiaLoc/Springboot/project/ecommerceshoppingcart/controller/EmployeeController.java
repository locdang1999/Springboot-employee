package DangGiaLoc.Springboot.project.ecommerceshoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DangGiaLoc.Springboot.project.ecommerceshoppingcart.model.Employee;
import DangGiaLoc.Springboot.project.ecommerceshoppingcart.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("")
	public ResponseEntity<Object> getAll(){
		
		List<Employee> employee = service.findAll();
		
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/{employee-id}")
	public ResponseEntity<Object> getById(@PathVariable("employee-id") Long id){
		return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(service.save(employee),HttpStatus.CREATED);
	}
	
	@PutMapping("/{employee-id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable("employee-id") Long id){
		return new ResponseEntity<>(service.update(employee, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{employee-id}")
	public ResponseEntity<String> deleteById(@PathVariable("employee-id") Long id){
		service.delete(id);
		return new ResponseEntity<>("Delete successfully!!!",HttpStatus.OK);
	}
}
