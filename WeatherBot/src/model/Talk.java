package model;

import java.io.Serializable;

public class Talk implements Serializable {
	private String from_user;
	private String talk;

	public Talk(String from_user, String talk){
		this.from_user = from_user;
		this.talk = talk;
	}

	public String getFrom_user() {
		return from_user;
	}
	public String getTalk() {
		return talk;
	}
}
