package com.example.demo.Metier;


  
  import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service; import
  org.springframework.transaction.annotation.Transactional;
  
  import com.example.demo.DAO.TachesIm; import com.example.demo.entity.Taches;
  
  
  @Service
  
  @Transactional public class MetierIm implements IMetier{
  
  @Autowired TachesIm tachesim;
  
  @Override 
  public Taches TacheCompletJour(Taches t) { 
	  // TODO Auto-generated  method stub 
	  int n=NombreHeureJours(t);
	  
		  if(n>9) {
			  t.setNbreHtNormale(9);
			  if(t.getNbreSup15()<8) {
				  t.setNbreSup15(n-9);
				  if(t.getNbreSup15()>8) {
					  t.setNbreSup15(8);
					  t.setNbreSup40(NombreHeureJours(t)-9-8);
					  if(t.getNbreSup40()>6) {
						  t.setNbreSup40(6);
						  t.setNbreSup100(NombreHeureJours(t)-9-8-6);
					  }
					  
				  }
			
			  }
			  
		  }
		  if(NombreHeureJours(t)==9) {
			  t.setNbreHtNormale(9);
		  }
		  
	  
  
  return t; }
  
  @Override 
  public int NombreHeureJours(Taches t) { 
	  int rs=0;
	  int premier=(t.getDatedebut().getHours()*3600)+(t.getDatedebut().getMinutes()*60);
	  int seconde=(t.getDatefint().getHours()*3600)+(t.getDatefint().getMinutes()*60);
  if(seconde>premier) {
  
  rs=(seconde-premier)/3600;}
  
  else { rs=(24)-((premier-seconde)/3600); }
  
  
  return rs;
  
  
  }

@Override
public Taches MemeJours(Taches t1, Taches t2) {
	// TODO Auto-generated method stub
	int n=NombreHeureJours(t1);
	
	if(t2.getNbreSup15()<8&&t2.getNbreSup40()<6) {
		t1.setNbreSup15(t2.getNbreSup15()+n);
		if(t1.getNbreSup15()>8) {
			
			t1.setNbreSup40((t1.getNbreSup15()-8)+t2.getNbreSup40());
			t1.setNbreSup15(8);
			if(t1.getNbreSup40()>6) {
				
				t1.setNbreSup100((t1.getNbreSup40()-6)+t2.getNbreSup100());
			}
			
			
		}
		
		
		
		
	}
	if(t2.getNbreSup15()==8&&t2.getNbreSup40()<6) {
		t1.setNbreSup40((n)+t2.getNbreSup40());
		if(t1.getNbreSup40()>6) {
		
			t1.setNbreSup100(n-(6-t2.getNbreSup40()));
			t1.setNbreSup40(6);
		}
	}
	if(t2.getNbreSup15()==8&&t2.getNbreSup40()>=6) {
		t1.setNbreSup100(n+t2.getNbreSup100());
		
	}
	
	return t1;
}
 
  

  
  
  }
 