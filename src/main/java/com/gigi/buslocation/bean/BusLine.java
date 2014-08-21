package com.gigi.buslocation.bean;


public class BusLine
{

	/**
	 * 线路id
	 */
	private String lineId;
	
	/**
	 * 线路名称
	 */
	private String lineName;
	
	/**
	 * 搜索关键字
	 */
	private String searchKey;
	
	/**
	 * 主要站点描述
	 */
	private String mainStationsDesc;
	
	/**
	 * 下行描述
	 */
	private String downDesc;
	
	/**
	 * 上行描述
	 */
	private String upDesc;

	/**
	 * 下行工作时间
	 */
	private String downAvilableTime;
	
	/**
	 * 上行工作时间
	 */
	private String upAvilableTime;

	/**
	 * 线路全长
	 */
	private String totalLength;
	
	/**
	 * 票价信息
	 */
	private String price;
	
	/**
	 * 运营公司
	 */
	private String groupName;

	/*********************************************************************
	 * 
	 * 数据库列名常量列表
	 * 
	 *********************************************************************/

	public String getLineId()
	{
		return lineId;
	}

	public void setLineId(String lineId)
	{
		this.lineId = lineId;
	}

	public String getLineName()
	{
		return lineName;
	}

	public void setLineName(String lineName)
	{
		this.lineName = lineName;
	}

	public String getSearchKey()
	{
		return searchKey;
	}

	public void setSearchKey(String searchKey)
	{
		this.searchKey = searchKey;
	}

	public String getMainStationsDesc()
	{
		return mainStationsDesc;
	}

	public void setMainStationsDesc(String mainStationsDesc)
	{
		this.mainStationsDesc = mainStationsDesc;
	}

	public String getDownDesc()
	{
		return downDesc;
	}

	public void setDownDesc(String downDesc)
	{
		this.downDesc = downDesc;
	}

	public String getUpDesc()
	{
		return upDesc;
	}

	public void setUpDesc(String upDesc)
	{
		this.upDesc = upDesc;
	}

	public String getDownAvilableTime()
	{
		return downAvilableTime;
	}

	public void setDownAvilableTime(String downAvilableTime)
	{
		this.downAvilableTime = downAvilableTime;
	}

	public String getUpAvilableTime()
	{
		return upAvilableTime;
	}

	public void setUpAvilableTime(String upAvilableTime)
	{
		this.upAvilableTime = upAvilableTime;
	}

	public String getTotalLength()
	{
		return totalLength;
	}

	public void setTotalLength(String totalLength)
	{
		this.totalLength = totalLength;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getGroupName()
	{
		return groupName;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	/**
	 * 线路id
	 */
	public static final String LINEID = "lineId";
	
	/**
	 * 线路名称
	 */
	public static final String LINENAME = "lineName";
	
	/**
	 * 搜索关键字
	 */
	public static final String SEARCHKEY = "searchKey";
	
	/**
	 * 主要站点描述
	 */
	public static final String MAINSTATIONSDESC = "mainStationsDesc";
	
	/**
	 * 下行描述
	 */
	public static final String DOWNDESC = "downDesc";
	
	/**
	 * 上行描述
	 */
	public static final String UPDESC = "upDesc";

	/**
	 * 下行工作时间
	 */
	public static final String DOWNAVILABLETIME = "downAvilableTime";
	
	/**
	 * 上行工作时间
	 */
	public static final String UPAVILABLETIME = "upAvilableTime";

	/**
	 * 线路全长
	 */
	public static final String TOTALLENGTH = "totalLength";
	
	/**
	 * 票价信息
	 */
	public static final String PRICE = "price";
	
	/**
	 * 运营公司
	 */
	public static final String GROUP_NAME = "groupName";

	@Override
	public String toString()
	{
		return "【线路名称：】" + lineName + " 【线路ID:】" + lineId + " 【线路描述：】" + mainStationsDesc;
	}

}
