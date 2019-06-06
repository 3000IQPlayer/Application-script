package JHerblore;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;

import JHerblore.enums.Potions;
import JHerblore.gui.Gui;
import JHerblore.strategies.Bankwithdraw;
import JHerblore.strategies.Clickbank;
import JHerblore.strategies.MakePotstwoitems;

@ScriptManifest(author = "Jadsbutt", category = Category.HERBLORE, description = "Makes a wide variety of potions.", name = "JAIOHerblore", servers = { "Ikov" }, version = 1.0)

public class JHerblore extends Script implements Paintable, MessageListener {
	
	 private final Timer RUNTIME = new Timer(); // Gonna use this for run timer in paint
	 
	 private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	    @Override
	    public boolean onExecute() {
	    	 Gui main = new Gui();
	    	 while (main.isVisible()) {
              Time.sleep(600);
	    	 }
	    	 Potions potion = main.getPotion();
	    	 strategies.add(new Bankwithdraw(potion));
	    	 strategies.add(new Clickbank(potion));
	    	 strategies.add(new MakePotstwoitems(potion));
	     
	        provide(strategies);
	        return true;
	    }
		@Override
		public void messageReceived(MessageEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void paint(Graphics arg0) {
			// TODO Auto-generated method stub
		}
	
	}



