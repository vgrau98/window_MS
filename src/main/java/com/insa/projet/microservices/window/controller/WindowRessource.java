package com.insa.projet.microservices.window.controller;

import com.insa.projet.microservices.window.model.*;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class WindowRessource {
	
	public DataBase db = new DataBase();
	
	@PostMapping(path="/init/{n}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Window> initDataBase(@PathVariable int n){
		db.initDataBase(n);
		return db.getListWindows();
	}
	
	
	@GetMapping("/list")
	public List<Window> getListWindows(){
		for(int i=0;i<db.getListWindows().size();i++) {
			System.out.println(db.getListWindows().get(i));
		}
		return db.getListWindows();
	}
	
	
	@GetMapping("/id/{id}")
	public Window getWindowID(@PathVariable int id) {
		
		int index=-1;
		for (int i=0;i<db.getListWindows().size();i++) {
			if(db.getListWindows().get(i).getId()==id) {
				index=i;
			}
		}
		return db.getListWindows().get(index);
	}
	
	@GetMapping("/room/{room}")
	public Window getWindowRoom(@PathVariable int room) {
		int index =1;
		for(int i=0;i<db.getListWindows().size();i++) {
			if(db.getListWindows().get(i).getRoom()==room) {
				index=i;
			}
		}
		return db.getListWindows().get(index);
	}
	
	@PutMapping("/setWindowID/{id}/{state}")
	public void setStateID(@PathVariable boolean state,@PathVariable int id) {
		getWindowID(id).setState(state);
	}

}
