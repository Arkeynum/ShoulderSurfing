package com.github.exopandora.shouldersurfing.fabric.compat;

import com.github.exopandora.shouldersurfing.compat.Mods;
import com.github.exopandora.shouldersurfing.compat.ShoulderSurfingCompatMixinPlugin;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.metadata.version.VersionPredicate;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.ArrayList;
import java.util.List;

public class ShoulderSurfingCompatMixinPluginFabric extends ShoulderSurfingCompatMixinPlugin
{
	@Override
	public List<String> getMixins()
	{
		List<String> mixins = new ArrayList<String>();
		addCommonCompatMixins(mixins);
		addCreateModMixins(mixins);
		addIrisMixins(mixins);
		addSkinLayersMixins(mixins);
		return mixins.isEmpty() ? null : mixins;
	}
	
	private static void addIrisMixins(List<String> mixins)
	{
		String irisModVersion = Mods.IRIS.getModVersion();
		
		if(irisModVersion != null)
		{
			Version version = parseVersionSilent(irisModVersion);
			
			if(parseVersionPredicateSilent(">=1.7.0-snapshot").test(version))
			{
				mixins.add("iris.MixinSheets_1_7_0");
			}
			else if(parseVersionPredicateSilent("<1.7.0-snapshot >=1.6.17").test(version))
			{
				mixins.add("iris.MixinSheets_1_6_15");
			}
		}
	}
	
	private static void addCreateModMixins(List<String> mixins)
	{
		String createModVersion = Mods.CREATE.getModVersion();
		
		if(createModVersion != null)
		{
			Version version = parseVersionSilent(createModVersion);
			
			if(parseVersionPredicateSilent(">=6.0.0").test(version))
			{
				mixins.add("create.MixinContraptionHandlerClient_6_0_0");
			}
			else if(parseVersionPredicateSilent("<6.0.0").test(version))
			{
				mixins.add("create.MixinContraptionHandlerClient_0_5_0");
			}
		}
	}
	
	private static void addSkinLayersMixins(List<String> mixins)
	{
		String skinLayersModVersion = Mods.SKIN_LAYERS.getModVersion();
		
		if(skinLayersModVersion != null)
		{
			Version version = parseVersionSilent(skinLayersModVersion);
			
			if(parseVersionPredicateSilent(">=1.6.6").test(version))
			{
				mixins.add("skinlayers.MixinCustomizableModelPart_1_6_6");
			}
			else if(parseVersionPredicateSilent("<1.6.6").test(version))
			{
				mixins.add("skinlayers.MixinCustomizableModelPart_1_6_5");
			}
		}
	}
	
	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo)
	{
		
	}
	
	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo)
	{
		
	}
	
	private static Version parseVersionSilent(String version)
	{
		try
		{
			return Version.parse(version);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	private static VersionPredicate parseVersionPredicateSilent(String predicate)
	{
		try
		{
			return VersionPredicate.parse(predicate);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
