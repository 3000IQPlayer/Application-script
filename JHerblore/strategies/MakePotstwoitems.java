package JHerblore.strategies;


import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;

import JHerblore.enums.Potions;

public class MakePotstwoitems implements Strategy { // This class name is kind've confusing, but makes a finished potions that require one step. 
	 private final int ingrId;
	 private final int herbId;

	 public MakePotstwoitems(Potions potion) {
	        this.ingrId = potion.getIngredId();
	        this.herbId = potion.getHerbId();
	    }
	 
	@Override
	public boolean activate() {
		if(Inventory.containts(ingrId)) { // Returns true if the player has the ingredients in inventory
			
			return true;
		}
		
		return false;
	}

	@Override
	public void execute() {
		if(Players.getMyPlayer().getAnimation() != 363) {
			/*Menu.sendAction(447, ingrId, 13, 3214, 0, 22265);
			Time.sleep(300);
			Menu.sendAction(870, herbId, 14, 3214, 0, 22265);
			Time.sleep(500);
			Mouse.getInstance().click(5, 25, false);  The coordinates are wrong, but this is what I was going to use to click on the herblore interface.*/
			// Probably add a sleep after this to check the animation ;p 
			
		}
	}
}




