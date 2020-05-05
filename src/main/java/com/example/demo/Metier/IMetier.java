package com.example.demo.Metier;

import com.example.demo.entity.Taches;

public interface IMetier {
	public Taches TacheCompletJour(Taches t);
	public int  NombreHeureJours(Taches t);
	public Taches MemeJours(Taches t1 ,Taches t2);
	
	
	
	
	
	
	
}
