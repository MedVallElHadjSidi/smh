
  package com.example.demo.Metier;
  
  import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
  import  org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAO.TachesIm;
import com.example.demo.entity.Taches;
  
  @Service
  
  @Transactional 
  public class MetierImp implements IMetier{
		@Autowired
		private TachesIm tachesim;

	@Override
	public Taches TacheCompletJour(Taches t) {
		// TODO Auto-generated method stub
		int n=NombreHeureJours(ConverteDate(t.getDatedebut()),ConverteDate(t.getDatefint()));
		  t.setTotal_Heure(n);
		  /*datedebut>0*/
		  if(t.getDatedebut().getHours()>0) {
			  if(t.getDatedebut().getHours()<5) {
				  if(n<=9) {
					  t.setNbreHtNormale(n);
				  }

				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=23&&t.getDatedebut().getHours()<t.getDatefint().getHours())
				  {
					  if(t.getDatefint().getHours()==23) {
						  t.setNbreHtNormale(9);
						
							t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
							t.setNbreSup15(n-9-t.getNbreSup50());
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
								t.setNbreSup15(n-(9+t.getNbreSup50()));
								if(t.getNbreSup15()>8) {
									t.setNbreSup40(t.getNbreSup15()-8);
									t.setNbreSup15(8);
									if(t.getNbreSup40()>6) {
										t.setNbreSup50(t.getNbreSup40()-6+t.getNbreSup50());
										t.setNbreSup40(6);
									}
									
								}}
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
						  
						  t.setNbreHtNormale(NombreHeureJours(ConverteDate(t.getDatedebut()),61200));
							t.setNbreSup15(NombreHeureJours(61200,ConverteDate(t.getDatefint())));
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
				  /*datefin>0*/
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=t.getDatedebut().getHours())
				  {
					  if(t.getDatefint().getHours()<=8) {
						  if(t.getDatefint().getHours()<=5) {
							  
							  t.setNbreHtNormale(NombreHeureJours(ConverteDate(t.getDatedebut()),61200));
								t.setNbreSup15(NombreHeureJours(61200,79200));
								t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
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
			  else if(t.getDatedebut().getHours()==5) {
				  if(n<=9) {
					  t.setNbreHtNormale(n);
				  }

				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=23&&t.getDatedebut().getHours()<t.getDatefint().getHours())
				  {
					  if(t.getDatefint().getHours()==23) {
						  t.setNbreHtNormale(9);
							
							t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
							t.setNbreSup15(n-9-t.getNbreSup50());
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
							t.setNbreSup15(n-9);
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
				  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=t.getDatedebut().getHours())
				  {
					  if(t.getDatefint().getHours()<=8) {
						  if(t.getDatefint().getHours()<=5) {
							  
							  t.setNbreHtNormale(9);
								
								t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
								t.setNbreSup15(n-(9+t.getNbreSup50()));
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
			  else {
			  	/*****************************************/

				  if(n<=9) {
					  t.setNbreHtNormale(n);
				  }
				  else{
				  	if(t.getDatedebut().getHours()>=5){
				  		if (t.getDatefint().getHours()<=23&&t.getDatefint().getHours()>t.getDatedebut().getHours())
						{


						}


					}


				  }

				  
			  }
			  
		  }
		  else {
			  if(n<=9) {
				  t.setNbreHtNormale(n);
				  
			  }
			  else {
				  
				  
	  if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=17&&t.getDatedebut().getHours()<t.getDatefint().getHours())
	  {
						  
						  if(n<=9) {
							  t.setNbreHtNormale(n);
							  
						  }
					  else {
						  t.setNbreHtNormale(9);
						  t.setNbreSup15(n-9);
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
				  
	  else if(t.getDatefint().getHours()>0&&t.getDatefint().getHours()<=23&&t.getDatedebut().getHours()<t.getDatefint().getHours()&&t.getDatefint().getHours()>17)
  {
	  if(t.getDatefint().getHours()==23) {
		  t.setNbreHtNormale(9);
		
			t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
			t.setNbreSup15(n-9-t.getNbreSup50());
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
			t.setNbreSup15(n-9);
			if(t.getNbreSup15()>8) {
				t.setNbreSup40(t.getNbreSup15()-8);
				t.setNbreSup15(8);
				if(t.getNbreSup40()>6) {
					t.setNbreSup50(t.getNbreSup40()-6+t.getNbreSup50());
					t.setNbreSup40(6);
				} }
	  }
  }  
	  else {
		  t.setNbreHtNormale(9);
			
			t.setNbreSup50(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
			t.setNbreSup15(n-9-t.getNbreSup50());
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
		
		return t1;
	}

	@Override
	public Taches TachesCompletJoursSup(Taches t1, Taches t2) {
	
		 int n=0; 
		 Date	 debutwekend=tachesim.DebutSemaine(t1.getDateday());
		 
		 int regarde=tachesim.SommeSup15(debutwekend, t1.getDateday(), t1.getEmployer().getId());
		 int regarde2=tachesim.SommeSup40(debutwekend, t1.getDateday(), t1.getEmployer().getId());
		 n=NombreHeureJours(ConverteDate(t1.getDatedebut()),ConverteDate(t1.getDatefint()));
		 t1.setTotal_Heure(n);
		 System.out.println("on rentre avec db>0");
		 if(t1.getDatedebut().getHours()>0) {
			 if(t1.getDatedebut().getHours()<5) {
				 
				 
				  if(n<=9) {
					  t1.setNbreHtNormale(n);
				  }
				  else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=17&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
				  {
					  
					  
					  if(n<=9) {
						  t1.setNbreHtNormale(n);
						  
					  }
					  else {
						  
						  if(regarde<8) {
							  t1.setNbreHtNormale(9);
							  t1.setNbreSup15(n-9);
							  if(regarde+t1.getNbreSup15()>8) {
									t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
									t1.setNbreSup15(8-regarde);
									if(regarde2+t1.getNbreSup40()>6) {
										t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
										t1.setNbreSup40(6-regarde2);
									}
									
								}
							  
						  }
						  else if(regarde==8&&regarde2<6) {
							  t1.setNbreHtNormale(9);
							  t1.setNbreSup40(n-9);
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
								
							  
						  }
						  else {
							  t1.setNbreHtNormale(9);
							  t1.setNbreSup50(n-9);
						  }
						  
						  
					
					  }
					  
				  }
				  else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours()&&t1.getDatefint().getHours()>17)
				  {
					  if(t1.getDatefint().getHours()==23) {
						  if(regarde<8) {
							  t1.setNbreHtNormale(9);
							  t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
							  t1.setNbreSup15(n-9-t1.getNbreSup50());
							  if(regarde+t1.getNbreSup15()>8) {
								  t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								  t1.setNbreSup15(8-regarde);
								  if(regarde2+t1.getNbreSup40()>6) {
									  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									  t1.setNbreSup40(6-regarde2);
								  }

							  }


						  }
						  else if(regarde==8&&regarde2<6) {
							  t1.setNbreHtNormale(9);
							  t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
							  t1.setNbreSup40(n-9-t1.getNbreSup50());
							  if(regarde2+t1.getNbreSup40()>6) {
								  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								  t1.setNbreSup40(6-regarde2);
							  }

						  }
						  else {
							  t1.setNbreHtNormale(9);
							  t1.setNbreSup50(n-9);


						  }


					  }
					  else {
						  if(regarde<8) {
							  t1.setNbreHtNormale(9);
							  t1.setNbreSup15(n-9);
							  if(regarde+t1.getNbreSup15()>8) {
								  t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								  t1.setNbreSup15(8-regarde);
								  if(regarde2+t1.getNbreSup40()>6) {
									  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									  t1.setNbreSup40(6-regarde2);
								  }
							  }


						  }
						  else if(regarde==8&&regarde<6) {
							  t1.setNbreHtNormale(9);
							  t1.setNbreSup40(n-9);
							  if(regarde2+t1.getNbreSup40()>6) {
								  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								  t1.setNbreSup40(6-regarde2);
							  }
						  }
						  else {
							  t1.setNbreHtNormale(9);
							  t1.setNbreSup50(n-9);
						  }
					  }


				  }
				  else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=t1.getDatedebut().getHours()) {
					  if(t1.getDatefint().getHours()<=8) {
						  if(t1.getDatefint().getHours()<=5) {
							  if(n<=9) {
								  t1.setNbreHtNormale(n);

							  }
							  else {
								  if(regarde<8) {
									  t1.setNbreHtNormale(9);

									  t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
									  t1.setNbreSup15(n-(9+t1.getNbreSup50()));
									  if(regarde+t1.getNbreSup15()>8) {
										  t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
										  t1.setNbreSup15(8-regarde);
										  if(regarde2+t1.getNbreSup40()>6) {
											  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
											  t1.setNbreSup40(6-regarde2);
										  }

									  }

								  }
								  else if(regarde==8&&regarde2<6) {
									  t1.setNbreHtNormale(9);

									  t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
									  t1.setNbreSup40(n-(9+t1.getNbreSup50()));
									  if(regarde2+t1.getNbreSup40()>6) {
										  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
										  t1.setNbreSup40(6-regarde2);
									  }

								  }
								  else {
									  t1.setNbreHtNormale(9);

									  t1.setNbreSup50(n-9);
								  }

							  }
						  }
						  else {
							  if(n<=9) {
								  t1.setNbreHtNormale(n);
							  }
							  else {
								  if(regarde<8) {
									  t1.setNbreHtNormale(9);
									  t1.setNbreSup50(NombreHeureJours(79200,18000));
									  t1.setNbreSup15((n-9-t1.getNbreSup50())+(NombreHeureJours(18000,ConverteDate(t1.getDatefint()))));

									  if(regarde+t1.getNbreSup15()>8) {
										  t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
										  t1.setNbreSup15(8-regarde);
										  if(regarde2+t1.getNbreSup40()>6) {
											  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
											  t1.setNbreSup40(6-regarde2);
										  }}

								  }
								  else if(regarde==8&&regarde2<6) {
									  t1.setNbreHtNormale(9);
									  t1.setNbreSup50(NombreHeureJours(79200,18000));
									  t1.setNbreSup40((n-9-t1.getNbreSup50())+(NombreHeureJours(18000,ConverteDate(t1.getDatefint()))));
									  if(regarde2+t1.getNbreSup40()>6) {
										  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
										  t1.setNbreSup40(6-regarde2);
									  }
								  }
								  else {

									  t1.setNbreHtNormale(9);

									  t1.setNbreSup50(n-9);
								  }


							  }



						  }

					  }
				  }

				  else {
					  if(regarde<8) {

						  t1.setNbreHtNormale(9);

						  t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
						  t1.setNbreSup15(n-(9+t1.getNbreSup50()));
						  if(regarde+t1.getNbreSup15()>8) {
							  t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
							  t1.setNbreSup15(8-regarde);
							  if(regarde2+t1.getNbreSup40()>6) {
								  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								  t1.setNbreSup40(6-regarde2);
							  }

						  }

					  }
					  else  if(regarde==8&& regarde2<6) {

						  t1.setNbreHtNormale(9);

						  t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
						  t1.setNbreSup40(n-(9+t1.getNbreSup50()));
						  if(regarde2+t1.getNbreSup40()>6) {
							  t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
							  t1.setNbreSup40(6-regarde2);
						  }

					  }
					  else {
						  t1.setNbreHtNormale(9);
						  t1.setNbreSup50(n-9);

					  }



				  }
				 
			 }
			 else  if(t1.getDatedebut().getHours()==8) {
				 if(n<=9) {
					 t1.setNbreHtNormale(n);
				 }
				 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours()&&t1.getDatefint().getHours()>17)
				 {
					 if(t1.getDatefint().getHours()==23) {
					 	if(regarde<8){
							t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()),61200));
							t1.setNbreSup15(NombreHeureJours(61200,79200));
							t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
							if(regarde+t1.getNbreSup15()>8) {
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}

							}

						}
					 	else if(regarde==8&&regarde2<6){
							t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()),61200));
							t1.setNbreSup40(NombreHeureJours(61200,79200));
							t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
					 	else{
					 		t1.setNbreHtNormale(9);
					 		t1.setNbreSup50(n-9);
						}



					 }
					 else {
					 	if(regarde<8){
							t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()),61200));
							t1.setNbreSup15(NombreHeureJours(61200,ConverteDate(t1.getDatefint())));
							if(regarde+t1.getNbreSup15()>8) {
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}

							}

						}
					 	else if(regarde==8&&regarde2<6){
							t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()),61200));
							t1.setNbreSup40(NombreHeureJours(61200,ConverteDate(t1.getDatefint())));
							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
					 	else {
					 		t1.setNbreHtNormale(9);
					 		t1.setNbreSup50(n-9);
						}


					 }



				 }
				 /*datefin>0*/
				 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=t1.getDatedebut().getHours())
				 {
				 	if (n<=9){
				 		t1.setNbreHtNormale(n);
					}
					else if(t1.getDatefint().getHours()<=8) {
						 if(t1.getDatefint().getHours()<=5) {
						 	if (regarde<8){
								t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()),61200));
								t1.setNbreSup15(NombreHeureJours(61200,79200));
								t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
								if(regarde+t1.getNbreSup15()>8) {
									t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
									t1.setNbreSup15(8-regarde);
									if(regarde2+t1.getNbreSup40()>6) {
										t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
										t1.setNbreSup40(6-regarde2);
									}

								}
							}
						 	else if(regarde==8&&regarde2<6){
								t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()),61200));
								t1.setNbreSup40(NombreHeureJours(61200,79200));
								t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}
						 	else{
						 		t1.setNbreHtNormale(9);
						 		t1.setNbreSup50(n-9);
							}


						 }
						 else {
						 	if (regarde<8) {
								t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()), 61200));
								t1.setNbreSup15(NombreHeureJours(61200, 79200));
								t1.setNbreSup50(NombreHeureJours(79200, 18000));
								t1.setNbreSup15(t1.getNbreSup15() + (NombreHeureJours(18000, ConverteDate(t1.getDatefint()))));
								if (regarde+t1.getNbreSup15() > 8) {
									t1.setNbreSup40(regarde+t1.getNbreSup15() - 8);
									t1.setNbreSup15(8-regarde);
									if (regarde2+t1.getNbreSup40() > 6) {
										t1.setNbreSup50(regarde2+t1.getNbreSup40() - 6 + t1.getNbreSup50());
										t1.setNbreSup40(6-regarde2);
									}

								}
							}
						 	else if (regarde==8&&regarde2<6){
								t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()), 61200));
								t1.setNbreSup40(NombreHeureJours(61200, 79200));
								t1.setNbreSup50(NombreHeureJours(79200, 18000));
								t1.setNbreSup40(t1.getNbreSup40() + (NombreHeureJours(18000, ConverteDate(t1.getDatefint()))));
								if (regarde2+t1.getNbreSup40() > 6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40() - 6 + t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}
						 	else{
						 		t1.setNbreHtNormale(9);
						 		t1.setNbreSup50(n-9);
							}



						 }

					 }
				 }
				 else {
				 	if (regarde<8){
						t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()),61200));
						t1.setNbreSup15(NombreHeureJours(61200,79200));
						t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));

						if(regarde+t1.getNbreSup15()>8) {
							t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
							t1.setNbreSup15(8-regarde);
							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}
					}
				 	else if (regarde==8&&regarde2<6){
						t1.setNbreHtNormale(NombreHeureJours(ConverteDate(t1.getDatedebut()),61200));
						t1.setNbreSup40(NombreHeureJours(61200,79200));
						t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
						if(regarde2+t1.getNbreSup40()>6) {
							t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);
						}


					}
				 	else{
				 		t1.setNbreHtNormale(9);
				 		t1.setNbreSup50(n-9);
					}



				 }

			 }
			 else if(t1.getDatedebut().getHours()==5) {
				 if(n<=9) {
					 t1.setNbreHtNormale(n);
				 }
				 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=17&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
				 {

					 if(n<=9) {
						 t1.setNbreHtNormale(n);

					 }
					 else {
					 	if (regarde<8) {
							t1.setNbreHtNormale(9);
							t1.setNbreSup15(n - 9);
							if (regarde + t1.getNbreSup15() > 8) {
								t1.setNbreSup40(regarde + t1.getNbreSup15() - 8);
								t1.setNbreSup15(8 - regarde);
								if (regarde2 + t1.getNbreSup40() > 6) {
									t1.setNbreSup50(regarde2 + t1.getNbreSup40() - 6 + t1.getNbreSup50());
									t1.setNbreSup40(6 - regarde2);
								}

							}
						}
					 	else  if (regarde==8&&regarde2<6){
							t1.setNbreHtNormale(9);
							t1.setNbreSup40(n - 9);
							if (regarde2 + t1.getNbreSup40() > 6) {
								t1.setNbreSup50(regarde2 + t1.getNbreSup40() - 6 + t1.getNbreSup50());
								t1.setNbreSup40(6 - regarde2);
							}

						}
					 	else{
							t1.setNbreHtNormale(9);
							t1.setNbreSup50(n - 9);
						}
					 }

				 }
				 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours()&&t1.getDatefint().getHours()>17)
				 {
					 if(t1.getDatefint().getHours()==23) {
					 	if (regarde<8){
							t1.setNbreHtNormale(9);

							t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
							t1.setNbreSup15(n-9-t1.getNbreSup50());
							if(regarde+t1.getNbreSup15()>8) {
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}

							}
						}
					 	else  if (regarde==8&&regarde2<6){
							t1.setNbreHtNormale(9);

							t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
							t1.setNbreSup40(n-9-t1.getNbreSup50());
							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}
					 	else{
							t1.setNbreHtNormale(9);
							t1.setNbreSup50(n-9);
						}


					 }
					 else {
						 if (regarde < 8) {

							 t1.setNbreHtNormale(9);
							 t1.setNbreSup15(n - 9);
							 if (t1.getNbreSup15() > 8) {
								 t1.setNbreSup40(t1.getNbreSup15() - 8);
								 t1.setNbreSup15(8);
								 if (t1.getNbreSup40() > 6) {
									 t1.setNbreSup50(t1.getNbreSup40() - 6 + t1.getNbreSup50());
									 t1.setNbreSup40(6);
								 }

							 }
						 }
						 else if (regarde==8&&regarde2<6){
							 t1.setNbreHtNormale(9);
							 t1.setNbreSup40(n - 9);
							 if (t1.getNbreSup40() > 6) {
								 t1.setNbreSup50(t1.getNbreSup40() - 6 + t1.getNbreSup50());
								 t1.setNbreSup40(6);
							 }
						 }
						 else
						 {
						 	t1.setNbreHtNormale(9);
						 	t1.setNbreSup50(n-9);
						 }
					 }

				 }
				 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=t1.getDatedebut().getHours())
				 {
					 if(t1.getDatefint().getHours()<=8) {
						 if(t1.getDatefint().getHours()<=5) {
						 	if (regarde<8){
								t1.setNbreHtNormale(9);

								t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
								t1.setNbreSup15(n-(9+t1.getNbreSup50()));
								if(regarde+t1.getNbreSup15()>8) {
									t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
									t1.setNbreSup15(8-regarde);
									if(regarde2+t1.getNbreSup40()>6) {
										t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
										t1.setNbreSup40(6-regarde2);
									}

								}
							}
						 	else if (regarde==8&&regarde2<6){
								t1.setNbreHtNormale(9);

								t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
								t1.setNbreSup40(n-(9+t1.getNbreSup50()));
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}
						 	else
							{
								t1.setNbreHtNormale(9);
								t1.setNbreSup50(n-9);
							}


						 }
						 else {
						 	if (regarde<8){
							 t1.setNbreHtNormale(9);

							 t1.setNbreSup50(NombreHeureJours(79200,18000));

							 t1.setNbreSup15(n-(9+t1.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
							 if(regarde+t1.getNbreSup15()>8) {
								 t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								 t1.setNbreSup15(8-regarde);
								 if(regarde2+t1.getNbreSup40()>6) {
									 t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									 t1.setNbreSup40(6-regarde2);
								 }

							 }

						 	}
						 	else if (regarde==8&&regarde2<8){
								t1.setNbreHtNormale(9);

								t1.setNbreSup50(NombreHeureJours(79200,18000));

								t1.setNbreSup40(n-(9+t1.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}

							}
						 	else
							{
								t1.setNbreHtNormale(9);
								t1.setNbreSup50(n-9);
							}



						 }

					 }
				 }
				 else {
				 	if (regarde<8) {
						t1.setNbreHtNormale(9);

						t1.setNbreSup50(NombreHeureJours(79200, 18000));

						t1.setNbreSup15(n - (9 + t1.getNbreSup50()) + NombreHeureJours(18000, ConverteDate(t1.getDatefint())));
						if (regarde+t1.getNbreSup15() > 8) {
							t1.setNbreSup40(regarde+t1.getNbreSup15() - 8);
							t1.setNbreSup15(8-regarde);
							if (regarde2+t1.getNbreSup40() > 6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40() - 6 + t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}
					}
				 	else if (regarde==8&&regarde2<6){
						t1.setNbreHtNormale(9);

						t1.setNbreSup50(NombreHeureJours(79200, 18000));

						t1.setNbreSup40(n - (9 + t1.getNbreSup50()) + NombreHeureJours(18000, ConverteDate(t1.getDatefint())));
						if (regarde2+t1.getNbreSup40() > 6) {
							t1.setNbreSup50(regarde2+t1.getNbreSup40() - 6 + t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);
						}
					}
				 	else
					{
						t1.setNbreHtNormale(9);
						t1.setNbreSup50(n-9);
					}


				 }


			 }
			 else {
				 if(n<=9) {
					 t1.setNbreHtNormale(n);
				 }
				 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours()&&t1.getDatefint().getHours()>17)
				 {
					 if(t1.getDatefint().getHours()==23) {
					 	if (regarde<8) {
							t1.setNbreHtNormale(9);

							t1.setNbreSup50(NombreHeureJours(79200, ConverteDate(t1.getDatefint())));
							t1.setNbreSup15(n - 9 - t1.getNbreSup50());
							if (regarde+t1.getNbreSup15() > 8) {
								t1.setNbreSup40(regarde+t1.getNbreSup15() - 8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40() > 6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40() - 6 + t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}

							}
						}
					 	else if(regarde==8&&regarde2<6){
							t1.setNbreHtNormale(9);

							t1.setNbreSup50(NombreHeureJours(79200, ConverteDate(t1.getDatefint())));
							t1.setNbreSup40(n - 9 - t1.getNbreSup50());
							if (regarde2+t1.getNbreSup40() > 6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40() - 6 + t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}
					 	else
						{
							t1.setNbreHtNormale(9);
							t1.setNbreSup50(n-9);
						}

					 }
					 else {
					 	if (regarde<8){
							t1.setNbreHtNormale(9);
							t1.setNbreSup15(n-9);
							if(regarde+t1.getNbreSup15()>8) {
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}

							}
						}
					 	else if (regarde==8&&regarde2<6){
							t1.setNbreHtNormale(9);
							t1.setNbreSup40(n-9);
							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}
					 	else{
					 		t1.setNbreHtNormale(9);
					 		t1.setNbreSup50(n-9);
						}


					 }

				 }
				 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=t1.getDatedebut().getHours())
				 {
					 if(t1.getDatefint().getHours()<=8) {
						 if(t1.getDatefint().getHours()<=5) {
						 	if (regarde<8){
								t1.setNbreHtNormale(9);

								t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
								t1.setNbreSup15(n-(9+t1.getNbreSup50()));
								if(regarde+t1.getNbreSup15()>8) {
									t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
									t1.setNbreSup15(8-regarde);
									if(regarde2+t1.getNbreSup40()>6) {
										t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
										t1.setNbreSup40(6-regarde2);
									}

								}
							}
						 	else if (regarde==8&&regarde2<6){
								t1.setNbreHtNormale(9);

								t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
								t1.setNbreSup40(n-(9+t1.getNbreSup50()));
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}
						 	else {
						 		t1.setNbreHtNormale(9);
						 		t1.setNbreSup50(n-9);
							}


						 }
						 else {
						 	if (regarde<8){
								t1.setNbreHtNormale(9);

								t1.setNbreSup50(NombreHeureJours(79200,18000));

								t1.setNbreSup15(n-(9+t1.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
								if(regarde+t1.getNbreSup15()>8) {
									t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
									t1.setNbreSup15(8-regarde);
									if(regarde2+t1.getNbreSup40()>6) {
										t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
										t1.setNbreSup40(6-regarde2);
									}

								}
							}
						 	else if (regarde==8&&regarde2<6){
								t1.setNbreHtNormale(9);

								t1.setNbreSup50(NombreHeureJours(79200,18000));

								t1.setNbreSup40(n-(9+t1.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}
						 	else {
						 		t1.setNbreHtNormale(9);
						 		t1.setNbreSup50(n-9);
							}




						 }

					 }
				 }
				 else if(t1.getDatefint().getHours()==0) {
					 if(n<=9) {
						 t1.setNbreHtNormale(n);
					 }
					 else {
					 	if (regarde<8){

							t1.setNbreHtNormale(9);

							t1.setNbreSup50(NombreHeureJours(79200,0));
							t1.setNbreSup15(n-9-t1.getNbreSup50());
							if(regarde+t1.getNbreSup15()>8) {
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}

							}

						}
					 	else if (regarde==8&&regarde2<6){
							t1.setNbreHtNormale(9);

							t1.setNbreSup50(NombreHeureJours(79200,0));
							t1.setNbreSup40(n-9-t1.getNbreSup50());
							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}
					 	else {
					 		t1.setNbreHtNormale(9);
					 		t1.setNbreSup50(n-9);
						}

					 }

				 }
				 else {
					 if(n<=9) {
						 t1.setNbreHtNormale(n);

					 }
					 else {
						 if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours()&&t1.getDatefint().getHours()>17)
						 {
							 if(t1.getDatefint().getHours()==23) {
							 	if (regarde<8){
									t1.setNbreHtNormale(9);

									t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
									t1.setNbreSup15(n-9-t1.getNbreSup50());
									if(regarde+t1.getNbreSup15()>8) {
										t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
										t1.setNbreSup15(8-regarde);
										if(regarde2+t1.getNbreSup40()>6) {
											t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
											t1.setNbreSup40(6-regarde2);
										}

									}
								}
							 	else if (regarde==8&&regarde2<6){
									t1.setNbreHtNormale(9);

									t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
									t1.setNbreSup40(n-9-t1.getNbreSup50());
									if(regarde2+t1.getNbreSup40()>6) {
										t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
										t1.setNbreSup40(6-regarde2);
									}
								}
							 	else
							 		{
							 			t1.setNbreHtNormale(9);
							 			t1.setNbreSup50(n-9);
									}



							 }
							 else {
							 	if (regarde<8){
									t1.setNbreHtNormale(9);
									t1.setNbreSup15(n-9);
									if(regarde+t1.getNbreSup15()>8) {
										t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
										t1.setNbreSup15(8-regarde);
										if(regarde2+t1.getNbreSup40()>6) {
											t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
											t1.setNbreSup40(6-regarde2);
										}

									}
								}
							 	else  if (regarde==8&&regarde2<6){
									t1.setNbreHtNormale(9);
									t1.setNbreSup40(n-9);
									if(regarde2+t1.getNbreSup40()>6) {
										t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
										t1.setNbreSup40(6-regarde2);
									}

								}
							 	else {
							 		t1.setNbreSup50(n-9);
							 		t1.setNbreHtNormale(9);
								}


							 }



						 }
						 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=t1.getDatedebut().getHours())
						 {
							 if(t1.getDatefint().getHours()<=8) {
								 if(t1.getDatefint().getHours()<=5) {
								 	if (regarde<8){

										t1.setNbreHtNormale(9);

										t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
										t1.setNbreSup15(n-(9+t1.getNbreSup50()));
										if(regarde+t1.getNbreSup15()>8) {
											t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
											t1.setNbreSup15(8-regarde);
											if(regarde2+t1.getNbreSup40()>6) {
												t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
												t1.setNbreSup40(6-regarde2);
											}

										}
									}
								 	else if (regarde==8&&regarde2<6){
										t1.setNbreHtNormale(9);

										t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
										t1.setNbreSup40(n-(9+t1.getNbreSup50()));
										if(regarde2+t1.getNbreSup40()>6) {
											t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
											t1.setNbreSup40(6-regarde2);
										}

									}
								 	else {
								 		t1.setNbreHtNormale(9);
								 		t1.setNbreSup50(n-9);
									}

								 }
								 else {
								 	if (regarde<8){
										t1.setNbreHtNormale(9);

										t1.setNbreSup50(NombreHeureJours(79200,18000));

										t1.setNbreSup15(n-(9+t1.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
										if(regarde+t1.getNbreSup15()>8) {
											t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
											t1.setNbreSup15(8-regarde);
											if(regarde2+t1.getNbreSup40()>6) {
												t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
												t1.setNbreSup40(6-regarde2);
											}

										}
									}
								 	else  if (regarde==8&&regarde2<6){
										t1.setNbreHtNormale(9);

										t1.setNbreSup50(NombreHeureJours(79200,18000));

										t1.setNbreSup40(n-(9+t1.getNbreSup50())+NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
										if(regarde2+t1.getNbreSup40()>6) {
											t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
											t1.setNbreSup40(6-regarde2);
										}
									}
								 	else {
								 		t1.setNbreSup50(n-9);
								 		t1.setNbreHtNormale(9);
									}




								 }

							 }
						 }
					 }
				 }
			 }

			 
			 
		 }
		 else {
			 if(n<=9) {
				 t1.setNbreHtNormale(n);

			 }
			 else {
				 if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=17&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
				 {
					 if(n<=9) {
						 t1.setNbreHtNormale(n);

					 }
					 else {
					 	if (regarde<8){
							t1.setNbreHtNormale(9);
							t1.setNbreSup15(n-9);
							if(regarde+t1.getNbreSup15()>8) {
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}

							}
						}
					 	else if (regarde==8&&regarde2<6){
							t1.setNbreHtNormale(9);
							t1.setNbreSup40(n-9);
							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
					 	else {
					 		t1.setNbreHtNormale(9);
					 		t1.setNbreSup50(n-9);
						}

					 }

				 }
				 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours()&&t1.getDatefint().getHours()>17)
				 {
					 if(t1.getDatefint().getHours()==23) {
					 	if (regarde<8){
							t1.setNbreHtNormale(9);

							t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
							t1.setNbreSup15(n-9-t1.getNbreSup50());
							if(regarde+t1.getNbreSup15()>8) {
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}

							}
						}
					 	else if (regarde==8&&regarde2<6){
							t1.setNbreHtNormale(9);

							t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
							t1.setNbreSup40(n-9-t1.getNbreSup50());
							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
					 	else {
					 		t1.setNbreHtNormale(9);
					 		t1.setNbreSup50(n-9);
						}


					 }
					 else {
					 	if (regarde<8){
							t1.setNbreHtNormale(9);
							t1.setNbreSup15(n-9);
							if(regarde+t1.getNbreSup15()>8) {
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if(regarde2+t1.getNbreSup40()>6) {
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								} }

						}
					 	else if (regarde==8&&regarde2<6){
							t1.setNbreHtNormale(9);
							t1.setNbreSup40(n-9);

							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
					 	else {
					 		t1.setNbreSup50(n-9);
					 		t1.setNbreHtNormale(9);
						}


					 }
				 }
				 else {
				 	if (regarde<8){
						t1.setNbreHtNormale(9);
						t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
						t1.setNbreSup15(n-9-t1.getNbreSup50());
						if(regarde+t1.getNbreSup15()>8) {
							t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
							t1.setNbreSup15(8-regarde);
							if(regarde2+t1.getNbreSup40()>6) {
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
					}
				 	else if (regarde==8&&regarde2<6){
						t1.setNbreHtNormale(9);
						t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
						t1.setNbreSup40(n-9-t1.getNbreSup50());
						if(regarde2+t1.getNbreSup40()>6) {
							t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);
						}
					}
				 	else {
				 		t1.setNbreHtNormale(9);
				 		t1.setNbreSup50(n-9);
					}


				 }


			 }
		 }
		 
		 
		return t1;
	}

	@Override
	public Taches vider(Taches t) {
		// TODO Auto-generated method stub
		return null;
	}
/*******************************************************************************************************************************/
	  @Override
	  public Taches HeureSupSecuriter(Taches t1, Taches t2) {
		  int n=NombreHeureJours(ConverteDate(t1.getDatedebut()),ConverteDate(t1.getDatefint()));
		System.out.println("ona rentrer dans la fonction HeureSupSecuriter");
		t1.setTotal_Heure(n);
		if (t1!=null &&t2==null){
			System.out.println("tach2==null");
			t1.setNbreHtNormale(n);


		}
		else if (t1!=null&&tachesim.DebutSemaine(t1.getDateday())==null){
			System.out.println("tdebut wekkend");
			t1.setNbreHtNormale(n);

		}
		else {System.out.println("dans le plus part ");

			Date	 debutwekend=tachesim.DebutSemaine(t1.getDateday());

			int regarde=tachesim.SommeSup15(debutwekend, t1.getDateday(), t1.getEmployer().getId());
			int regarde2=tachesim.SommeSup40(debutwekend, t1.getDateday(), t1.getEmployer().getId());
			int nbreHeureSecurity=tachesim.SommeHeureNormaleSecuriter(t1.getEmployer().getId(),debutwekend,t1.getDateday());

			t1.setTotal_Heure(n);
			if ((nbreHeureSecurity+n)<=40){
				t1.setNbreHtNormale(n);

			}
			else {
				if (nbreHeureSecurity==40){
					t1=this.HeureSupSecuriterparticuliers(t1,t2);


				}
				else {
					System.out.println("dans la plus part ");
					if (t1.getDatedebut().getHours()>0){
						System.out.println("commence >0 ");
						if (t1.getDatedebut().getHours()<5){
							System.out.println("commence <5");
							if (t1.getDatefint().getHours()<=23&&t1.getDatefint().getHours()>t1.getDatedebut().getHours())
							{
								if (t1.getDatefint().getHours()==23){
									if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
										t1.setNbreSup50(1);
										t1.setNbreHtNormale(40-nbreHeureSecurity);
										t1.setNbreSup15(n-t1.getNbreSup50()-t1.getNbreHtNormale());
										if(t1.getNbreSup15()>8){
											t1.setNbreSup40(t1.getNbreSup15()-8);
											t1.setNbreSup15(8);
											if (t1.getNbreSup40()>6){
												t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
												t1.setNbreSup40(6);
											}

										}
									}
									else {
										t1.setNbreSup50(1);
										t1.setNbreHtNormale(n-1);

									}
								}
								else {
									t1.setNbreHtNormale(40-nbreHeureSecurity);
									t1.setNbreSup15(n-t1.getNbreHtNormale());
									if(t1.getNbreSup15()>8){
										t1.setNbreSup40(t1.getNbreSup15()-8);
										t1.setNbreSup15(8);
										if (t1.getNbreSup40()>6){
											t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
											t1.setNbreSup40(6);
										}

									}

								}

							}


						else if (t1.getDatefint().getHours()<=8&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
							{
								if (t1.getDatefint().getHours()<=5) {
									t1.setNbreHtNormale(40 - nbreHeureSecurity);
									t1.setNbreSup50(n - t1.getNbreHtNormale());
								}
								else {
									if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),18000)<40){
										t1.setNbreHtNormale(40-nbreHeureSecurity);
										t1.setNbreSup15(n-t1.getNbreHtNormale());
										if(t1.getNbreSup15()>8){
											t1.setNbreSup40(t1.getNbreSup15()-8);
											t1.setNbreSup15(8);
											if (t1.getNbreSup40()>6){
												t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
												t1.setNbreSup40(6);
											}

										}
									}
									else if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),18000)==40){

										t1.setNbreSup15(NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
										t1.setNbreHtNormale(n-t1.getNbreSup15());
										if(t1.getNbreSup15()>8){
											t1.setNbreSup40(t1.getNbreSup15()-8);
											t1.setNbreSup15(8);
											if (t1.getNbreSup40()>6){
												t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
												t1.setNbreSup40(6);
											}

										}
									}
									else {
										t1.setNbreSup15(NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
										t1.setNbreHtNormale(40-nbreHeureSecurity);
										t1.setNbreSup50(n-t1.getNbreSup15()-t1.getNbreSup50());
										if(t1.getNbreSup15()>8){
											t1.setNbreSup40(t1.getNbreSup15()-8);
											t1.setNbreSup15(8);
											if (t1.getNbreSup40()>6){
												t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
												t1.setNbreSup40(6);
											}

										}

									}

								}



							}
							else {
								System.out.println("on a df=0");
								if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)<40){
									System.out.println("on a apre 22 on a 40");
									t1.setNbreHtNormale(40-nbreHeureSecurity)	;
									t1.setNbreSup50(n- t1.getNbreHtNormale());


								}
								else  if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)==40){
									t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
									t1.setNbreHtNormale(n-t1.getNbreSup50());
									System.out.println("on a  22 on a 40");

								}
								else {
									System.out.println("nbreheure"+nbreHeureSecurity);
									t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
									t1.setNbreHtNormale(40-nbreHeureSecurity);
									t1.setNbreSup15(n-t1.getNbreSup50()-t1.getNbreHtNormale());
									if(t1.getNbreSup15()>8){
										t1.setNbreSup40(t1.getNbreSup15()-8);
										t1.setNbreSup15(8);
										if (t1.getNbreSup40()>6){
											t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
											t1.setNbreSup40(6);
										}

									}
									System.out.println("on a avant 22 on a 40");
								}



							}

						}
						else	if (t1.getDatedebut().getHours()==5){
							System.out.println("commence de 5");
							if (nbreHeureSecurity+n<=40){
								t1.setNbreHtNormale(n);
							}
							else{
								if (nbreHeureSecurity==40){
									t1=this.HeureSupSecuriterparticuliers(t1,t2);

								}
								else {
									 if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
									 {
									 	if (t1.getDatefint().getHours()==23){
									 		if ((nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40)){
									 			t1.setNbreSup50(1);
									 			t1.setNbreHtNormale(40-nbreHeureSecurity);
									 			t1.setNbreSup15(n-t1.getNbreSup50()-t1.getNbreHtNormale());
												if(t1.getNbreSup15()>8){
													t1.setNbreSup40(t1.getNbreSup15()-8);
													t1.setNbreSup15(8);
													if (t1.getNbreSup40()>6){
														t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
														t1.setNbreSup40(6);
													}

												}

											}
											else{
												t1.setNbreSup50(1);
												t1.setNbreHtNormale(n-1);
											}
										}
									 	else{
									 		t1.setNbreHtNormale(40-nbreHeureSecurity);
									 		t1.setNbreSup15(n-t1.getNbreHtNormale());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}

										}
									}
									 else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=t1.getDatedebut().getHours())
									 {

									 		if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
									 			t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
									 			t1.setNbreHtNormale(40-nbreHeureSecurity);
									 			t1.setNbreSup15(n-t1.getNbreSup50()-t1.getNbreHtNormale());
												if(t1.getNbreSup15()>8){
													t1.setNbreSup40(t1.getNbreSup15()-8);
													t1.setNbreSup15(8);
													if (t1.getNbreSup40()>6){
														t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
														t1.setNbreSup40(6);
													}

												}
											}
									 		else{
									 			t1.setNbreHtNormale(40-nbreHeureSecurity);
									 			t1.setNbreSup50(n-t1.getNbreHtNormale());
											}





									 }
									 else {
									 	System.out.println("commence de 05 -00");
										 if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
											 t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
											 t1.setNbreHtNormale(40-nbreHeureSecurity);
											 t1.setNbreSup15(n-t1.getNbreSup50()-t1.getNbreHtNormale());
											 if(t1.getNbreSup15()>8){
												 t1.setNbreSup40(t1.getNbreSup15()-8);
												 t1.setNbreSup15(8);
												 if (t1.getNbreSup40()>6){
													 t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													 t1.setNbreSup40(6);
												 }

											 }
										 }
										 else{
											 t1.setNbreHtNormale(40-nbreHeureSecurity);
											 t1.setNbreSup15(n-t1.getNbreHtNormale());
											 if(t1.getNbreSup15()>8){
												 t1.setNbreSup40(t1.getNbreSup15()-8);
												 t1.setNbreSup15(8);
												 if (t1.getNbreSup40()>6){
													 t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													 t1.setNbreSup40(6);
												 }

											 }
										 }
									 }

								}
							}



						}
						else if (t1.getDatedebut().getHours()==8){
							System.out.println("commence de 08");
							if (nbreHeureSecurity+n<=40){
								t1.setNbreHtNormale(n);
							}
							else {
								if (nbreHeureSecurity==40){


									return HeureSupSecuriterparticuliers(t1,t2);
								}
								else {
									if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
									{
										if (t1.getDatefint().getHours() == 23) {
											if ((nbreHeureSecurity + NombreHeureJours(ConverteDate(t1.getDatedebut()), 79200) > 40)) {
												t1.setNbreSup50(1);
												t1.setNbreHtNormale(40 - nbreHeureSecurity);
												t1.setNbreSup15(n - t1.getNbreSup50() - t1.getNbreHtNormale());
												if(t1.getNbreSup15()>8){
													t1.setNbreSup40(t1.getNbreSup15()-8);
													t1.setNbreSup15(8);
													if (t1.getNbreSup40()>6){
														t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
														t1.setNbreSup40(6);
													}

												}
											} else {
												t1.setNbreSup50(1);
												t1.setNbreHtNormale(n - 1);
											}
										} else {

												t1.setNbreHtNormale(40 - nbreHeureSecurity);
											t1.setNbreSup15(n - t1.getNbreHtNormale());
											if (t1.getNbreSup15() > 8) {
												t1.setNbreSup40(t1.getNbreSup15() - 8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40() > 6) {
													t1.setNbreSup50(t1.getNbreSup40() - 6 + t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}

										}
									}
									else if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=t1.getDatedebut().getHours())
									{
										if (t1.getDatefint().getHours()<=5){
											if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
												t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
												t1.setNbreHtNormale(40-nbreHeureSecurity);
												t1.setNbreSup15(n-t1.getNbreSup50()-t1.getNbreHtNormale());
												if(t1.getNbreSup15()>8){
													t1.setNbreSup40(t1.getNbreSup15()-8);
													t1.setNbreSup15(8);
													if (t1.getNbreSup40()>6){
														t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
														t1.setNbreSup40(6);
													}

												}
											}

											else{
												t1.setNbreHtNormale(40-nbreHeureSecurity);
												t1.setNbreSup15(n-t1.getNbreHtNormale());
												if(t1.getNbreSup15()>8){
													t1.setNbreSup40(t1.getNbreSup15()-8);
													t1.setNbreSup15(8);
													if (t1.getNbreSup40()>6){
														t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
														t1.setNbreSup40(6);
													}

												}
											}



										}
										else {
											if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
												t1.setNbreSup50(NombreHeureJours(79200,18000));
												t1.setNbreHtNormale(40-nbreHeureSecurity);
												t1.setNbreSup15(n-t1.getNbreSup50()-t1.getNbreHtNormale());
												if(t1.getNbreSup15()>8){
													t1.setNbreSup40(t1.getNbreSup15()-8);
													t1.setNbreSup15(8);
													if (t1.getNbreSup40()>6){
														t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
														t1.setNbreSup40(6);
													}

												}
											}
											else{
												if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),18000)>40){
													t1.setNbreSup15(NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
													t1.setNbreHtNormale(40-nbreHeureSecurity);
													t1.setNbreSup50(n-t1.getNbreSup15()-t1.getNbreHtNormale());
													if(t1.getNbreSup15()>8){
														t1.setNbreSup40(t1.getNbreSup15()-8);
														t1.setNbreSup15(8);
														if (t1.getNbreSup40()>6){
															t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
															t1.setNbreSup40(6);
														}

													}
												}
												else {
													t1.setNbreHtNormale(40-nbreHeureSecurity);
													t1.setNbreSup15(n-t1.getNbreHtNormale());
													if(t1.getNbreSup15()>8){
														t1.setNbreSup40(t1.getNbreSup15()-8);
														t1.setNbreSup15(8);
														if (t1.getNbreSup40()>6){
															t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
															t1.setNbreSup40(6);
														}

													}
												}

											}

										}

									}
									else {
										System.out.println("commence de 08-00");
										if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
											t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup15(n-t1.getNbreSup50()-t1.getNbreHtNormale());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}
										}
										else{
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(n-t1.getNbreHtNormale());

										}


									}




								}

							}


						}
						else
						{
							System.out.println("commence autre cas ");
							if (nbreHeureSecurity+n<=40){
								t1.setNbreHtNormale(n);

							}
							else
							{
								if (nbreHeureSecurity==40){
									t1=this.HeureSupSecuriterparticuliers(t1,t2);

								}
								else {
									if (t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatefint().getHours()>t1.getDatedebut().getHours()){
										if (t1.getDatefint().getHours()==23){
											if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
												t1.setNbreHtNormale(40-nbreHeureSecurity);
												t1.setNbreSup50(1);
												t1.setNbreSup15(n-t1.getNbreHtNormale()-1);
												if(t1.getNbreSup15()>8){
													t1.setNbreSup40(t1.getNbreSup15()-8);
													t1.setNbreSup15(8);
													if (t1.getNbreSup40()>6){
														t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
														t1.setNbreSup40(6);
													}

												}
											}
											else{
												t1.setNbreHtNormale(40-nbreHeureSecurity);
												t1.setNbreSup50(n-t1.getNbreHtNormale());
											}

										}
										else {

											t1.setNbreHtNormale(40-nbreHeureSecurity);

											t1.setNbreSup15(n-t1.getNbreHtNormale());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}



										}

									}
									else if (t1.getDatefint().getHours()==0){
										if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(2);
											t1.setNbreSup15(n-t1.getNbreHtNormale()-2);
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}
										}
										else{
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(n-t1.getNbreHtNormale());
										}



									}
									else if (t1.getDatefint().getHours()<=5){
										if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
											t1.setNbreSup15(n-t1.getNbreHtNormale()-t1.getNbreSup50());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}
										}
										else{
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(n-t1.getNbreHtNormale());
										}


									}
									else {
										if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
											t1.setNbreSup15(n-t1.getNbreHtNormale()-t1.getNbreSup50());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}

										}
										else if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),18000)>40){
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup15(NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
											t1.setNbreSup50(n-t1.getNbreSup15()-t1.getNbreHtNormale());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}


										}
										else {
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup15(n-t1.getNbreHtNormale());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}
										}


									}


								}

							}





						}

					}
					else {
						System.out.println("commence de 0");
						if (nbreHeureSecurity+n<=40){
							t1.setNbreHtNormale(n);
						}
						else {
							if (nbreHeureSecurity==40){
								t1=this.HeureSupSecuriterparticuliers(t1,t2);

							}
							else {
								if(t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours()&&t1.getDatefint().getHours()>5)
								{
									if (t1.getDatefint().getHours()==23){
										if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),18000)>40){
											t1.setNbreSup15(NombreHeureJours(18000,79200));
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(n-t1.getNbreHtNormale()-t1.getNbreSup15());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}

										}
										else {
											if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40){
												t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
												t1.setNbreHtNormale(40-nbreHeureSecurity);
												t1.setNbreSup15(n-t1.getNbreHtNormale()-t1.getNbreSup50());
												if(t1.getNbreSup15()>8){
													t1.setNbreSup40(t1.getNbreSup15()-8);
													t1.setNbreSup15(8);
													if (t1.getNbreSup40()>6){
														t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
														t1.setNbreSup40(6);
													}

												}

											}
											else {

												t1.setNbreHtNormale(40-nbreHeureSecurity);
												t1.setNbreSup50(n-t1.getNbreHtNormale());
											}


										}


									}
									else {
										if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),18000)>40){
											t1.setNbreSup15(NombreHeureJours(18000,ConverteDate(t1.getDatefint())));
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(n-t1.getNbreHtNormale()-t1.getNbreSup15());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}

										}
										else {
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup15(n-t1.getNbreHtNormale());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}

										}



									}

								}
								else {
									if (t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=5){
										t1.setNbreHtNormale(40-nbreHeureSecurity);
										t1.setNbreSup50(n-t1.getNbreHtNormale());
									}
									else{
										if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),18000)>40)
										{
											t1.setNbreSup15(NombreHeureJours(18000,79200));
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(n-t1.getNbreHtNormale()-t1.getNbreSup15());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}
										}
										else if (nbreHeureSecurity+NombreHeureJours(ConverteDate(t1.getDatedebut()),79200)>40)
										{
											t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup15(n-t1.getNbreSup50()-t1.getNbreHtNormale());
											if(t1.getNbreSup15()>8){
												t1.setNbreSup40(t1.getNbreSup15()-8);
												t1.setNbreSup15(8);
												if (t1.getNbreSup40()>6){
													t1.setNbreSup50(t1.getNbreSup40()-6+t1.getNbreSup50());
													t1.setNbreSup40(6);
												}

											}



										}
										else {
											t1.setNbreHtNormale(40-nbreHeureSecurity);
											t1.setNbreSup50(n-t1.getNbreSup50());


										}


									}


								}

							}


						}



					}

				}



			}





		}





		  return t1;
	  }

	  @Override
	  public Taches HeureSupSecuriterparticuliers(Taches t1, Taches t2) {
		  int n=NombreHeureJours(ConverteDate(t1.getDatedebut()),ConverteDate(t1.getDatefint()));
		  System.out.println("ona rentrer dans la fonction HeureSupSecuriterparticuliers");
		  t1.setTotal_Heure(n);
		  Date	 debutwekend=tachesim.DebutSemaine(t1.getDateday());

		  int regarde=tachesim.SommeSup15(debutwekend, t1.getDateday(), t1.getEmployer().getId());
		  int regarde2=tachesim.SommeSup40(debutwekend, t1.getDateday(), t1.getEmployer().getId());
		  if (t1.getDatedebut().getHours()>0){
		  	if (t1.getDatedebut().getHours()<5){
		  		if (t1.getDatefint().getHours()>0&&t1.getDatedebut().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
				{
					if (t1.getDatefint().getHours()==23){
						if (regarde<8) {
							t1.setNbreSup15(NombreHeureJours(18000, 79200));
							t1.setNbreSup50(n - t1.getNbreSup15());
							if (regarde+t1.getNbreSup15()>8){
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}
						}
						else if (regarde==8&&regarde2<6){
							t1.setNbreSup40(NombreHeureJours(18000, 79200));
							t1.setNbreSup50(n - t1.getNbreSup15());
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(t1.getNbreSup40()+regarde2-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
						else {
							t1.setNbreSup50(n);
						}
					}
					else {
						if (regarde<8) {
							t1.setNbreSup50(NombreHeureJours(ConverteDate(t1.getDatedebut()), 18000));
							t1.setNbreSup15(n - t1.getNbreSup50());
							if (regarde+t1.getNbreSup15()>8){
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup40(t1.getNbreSup50()+regarde2-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}
						}
						else if (regarde==8&&regarde2<6){
							t1.setNbreSup50(NombreHeureJours(ConverteDate(t1.getDatedebut()), 18000));
							t1.setNbreSup40(n - t1.getNbreSup50());
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(t1.getNbreSup40()+regarde2-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
						else {
							t1.setNbreSup50(n);
						}
					}

				}
		  		else  if (t1.getDatefint().getHours()<=5&&t1.getDatefint().getHours()>0){
		  			t1.setNbreSup50(n);

				}
		  		else {
		  			if (regarde<8){
		  			t1.setNbreSup15(NombreHeureJours(18000,79200));
		  		t1.setNbreSup50(n-t1.getNbreSup15());
		  			if (regarde+t1.getNbreSup15()>8){
		  				t1.setNbreSup40(t1.getNbreSup15()+regarde-8);
		  				t1.setNbreSup15(8-regarde);
		  				if (regarde2+t2.getNbreSup40()>6){
		  					t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
		  					t1.setNbreSup40(6-regarde2);


						}
					}

		  			}
		  			else if (regarde==8&&regarde2<6){
						t1.setNbreSup40(NombreHeureJours(18000,79200));
						t1.setNbreSup50(n-t1.getNbreSup15());
						if (regarde2+t2.getNbreSup40()>6){
							t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);


						}
					}
		  			else {
		  				t1.setNbreSup50(n);
					}


				}

			}
		  	else if (t1.getDatedebut().getHours()==5){
				if (t1.getDatefint().getHours()>0&&t1.getDatedebut().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
				{
					if (t1.getDatefint().getHours()==23){
						if (regarde<8) {
							t1.setNbreSup15(NombreHeureJours(18000, 79200));
							t1.setNbreSup50(n - t1.getNbreSup15());
							if (regarde+t1.getNbreSup15()>8){
								t1.setNbreSup40(t1.getNbreSup15()+regarde-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(t1.getNbreSup40()+regarde2-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}
						}
						else if (regarde==8&&regarde2<6){
							t1.setNbreSup40(NombreHeureJours(18000, 79200));
							t1.setNbreSup50(n - t1.getNbreSup15());
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(t1.getNbreSup40()+regarde2-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}
						else {
							t1.setNbreSup50(n);
						}
					}
					else {
						if (regarde<8) {

							t1.setNbreSup15(n);
							if (t1.getNbreSup15()+regarde>8){
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6);
									t1.setNbreSup40(6-regarde2);
								}
							}
						}
						else if(regarde==8&&regarde2<6){
							t1.setNbreSup40(n);
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6);
								t1.setNbreSup40(6-regarde2);
							}
						}
						else {
							t1.setNbreSup50(n);
						}

					}

				}
				else  if (t1.getDatefint().getHours()<=5&&t1.getDatefint().getHours()>0){
					if (t1.getDatefint().getHours()==5){
						if (regarde<8) {
							t1.setNbreSup50(NombreHeureJours(79200, 18000));
							t1.setNbreSup15(n - t1.getNbreSup50());
							if (regarde+t1.getNbreSup15()>8){
								t1.setNbreSup40(t1.getNbreSup15()+regarde-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);

								}
							}
						}
						else if (regarde==8&&regarde2<6){
							t1.setNbreSup50(NombreHeureJours(79200, 18000));
							t1.setNbreSup40(n - t1.getNbreSup50());
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);

							}

						}
						else {
							t1.setNbreSup50(n);
						}
					}
					else {
						if (regarde<8) {
							t1.setNbreSup50(NombreHeureJours(79200, ConverteDate(t1.getDatefint())));

							t1.setNbreSup15(n - t1.getNbreSup50());
							if (regarde+t1.getNbreSup15()>8){
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());

									t1.setNbreSup40(6-regarde2);

								}




							}
						}
						else if (regarde==8&&regarde2>6){
							t1.setNbreSup50(NombreHeureJours(79200, ConverteDate(t1.getDatefint())));

							t1.setNbreSup40(n - t1.getNbreSup50());
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());

								t1.setNbreSup40(6-regarde2);

							}
						}
						else {
							t1.setNbreSup50(n);
						}
					}

				}
				else {
					if (regarde<8){
					t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));

					t1.setNbreSup15(n-t1.getNbreSup50());
					if (regarde+t1.getNbreSup15()>8){
						t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
						t1.setNbreSup15(8-regarde);
						if (regarde2+t1.getNbreSup40()>6){
							t1.setNbreSup50(t1.getNbreSup40()+regarde2-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);
						}
					}
					}
					else if (regarde==8&&regarde2<6){
						t1.setNbreSup50(NombreHeureJours(79200,ConverteDate(t1.getDatefint())));

						t1.setNbreSup40(n-t1.getNbreSup50());
						if (regarde2+t1.getNbreSup40()>6){
							t1.setNbreSup50(t1.getNbreSup40()+regarde2-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);
						}

					}
					else {
						t1.setNbreSup50(n);
					}

				}


			}
		  	else if (t1.getDatedebut().getHours()==8){
				if (t1.getDatefint().getHours()>0&&t1.getDatedebut().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
				{
					if (t1.getDatefint().getHours()==23){
						if (regarde<8) {
							t1.setNbreSup50(1);
							t1.setNbreSup15(n - 1);
							if (regarde+t1.getNbreSup15()>8){
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);

								}

							}

						}
						else if (regarde==8&&regarde2<6){
							t1.setNbreSup50(1);
							t1.setNbreSup40(n - 1);
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);

							}

						}
						else {
							t1.setNbreSup50(n);
						}
					}
					else {
						if (regarde<8) {

							t1.setNbreSup15(n);
							if (t1.getNbreSup15()+regarde>8){
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6);
									t1.setNbreSup40(6-regarde2);

								}

							}
						}
						else if (regarde==8&&regarde2<6){
							t1.setNbreSup40(n);
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6);
								t1.setNbreSup40(6-regarde2);

							}

						}
						else {
							t1.setNbreSup50(n);
						}

					}

				}
				else  if (t1.getDatefint().getHours()<=5&&t1.getDatefint().getHours()>0){
					if (t1.getDatefint().getHours()==5){
						if (regarde<8) {
							t1.setNbreSup50(NombreHeureJours(79200, 18000));
							t1.setNbreSup15(n - t1.getNbreSup50());
							if (regarde+t1.getNbreSup15()>8){
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}

						}
						else if (regarde==8&&regarde2<6){
							t1.setNbreSup50(NombreHeureJours(79200, 18000));
							t1.setNbreSup40(n - t1.getNbreSup50());
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}

						else{
							t1.setNbreSup50(n);
						}

					}
					else {
						if (regarde<8) {
							t1.setNbreSup50(NombreHeureJours(79200, ConverteDate(t1.getDatefint())));

							t1.setNbreSup15(n - t1.getNbreSup50());
							if (regarde+t1.getNbreSup15()>8){
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}

						}
						else  if (regarde==8&&regarde2<6){
							t1.setNbreSup50(NombreHeureJours(79200, ConverteDate(t1.getDatefint())));

							t1.setNbreSup40(n - t1.getNbreSup50());
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}
						else {
							t1.setNbreSup50(n);
						}

					}

				}
				else  if (t1.getDatefint().getHours()==0){
					if (regarde<8) {
						t1.setNbreSup50(2);
						t1.setNbreSup15(n - 2);
						if (regarde+t1.getNbreSup15()>8){
							t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
							t1.setNbreSup15(8-regarde);
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}

					}
					else if (regarde==8&&regarde2<6){
						t1.setNbreSup50(2);
						t1.setNbreSup40(n - 2);
						if (regarde2+t1.getNbreSup40()>6){
							t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);
						}

					}
					else {
						t1.setNbreSup50(n);
					}

				}


			}



			else {
				if (t1.getDatefint().getHours()>0&&t1.getDatefint().getHours()<=5){
					if (regarde<8) {
						t1.setNbreSup50(NombreHeureJours(79200, ConverteDate(t1.getDatefint())));

						t1.setNbreSup15(n - t1.getNbreSup50());
						if (regarde+t1.getNbreSup15()>8){
							t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
							t1.setNbreSup15(8-regarde);
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}


					}
					else if (regarde==8&&regarde2<6){
						t1.setNbreSup50(NombreHeureJours(79200, ConverteDate(t1.getDatefint())));

						t1.setNbreSup40(n - t1.getNbreSup50());
						if (regarde2+t1.getNbreSup40()>6){
							t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);
						}

					}
					else {
						t1.setNbreSup50(n);
					}

				}
				else if (t1.getDatefint().getHours()>0&&t1.getDatedebut().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
				{
					if (t1.getDatefint().getHours()==23){
						if (regarde<8) {

							t1.setNbreSup50(1);
							t1.setNbreSup15(n - 1);
							if (regarde+t1.getNbreSup15()>8){
								t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
								t1.setNbreSup15(8-regarde);
								if (regarde2+t1.getNbreSup40()>6){
									t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
									t1.setNbreSup40(6-regarde2);
								}
							}
						}
						else if (regarde==8&&regarde2<6){
							t1.setNbreSup50(1);
							t1.setNbreSup40(n - 1);
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}

						}
						else {
							t1.setNbreSup50(n);
						}
					}
					else {

						t1.setNbreSup15(n);

					}

				}

				else {
					if (regarde<8) {
						t1.setNbreSup50(NombreHeureJours(79200, 18000));

						t1.setNbreSup15(n - t1.getNbreSup50());
						if (regarde+t1.getNbreSup15()>8){
							t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
							t1.setNbreSup15(8-regarde);
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(t1.getNbreSup40()+regarde2-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
					}
					else if (regarde==8&&regarde2<6){
						t1.setNbreSup50(NombreHeureJours(79200, 18000));

						t1.setNbreSup40(n - t1.getNbreSup50());
						if (regarde2+t1.getNbreSup40()>6){
							t1.setNbreSup50(t1.getNbreSup40()+regarde2-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);
						}



					}
					else {
						t1.setNbreSup50(n);
					}
				}
			}


		  }
		  else {
			  if (t1.getDatefint().getHours()>0&&t1.getDatedebut().getHours()<=23&&t1.getDatedebut().getHours()<t1.getDatefint().getHours())
			  {
				  if (t1.getDatefint().getHours()==23){
				  	if (regarde<8) {
						t1.setNbreSup15(NombreHeureJours(18000, 79200));
						t1.setNbreSup50(n - t1.getNbreSup15());
						if (regarde+t1.getNbreSup15()>8){
							t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
							t1.setNbreSup15(8-regarde);
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);
							}
						}
					}
				  	else if (regarde==8&&regarde2<6){
						t1.setNbreSup40(NombreHeureJours(18000, 79200));
						t1.setNbreSup50(n - t1.getNbreSup15());
						if (regarde2+t1.getNbreSup40()>6){
							t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);
						}




					}
				  	else {
				  		t1.setNbreSup50(n);
					}


				  }
				  else if (t1.getDatefint().getHours()<=5&&t1.getDatefint().getHours()>0){

				  	t1.setNbreSup50(n);
				  }
				  else {
				      System.out.println("on a rentre de 0 ");
				  	if (regarde<8){
						t1.setNbreSup50(NombreHeureJours(0,18000));
						t1.setNbreSup15(n-t1.getNbreSup50());
						if (regarde+t1.getNbreSup15()>8){
							t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
							t1.setNbreSup15(8-regarde);
							if (regarde2+t1.getNbreSup40()>6){
								t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
								t1.setNbreSup40(6-regarde2);

							}

						}

					}
				  	else if (regarde==8&&regarde2<6){
                        t1.setNbreSup50(NombreHeureJours(0,18000));
                        t1.setNbreSup40(n-t1.getNbreSup50());
						if (regarde2+t1.getNbreSup40()>6){
							t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);

						}


					}
				  	else {
				  		t1.setNbreSup50(n);
					}

				  }


			  }
			  else {
			  	if (regarde<8) {
					t1.setNbreSup15(NombreHeureJours(18000, 79200));
					t1.setNbreSup50(n - t1.getNbreSup15());
					if (regarde+t1.getNbreSup15()>8){
						t1.setNbreSup40(regarde+t1.getNbreSup15()-8);
						t1.setNbreSup15(8-regarde);
						if (regarde2+t1.getNbreSup40()>6){
							t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
							t1.setNbreSup40(6-regarde2);

						}
					}
				}
			  	else if (regarde==8&&regarde2<6){
					t1.setNbreSup40(NombreHeureJours(18000, 79200));
					t1.setNbreSup50(n - t1.getNbreSup15());
					if (regarde2+t1.getNbreSup40()>6){
						t1.setNbreSup50(regarde2+t1.getNbreSup40()-6+t1.getNbreSup50());
						t1.setNbreSup40(6-regarde2);

					}

				}
			  	else {
			  		t1.setNbreSup50(n);
				}
			  }


		  }


		  return t1;
	  }

	  @Override
	  public int CalulePanier(Taches t) {
	  	int n=0;
	  	if (NombreHeureJours(ConverteDate(t.getDatedebut()),ConverteDate(t.getDatefint()))>=9)
	  	{
	  		n=n+1;
		}
		  return n;
	  }

	  @Override
	public Taches TacheWeekend(Taches t) {
		// TODO Auto-generated method stub
          int n=NombreHeureJours(ConverteDate(t.getDatedebut()),ConverteDate(t.getDatefint()));
          System.out.println("ona rentrer dans la fonction TacheWeekend");

          t.setTotal_Heure(n);
          if (t.getDatedebut().getHours()>0){
              if (t.getDatedebut().getHours()<5){
                  if (t.getDatefint().getHours()<=23&&t.getDatefint().getHours()>t.getDatefint().getHours())
                  {
                      if (t.getDatefint().getHours()<=22){
                          t.setNbreSup50(NombreHeureJours(18000,ConverteDate(t.getDatefint())));


                      }
                      else {
                          t.setNbreSup50(NombreHeureJours(18000, 79200));
                          t.setNbreSup100(n - t.getNbreSup50());

                      }

                  }
                  else if (t.getDatefint().getHours()==0){
                      t.setNbreSup50(NombreHeureJours(18000,79200));
                      t.setNbreSup100(n-t.getNbreSup50());

                  }
                  else {
                      t.setNbreSup100(n);

                  }



              }
              else if (t.getDatedebut().getHours()==5){
                  if (t.getDatefint().getHours()<=23&&t.getDatefint().getHours()>t.getDatefint().getHours())
                  {
                      if (t.getDatefint().getHours()<=22)
                      {
                          t.setNbreSup50(n);
                      }
                      else {
                          t.setNbreSup50(NombreHeureJours(18000, 79200));
                          t.setNbreSup100(n - t.getNbreSup50());

                      }

                  }
                  else if (t.getDatefint().getHours()==0){
                      t.setNbreSup50(NombreHeureJours(18000,79200));
                      t.setNbreSup100(n-t.getNbreSup50());

                  }

                  else {

                      t.setNbreSup100(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
                      t.setNbreSup50(n-t.getNbreSup100());

                  }



              }
              else if (t.getDatedebut().getHours()==8){
                  if (t.getDatefint().getHours()<=23&&t.getDatefint().getHours()>t.getDatedebut().getHours())
                  {
                      if (t.getDatefint().getHours()<=22)
                      {
                          t.setNbreSup50(n);
                      }
                      else {
                          t.setNbreSup50(1);
                          t.setNbreSup100(n - t.getNbreSup50());

                      }

                  }
                  else if (t.getDatefint().getHours()==0){

                      t.setNbreSup100(2);
                      t.setNbreSup50(n-t.getNbreSup100());

                  }

                  else {

                      t.setNbreSup100(NombreHeureJours(79200,ConverteDate(t.getDatefint())));
                      t.setNbreSup50(n-t.getNbreSup100());

                  }


              }
              else {
                  if (t.getDatefint().getHours()<=23&&t.getDatefint().getHours()>t.getDatefint().getHours())
                  {
                      if (t.getDatefint().getHours()<=22)
                      {
                          t.setNbreSup50(n);
                      }
                      else {
                          t.setNbreSup50(1);
                          t.setNbreSup100(n - t.getNbreSup50());

                      }

                  }
                  else if (t.getDatefint().getHours()==0){

                      t.setNbreSup100(2);
                      t.setNbreSup50(n-t.getNbreSup100());

                  }

                  else {

                      t.setNbreSup100(NombreHeureJours(79200,18000));
                      t.setNbreSup50(n-t.getNbreSup100());

                  }




              }


          }
          else {
              System.out.println("on entrer avec db=0");
              if (t.getDatefint().getHours()<=23&&t.getDatefint().getHours()>=t.getDatefint().getHours())
              {
              	System.out.println("dureefin<=23");
                  if (t.getDatefint().getHours()<=5&&t.getDatefint().getHours()>0){
                      t.setNbreSup100(n);
                  }

              else  if (t.getDatefint().getHours()<=22&&t.getDatefint().getHours()>0)
                  {
                  	System.out.println("tojours");
                      t.setNbreSup100(NombreHeureJours(ConverteDate(t.getDatedebut()),18000));
                      t.setNbreSup50(n-t.getNbreSup100());
                  }
                  else {
                      t.setNbreSup50(NombreHeureJours(18000,79200));
                      t.setNbreSup100(n - t.getNbreSup50());

                  }

              }
              else{

                  t.setNbreSup50(NombreHeureJours(18000,79200));
                  t.setNbreSup100(n - t.getNbreSup50());

              }




          }


		return t;
	}

	@Override
	public int ConverteDate(Date t) {
		// TODO Auto-generated method stub
		int nb=(t.getHours()*3600)+(t.getMinutes()*60);
		
		return nb;
	}
  
 
  }
 