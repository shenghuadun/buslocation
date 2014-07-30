package com.gigi.buslocation.util;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.Span;

public class NodeFilterFactory
{
	/**
	 * 公交站过滤器
	 */
	public static NodeFilter busStationFilter = new NodeFilter()
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean accept(Node node)
		{
			if(node != null && node instanceof Div 
					&& "article".equals(((Div)node).getAttribute("class")))
				return true;
			return false;
		}
	};
	

	/**
	 * 公交站点seq过滤器
	 */
	public static NodeFilter busStationIDFilter = new NodeFilter()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6026041245485919070L;

		public boolean accept(Node node)
		{
			if(node != null && node instanceof Div)
			{
				if("titlebar".equals(((Div)node).getAttribute("class")))
				{
					return true;
				}
				else
					return false;
			}
			return false;
		}
	};
	
	/**
	 * 公交站点seq过滤器
	 */
	public static NodeFilter busStationSeqFilter = new NodeFilter()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -127258451412550683L;

		public boolean accept(Node node)
		{
			if(node != null && node instanceof Span)
			{
				if("s-num inblock x-large".equals(((Span)node).getAttribute("class")))
				{
					return true;
				}
				else
					return false;
			}
			return false;
		}
	};
	
	/**
	 * 公交站点名称过滤器
	 */
	public static NodeFilter busStationNameFilter = new NodeFilter()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 4350626103324753498L;

		public boolean accept(Node node)
		{
			if(node != null && node instanceof Span)
			{
				if("s-name inblock x-large".equals(((Span)node).getAttribute("class")))
				{
					return true;
				}
				else
					return false;
			}
			return false;
		}
	};
	
	/**
	 * 公交车牌过滤器
	 */
	public static NodeFilter busPlateFilter = new NodeFilter()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -3379296767002557873L;

		public boolean accept(Node node)
		{
			if(node != null && node instanceof Span)
			{
				if("b-no inblock".equals(((Span)node).getAttribute("class")))
				{
					return true;
				}
				else
					return false;
			}
			return false;
		}
	};
	
	/**
	 * 公交距离过滤器
	 */
	public static NodeFilter busStationNumFilter = new NodeFilter()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1773546847297799923L;

		public boolean accept(Node node)
		{
			if(node != null && node instanceof Span)
			{
				if("b-s inblock".equals(((Span)node).getAttribute("class")))
				{
					return true;
				}
				else
					return false;
			}
			return false;
		}
	};

	/**
	 * 公交当前站点过滤器
	 */
	public static NodeFilter busCurrentStationFilter = new NodeFilter()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -775537849407696696L;

		public boolean accept(Node node)
		{
			if(node != null && node instanceof Span)
			{
				if("b-t block".equals(((Span)node).getAttribute("class")))
				{
					return true;
				}
				else
					return false;
			}
			return false;
		}
	};
}
