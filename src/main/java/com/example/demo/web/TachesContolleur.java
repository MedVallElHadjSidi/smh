package com.example.demo.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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


@Controller
public class TachesContolleur {
	
	
	@Autowired
	TachesIm tachesim;
	@Autowired
	EmployerIm employerim;
	@Autowired
	IMetier imetier;
	
	
	
	Employer em=new Employer();
	
	@RequestMapping(value = "/taches",method = RequestMethod.GET)
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
		
		

		return "taches";
	}

	
	
	@RequestMapping(value = "/AjouterEm" ,method = RequestMethod.POST)
	public String AjouterEmployer(@RequestParam(name = "matircule")String matricule,
			@RequestParam(name = "nom")String nom,
			@RequestParam(name = "fonction")String fonction) {
		Employer em=new Employer(matricule,nom,fonction);
		employerim.save(em);
		
		
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
		Taches tache=new Taches();
		if(employerim.existsById(matricule)) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat formatter2 = new SimpleDateFormat("hh:mm");
			DateFormat formatter3 = new SimpleDateFormat("hh:mm");
			try {
				Date dureeb=formatter3.parse(db);
				Date dureef=formatter2.parse(df);
				Date journee=formatter.parse(date);
				tache.setDateday(journee);
				tache.setDatedebut(dureeb);
				tache.setDatefint(dureef);
				em=(Employer)employerim.findById(matricule).get();
				
				tache.setEmployer(em);
				Taches tach=tachesim.SommeJous(tache.getEmployer().getId());
				if(tach==null) {

				tachesim.save(imetier.TacheCompletJour(tache));}
				if(tach!=null&&tach.getDatedebut().getHours()==dureeb.getHours()&&tach.getDatefint().getHours()==dureef.getHours()){
					
					
				return "Jours";
				}
				else if(tach!=null &&journee.getDay()!=6&&journee.getDay()!=7) {
					
						
						tachesim.save(imetier.TacheCompletJour(tache));
					}
					if(journee.getDay()==1&&(journee.getDay()-tach.getDateday().getDay()==0)) {
						tachesim.save(imetier.MemeJours(tache, tach));
						
					}
					if(journee.getDay()==1&&(journee.getDay()-tach.getDateday().getDay()!=0)) {
						tachesim.save(imetier.TacheCompletJour(tache));
						
					}
					
					
					
				
					
					
				
			
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
		
		return "jours";
	}
	

}
