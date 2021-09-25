package com.teamderpy.shouldersurfing.asm;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

public class ShoulderPlugin implements IFMLLoadingPlugin
{
	@Override
	public String[] getASMTransformerClass()
	{
		return new String[]
		{
			"com.teamderpy.shouldersurfing.asm.transformers.EntityPlayerRayTrace",
			"com.teamderpy.shouldersurfing.asm.transformers.EntityRendererGetMouseOver",
			"com.teamderpy.shouldersurfing.asm.transformers.EntityRendererGetMouseOver2",
			"com.teamderpy.shouldersurfing.asm.transformers.EntityRendererOrientCamera",
			"com.teamderpy.shouldersurfing.asm.transformers.EntityRendererRayTrace"
		};
	}
	
	@Override
	public String getModContainerClass()
	{
		return null;
	}
	
	@Override
	public String getSetupClass()
	{
		return null;
	}
	
	@Override
	public void injectData(Map<String, Object> data)
	{
		
	}
	
	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
}
