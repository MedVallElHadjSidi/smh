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
	
	@Query("select distinct d.dateday from Taches d, Employer l where DAYOFWEEK(d.dateday)=2 and d.dateday between d.dateday and :x and DATEDIFF(:x,d.dateday) between 0 and 4 ")
	public Date DebutSemaine(@Param("x")Date d1);
	
	
	
	@Query("select max(b) from Taches b, Employer em where b.employer.id like:x and b.employer.id=em.id")
	public Taches SommeJous(@Param("x")String matricule);
	
	@Query("select t from Taches t , Employer e where  t.dateday between :x and :y and t.employer.id like :z and t.employer.id=e.id")
	public List<Taches> SommeSemaine(@Param("x")Date d1,@Param("y")Date d2,@Param("z")String matricule);
	
	@Query("select sum(t.nbreSup15) from Taches t , Employer e where  t.dateday between :x and :y and t.employer.id like :z and t.employer.id=e.id")
	public int SommeSup15(@Param("x")Date d1,@Param("y")Date d2,@Param("z")String matricule);
	
	
	@Query("select sum(t.nbreSup40) from Taches t , Employer e where  t.dateday between :x and :y and t.employer.id like :z and t.employer.id=e.id")
	public int SommeSup40(@Param("x")Date d1,@Param("y")Date d2,@Param("z")String matricule);
	
	
	
	
}
