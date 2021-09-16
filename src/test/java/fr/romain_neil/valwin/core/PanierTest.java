package fr.romain_neil.valwin.core;

import fr.romain_neil.valwin.core.tools.Perceuse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

	private static Panier panier;

	@BeforeAll
	static void setPanier() {
		panier = new Panier();
	}

	@Test
	void addTool() {
		Perceuse perceuse = new Perceuse(Brand.DeWalt);

		panier.addTool(perceuse);

		assertTrue(panier.getToolsList().contains(perceuse));
	}

}