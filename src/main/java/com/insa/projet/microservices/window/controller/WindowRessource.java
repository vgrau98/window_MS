package com.insa.projet.microservices.window.controller;

import com.insa.projet.microservices.window.model.*;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class WindowRessource {
	
	public DataBase db = new DataBase();
	
	
	
	@GetMapping("/list")
	public List<Window> getListWindows(){
		for(int i=0;i<db.getListWindows().size();i++) {
			System.out.println(db.getListWindows().get(i));
		}
		return db.getListWindows();
	}


}
