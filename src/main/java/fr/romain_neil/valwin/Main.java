package fr.romain_neil.valwin;

import fr.romain_neil.valwin.core.Brand;
import fr.romain_neil.valwin.core.Panier;
import fr.romain_neil.valwin.core.tools.Perceuse;

public class Main {

	public static void main(String[] args) {
		Perceuse perceuse = new Perceuse(Brand.DeWalt);
		Perceuse perceuse1 = new Perceuse(Brand.Hilti);
		Perceuse perceuse2 = new Perceuse(Brand.Milwaukee);
		//ScieCirculaire scieCirculaire = new ScieCirculaire(Brand.Parkside);

		Panier panier = new Panier();
		panier.addTool(perceuse);
		panier.addTool(perceuse1);
		panier.addTool(perceuse2);

		panier.calcPrice();
		panier.printResume();
	}
}
