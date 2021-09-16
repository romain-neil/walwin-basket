package fr.romain_neil.valwin;

import fr.romain_neil.valwin.core.Brand;
import fr.romain_neil.valwin.core.tools.AbstractTool;
import fr.romain_neil.valwin.core.tools.Perceuse;
import fr.romain_neil.valwin.core.tools.ScieCirculaire;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

	@Test
	void getIndexByToolName() {
		List<AbstractTool> liste = new ArrayList<>();

		liste.add(new Perceuse(Brand.Parkside));
		liste.add(new ScieCirculaire(Brand.Milwaukee));

		assertEquals(0, Utils.getIndexByToolName(liste, "Perceuse"));
		assertEquals(1, Utils.getIndexByToolName(liste, "Scie-circulaire"));
		assertEquals(-1, Utils.getIndexByToolName(liste, "null"));
	}
}