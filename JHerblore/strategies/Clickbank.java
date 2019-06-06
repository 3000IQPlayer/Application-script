package JHerblore.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;
import JHerblore.enums.Potions;


public class Clickbank implements Strategy {
	 private final int finId;
	 private final int ingrId;
	 private final int herbId;

	 public Clickbank(Potions potion) {
	        this.finId = potion.getFinishId();
	        this.ingrId = potion.getIngredId();
	        this.herbId = potion.getHerbId();
	    }
	@Override
	public boolean activate() {
		if (Game.getOpenInterfaceId() != 5292 && !Inventory.containts(ingrId) || Inventory.getCount(finId) == 14) { // Clicks if gets one of these
         
			return true;
		
		}
		
		return false;
	}

	@Override
	public void execute() {
		 SceneObject[] BANKBOOTH = SceneObjects.getNearest(2213);
		 if (Game.getOpenInterfaceId() != 5292 && BANKBOOTH.length > 0) {
			 BANKBOOTH[0].interact(0);
	         Time.sleep(1000);
	     }
	}
}