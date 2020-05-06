package geek.manufactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Registry {
	 private static final Logger LOGGER = LogManager.getLogger();
	
	protected  static DeferredRegister<Block> BlocksRegistry = new DeferredRegister<>(ForgeRegistries.BLOCKS, ManuFactory.getModID());
	protected  static DeferredRegister<Item> ItemsRegistry = new DeferredRegister<>(ForgeRegistries.ITEMS, ManuFactory.getModID());

	public static final RegistryObject<Block> tinBlock = registerBlock("tinBlock", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON)));
	
	public static final RegistryObject<Item> tinIngot = registerItem("tiningot", new Item(new Item.Properties()));
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, T block) {
		RegistryObject<T> register = BlocksRegistry.register(name, () -> block);
		LOGGER.info("registered block: " + block.getRegistryName());
		return register;
	}
	
	private static <T extends Item> RegistryObject<T> registerItem(String name, T item) {
		RegistryObject<T> register = ItemsRegistry.register(name, () -> item);
		LOGGER.info("registered item: " + item.getRegistryName());
		return register;
	}
}
