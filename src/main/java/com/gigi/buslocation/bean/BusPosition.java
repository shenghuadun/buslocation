package com.gigi.buslocation.bean;

public class BusPosition
{
	/**
	 * 车牌号
	 */
	private String busPlateNum;
	
	/**
	 * 当前位置
	 */
	private String stationName;
	
	/**
	 * 多久前
	 */
	private String when;
	
	/**
	 * 距查询站点间距站数
	 */
	private String stationNum;

	public String getBusPlateNum()
	{
		return busPlateNum;
	}

	public void setBusPlateNum(String busPlateNum)
	{
		this.busPlateNum = busPlateNum;
	}

	public String getStationName()
	{
		return stationName;
	}

	public void setStationName(String stationName)
	{
		this.stationName = stationName;
	}

	public String getWhen()
	{
		return when;
	}

	public void setWhen(String when)
	{
		this.when = when;
	}

	public String getStationNum()
	{
		return stationNum;
	}

	public void setStationNum(String stationNum)
	{
		this.stationNum = stationNum;
	}

	@Override
	public String toString()
	{
		return "车辆【" + when + "】前到达" + stationName +"，距离本站还有【" + stationNum + "】站"; 
	}
	
	
}
