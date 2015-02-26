package com.otgenasis.virtualwar.plateau;

import java.util.Scanner;

import com.otgenasis.virtualwar.unites.Piegeur;
import com.otgenasis.virtualwar.unites.Tank;
import com.otgenasis.virtualwar.unites.Tireur;
import com.otgenasis.virtualwar.unites.Unite;

public class MainTestPlateau2D {
	public static void main(String[] args) {
		Plateau2D p = new Plateau2D();
		///////////////////////////////////////////////////////
		Unite[] tabUnites = new Unite[3];
		String res = "";
		int cpt = 0;
		for (int i = 0; i < tabUnites.length; i++) {
			cpt = tabUnites.length-i;
			System.out.println("Encore " +cpt+ " unites a choisir ! (Tireur, Tank, Piegeur) \n :");
			Scanner sc = new Scanner(System.in);
			res = sc.nextLine();
			if(res.equals("Tireur"))
				tabUnites[i] = new Tireur(10, 10, 10, 10, 10);
			else if(res.equals("Piegeur"))
				tabUnites[i] = new Piegeur(10, 10, 10, 10, 10);
			else if(res.equals("Tank"))
				tabUnites[i] = new Tank(10, 10, 10, 10, 10);
			else {
				System.out.println("Reessayer :");
				i--;
			}
		}
		for (int i = 0; i < tabUnites.length; i++) {
			System.out.println(tabUnites[i]);
		}
		////////////////////////////////////////////////////////
		p.setBases(tabUnites, tabUnites);
		System.out.println(p.toString());
		
	}
}
