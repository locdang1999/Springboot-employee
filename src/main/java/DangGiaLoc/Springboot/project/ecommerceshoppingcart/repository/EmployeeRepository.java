package DangGiaLoc.Springboot.project.ecommerceshoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DangGiaLoc.Springboot.project.ecommerceshoppingcart.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
