package me.iffa.bananaspace.listeners.spout;

import me.iffa.bananaspace.BananaSpace;
import me.iffa.bananaspace.api.event.area.AreaEnterEvent;
import me.iffa.bananaspace.api.event.area.AreaLeaveEvent;
import me.iffa.bananaspace.api.event.area.SpaceAreaListener;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;
/**
 * Area Listener to change gravity settings between Space areas and Airlock areas
 * @author HACKhalo2
 */
public class SpaceSpoutAreaListener extends SpaceAreaListener {
    private final BananaSpace plugin;
    
    public SpaceSpoutAreaListener(BananaSpace plugin) {
	this.plugin = plugin;
    }
    
    @Override
    public void onAreaEnter(AreaEnterEvent event) {
	SpoutPlayer player = SpoutManager.getPlayer(event.getPlayer());
	if(player.isSpoutCraftEnabled()) {
	    //reset the movement multipliers
	    player.setAirSpeedMultiplier(1);
	    player.setGravityMultiplier(1);
	    player.setWalkingMultiplier(1);
	}
    }
    
    @Override
    public void onAreaLeave(AreaLeaveEvent event) {
	SpoutPlayer player = SpoutManager.getPlayer(event.getPlayer());
	if(player.isSpoutCraftEnabled()) {
	    //set the movement multipliers for space
	    player.setAirSpeedMultiplier(1.2);
	    player.setGravityMultiplier(0.3);
	    player.setWalkingMultiplier(0.7);
	}
    }

}
