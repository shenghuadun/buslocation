package com.gigi.buslocation.bean;

import java.io.Serializable;

import org.htmlparser.Node;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.Span;
import org.htmlparser.util.NodeList;

import com.gigi.buslocation.util.NodeFilterFactory;

public class BusStation implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -439367454541253346L;

	/**
	 * 站点名称
	 */
	private String stationName;
	
	/**
	 * 站点ID
	 */
	private String stationId;
	
	/**
	 * 区域ID
	 */
	private String segmentId;
	
	/**
	 * 序号，从1开始
	 */
	private String seq;

	/**
	 * 路线号
	 */
	private String lineId;

	/**
	 * 方向
	 */
	private String direction;

	/*********************************************************************
	 * 
	 * 数据库列名常量列表
	 * 
	 *********************************************************************/

	/**
	 * 站点名称
	 */
	public static String STATION_NAME = "stationName";
	
	/**
	 * 站点ID
	 */
	public static  String STATION_ID = "stationId";
	
	/**
	 * 区域ID
	 */
	public static  String SEGMENT_ID = "segmentId";
	
	/**
	 * 序号，从1开始
	 */
	public static  String SEQ = "seq";

	/**
	 * 路线号
	 */
	public static  String LINE_ID = "lineId";

	/**
	 * 方向
	 */
	public static  String DIRECTION = "direction";

	/**
	 * 状态时间
	 */
	public static  String STATUS_DATE = "statusDate";

	public String getStationName()
	{
		return stationName;
	}

	public void setStationName(String stationName)
	{
		this.stationName = stationName;
	}

	public String getStationId()
	{
		return stationId;
	}

	public void setStationId(String stationId)
	{
		this.stationId = stationId;
	}

	public String getSeq()
	{
		return seq;
	}

	public void setSeq(String seq)
	{
		this.seq = seq;
	}

	public String getSegmentId()
	{
		return segmentId;
	}

	public void setSegmentId(String segmentId)
	{
		this.segmentId = segmentId;
	}
	
	public String getLineId()
	{
		return lineId;
	}

	public void setLineId(String lineId)
	{
		this.lineId = lineId;
	}

	public String getDirection()
	{
		return direction;
	}

	public void setDirection(String direction)
	{
		this.direction = direction;
	}

	public static class Builder
	{
		public static BusStation build(Node node, String lineId, String direction) throws Exception
		{
			if(null != node && node instanceof Div)
			{
				BusStation station = new BusStation();
	
				// 获取stationId 和 segmentId
				NodeList list = new NodeList();
				node.collectInto(list, NodeFilterFactory.busStationIDFilter);
					
				station.setStationId((((Div)list.elementAt(0)).getAttribute("stationId")));
				station.setSegmentId((((Div)list.elementAt(0)).getAttribute("segmentId")));
				
				list = new NodeList();
				node.collectInto(list, NodeFilterFactory.busStationSeqFilter);
				station.setSeq((((Span)list.elementAt(0)).getStringText()));

				list = new NodeList();
				node.collectInto(list, NodeFilterFactory.busStationNameFilter);
				station.setStationName((((Span)list.elementAt(0)).getStringText()));
				
				station.setLineId(lineId);
				station.setDirection(direction);
				return station;
			}
			else
			{
				throw new Exception("元素不是Div，无法解析站点信息");
			}
		}
	}

	@Override
	public String toString()
	{
		return "【站点名称：】" + stationName + " 【站点ID:】" + stationId + " 【站点序号：】" + seq + " 【站点区域：】" + segmentId;
	}

}
