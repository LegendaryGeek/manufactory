package geek.manufactory.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraftforge.common.ToolType;

public class MachineBase extends Block {
	
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
