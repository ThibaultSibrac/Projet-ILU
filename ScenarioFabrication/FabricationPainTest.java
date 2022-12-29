package ScenarioFabrication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ratcm.exceptions.InventoryException;

public class FabricationPainTest {
	private FabriPain fp;
	private Recette r1;
	private Recette r2;
	private Recette r3;
	private Recette r4;

	public void setUp() throws Exception {
		fp = new FabricationPain();
		
		//Set up for r1
		r1 = new Recette();
		r1.setName("Baguette");
		r1.setAmtsel("2");
		r1.setAmtfarine("5");
		r1.setAmtEau("3");
		r1.setAmtlevure("4");
		r1.setPrix("60");
		
		//Set up for r2
		r2 = new Recette();
		r2.setName("Campagne");
		r2.setAmtSel("5");
		r2.setAmtFarine("15");
		r2.setAmtEau("10");
		r2.setAmtLevure("3");
		r2.setPrix("80");
		
		//Set up for r3
		r3 = new Recette();
		r3.setName("Tradition");
		r3.setAmtSel("4");
		r3.setAmtFarine("10");
		r3.setAmtEau("5");
		r3.setAmtLevure("10");
		r3.setPrice("95");
		
		//Set up for r4
		r4 = new Recipe();
		r4.setName("Ficelle");
		r4.setAmtSel("0");
		r4.setAmtFaribe("2");
		r4.setAmtEau("1");
		r4.setAmtLevure("2");
		r4.setPrice("50");
		
	}

	@Test
	public void testAddInventaire() throws InventoryException {
		assertThrows(InventoryException.class,
				() -> { fp.addInventaire("4", "-1", "asdf", "3"); });
	}
	
	@Test
	public void testFabriPain() {
		fp.addRecipe(r1);
		assertEquals(25, fp.fabriPain(0, 75));
	}
	
	@Test
	public void testFabriPainSansArgent() {
		fp.addRecipe(r1);
		final int montantArgent = 10;
		assertTrue(montantArgent < fp.getRecettes()[0].getPrix());
		assertEquals(montantArgent, fp.fabriPain(0, montantArgent));
	}
	
	@Test
	public void testFabriTraditionSansSel() {
		fp.addRecipe(r3);
		assertEquals(75, fp.fabriPain(0, 75));
		
	}
	
	@Test
	public void testFabriPainBaisseLesStocks() {
		fp.addRecipe(r3);
		assertEquals(0,fp.fabriPain(0, 50));
		assertEquals(0,fp.fabriPain(0, 50));
		assertEquals(0,fp.fabriPain(0, 50));
		assertEquals(0,fp.fabriPain(0, 50));
		assertEquals(0,fp.fabriPain(0, 50));
		assertEquals(50,fp.fabriPain(0, 50));
	}
}