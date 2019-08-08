package com.jihe;
import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		Collection<String> list=new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		Iterator it=list.iterator();
		while(it.hasNext()) {
			System.out.println((String)it.next());
		}
		
		Map<String,String> map=new HashMap<>();
		map.put("321", "mark");
		map.put("312", "jim");
		map.put("123", "tim");
		Set<String> set=map.keySet();
		Iterator it2=set.iterator();
		while(it2.hasNext()) {
			String name=map.get((String)it2.next());
			System.out.println(name);
		}

	}

}
