package JHerblore.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;

import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.wrappers.Item;

public class Makefullpots implements Strategy {
	private final int Prayerpot = 140;

	@Override
	public boolean activate() {
		if (Inventory.containts(Prayerpot) && Game.getOpenInterfaceId() == 5292) {
			return true;
		}
			return false;
			
		
	}
    // This class isn't apart of the script yet.  Was testing on how to make full pots of prayer potion (4) with the script. 
	@Override
	public void execute() {
	     
		if ((Inventory.getCount(2435) < 14)) {
		for (Item i : Inventory.getItems(Prayerpot)) {
		
			Menu.sendAction(447, i.getId() - 1, i.getSlot() , 3214);
			Time.sleep(100);
			Menu.sendAction(870, i.getId() - 1, i.getSlot() + 1 , 3214);
			Time.sleep(100);
			
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return i.getId() == 2435;
				}
			}, 150);
			 if( i.getId() != 2435 || Inventory.getCount(2435) == 14) {
				 Time.sleep(400);
		            break;
			
			 }
		}
		}
	}
}
