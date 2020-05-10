package geek.manufactory.container.sawmill;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

public class SawmillContainer extends Container {

	/*
	 * the container should hold everything that deals with slots, 
	 * like auto input, auto output,inventory, etc. just need to 
	 * figure out how to slots
	 * */ 

	// the container type for this container
	public static ContainerType<SawmillContainer> TYPE;

	public SawmillContainer(int id) {
		super(TYPE, id);

	}

	public SawmillContainer(int windowId, PlayerInventory inventory) {
		this(windowId, inventory);
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return true;
	}

}