/*
 * http://www.json.org/
 * https://github.com/stleary/JSON-java
 * 
 * 
 * */
package jmeter.json;

import java.util.Arrays;

import org.json.*;

public class JsonTest {

	public static void main(String[] args) {
//		String response_data = prev.getResponseDataAsString();
		String jsonStr = "{\"id\":\"07\",\"language\": [{\"name\":\"1111\"},{\"name\":\"22222\"}]"
				+",\"edition\": \"second\",\"author\": \"E.Balagurusamy\"}";
		JSONTokener jsonTokener = new JSONTokener(jsonStr);
		JSONObject data_obj=new JSONObject(jsonTokener);
		String id_str=data_obj.getString("id");
		JSONArray lang_arry=data_obj.getJSONArray("language");
		for(int i=0;i<lang_arry.length();i++) {
			JSONObject lang_obj=new JSONObject(lang_arry.get(i).toString());
			String name=lang_obj.getString("name");
			System.out.println(name);
		}
//		vars.put("result", Arrays.toString(result));

	}

}
