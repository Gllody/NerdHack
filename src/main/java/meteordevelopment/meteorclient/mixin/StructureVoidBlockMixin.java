/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.mixin;

import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.render.Deadmausmod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.StructureVoidBlock;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StructureVoidBlock.class)
public abstract class StructureVoidBlockMixin extends Block {

    public StructureVoidBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "getRenderType", cancellable = true)
    public void getRenderType(BlockState state, CallbackInfoReturnable<BlockRenderType> info) {
        info.setReturnValue(BlockRenderType.MODEL);
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState neighbor, Direction facing) {
        return !(Modules.get().get(Deadmausmod.class).renderStructureVoid());
    }
}
