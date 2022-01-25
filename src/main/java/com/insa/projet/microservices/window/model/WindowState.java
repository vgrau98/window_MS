package com.insa.projet.microservices.window.model;

/**
 * 
 * @author grau
 * This class allows to implement a window state
 */
public class WindowState {
	private boolean state;
	private long timestamp;
	
	/**
	 * 
	 * @param state, false for close, and true for open
	 * @param timestamp
	 */
	public WindowState(boolean state, long timestamp) {
		super();
		this.state = state;
		this.timestamp = timestamp;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
