package geek.manufactory.container.sawmill;

import geek.manufactory.blocks.MachineBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ForgeHooks;

public class SawmillTileentity extends MachineBase {
	
	/*
	 * the tile entity handles any and all calculation needed for
	 * the entire block.
	 */
	
	// the type for this tile entity
	public static TileEntityType<SawmillTileentity> type;

	public SawmillTileentity(MaterialTier tier) {
		super(type, tier);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Container createMenu(int windowId, PlayerInventory inventory, PlayerEntity player) {
		return new SawmillContainer(windowId, inventory);
	}

}
