package com.example.demo.web;

import java.io.ByteArrayInputStream;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;
import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.EmployerIm;
import com.example.demo.DAO.TachesIm;
import com.example.demo.Metier.IMetier;
import com.example.demo.entity.Employer;
import com.example.demo.entity.Taches;
import com.example.demo.excel.ExcelFileExporter;


@Controller
public class TachesContolleur {
	
	
	
	@Autowired
	TachesIm tachesim;
	@Autowired
	EmployerIm employerim;
	@Autowired
	IMetier imetier;
	@Autowired
	ServletContext context;
	Date dateDebut_Weekend=null;
	
	
	
	Employer em=new Employer();
	
	@RequestMapping(value = "/taches",method = RequestMethod.POST)
	public String sommes(Model model,@RequestParam(name = "Duree1")String d1,
			@RequestParam(name = "Duree2")String d2,
			@RequestParam(name = "motcler")String matricule) {
		List<Taches>taches=new ArrayList<Taches>();
		if(employerim.existsById(matricule)) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dat;
			try {
				dat = formatter.parse(d1);
				Date dt2=formatter.parse(d2);
				taches=tachesim.SommeSemaine(dat, dt2, matricule);
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		model.addAttribute("taches",taches);
		
		

		return "calcleSemaine";
	}

	
	
	@RequestMapping(value = "/AjouterEm" ,method = RequestMethod.POST)
	public String AjouterEmployer(@RequestParam(name = "matircule")String matricule,
			@RequestParam(name = "nom")String nom,
			@RequestParam(name = "fonction")String fonction,Model model) {
		String valider="";
		String ma="";
		Employer em=new Employer(matricule,nom,fonction);
		if(!employerim.existsById(matricule)) {
			Employer emmodel= employerim.save(em);
			valider="images/valider.jpg";
			ma="L'ajout de l'employer "+emmodel.getId()+" "+"avec success";
		}

		
		else {
			valider="images/dow22.png";
			
			ma="desoler cet matricule existe deja!";
			
		}
		model.addAttribute("valider", valider);
		model.addAttribute("matricule", ma);

	
		
		
		
		
		return "AjouterEmployer";	
	}
	
	@RequestMapping(value = "/")
	public String index() {	
		return "Jours";
	}
	
	@RequestMapping(value = "/chaquejours",method = RequestMethod.POST)
	public String chaqueJours(Model model,
			@RequestParam(name = "matircule")String matricule,
			@RequestParam(name="Dureedb")String db,
			@RequestParam(name = "Dureef")String df,
			@RequestParam(name = "Dureej")String date) {
		String valider="";
		String failse="";
		String comment="";
		
		
		Taches tache=new Taches();
		if(employerim.existsById(matricule)) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat formatter2 = new SimpleDateFormat("HH:mm");
			DateFormat formatter3 = new SimpleDateFormat("HH:mm");
			try {
				Date dureeb=formatter3.parse(db);
				Date dureef=formatter2.parse(df);
				Date journee=formatter.parse(date);
				tache.setDateday(journee);
				tache.setDatedebut(dureeb);
				tache.setDatefint(dureef);
				em=(Employer)employerim.findById(matricule).get();
				tache.setEmployer(em);
				Taches tv=null;
				Taches tach=tachesim.SommeJous(tache.getEmployer().getId());
              dateDebut_Weekend=tachesim.DebutSemaine(tache.getDateday());
              System.out.println(dateDebut_Weekend);
              if(tach==null) {
            	  tv=tachesim.save(imetier.TacheCompletJour(tache));
            	  if(tv!=null) {
    					valider="images/valider.jpg";
    					comment="vous vient d'enregistrer la tache de l'employer"+" : "+tv.getEmployer().getId();
    					
    					model.addAttribute("etat",valider);
    					model.addAttribute("comment",comment);
    				
    				}
    				else {
    					failse="images/dow22.png";
    					model.addAttribute("etat",failse);
    					comment="on a rencontrer une probleme concernant tache de l'employer"+" : "+tache.getEmployer().getId();
    					model.addAttribute("comment",comment);
    				}
              }
              else if(tach!=null&&dateDebut_Weekend==null) {
            	  tv=tachesim.save(imetier.TacheCompletJour(tache));
            	  if(tv!=null) {
  					valider="images/valider.jpg";
  					comment="vous vient d'enregistrer la tache de l'employer"+" : "+tv.getEmployer().getId();
  					
  					model.addAttribute("etat",valider);
  					model.addAttribute("comment",comment);
  				
  				}
  				else {
  					failse="images/dow22.png";
  					model.addAttribute("etat",failse);
  					comment="on a rencontrer une probleme concernant tache de l'employer"+" : "+tache.getEmployer().getId();
  					model.addAttribute("comment",comment);
  				}
            	  
              }
              
              else {
            	  if(tache.getDateday().getDay()==tach.getDateday().getDay()) {
            		 
            		Taches enregister=imetier.MemeJours(tache, tach);
            		if(enregister!=null) {
            		
            		Taches memejours=	tachesim.save(enregister);
            		if(memejours!=null) {
            			String validermeme="images/dow2.jpg";
  	  					comment="vous vient d'enregistrer la tache de l'employer"+" : "+tv.getEmployer().getId();
  	  					
  	  					model.addAttribute("etat",validermeme);
  	  					model.addAttribute("comment",comment);
            		}
            		}
            		else {
            			failse="images/dow22.png";
  	  					model.addAttribute("etat",failse);
  	  					comment="on a rencontrer verifier date depart ou  arriver";
  	  					model.addAttribute("comment",comment);
            		}
            		  
            	  }
            	  else {
            		  
            			 tv= tachesim.save(imetier.TachesCompletJoursSup(tache, tach));
      	            	  if(tv!=null) {
      	  					valider="images/valider.jpg";
      	  					comment="vous vient d'enregistrer la tache de l'employer"+" : "+tv.getEmployer().getId();
      	  					
      	  					model.addAttribute("etat",valider);
      	  					model.addAttribute("comment",comment);
      	  				
      	  				}
      	  				else {
      	  					failse="images/dow22.png";
      	  					model.addAttribute("etat",failse);
      	  					comment="on a rencontrer une probleme concernant tache de l'employer"+" : "+tache.getEmployer().getId();
      	  					model.addAttribute("comment",comment);
      	  				}}}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
			
			failse="images/dow22.png";
				model.addAttribute("etat",failse);
				comment="Desoler cet employer n'existe pas!"+" "+"verfier matricule";
				model.addAttribute("comment",comment);
		}
		
		return "jours";
	}
	
	
	@GetMapping("/download")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=taches.xlsx");
        ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(tachesim.findAll());
        IOUtils.copy(stream, response.getOutputStream());}
	
	

		
		
		
	

		
	}
	


