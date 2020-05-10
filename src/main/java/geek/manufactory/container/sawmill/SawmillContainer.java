package geek.manufactory.container.sawmill;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

public class SawmillContainer extends Container {
	
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