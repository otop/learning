package jsonobject;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectParser {

	public static void main(String[] args) {
		JSONObject obj;
		try {
			obj = new JSONObject("{interests : [{interestKey:Dogs}, {interestKey:Cats}]}");
			List<String> list = new ArrayList<String>(); 
			JSONArray array = obj.getJSONArray("interests"); 

			for(int i = 0 ; i < array.length() ; i++){ 
				list.add(array.getJSONObject(i).getString("interestKey")); 
				System.out.println(list.get(i));
			} 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
