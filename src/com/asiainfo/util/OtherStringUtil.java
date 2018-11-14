package com.asiainfo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherStringUtil {
	/**
	 * 将字符串中@@中的数据提取出来
	 */
	public static Map<String,List<Integer>> str2Map(String str){
		Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
		String[] split = str.split("@");
		/**
		 * 1_1
		 * 1_2
		 * 1_3
		 * 2_1
		 * 2_2
		 */
		for (String s : split) {
			if(s.indexOf("_")!=-1){
				String[] s2 = s.split("_");
				if(map.containsKey(s2[0])){
					map.get(s2[0]).add(Integer.parseInt(s2[1]));
					map.put(s2[0], map.get(s2[0]));
				}else{
					List<Integer> list = new ArrayList<Integer>();
					list.add(Integer.parseInt(s2[1]));
					map.put(s2[0], list);
				}
			}
		}
		return map;
	}
}
