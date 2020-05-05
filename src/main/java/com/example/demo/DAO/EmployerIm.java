package com.example.demo.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Employer;
import com.example.demo.entity.Taches;

public interface EmployerIm extends JpaRepository<Employer, String>{
	boolean existsById(String id);
	
	
	
}
