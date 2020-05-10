package geek.manufactory.items.tools;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SquirtGun extends BowItem {
	private final Fluid containedBlock;

	public SquirtGun(Properties builder, Fluid fluidIn) {
		super(builder);

		this.containedBlock = fluidIn;
	}
	
	   /**
	    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
	    * {@link #onItemUse}.
	    */
	   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	      ItemStack itemstack = playerIn.getHeldItem(handIn);
	      RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, this.containedBlock == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
	      ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);
	      
	      if (ret != null) return ret;
	      if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
	         return ActionResult.resultPass(itemstack);
	      } else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
	         return ActionResult.resultPass(itemstack);
	      } else {
	         BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
	         BlockPos blockpos = blockraytraceresult.getPos();
	         Direction direction = blockraytraceresult.getFace();
	         BlockPos blockpos1 = blockpos.offset(direction);
	         
	         if (worldIn.isBlockModifiable(playerIn, blockpos) && playerIn.canPlayerEdit(blockpos1, direction, itemstack)) {
	            if (this.containedBlock == Fluids.EMPTY) {
	               BlockState blockstate1 = worldIn.getBlockState(blockpos);
	               if (blockstate1.getBlock() instanceof IBucketPickupHandler) {
	                  Fluid fluid = ((IBucketPickupHandler)blockstate1.getBlock()).pickupFluid(worldIn, blockpos, blockstate1);
	                  if (fluid != Fluids.EMPTY) {
	                     playerIn.addStat(Stats.ITEM_USED.get(this));

	                     SoundEvent soundevent = this.containedBlock.getAttributes().getEmptySound();
	                     if (soundevent == null) soundevent = fluid.isIn(FluidTags.LAVA) ? SoundEvents.ITEM_BUCKET_FILL_LAVA : SoundEvents.ITEM_BUCKET_FILL;
	                     playerIn.playSound(soundevent, 1.0F, 1.0F);
	                     ItemStack itemstack1 = this.fillBucket(itemstack, playerIn, fluid.getFilledBucket());
	                     if (!worldIn.isRemote) {
	                        CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity)playerIn, new ItemStack(fluid.getFilledBucket()));
	                     }

	                     return ActionResult.resultSuccess(itemstack1);
	                  }
	               }

	               return ActionResult.resultFail(itemstack);
	            } else {
	            	// Do stuff if possible
	               RayTraceResult rtrus = squirtgun.rayTrace(worldIn, playerIn, FluidMode.ANY);
	               if (rtrus.getType() == RayTraceResult.Type.BLOCK) {
	            	   BlockRayTraceResult blockrtrus = (BlockRayTraceResult)rtrus;
	            	   BlockState blockstate1 = worldIn.getBlockState(blockrtrus.getPos());
	            	   if(blockstate1.getBlock() == Blocks.WATER && this.containedBlock == Fluids.LAVA) {
	            		   worldIn.setBlockState(blockrtrus.getPos(), Blocks.COBBLESTONE.getDefaultState());
	            	   } else if (blockstate1.getBlock() == Blocks.LAVA && this.containedBlock == Fluids.WATER) { 
	            		   worldIn.setBlockState(blockrtrus.getPos(), Blocks.STONE.getDefaultState());
	            	   } else if (blockstate1.getBlock() == Blocks.FIRE && this.containedBlock == Fluids.WATER) {
	            		   worldIn.setBlockState(blockrtrus.getPos(), Blocks.AIR.getDefaultState());
	            	   } else if (blockstate1.getBlock() == Blocks.CAMPFIRE && this.containedBlock == Fluids.WATER) {
	            		   if(blockstate1.get(BlockStateProperties.LIT).booleanValue() == true) {
	            			  worldIn.setBlockState(blockrtrus.getPos(), Blocks.CAMPFIRE.getDefaultState().with(BlockStateProperties.LIT, true));
	            		   }
	            	   }
	               }
	            }
	         } else {
	            return ActionResult.resultFail(itemstack);
	         }
	      }
	   }

}
