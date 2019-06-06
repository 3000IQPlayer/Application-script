package JHerblore.enums;

import org.rev317.min.api.methods.Inventory;

public enum Potions {                  // These were really notes to myself
    COMBAT(36, 9737, 9742, 98, 15, 16), // 98 is Harralander unf potion // last 0 is unfinished potion or potion needed to make finished pot is bank slot
    ANTIPOISONPLUSPLUS(79, 260, 35955, 35952, 5936, 0, 0), //  The digit before the last 0 is the bank slot for herbs or other ingredients
    EXTREME_ATTACK(88, 262, 15310, 146, 0, 0),
    EXTREME_STRENGTH(89, 268, 15314, 158, 0, 0),
    EXTREME_DEFENCE(90, 2482, 15318, 164, 0, 0),
    EXTREME_RANGING(92, 12540, 15326, 170, 0, 0),
    EXTREME_MAGIC(91, 9595, 15322, 3043, 0, 0),
	OVERLOAD(96, 270, 15333, 15314, 0, 0);
   
	private int levelReq;
    private int ingrdId;
    private int finishId;
    private int unfinId;
    private int herbId;
    private int bankslotherbs;  // this is the bankslot of either a herb or other ingreidient. Not just herbs
    private int bankslotunifpot;
 

    Potions(int levelReq, int herbId, int finishId, int ingrdId, int bankslotherbs, int bankslotunfpot) {
        this.levelReq = levelReq;
        this.herbId = herbId;
        this.finishId = finishId;
        this.ingrdId = ingrdId;
        this.bankslotherbs = bankslotherbs;
        this.bankslotunifpot = bankslotunfpot;
        
    }
    
    Potions(int levelReq, int herbId, int finishId, int unfinId, int ingrdId, int bankslotherbs, int bankslotunfpot) { 
        this.levelReq = levelReq;
        this.herbId = herbId;
        this.finishId = finishId;
        this.unfinId = unfinId;
        this.ingrdId = ingrdId;
        this.bankslotherbs = bankslotherbs;
        this.bankslotunifpot = bankslotunfpot;
    }

    public int getHerbId() { // Returns the herb or Item needed to use with a vial of water or other potion
        return herbId;
    }

    public int getIngredId() { // returns the potion needed to use with herb to make with potion. An example is super attack.
        return ingrdId;
    }

    public int getFinishId() { // The outcome of the combination of the herb and ingredient item.
        return finishId;
    }
    
    public int getUnfinId() { // Sometimes theres multiple steps into making a potion, an example is Super Antipoison++.
    	                      // coconutmilk+irit -> antipoison++unf + magic root ->  
        return unfinId;
    }
    
    public boolean hasUnfinIngredients() {  // This will check if it has any herbs + the following ingredients in the inventory 
        return Inventory.getCount(unfinId) > 0 && Inventory.getCount(herbId) > 0;
    }
    public int getLevelReq() {
    	return levelReq;
    }
    
    public int getBankSlotHerbs() {
    	return bankslotherbs;
    }
    
    public int getBankSlotUnfPots() {
    	return bankslotunifpot;
    	
    }
}
    