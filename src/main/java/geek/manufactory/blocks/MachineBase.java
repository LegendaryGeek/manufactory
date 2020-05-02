package geek.manufactory.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraftforge.common.ToolType;

public class MachineBase extends Block {
	
	/*
	 * Mat.  Time  Fuel  F/t
	 * Diam    75   150    2
	 * Iron   100   300    3
	 * Ston   150   600    4
	 * Wood   300  1200    4
	 * Gold    50  2400   48
	 */
	
	private int speed;
	private IItemTier toolTier;

	public MachineBase(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	public MachineBase WoodTeir(MachineBase machine) {
		return machine;
	}

}
