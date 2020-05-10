package geek.manufactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import geek.manufactory.container.sawmill.SawmillContainer;
import geek.manufactory.container.sawmill.SawmillTileentity;
import geek.manufactory.items.tools.squirtgun;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public final class Registry {
	 private static final Logger LOGGER = LogManager.getLogger();
	
	protected static DeferredRegister<Block> BlocksRegistry = new DeferredRegister<>(ForgeRegistries.BLOCKS, ManuFactory.getModID());
	protected static DeferredRegister<Item> ItemsRegistry = new DeferredRegister<>(ForgeRegistries.ITEMS, ManuFactory.getModID());
	protected static DeferredRegister<ContainerType<?>> ContainerRegistry = new DeferredRegister<>(ForgeRegistries.CONTAINERS, ManuFactory.getModID());
	protected static DeferredRegister<TileEntityType<?>> tileEntityRegistry = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, ManuFactory.getModID());

	public static final RegistryObject<Block> tinBlock = registerBlock("tinblock", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON)));
	
	public static final RegistryObject<Item> tinIngot = registerItem("tiningot", new Item(new Item.Properties()));
	public static final RegistryObject<Item> squirtGun = registerItem("squirtgun", new squirtgun(new Item.Properties().))
	
	public static final RegistryObject<ContainerType<?>> sawmillContainer = registerContainer("sawmill", SawmillContainer.TYPE);
	
	public static final RegistryObject<TileEntityType<SawmillTileentity>> sawmilltileentity = registerTileEntity("sawmill", SawmillTileentity.type);
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, T block) {
		RegistryObject<T> register = BlocksRegistry.register(name, () -> block);
		registerItem(name, new BlockItem(block, new Item.Properties()));
		LOGGER.info("registered block: " + block.getRegistryName());
		return register;
	}
	
	private static <T extends Item> RegistryObject<T> registerItem(String name, T item) {
		RegistryObject<T> register = ItemsRegistry.register(name, () -> item);
		LOGGER.info("registered item: " + item.getRegistryName());
		return register;
	}
	
	private static <T extends ContainerType<?>> RegistryObject<T> registerContainer(String name, T container){
		RegistryObject<T> register = ContainerRegistry.register(name, () -> container);
		LOGGER.info("registered container: " + container.getRegistryName());
		return register;
	}
	
	private static <T extends TileEntityType<?>> RegistryObject<T> registerTileEntity(String name, T tileentity){
		RegistryObject<T> register = tileEntityRegistry.register(name, () -> tileentity);
		LOGGER.info("registered container: " + tileentity.getRegistryName());
		return register;
	}
}
