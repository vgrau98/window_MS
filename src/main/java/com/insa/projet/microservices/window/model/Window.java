package com.insa.projet.microservices.window.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author grau
 * This class allows to implement a window actuators
 * 
 */
public class Window {

	private int id;
	private int room;
	private List<WindowState> states;

	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 * @param room
	 */
	public Window(int id, int room) {
		this.id = id;
		this.room = room;
		states=new ArrayList<WindowState>();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}
	
	public List<WindowState> getStates(){
		return states;
	}

	public void addState(WindowState state) {
		this.states.add(state);
	}
}
