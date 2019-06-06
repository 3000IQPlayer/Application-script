package JHerblore.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;
import JHerblore.enums.Potions;


public class Bankwithdraw implements Strategy {
	 private final int finId;
	 private final int ingrId;
	 private final int herbId;
	 private final int bankslotherbs;
	 private final int bankslotunifpot;
	
	 
	 public Bankwithdraw(Potions potion) {
	        this.finId = potion.getFinishId();
	        this.ingrId = potion.getIngredId();
	        this.bankslotherbs = potion.getBankSlotHerbs();
	        this.bankslotunifpot = potion.getBankSlotUnfPots();
	        this.herbId = potion.getHerbId();
	    }
	@Override
	public boolean activate() {
		if (Game.getOpenInterfaceId() == 5292) {
         
			return true;
		
		}
		
		return false;
	}

	@Override
	public void execute() {
		
	    	  if (!Inventory.containts(ingrId) && Inventory.containts(finId)) {  // It banks all the finished pots.
			 Menu.sendAction(431, finId - 1 , 0, 5064, 0, 22265);
			 Time.sleep(500, 1200);
			
			 } else if (!Inventory.containts(ingrId)) { // Grabs other ingredient item
			 Menu.sendAction(53, ingrId , bankslotunifpot, 18693, ingrId - 1, 22265);
			 Time.sleep(800);
			 Keyboard.getInstance().sendKeys("14");
		     Time.sleep(700);

			 } 
	    	  if (Inventory.containts(ingrId) && !Inventory.containts(herbId)) {  // Grabs herbs 
				 Menu.sendAction(53, herbId, bankslotherbs, 18693, ingrId, 22265);
				 Time.sleep(800);
				 Keyboard.getInstance().sendKeys("14");
			     Time.sleep(700);
			 }
	    	  if(Inventory.containts(ingrId) && Inventory.containts(herbId)) { // Closes the bank if it has these two. 
	    		  Menu.sendAction(200, 0, 0, 5384, 22265);
	    		  Time.sleep(300, 500);
	    	  }
	}
}

