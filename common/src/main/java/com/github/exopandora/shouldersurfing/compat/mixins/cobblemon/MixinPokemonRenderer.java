package com.github.exopandora.shouldersurfing.compat.mixins.cobblemon;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(targets = "com.cobblemon.mod.common.client.render.pokemon.PokemonRenderer")
public class MixinPokemonRenderer
{
	@Redirect
	(
		method = "shouldRenderLabel",
		at = @At
		(
			value = "INVOKE",
			target = "Lcom/cobblemon/mod/common/util/PlayerExtensionsKt;isLookingAt$default(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;FFILjava/lang/Object;)Z",
			remap = true
		),
		remap = false
	)
	private static boolean isLookingAt$default(Entity entity, Entity other, float maxDistance, float stepDistance, int flags, Object object)
	{
		return other == Minecraft.getInstance().crosshairPickEntity;
	}
}
