package fr.romain_neil.valwin.core;

import fr.romain_neil.valwin.core.tools.*;
import org.junit.jupiter.api.*;

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
	void reduc1() {
		ScieCirculaire scie = new ScieCirculaire(Brand.Parkside);
		Ponceuse ponceuse = new Ponceuse(Brand.Parkside);

		panier.addTool(scie);
		panier.addTool(ponceuse);

		panier.calcPrice();

		double expectedPrice = scie.getPrice() + ponceuse.getPrice();
		double priceAfterReduction = expectedPrice * 0.8;

		assertEquals(expectedPrice, panier.getTotal());
		assertEquals(priceAfterReduction, expectedPrice - panier.getReduc());
	}

	@Test
	void reduc2() {
		Meuleuse meuleuse = new Meuleuse(Brand.Parkside);
		Perceuse perceuse = new Perceuse(Brand.Parkside);
		Visseuse visseuse = new Visseuse(Brand.Parkside);

		panier.addTool(meuleuse);
		panier.addTool(perceuse);
		panier.addTool(visseuse);

		panier.calcPrice();

		double expectedPrice = (meuleuse.getPrice() + perceuse.getPrice() + visseuse.getPrice());
		double priceAfterReduction = expectedPrice * 0.7;

		assertEquals(expectedPrice, panier.getTotal());
		assertEquals(priceAfterReduction, expectedPrice - panier.getReduc());
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
		assertEquals(priceAfterReduction, expectedPrice - panier.getReduc());
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
		assertEquals(priceAfterReduction, expectedPrice - panier.getReduc());
	}

}