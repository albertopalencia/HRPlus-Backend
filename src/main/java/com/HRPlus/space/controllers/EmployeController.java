package com.HRPlus.space.controllers;


import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HRPlus.space.entities.Conge;
import com.HRPlus.space.entities.Employe;
import com.HRPlus.space.repositories.IEmployeRepo;
import com.HRPlus.space.services.EmployeServiceImpl;


@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeController {

	@Autowired
	private EmployeServiceImpl emplService;
	
	@Autowired
	private IEmployeRepo employeRepo;
	
	 @GetMapping("/employees")
	    public List<Employe> getAllEmployees() {
	        return employeRepo.findAll();
	    }

	/*@GetMapping("/employees")
	public List<Employe> getAllEmployees() {

		return (List<Employe>) emplService.getAllEmployees();

	}*/

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employe> findById(@PathVariable("id") Long id) {
		Optional<Employe> emp = emplService.findById(id);
		if (emp.isPresent())
			return new ResponseEntity<Employe>(emp.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Employe>(HttpStatus.NO_CONTENT);

	}

	@PostMapping("/employees/create")
	public ResponseEntity<Employe> create(@RequestBody Employe employe) {
		try {
			emplService.saveEmploye(employe);
			return new ResponseEntity<Employe>(employe, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Employe>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@PostMapping("/employees/update")
	public ResponseEntity<Employe> update(@RequestBody Employe employe) {
		try {
			emplService.saveEmploye(employe);
			return new ResponseEntity<Employe>(employe, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Employe>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employe> deleteEmploye(@PathVariable("id") Long id) {
		Optional<Employe> emp = emplService.findById(id);
		if (emp.isPresent()) {
			emplService.deleteEmploye(emp.get());
			return new ResponseEntity<Employe>(emp.get(), HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<Employe>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	/*@DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
          {
        Optional<Employe> employee = employeRepo.findById(employeeId);

        employeRepo.deleteById(employeeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/
	
	@DeleteMapping("/employees/{id}")
	  void deleteEmployee(@PathVariable Long id) {
		employeRepo.deleteById(id);
	  }

	
	
	@GetMapping("/employees/count")
	Long countEmploye() {
		return emplService.countEmploye();
	}
	
	@GetMapping("/employees/conges")
	List<Conge> getCongeByemployeId (Long id) {
		return emplService.getCongeByemployeId(id);
	}
	
	/*@PutMapping("/employees/{id}")
    public ResponseEntity<Employe> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody Employe employeeDetails)  {
		
        Employe employee = employeRepo.findEmployeById(employeeId);
       
        employee.setPhone(employeeDetails.getPhone());
        employee.setEmail(employeeDetails.getEmail());
        employee.setAdresse(employeeDetails.getAdresse());
        employee.setVille(employeeDetails.getVille());
        final Employe updatedEmployee = employeRepo.save(employee);
        
        return ResponseEntity.ok(updatedEmployee);
    }*/

}
