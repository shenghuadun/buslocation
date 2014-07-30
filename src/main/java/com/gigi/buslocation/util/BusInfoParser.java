package com.gigi.buslocation.util;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Parser;
import org.htmlparser.tags.Span;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.gigi.buslocation.bean.BusPosition;
import com.gigi.buslocation.bean.BusStation;

class BusInfoParser
{
	private static Parser parser = new Parser(); 
	
	/**
	 * 查询指定公交路线的站点信息
	 * @param lineId 公交路线
	 * @param direction 方向
	 * @return
	 * @throws ParserException 网络有问题时抛出
	 */
	public static List<BusStation> getLineInfo(String lineId, String direction) throws ParserException
	{
		List<BusStation> result = new ArrayList<BusStation>();
		
		parser.setURL("http://khd.qingdaonews.com/qdbus/ss/index.php?direct=" 
				+ direction + "&routeId=" + lineId);
		
		NodeList stationList = parser.extractAllNodesThatMatch(NodeFilterFactory.busStationFilter);
		
		int size = stationList.size();
		
		try
		{
			for (int i = 0; i < size; i++)
			{
				result.add(BusStation.Builder.build(stationList.elementAt(i), lineId, direction));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 查询公交车的当前位置信息，如果未发车或无车，返回null
	 * @param lineId 公交路线
	 * @param stationId 站点ID
	 * @param segmentId 区域ID
	 * @return
	 * @throws ParserException 网络有问题时抛出
	 */
	public static List<BusPosition> getBusPosition(String lineId, String stationId, String segmentId) throws ParserException
	{
		parser.setURL("http://khd.qingdaonews.com//qdbus/ss/busdetail.php?r="
				+ Math.random() + "&routeId=" + lineId + "&segmentId=" + segmentId + "&stationId=" + stationId);
		
		NodeList stationList = parser.parse(null);
		
		String[] positions = stationList.toHtml().split(":\"")[1].split("\",")[0].replace("\\", "").split("<br />");
		
		List<BusPosition> result = new ArrayList<BusPosition>();
		try
		{
			for(String html : positions)
			{
				BusPosition position = new BusPosition();
				parser.setInputHTML(html);
				
				//车牌号
				NodeList list = parser.parse(NodeFilterFactory.busPlateFilter);
				position.setBusPlateNum(((Span)list.elementAt(0)).getStringText());
	
				//距离站数
				parser.setInputHTML(html);
				list = parser.parse(NodeFilterFactory.busStationNumFilter);
				position.setStationNum(((Span)list.elementAt(0)).getStringText().split(" ")[1]);
	
				//最近站点及时间
				parser.setInputHTML(html);
				list = parser.parse(NodeFilterFactory.busCurrentStationFilter);
				position.setStationName(((Span)list.elementAt(0)).getStringText().split("（")[0]);
				
				String time = ((Span)list.elementAt(0)).getStringText().split("（")[1].split("）")[0];
				int index = time.indexOf("前");
				if(-1 != index)
				{
					time = time.substring(0, time.indexOf("前")).replaceAll(" ", "");
				}
				position.setWhen(time);
			
				result.add(position);
			}
		} 
		//总站未发车或没找到车辆
		catch (NullPointerException e)
		{
			return new ArrayList<BusPosition>();
		}
		
		return result;
	}
}
