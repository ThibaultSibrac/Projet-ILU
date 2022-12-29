package Boulangerie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static FarbriPain pain;

    /**
     * Prints the main menu and handles user input for 
     * main menu commands.
     */
    public static void mainMenu() {
        System.out.println("1. Ajout d'une recette ");
        System.out.println("2. Effacer une recette");
        System.out.println("3. Modifier une recette");
        System.out.println("4. Ajout dans l'inventaire");
        System.out.println("5. Verifier l'inventaire");
        System.out.println("6. Creer le pain");
        System.out.println("0. Quitter\n");
        
        //Get user input
        try {
        	int commandeUtilisateur = Integer.parseInt(inputOutput("Please press the number that corresponds to what you would like the coffee maker to do."));
        	
        	if (commandeUtilisateur >= 0 && commandeUtilisateur <=6) {
		        if (commandeUtilisateur == 1) addRecette();
		        if (commandeUtilisateur == 2) effacerRecette();
		        if (commandeUtilisateur == 3) modifierRecette();
		        if (commandeUtilisateur == 4) addInventaire();
		        if (commandeUtilisateur == 5) verifierInventaire();
		        if (commandeUtilisateur == 6) makeCoffee();
		        if (commandeUtilisateur == 0) System.exit(0);
        	} else {
        		System.out.println("Please enter a number from 0 - 6");
            	mainMenu();
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Please enter a number from 0 - 6");
        	mainMenu();
        }
    }
    
    /**
     * The add recipe user interface that process user input.
     */
	public static void addRecette() {
		
	    //Read in recipe name
	    String name = inputOutput("\nPlease enter the recipe name: ");
	    
	    //Read in recipe price
	    String PrixString = inputOutput("\nPlease enter the recipe price: $");
	    	    
	    //Read in amt coffee
	    String farineString = inputOutput("\nPlease enter the units of farine in the recipe: ");
	    	    
	    //Read in amt milk
	    String eauString = inputOutput("\nPlease enter the units of eau in the recipe: ");
	    	    
	    //Read in amt sugar
	    String levureString = inputOutput("\nPlease enter the units of levure in the recipe: ");
	    	    
	    //Read in amt chocolate
	    String selString = inputOutput("\nPlease enter the units of sel in the recipe: ");
	    	    
		Recette a = new Recette();
		try {
			a.setName(name);
			a.setPrice(prixString);
			a.setAmtFarine(farineString);
			a.setAmtEau(eauString);
			a.setAmtLevure(levureString);
			a.setAmtSel(selString);
			
			boolean recetteAjoute = pain.addRecette(a);
		    
		    if(recetteAjoute) {
		    	System.out.println(name + " successfully added.\n");
		    } else {
		    	System.out.println(name + " could not be added.\n");
		    }
		} catch (RecipeException e) {
			System.out.println(e.getMessage());
		} finally {
			mainMenu();
		}
    }
    
	/**
	 * Delete recipe user interface that processes input.
	 */
    public static void effacerRecette() {
        Recette [] recettes = pain.getRecettes();
        for(int i = 0; i < recettes.length; i++) {
        	if (recettes[i] != null) {
        		System.out.println((i+1) + ". " + recettes[i].getName());
        	}
        }
        int recetteAEffacer = listeRecetteDisponible("Please select the number of the recipe to delete.");
        
	    if(recetteAEffacer < 0) {
	    	mainMenu();
	    }
	    
        String recetteEffacer = pain.effacerRecette(recetteAEffacer);
        
        if (recetteEffacer != null) {
        	System.out.println(recetteEffacer + " successfully deleted.\n");
        } else {
	        System.out.println("Selected recipe doesn't exist and could not be deleted.\n");
        }
        mainMenu();
    }
    
    /**
     * Edit recipe user interface the processes user input.
     */
    public static void modifierRecette() {
        Recette [] recettes = pain.getRecettes();
        for(int i = 0; i < recettes.length; i++) {
        	if (recettes[i] != null) {
        		System.out.println((i+1) + ". " + recettes[i].getName());
        	}
        }
        int recetteaModifier = listeRecetteDisponible("Please select the number of the recipe to edit.");
        
	    if(recetteaModifier < 0) {
	    	mainMenu();
	    }
	    
	    //Read in recipe price
	    String priceString = inputOutput("\nPlease enter the recipe price: $");
	    
	    //Read in amt coffee
	    String FarineString = inputOutput("\nPlease enter the units of coffee in the recipe: ");
	    
	    //Read in amt milk
	    String eauString = inputOutput("\nPlease enter the units of milk in the recipe: ");
	    
	    //Read in amt sugar
	    String levureString = inputOutput("\nPlease enter the units of sugar in the recipe: ");
	    
	    //Read in amt chocolate
	    String selString = inputOutput("\nPlease enter the units of chocolate in the recipe: ");
	    
	    Recette newRecette = new Recette();
	    try {
			newRecette.setPrix(priceString);
			newRecette.setAmtFarine(farineString);
			newRecette.setAmtEau(eauString);
			newRecette.setAmtLevure(levureString);
			newRecette.setAmtSel(selString);
			
			String recetteModifiee = pain.modifierRecette(recetteaModifier, newRecette);
	        
	        if (recetteModifiee != null) {
	        	System.out.println(recetteModifiee + " successfully edited.\n");
	        }
		    else {
		    	System.out.println(recetteModifiee + "could not be edited.\n");
		    }
		} catch (RecipeException e) {
			System.out.println(e.getMessage());
		} finally {
			mainMenu();
		}
    }
    
    /**
     * Add inventory user interface that processes input.
     */
    public static void addInventaire() {
	    //Read in amt coffee
	    String farineString = inputOutput("\nPlease enter the units of coffee to add: ");
	    	    
	    //Read in amt milk
	    String eauString = inputOutput("\nPlease enter the units of milk to add: ");
	    	    
	    //Read in amt sugar
	    String levureString = inputOutput("\nPlease enter the units of sugar to add: ");
	    	    
	    //Read in amt chocolate
	    String selString = inputOutput("\nPlease enter the units of chocolate to add: ");
	    	    
        try {
        	pain.addInventaire(farineString, eauString, levureString, selString);
        	System.out.println("Inventory successfully added");
        } catch (InventoryException e) {
        	System.out.println("Inventory was not added");
        } finally {
        	mainMenu();
        }
    }
    
    /**
     * Check inventory user interface that processes input.
     */
    public static void verifierInventaire() {
    	System.out.println(pain.verifierInventaire());
    	mainMenu();
    }
    
    /**
     * Make coffee user interface the processes input.
     */
    public static void PreparerPain() {
        Recette [] recettes = pain.getRecettes();
        for(int i = 0; i < recettes.length; i++) {
        	if (recettes[i] != null) {
        		System.out.println((i+1) + ". " + recettes[i].getName());
        	}
        }
        
        int recetteAchetable = listeRecetteDisponible("Please select the number of the recipe to purchase.");
        
        String montantPrix = inputOutput("Please enter the amount you wish to pay");
        int amtPrix = 0;
        try {
        	amtPrix = Integer.parseInt(montantPrix);
        } catch (NumberFormatException e) {
        	System.out.println("Please enter a positive integer");
        	mainMenu();
        }
        
        int monnaie = pain.PreparerPain(recetteAchetable, amtPrix);
        
        if (monnaie == amtPrix) {
        	System.out.println("Insufficient funds to purchase.");
        } else {
        	System.out.println("Thank you for purchasing " + pain.getRecettes()[recetteAchetable].getName());
        }
        System.out.println("Your change is: " + monnaie + "\n");
        mainMenu();
    }
    
    /**
     * Passes a prompt to the user and returns the user specified 
     * string.
     * @param message
     * @return String
     */
    private static String inputOutput(String message) {
        System.out.println(message);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String returnString = "";
	    try {
	        returnString = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Error reading in value");
	        mainMenu();
	    }
	    return returnString;
    }
    
    /**
     * Passes a prompt to the user that deals with the recipe list
     * and returns the user selected number.
     * @param message
     * @return int
     */
    private static int listeRecetteDisponible(String message) {
    	String selectionUtilisateur = inputOutput(message);
    	int recette = 0;
        try {
        	recette = Integer.parseInt(selectionUtilisateur) - 1;
        	if (recette >= 0 && recette <=2) {
        		//do nothing here.
        	} else {
        		recette = -1;
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Please select a number from 1-3.");
        	recette = -1;
        }
        return recette;
    }
    
    /**
     * Starts the coffee maker program.
     * @param args
     */
    public static void main(String[] args) {
	    pain = new Main();
	    System.out.println("Welcome to the CoffeeMaker!\n");
	    mainMenu();
	}
}
