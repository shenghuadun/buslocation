package com.gigi.buslocation.util;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.util.ParserException;

import com.gigi.buslocation.bean.BusPosition;
import com.gigi.buslocation.bean.BusStation;

public class BusUtil
{
	private static BusUtil instance = new BusUtil();
	private BusUtil()
	{}
	
	/**
	 * 返回工具实例
	 * @param context
	 * @return
	 */
	public static BusUtil getInstance()
	{
		return instance;
	}
	
	/**
	 * 查询指定路线和方向的公交站信息
	 * @param lineId 路线
	 * @param direction 方向
	 * @return 
	 * @throws ParserException 
	 */
	public List<BusStation> getBusStations(String lineId, String direction) throws ParserException
	{
		List<BusStation> result = new ArrayList<BusStation>();

		result = BusInfoParser.getLineInfo(lineId, direction);
			
		return result;
	}
	
	/**
	 * 查询指定路线和方向的公交站信息
	 * @param lineId 路线
	 * @return 
	 * @throws ParserException 
	 */
	public List<BusStation> getBusStations(String lineId) throws ParserException
	{
		List<BusStation> result = new ArrayList<BusStation>();

		result = BusInfoParser.getLineInfo(lineId, "1");
		result.addAll(BusInfoParser.getLineInfo(lineId, "0"));

		return result;
	}

	/**
	 * 查询公交车的当前位置信息，如果未发车或无车，返回空列表
	 * @param lineId 公交路线
	 * @param stationId 站点ID
	 * @param segmentId 区域ID
	 * @return
	 * @throws ParserException 网络有问题时抛出
	 */
	public List<BusPosition> getBusPosition(String lineId, String stationId, String segmentId) throws ParserException
	{
		return BusInfoParser.getBusPosition(lineId, stationId, segmentId);
	}

	/**
	 * 查询公交车的当前位置信息，如果未发车或无车，返回null
	 * @param station 站点
	 * @return
	 * @throws ParserException 网络有问题时抛出
	 */
	public List<BusPosition> getBusPosition(BusStation station) throws ParserException
	{
		return getBusPosition(station.getLineId(), station.getStationId(), station.getSegmentId());
	}

	/**
	 * 根据站名查询站点信息
	 * @param busStations
	 * @param stationName
	 * @return
	 */
	public static BusStation getStationByName(List<BusStation> busStations, String stationName)
	{
		BusStation station = null;
		if(null != busStations)
		{
			for(BusStation tmp : busStations)
			{
				if(tmp.getStationName().equals(stationName))
				{
					station = tmp;
				}
			}
		}
		return station;
	}

	/**
	 * 判断当前站名是不是在positions中
	 * @param stationName
	 * @param positions
	 * @return
	 */
	public boolean busInPosition(String stationName, List<BusPosition> positions)
	{
		boolean inPosition = false;
		for(BusPosition position : positions)
    	{
			if(position.getStationName().equals(stationName))
			{
				inPosition = true;
				break;
			}
    	}
		return inPosition;
	};  
}
