package geek.manufactory;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registry {
	public static DeferredRegister<Block> BlocksRegistry = new DeferredRegister<>(ForgeRegistries.BLOCKS, ManuFactory.getModID());
	public static DeferredRegister<Item> ItemsRegistry = new DeferredRegister<>(ForgeRegistries.ITEMS, ManuFactory.getModID());

	public Block tinBlock = registerBlock("tinBlock", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON)));
	
	public Item tinIngot = registerItem("tiningot", new Item(new Item.Properties()));
	
	public <T extends Block> T registerBlock(String name, T block) {
		BlocksRegistry.register(name, () -> block);
		return block;
	}
	
	public <T extends Item> T registerItem(String name, T item) {
		ItemsRegistry.register(name, () -> item);
		return item;
	}
}
