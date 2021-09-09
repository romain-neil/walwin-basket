package fr.romain_neil.valwin.core;

import fr.romain_neil.valwin.Utils;
import fr.romain_neil.valwin.core.tools.AbstractTool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Romain Neil
 * @version 1.0.0
 *
 */
public class Panier {

	private final List<AbstractTool> liste;

	private double total;
	private double reduc;

	public Panier() {
		liste = new ArrayList<>();
	}

	public void addTool(AbstractTool tool) {
		liste.add(tool);
	}

	/**
	 * Calculate the total price of the basket
	 */
	public void calcPrice() {
		int nbDifferentProducts = 0;
		int nbDifferentBrands = 0;
		List<AbstractTool> tools = new ArrayList<>();
		List<Brand> existingBrands = new ArrayList<>();

		for (AbstractTool t : liste) {
			total += t.getPrice();

			if(!existingBrands.contains(t.getBrand())) {
				nbDifferentBrands++;
				existingBrands.add(t.getBrand());
			}

			int toolIndex = Utils.getIndexByToolName(tools, t.getName());

			if(toolIndex == -1) {
				nbDifferentProducts++;
				tools.add(t);
			}
		}

		//Réductions
		if(nbDifferentProducts >= 2 && nbDifferentBrands >= 1) {
			reduc += (total * 0.2); //2 outils différents de la même marque
		}

		if(nbDifferentBrands >= 3 && nbDifferentProducts >= 1) {
			//3 marques et 1 type d'outil
			reduc += (total * 0.4);
		}

		if(nbDifferentBrands == 2 && nbDifferentProducts == 1) {
			reduc += (total * 0.1); //1 outil dans 2 marques différentes
		}

		if(nbDifferentBrands == 1 && nbDifferentProducts == 1) {
			//Réduction sur les 3 derniers produits
			reduc += (total * 0.7);
		}

		System.out.println("Il y a " + existingBrands.size() + " marque(s) différentes");
	}

	/**
	 * Print the basket resume
	 */
	public void printResume() {
		System.out.println("Panier : ");
		System.out.println("---------------------");
		for (AbstractTool tool : liste) {
			System.out.println("Outil : " + tool.getName() + " " + tool.getBrand().toString() + " (" + tool.getPrice() + "€)");
		}

		System.out.println("Total : " + total + " €");
		System.out.println("Réduction : " + reduc + "€");
		System.out.println("Total après réduction : " + (total - reduc) + "€");
	}

}
