package com.otgenasis.virtualwar.unites;

public class Base extends Fixe {

	private Unite[] unites = new Unite[3];
	
	public Base(int ID, int PV, int armure){
		this.ID = ID;
		this.PV = PV;
		this.armure = armure;
	}

	public String getUnites() {
		String str = "";
		for(int i = 0; i < unites.length; i++){
			str = str + "[" + unites[i] + "]";
		}
		return str;
	}

	public void setUnites(Unite[] unites) {
		this.unites = unites;
	}

}
