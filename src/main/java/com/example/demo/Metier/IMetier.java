package com.example.demo.Metier;

import java.util.Date;

import com.example.demo.entity.Taches;

public interface IMetier {
	public Taches TacheCompletJour(Taches t);
	public int  NombreHeureJours(int t1,int t2);
	public Taches MemeJours(Taches t1 ,Taches t2);
	public Taches TachesCompletJoursSup(Taches t1 ,Taches t2);
	public Taches vider(Taches t);
	public Taches HeureSupSecuriter(Taches t1,Taches t2);
	public Taches HeureSupSecuriterparticuliers(Taches t1,Taches t2);
	public int CalulePanier(Taches t);
	public Taches TacheWeekend(Taches t);
	public int  ConverteDate(Date t);
}
