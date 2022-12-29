package Boulangerie;

public class FabricationPain {
	/** Array of recipes in coffee maker */
	private static allrecette allrecette;
	/** Inventory of the coffee maker */
	private static Inventaire inventaire;

	/**
	 * Constructor for the coffee maker
	 *
	 */
	public Fabrication() {
		allrecette = new allrecette();
		inventaire = new Inventaire();
	}

	/**
	 * Returns true if the recipe is added to the list of recipes in the CoffeeMaker
	 * and false otherwise.
	 * 
	 * @param r
	 * @return boolean
	 */
	public boolean addRecette(Recette a) {
		return allrecette.addrecette(a);
	}

	/**
	 * Returns the name of the successfully deleted recipe or null if the recipe
	 * cannot be deleted.
	 * 
	 * @param recipeToDelete
	 * @return String
	 */
	public String deleteRecette(int recetteSuppr) {
		return allrecette.deleteRecette(recetteSuppr);
	}

	/**
	 * Returns the name of the successfully edited recipe or null if the recipe
	 * cannot be edited.
	 * 
	 * @param recipeToEdit
	 * @param r
	 * @return String
	 */
	public String editRecette(int recetteEdit, Recette a) {
		return allrecette.editrecette(recetteEdit, a);
	}

	/**
	 * Returns true if inventory was successfully added
	 * 
	 * @param amtCoffee
	 * @param amtMilk
	 * @param amtSugar
	 * @param amtChocolate
	 * @return boolean
	 */
	public void addInventaire(String amtFarine, String amtEau, String amtLevure, String amtSel)
			throws InventoryException {
		inventaire.addFarine(amtFarine);
		inventaire.addEau(amtEau);
		inventaire.addLevure(amtLevure);
		inventaire.addSel(amtSel);
	}

	/**
	 * Returns the inventory of the coffee maker
	 * 
	 * @return Inventory
	 */
	public String checkInventaire() {
		return Inventaire.toString();
	}

	/**
	 * Returns the change of a user's beverage purchase, or the user's money if the
	 * beverage cannot be made
	 * 
	 * @param nbrecette
	 * @param prix
	 * @return int
	 */
	public int Pain(int nbrecette, int prix) {
		int monnaie = 0;

		final Recette recetteAchetable = getRecette()[nbrecette];
		final int prixPain = recetteAchetable != null
				? recetteAchetable.getPrix()
				: null;
		if ((recetteAchetable != null)
				&& (prixPain <= prix)
				&& (inventaire.utliseIngredients(Recette,recetteAchetable))) {
			monnaie = prix - prixPain;
		} else {
			monnaie = prix;
		}

		return monnaie;
	}

	/**
	 * Returns the list of Recipes in the RecipeBook.
	 * 
	 * @return Recipe []
	 */
	public Recette[] getRecette() {
		return allrecette.getRecette();
	}

}
