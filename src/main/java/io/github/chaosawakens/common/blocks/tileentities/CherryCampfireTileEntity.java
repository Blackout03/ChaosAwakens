package io.github.chaosawakens.common.blocks.tileentities;

import io.github.chaosawakens.common.blocks.CherryCampfireBlock;
import io.github.chaosawakens.common.registry.CATileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class CherryCampfireTileEntity extends TileEntity implements IClearable, ITickableTileEntity {
    private final NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);
    private final int[] cookingProgress = new int[4];
    private final int[] cookingTime = new int[4];

    public CherryCampfireTileEntity() {
        super(CATileEntities.CHERRY_CAMPFIRE.get());
    }

    public void tick() {
        boolean flag = this.getBlockState().getValue(CherryCampfireBlock.LIT);
        boolean flag1 = this.level.isClientSide;
        if (flag1) {
            if (flag) {
                this.makeParticles();
            }

        } else {
            if (flag) {
                this.cook();
            } else {
                for(int i = 0; i < this.items.size(); ++i) {
                    if (this.cookingProgress[i] > 0) {
                        this.cookingProgress[i] = MathHelper.clamp(this.cookingProgress[i] - 2, 0, this.cookingTime[i]);
                    }
                }
            }

        }
    }

    private void cook() {
        for(int i = 0; i < this.items.size(); ++i) {
            ItemStack itemstack = this.items.get(i);
            if (!itemstack.isEmpty()) {
                if (this.cookingProgress[i] >= this.cookingTime[i]) {
                    IInventory iinventory = new Inventory(itemstack);
                    ItemStack itemstack1 = this.level.getRecipeManager().getRecipeFor(IRecipeType.CAMPFIRE_COOKING, iinventory, this.level).map((p_213979_1_) -> p_213979_1_.assemble(iinventory)).orElse(itemstack);
                    BlockPos blockpos = this.getBlockPos();
                    InventoryHelper.dropItemStack(this.level, blockpos.getX(), blockpos.getY(), blockpos.getZ(), itemstack1);
                    this.items.set(i, ItemStack.EMPTY);
                    this.markUpdated();
                }
            }
        }

    }

    private void makeParticles() {
        World world = this.getLevel();
        if (world != null) {
            BlockPos blockpos = this.getBlockPos();
            Random random = world.random;
            if (random.nextFloat() < 0.11F) {
                for(int i = 0; i < random.nextInt(2) + 2; ++i) {
                    CherryCampfireBlock.makeParticles(world, blockpos, this.getBlockState().getValue(CherryCampfireBlock.SIGNAL_FIRE), false);
                }
            }

            int l = this.getBlockState().getValue(CherryCampfireBlock.FACING).get2DDataValue();

            for(int j = 0; j < this.items.size(); ++j) {
                if (!this.items.get(j).isEmpty() && random.nextFloat() < 0.2F) {
                    Direction direction = Direction.from2DDataValue(Math.floorMod(j + l, 4));
                    double d0 = (double)blockpos.getX() + 0.5D - (double)((float)direction.getStepX() * 0.3125F) + (double)((float)direction.getClockWise().getStepX() * 0.3125F);
                    double d1 = (double)blockpos.getY() + 0.5D;
                    double d2 = (double)blockpos.getZ() + 0.5D - (double)((float)direction.getStepZ() * 0.3125F) + (double)((float)direction.getClockWise().getStepZ() * 0.3125F);

                    for(int k = 0; k < 4; ++k) {
                        world.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 5.0E-4D, 0.0D);
                    }
                }
            }

        }
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.load(p_230337_1_, p_230337_2_);
        this.items.clear();
        ItemStackHelper.loadAllItems(p_230337_2_, this.items);
        if (p_230337_2_.contains("CookingTimes", 11)) {
            int[] aint = p_230337_2_.getIntArray("CookingTimes");
            System.arraycopy(aint, 0, this.cookingProgress, 0, Math.min(this.cookingTime.length, aint.length));
        }

        if (p_230337_2_.contains("CookingTotalTimes", 11)) {
            int[] aint1 = p_230337_2_.getIntArray("CookingTotalTimes");
            System.arraycopy(aint1, 0, this.cookingTime, 0, Math.min(this.cookingTime.length, aint1.length));
        }

    }

    public CompoundNBT save(CompoundNBT p_189515_1_) {
        this.saveMetadataAndItems(p_189515_1_);
        p_189515_1_.putIntArray("CookingTimes", this.cookingProgress);
        p_189515_1_.putIntArray("CookingTotalTimes", this.cookingTime);
        return p_189515_1_;
    }

    private CompoundNBT saveMetadataAndItems(CompoundNBT p_213983_1_) {
        super.save(p_213983_1_);
        ItemStackHelper.saveAllItems(p_213983_1_, this.items, true);
        return p_213983_1_;
    }

    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.worldPosition, 13, this.getUpdateTag());
    }

    public CompoundNBT getUpdateTag() {
        return this.saveMetadataAndItems(new CompoundNBT());
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public void clearContent() {
        this.items.clear();
    }

    public void dowse() {
        if (this.level != null) {
            if (!this.level.isClientSide) {
                InventoryHelper.dropContents(this.level, this.getBlockPos(), this.getItems());
            }

            this.markUpdated();
        }

    }
}