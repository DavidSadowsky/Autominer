package org.dsadowsky.mining.tasks;

import org.dsadowsky.mining.Autominer;
import org.dsadowsky.mining.data.Location;
import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.script.task.Task;

public class Drop extends Task {

    private static final String DROP_ACTION = "Drop";

    @Override
    public boolean validate() {
        return Inventory.isFull() && Autominer.location.equals(Location.POWERMINE);
    }

    @Override
    public int execute() {
        for(Item ore : Inventory.getItems(item -> item.getName().equals(Autominer.rock.getName()))) {
            ore.interact(DROP_ACTION);
            Time.sleep(300);
        }
        return Random.nextInt(400,600);
    }
}
