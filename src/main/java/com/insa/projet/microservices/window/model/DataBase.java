package com.insa.projet.microservices.window.model;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author grau
 * This class allows to implement a database of window actuators
 */
public class DataBase {

	private List<Window> listWindows;

	public DataBase() {
		listWindows = new ArrayList<Window>();
	}

	public List<Window> getListWindows() {
		return listWindows;
	}

	public void setListWindows(List<Window> listWindows) {
		this.listWindows = listWindows;
	}
	
}
