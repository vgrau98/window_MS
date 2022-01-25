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

/**
 * 
 * @author grau
 * Expose resources for managing a database of temperature sensors each with an ID, a room and a list of values representing the history. 
 */
@RestController
public class WindowRessource {
	
	public DataBase db = new DataBase();
	
	
	/**
	 * 
	 * @return, the list of window actuators
	 */
	@GetMapping("/list")
	public List<Window> getListWindows(){
		for(int i=0;i<db.getListWindows().size();i++) {
			System.out.println(db.getListWindows().get(i));
		}
		return db.getListWindows();
	}
	
	/**
	 * 
	 * @param id
	 * @param timestamp
	 * @return true if an action with a specific timestamp has already been posted
	 */
	@GetMapping("/isMeasured/{id}/{timestamp}")
	public boolean alreadyMeasured(@PathVariable ("id") int id,@PathVariable ("timestamp") long timestamp) {
		
		boolean measured=false;
		Window window = getWindowID(id);
		for(WindowState s : window.getStates()) {
			if(s.getTimestamp()==timestamp) {
				measured=true;
			}
		}
		return measured;
	}
	
	/**
	 * 
	 * @param window, see Window class
	 */
	@PostMapping(path="/addWindow", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void addWindow(@RequestBody Window window) {
		
		db.getListWindows().add(window);
		
	}
	
	/**
	 * 
	 * @param id
	 * @return, a window according to its ID or null if the id does not exist
	 */
	@GetMapping("/id/{id}")
	public Window getWindowID(@PathVariable int id) {
		
		int index=-1;
		Window window = null;
		for (int i=0;i<db.getListWindows().size();i++) {
			if(db.getListWindows().get(i).getId()==id) {
				index=i;
			}
		}
		
		if(index!=-1) {
			window=db.getListWindows().get(index);
		}
		return window;
	}
	
	/**
	 * 
	 * @param room
	 * @return, a window actuator according to a specific room
	 */
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
	
	/**
	 * 
	 * @param id
	 * @param state
	 */
	@PostMapping(path = "addStateID/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addStateID(@PathVariable("id") int id, @RequestBody WindowState state) {
		int index = -1;
		for (int i = 0; i < db.getListWindows().size(); i++) {
			if (db.getListWindows().get(i).getId() == id) {
				index = i;
			}
		}

		db.getListWindows().get(index).addState(state);
	}
	
	/**
	 * 
	 * @param room
	 * @param state
	 */
	@PostMapping(path = "addStateRoom/{room}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addStateRoom(@PathVariable("room") int room, @RequestBody WindowState state) {
		int index = -1;
		for (int i = 0; i < db.getListWindows().size(); i++) {
			if (db.getListWindows().get(i).getRoom() == room) {
				index = i;
			}
		}

		db.getListWindows().get(index).addState(state);
	}
	
	/**
	 * 
	 * @param ID
	 * @return true if a window actuator with a the specified ID already exists
	 */
	@GetMapping("/WindowInID/{id}")
	public boolean windowInDBbyID(@PathVariable ("id") int ID) {
		
		boolean isCreated=false;
		for(Window w : db.getListWindows()) {
			if(w.getId()==ID) {
				isCreated=true;
			}
		}

		
		return isCreated;
	}
}
