package com.example.demo.DAO;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Taches;
@Repository
public interface TachesIm extends JpaRepository<Taches, Long>{
	
	
	@Query("select max(b) from Taches b, Employer em where b.employer.id like:x")
	public Taches SommeJous(@Param("x")String matricule);
	
	@Query("select t from Taches t , Employer e where  t.dateday between :x and :y and t.employer.id like :z ")
	public List<Taches> SommeSemaine(@Param("x")Date d1,@Param("y")Date d2,@Param("z")String matricule);
	
	
	
	
	
}
