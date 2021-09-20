package fr.romain_neil.valwin.core;

import fr.romain_neil.valwin.core.tools.Meuleuse;
import fr.romain_neil.valwin.core.tools.Perceuse;
import fr.romain_neil.valwin.core.tools.Ponceuse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

	private static Panier panier;

	@BeforeEach
	void setPanier() {
		panier = new Panier();
	}

	@Test
	void addTool() {
		Perceuse perceuse = new Perceuse(Brand.DeWalt);

		panier.addTool(perceuse);

		assertTrue(panier.getToolsList().contains(perceuse));
	}

	@Test
	void reduc3() {
		Meuleuse m1 = new Meuleuse(Brand.Parkside);
		Meuleuse m2 = new Meuleuse(Brand.Hilti);

		panier.addTool(m1);
		panier.addTool(m2);

		panier.calcPrice();

		double expectedPrice = m1.getPrice() * 2;
		double priceAfterReduction = expectedPrice * 0.9;

		assertEquals(expectedPrice, panier.getTotal());
		assertEquals(priceAfterReduction, panier.getReduc());
	}

	@Test
	void reduc4() {
		//1 outil dans 3 marques différentes
		Ponceuse p1 = new Ponceuse(Brand.DeWalt);
		Ponceuse p2 = new Ponceuse(Brand.Milwaukee);
		Ponceuse p3 = new Ponceuse(Brand.Hilti);

		panier.addTool(p1);
		panier.addTool(p2);
		panier.addTool(p3);

		panier.calcPrice();

		double expectedPrice = p1.getPrice() * 3;
		double priceAfterReduction = expectedPrice * 0.6;

		assertEquals(expectedPrice, panier.getTotal());
		assertEquals(priceAfterReduction, panier.getReduc());
	}

}