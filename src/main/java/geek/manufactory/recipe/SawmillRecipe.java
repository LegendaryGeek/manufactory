package geek.manufactory.recipe;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SawmillRecipe extends SpecialRecipe {
	
	/*
	 * literally just a created class. needs everything to make it specialz
	 */

	public SawmillRecipe(ResourceLocation p_i48169_1_) {
		super(p_i48169_1_);
		// TODO Auto-generated constructor stub
	}
	
	   /**
	    * Used to check if a recipe matches current crafting inventory
	    */
	@Override
	public boolean matches(CraftingInventory inv, World worldIn) {
		return false;
	}

	/**
	    * Returns an Item that is the result of this recipe
	    */
	@Override
	public ItemStack getCraftingResult(CraftingInventory inv) {
		// TODO Auto-generated method stub
		return null;
	}

	   /**
	    * Used to determine if this recipe can fit in a grid of the given width/height
	    */
	@Override
	public boolean canFit(int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		// TODO Auto-generated method stub
		return null;
	}

}
