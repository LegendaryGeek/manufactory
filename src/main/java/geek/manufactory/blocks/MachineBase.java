package geek.manufactory.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraftforge.common.ToolType;

public abstract class MachineBase extends Block {
	
	protected enum MaterialTier { // assuming it's internal to MachineBase
		WOOD (1,1, ItemTier.WOOD),
		STONE (2,2, ItemTier.STONE),
		IRON (3,3, ItemTier.IRON),
		DIAMOND (4,4, ItemTier.DIAMOND),
		GOLD (6,0, ItemTier.GOLD);

		final int speed;
		final int fuelEfficiency;
		final IItemTier toolTier;

		MaterialTier (int speed, int fuelEfficiency, IItemTier toolTier) {
			this.speed = speed;
			this.fuelEfficiency = fuelEfficiency;
			this.toolTier = toolTier;
		}
	}

	// static variables used for internal calculations
	private static final int FUEL_PER_BURN_TICK = 96;
	private static final int TIME_PER_TICK = 12;


	private MaterialTier tier;

	public MachineBase(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}


}
