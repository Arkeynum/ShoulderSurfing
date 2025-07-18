package com.github.exopandora.shouldersurfing.plugin;

import com.github.exopandora.shouldersurfing.ShoulderSurfingCommon;
import com.github.exopandora.shouldersurfing.api.plugin.IShoulderSurfingPlugin;
import com.github.exopandora.shouldersurfing.api.plugin.IShoulderSurfingRegistrar;
import com.github.exopandora.shouldersurfing.compat.Mods;
import com.github.exopandora.shouldersurfing.compat.plugin.CreateModTargetCameraOffsetCallback;
import com.github.exopandora.shouldersurfing.plugin.callbacks.AdaptiveItemCallback;
import com.github.exopandora.shouldersurfing.plugin.callbacks.CameraEntityTransparencyCallback;
import com.github.exopandora.shouldersurfing.plugin.callbacks.CameraEntityTransparencyCallbackWhenAiming;
import org.apache.commons.lang3.StringUtils;

public class ShoulderSurfingPlugin implements IShoulderSurfingPlugin
{
	@Override
	public void register(IShoulderSurfingRegistrar registrar)
	{
		registrar.registerAdaptiveItemCallback(new AdaptiveItemCallback());
		registrar.registerCameraEntityTransparencyCallback(new CameraEntityTransparencyCallback());
		registrar.registerCameraEntityTransparencyCallback(new CameraEntityTransparencyCallbackWhenAiming());
		registerCompatibilityCallback(Mods.CREATE, () -> registrar.registerTargetCameraOffsetCallback(new CreateModTargetCameraOffsetCallback()));
	}
	
	private static void registerCompatibilityCallback(Mods mod, Runnable runnable)
	{
		if(mod.isLoaded())
		{
			String modName = StringUtils.capitalize(mod.name());
			
			try
			{
				ShoulderSurfingCommon.LOGGER.info("Registering compatibility callback for {}", modName);
				runnable.run();
			}
			catch(Throwable t)
			{
				ShoulderSurfingCommon.LOGGER.error("Failed to load compatibility callback for {}", modName, t);
			}
		}
	}
}
