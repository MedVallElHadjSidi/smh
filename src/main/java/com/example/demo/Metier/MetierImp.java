
  package com.example.demo.Metier;
  
  import java.util.Date;
  

  import  org.springframework.stereotype.Service;
  import  org.springframework.transaction.annotation.Transactional;
 
  import com.example.demo.entity.Taches;
  
  @Service
  
  @Transactional 
  public class MetierImp implements IMetier{

	@Override
	public Taches TacheCompletJour(Taches t) {
		// TODO Auto-generated method stub
		int n=NombreHeureJours(ConverteDate(t.getDatedebut()),ConverteDate(t.getDatefint()));
		  t.setTotal_Heure(n);
		  /*datedebut>0*/
		  if(t.getDatedebut().getHours()>0) {
			  if(t.getDatedebut().getHours()<5) {
				  if(n<=9) {
					  t.setNbreHtNormale(9);
				  }
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=17&&t.getDatedebut().getHours()<t.getDatefint().getHours()) {
					  
					  if(n<=9) {
						  t.setNbreHtNormale(9);
						  
					  }
					  else {
						  t.setNbreHtNormale(9);
						  t.setNbreSup15(n-9);
					  }
					  
				  }
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=23&&t.getDatedebut().getHours()<t.getDatefint().getHours()&&t.getDatefint().getHours()>17)
				  {
					  if(t.getDatefint().getHours()==23) {
						  t.setNbreHtNormale(9);
						
							t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
							t.setNbreSup15(n-9-t.getNbreSup50());
						  
					  }
					  else {
						  
						  t.setNbreHtNormale(9);
							t.setNbreSup15(n-9);
					  }
					  
					  
				  }
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=t.getDatedebut().getHours()) {
					  if(t.getDatefint().getHours()<=8) {
						  if(t.getDatefint().getHours()<=5) {
							  if(n<=9) {
								  t.setNbreHtNormale(n);
							  }
							  else {
							  t.setNbreHtNormale(9);
							
								t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
								t.setNbreSup15(n-(9+t.getNbreSup50()));}
						  }
						  else {
							  if(n<=9) {
								  t.setNbreHtNormale(n);
							  }
							  else {
							  t.setNbreHtNormale(9);
								t.setNbreSup50(NombreHeureJours(79200,18000));
								t.setNbreSup15((n-9-t.getNbreSup50())+(NombreHeureJours(18000,ConverteDate(t.getDatefint()))));
								if(t.getNbreSup15()>8) {
									t.setNbreSup40(t.getNbreSup15()-8);
									t.setNbreSup15(8);
									if(t.getNbreSup40()>6) {
										t.setNbreSup50(t.getNbreSup40()-6+t.getNbreSup50());
										t.setNbreSup40(6);
									}}
									
								}
							  
								  
							  
						  }
						  
					  }
				  }
				  else {
					  t.setNbreHtNormale(9);
						
						t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
						t.setNbreSup15(n-(9+t.getNbreSup50()));
					  
					  
				  }
				  
				  
			  }
			  
			  
			  /*datedebut==8*/
			  else  if(t.getDatedebut().getHours()==8) {
				  /*datefin<17*/
				  if(n<=9) {
					  t.setNbreHtNormale(n);
				  }
				  /*datefin=17*/
				 
				  /*datefin>17&datefin<=23*/
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=23&&t.getDatedebut().getHours()<t.getDatefint().getHours()&&t.getDatefint().getHours()>17)
				  {
					  if(t.getDatefint().getHours()==23) {
						  t.setNbreHtNormale(NombreHeureJours(ConverteDate(t.getDatedebut()),61200));
							t.setNbreSup15(NombreHeureJours(61200,79200));
							t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
						  
						  
					  }
					  else {
						  
						  t.setNbreHtNormale(NombreHeureJours(ConverteDate(t.getDatedebut()),61200));
							t.setNbreSup15(NombreHeureJours(61200,ConverteDate(t.getDatefint())));
					  }
					  
					  
				  }
				  /*datefin>0*/
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=t.getDatedebut().getHours()) {
					  if(t.getDatefint().getHours()<=8) {
						  if(t.getDatefint().getHours()<=5) {
							  
							  t.setNbreHtNormale(NombreHeureJours(ConverteDate(t.getDatedebut()),61200));
								t.setNbreSup15(NombreHeureJours(61200,79200));
								t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
						  }
						  else {
							  t.setNbreHtNormale(NombreHeureJours(ConverteDate(t.getDatedebut()),61200));
								t.setNbreSup15(NombreHeureJours(61200,79200));
								t.setNbreSup50(NombreHeureJours(79200,18000));
								t.setNbreSup15(t.getNbreSup15()+(NombreHeureJours(18000,ConverteDate(t.getDatefint()))));
								if(t.getNbreSup15()>8) {
									t.setNbreSup40(t.getNbreSup15()-8);
									t.setNbreSup15(8);
									if(t.getNbreSup40()>6) {
										t.setNbreSup50(t.getNbreSup40()-6+t.getNbreSup50());
										t.setNbreSup40(6);
									}
									
								}
							  
								  
							  
						  }
						  
					  }
				  }
				  /*commence	08	a	00*/
				  else {
					  t.setNbreHtNormale(NombreHeureJours(ConverteDate(t.getDatedebut()),61200));
						t.setNbreSup15(NombreHeureJours(61200,79200));
						t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
					  
					  
					  
				  }
				  
				  
				  
				  
				  
			  }
			  else if(t.getDatedebut().getHours()==5) {
				  if(n<=9) {
					  t.setNbreHtNormale(n);
				  }
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=17&&t.getDatedebut().getHours()<t.getDatefint().getHours()) {
					  
					  if(n<=9) {
						  t.setNbreHtNormale(9);
						  
					  }
					  else {
						  t.setNbreHtNormale(9);
						  t.setNbreSup15(n-9);
					  }
					  
				  }
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=23&&t.getDatedebut().getHours()<t.getDatefint().getHours()&&t.getDatefint().getHours()>17)
				  {
					  if(t.getDatefint().getHours()==23) {
						  t.setNbreHtNormale(9);
							
							t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
							t.setNbreSup15(n-9-t.getNbreSup50());
						  
					  }
					  else {
						  
						  t.setNbreHtNormale(9);
							t.setNbreSup15(n-9);
					  }
					  
					  
				  }
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=t.getDatedebut().getHours()) {
					  if(t.getDatefint().getHours()<=8) {
						  if(t.getDatefint().getHours()<=5) {
							  
							  t.setNbreHtNormale(9);
								
								t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
								t.setNbreSup15(n-(9+t.getNbreSup50()));
						  }
						  else {
							  t.setNbreHtNormale(9);
								
								t.setNbreSup50(NombreHeureJours(79200,18000));
								
								t.setNbreSup15(n-(9+t.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t.getDatefint())));
								if(t.getNbreSup15()>8) {
									t.setNbreSup40(t.getNbreSup15()-8);
									t.setNbreSup15(8);
									if(t.getNbreSup40()>6) {
										t.setNbreSup50(t.getNbreSup40()-6+t.getNbreSup50());
										t.setNbreSup40(6);
									}
									
								}
							  
								  
							  
						  }
						  
					  }
				  }
				  else {
					  t.setNbreHtNormale(9);
						
						t.setNbreSup50(NombreHeureJours(79200,18000));
						
						t.setNbreSup15(n-(9+t.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t.getDatefint())));
					  
					  
				  }
			  }
			  else {
				  
				  if(n<=9) {
					  t.setNbreHtNormale(n);
				  }
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=23&&t.getDatedebut().getHours()<t.getDatefint().getHours()&&t.getDatefint().getHours()>17)
				  {
					  if(t.getDatefint().getHours()==23) {
						  t.setNbreHtNormale(9);
						
							t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
							t.setNbreSup15(n-9-t.getNbreSup50());
						  
					  }
					  else {
						  
						  t.setNbreHtNormale(9);
							t.setNbreSup15(n-9);
					  }
					  
					  
				  }
				  
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=t.getDatedebut().getHours()) {
					  if(t.getDatefint().getHours()<=8) {
						  if(t.getDatefint().getHours()<=5) {
							  
							  t.setNbreHtNormale(9);
								
								t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
								t.setNbreSup15(n-(9+t.getNbreSup50()));
						  }
						  else {
							  t.setNbreHtNormale(9);
								
								t.setNbreSup50(NombreHeureJours(79200,18000));
								
								t.setNbreSup15(n-(9+t.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t.getDatefint())));
								if(t.getNbreSup15()>8) {
									t.setNbreSup40(t.getNbreSup15()-8);
									t.setNbreSup15(8);
									if(t.getNbreSup40()>6) {
										t.setNbreSup50(t.getNbreSup40()-6+t.getNbreSup50());
										t.setNbreSup40(6);
									}
									
								}
							  
								  
							  
						  }
						  
					  }
				  }
				  else {
					  if(t.getDatefint().getHours()>8) {
						  t.setNbreHtNormale(9);
						  t.setNbreSup50(NombreHeureJours(79200,18000));
						  t.setNbreSup15(NombreHeureJours(18000,ConverteDate(t.getDatefint())));
						  t.setNbreSup15(n-(9-t.getNbreSup50())+t.getNbreSup15());
						  if(t.getNbreSup15()>8) {
								t.setNbreSup40(t.getNbreSup15()-8);
								t.setNbreSup15(8);
								if(t.getNbreSup40()>6) {
									t.setNbreSup50(t.getNbreSup40()-6+t.getNbreSup50());
									t.setNbreSup40(6);
								}
								
							}
						  
					  }
					  
					  else {
						  
					  t.setNbreHtNormale(9);
						
						t.setNbreSup50(NombreHeureJours(79200,18000));
						
						t.setNbreSup15(n-(9+t.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t.getDatefint())));
					  }
					  
					  
				  }
				  
			  }
			  
		  }
		  
	
		
		return t;
	}

	@Override
	public int NombreHeureJours(int t1, int t2) {
		// TODO Auto-generated method stub
		  int rs=0;
			
		  if(t2>t1) {
		  
		  rs=(t2-t1)/3600;}
		  
		  
		  else { rs=(24)-((t1-t2)/3600); }
		  
		return rs;
	}

	@Override
	public Taches MemeJours(Taches t1, Taches t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Taches TachesCompletJoursSup(Taches t1, Taches t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Taches vider(Taches t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Taches TacheWeekend(Taches t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ConverteDate(Date t) {
		// TODO Auto-generated method stub
		int nb=(t.getHours()*3600)+(t.getMinutes()*60);
		
		return nb;
	}
  
 
  }
 