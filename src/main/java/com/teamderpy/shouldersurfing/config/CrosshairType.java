package com.teamderpy.shouldersurfing.config;

import com.teamderpy.shouldersurfing.client.ShoulderHelper;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public enum CrosshairType
{
	ADAPTIVE,
	DYNAMIC,
	STATIC,
	STATIC_WITH_1PP;
	
	public boolean isDynamic()
	{
		if(this == CrosshairType.ADAPTIVE)
		{
			return ShoulderHelper.isHoldingSpecialItem();
		}
		else if(this == CrosshairType.DYNAMIC)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean doSwitchPerspective()
	{
		if(this == CrosshairType.STATIC_WITH_1PP)
		{
			return ShoulderHelper.isHoldingSpecialItem();
		}
		
		return false;
	}
}