package Boulangerie;

public class Inventaire {
	
	private static int farine;
    private static int eau;
    private static int levure;
    private static int sel;
    
    /**
     * Creates a coffee maker inventory object and
     * fills each item in the inventory with 15 units.
     */
    public Inventaire() {
    	setFarine(15);
    	setEau(15);
    	setLevure(15);
    	setSel(15);
    }
    
    /**
     * Returns the current number of chocolate units in 
     * the inventory.
     * @return int
     */
    public int getSel() {
        return sel;
    }
    
    /**
     * Sets the number of chocolate units in the inventory
     * to the specified amount.
     * @param chocolate
     */
    public void setSel(int sel) {
    	if(sel >= 0) {
    		Inventaire.sel = sel;
    	}
        
    }
    
    /**
     * Add the number of chocolate units in the inventory 
     * to the current amount of chocolate units.
     * @param chocolate
     * @throws InventoryException
     */
    public void addSel(String sel) throws InventoryException {
    	int amtSel = 0;
    	try {
    		amtSel = Integer.parseInt(sel);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Units of sel must be a positive integer");
    	}
		if (amtSel >= 0) {
			Inventaire.sel += amtSel;
		} else {
			throw new InventoryException("Units of sel must be a positive integer");
		}
    }
    
    /**
     * Returns the current number of coffee units in
     * the inventory.
     * @return int
     */
    public int getFarine() {
        return farine;
    }
    
    /**
     * Sets the number of coffee units in the inventory 
     * to the specified amount.
     * @param coffee
     */
    public void setFarine(int farine) {
    	if(farine >= 0) {
    		Inventaire.farine = farine;
    	}
    }
    
    /**
     * Add the number of coffee units in the inventory 
     * to the current amount of coffee units.
     * @param coffee
     * @throws InventoryException
     */
    public void addFarine(String farine) throws InventoryException {
    	int amtFarine = 0;
    	try {
    		amtFarine = Integer.parseInt(farine);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Units of farine must be a positive integer");
    	}
		if (amtFarine >= 0) {
			Inventaire.farine += amtFarine;
		} else {
			throw new InventoryException("Units of farine must be a positive integer");
		}
    }
    
    /**
     * Returns the current number of milk units in
     * the inventory.
     * @return int
     */
    public int getEau() {
        return eau;
    }
    
    /**
     * Sets the number of milk units in the inventory
     * to the specified amount.
     * @param milk
     */
    public void setEau(int eau) {
    	if(eau >= 0) {
    		Inventaire.eau = eau;
    	}
    }
    
    /**
     * Add the number of milk units in the inventory 
     * to the current amount of milk units.
     * @param milk
     * @throws InventoryException
     */
    public void addEau(String eau) throws InventoryException {
    	int amtEau = 0;
    	try {
    		amtEau = Integer.parseInt(eau);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Units of eau must be a positive integer");
    	}
		if (amtEau >= 0) {
			Inventaire.eau += amtEau;
		} else {
			throw new InventoryException("Units of eau must be a positive integer");
		}
    }
    
    /**
     * Returns the current number of sugar units in 
     * the inventory.
     * @return int
     */
    public int getLevure() {
        return levure;
    }

    /**
     * Sets the number of sugar units in the inventory
     * to the specified amount.
     * @param sugar
     */
    public void setLevure(int levure) {
    	if(levure >= 0) {
    		Inventaire.levure = levure;
    	}
    }
    
    /**
     * Add the number of sugar units in the inventory 
     * to the current amount of sugar units.
     * @param sugar
     * @throws InventoryException
     */
    public void addLevure(String levure) throws InventoryException {
    	int amtLevure = 0;
    	try {
    		amtLevure = Integer.parseInt(levure);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Units of levure must be a positive integer");
    	}
		if (amtLevure >= 0) {
			Inventaire.levure += amtLevure;
		} else {
			throw new InventoryException("Units of levure must be a positive integer");
		}
    }
    
    /**
     * Returns true if there are enough ingredients to make
     * the beverage.
     * @param r
     * @return boolean
     */
    public boolean IngredientsSuffisant(Recette a) {
        boolean suffisant = true;
        if(Inventaire.farine < a.getAmtFarine()) {
            suffisant = false;
        }
        if(Inventaire.eau < a.getAmtEau()) {
            suffisant = false;
        }
        if(Inventaire.levure < a.getAmtLevure()) {
            suffisant = false;
        }
        if(Inventaire.sel < a.getAmtSel()) {
            suffisant = false;
        }
        return suffisant;
    }
    
    /**
     * Removes the ingredients used to make the specified 
     * recipe.  Assumes that the user has checked that there
     * are enough ingredients to make 
     * @param r
     */
    public boolean utiliseIngredients(Recette a) {
    	if (IngredientsSuffisant(a)) {
    		Inventaire.farine -= a.getAmtFarine();
    		Inventaire.eau -= a.getAmtEau();
    		Inventaire.levure -= a.getAmtLevure();
    		Inventaire.sel -= a.getAmtSel();
	    	return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Returns a string describing the current contents 
     * of the inventory.
     * @return String
     */
    public String toString() {
    	StringBuffer buf = new StringBuffer();
    	buf.append("Farine: ");
    	buf.append(getFarine());
    	buf.append("\n");
    	buf.append("Eau: ");
    	buf.append(getEau());
    	buf.append("\n");
    	buf.append("Levure: ");
    	buf.append(getLevure());
    	buf.append("\n");
    	buf.append("Sel: ");
    	buf.append(getSel());
    	buf.append("\n");
    	return buf.toString();
    }
}

