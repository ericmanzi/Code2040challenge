package code2040;

import java.io.IOException;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.*;






import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hamcrest.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
public class SendPost {
	//{"result":"RJZXdUBEzB"}
	public static void main(String[] args) throws IOException, JSONException, ParseException {
//		String token="";
//		JSONObject json = new JSONObject();
//		json.put("email", "ermanzi@mit.edu");
//		json.put("github", "https://github.com/ericmanzi/Code2040challenge.git");
//		
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost post = new HttpPost("http://challenge.code2040.org/api/register");
//        StringEntity params = new StringEntity(json.toString());
//        CloseableHttpResponse response = null;
//        Scanner in = null;
//        
//        try {
//        	post.addHeader("content-type", "application/json");
//            post.setEntity(params);
//            response = httpClient.execute(post);
//            HttpEntity entity = response.getEntity();
//            in = new Scanner(entity.getContent());
//            while (in.hasNext())
//            {
//            	String input=in.next();
//            	System.out.println(input);
//            	token=getToken(input);
//            }
//            EntityUtils.consume(entity);
//        } finally {
//            in.close();
//            response.close();
//        }
//        
//        
//        
//        ///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~GETSTRING~~~~~~~~~~~~~~~~~
//        JSONObject json2 = new JSONObject();
//		json2.put("token", token);
//		CloseableHttpClient httpClient2 = HttpClients.createDefault();
//        HttpPost post2 = new HttpPost("http://challenge.code2040.org/api/getstring");
//        StringEntity params2 = new StringEntity(json2.toString());
//        CloseableHttpResponse response2 = null;
//        Scanner in2 = null;
//        String toReverse="";
//        try {
//        	post2.addHeader("content-type", "application/json");
//            post2.setEntity(params2);
//            response2 = httpClient.execute(post2);
//            HttpEntity entity2 = response2.getEntity();
//            in2 = new Scanner(entity2.getContent());
//            while (in2.hasNext())
//            {
//            	String input2=in2.next();
//            	System.out.println("word to reverse: "+ input2);
//            	toReverse=getToken(input2);
//            }
//            EntityUtils.consume(entity2);
//        } finally {
//            in2.close();
//            response2.close();
//        }
//        
//        //reverse the string
//        String toReturn = reverse(toReverse);
//        System.out.print(toReturn);
//        ///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~VALIDATESTRING~~~~~~~~~~~~~~~~~~~~~
//        JSONObject json3 = new JSONObject();
//		json3.put("token", token);
//		json3.put("string", toReturn);
//		CloseableHttpClient httpClient3 = HttpClients.createDefault();
//        HttpPost post3 = new HttpPost("http://challenge.code2040.org/api/validatestring");
//        StringEntity params3 = new StringEntity(json3.toString());
//        CloseableHttpResponse response3 = null;
//        Scanner in3 = null;
//        try {
//        	post3.addHeader("content-type", "application/json");
//            post3.setEntity(params3);
//            response3 = httpClient.execute(post3);
//            HttpEntity entity3 = response3.getEntity();
//            in3 = new Scanner(entity3.getContent());
//            while (in3.hasNext())
//            {
//            	System.out.println("success: "+in3.next());
//            }
//            EntityUtils.consume(entity3);
//        } finally {
//            in3.close();
//            response3.close();
//        }
//        
//        
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~GET NEEDLE IN HAYSTACK~~~~~~~~~~~~~~~~~~~~
//		JSONObject json4 = new JSONObject();
//		json4.put("token", "RJZXdUBEzB");
//		CloseableHttpClient httpClient4 = HttpClients.createDefault();
//		HttpPost post4 = new HttpPost("http://challenge.code2040.org/api/haystack");
//		StringEntity params4 = new StringEntity(json4.toString());
//		CloseableHttpResponse response4 = null;
//		Scanner in4 = null;
//		String input4="";
//		try {
//			post4.addHeader("content-type", "application/json");
//			post4.setEntity(params4);
//			response4 = httpClient4.execute(post4);
//			HttpEntity entity4 = response4.getEntity();
//			in4 = new Scanner(entity4.getContent());
//			while (in4.hasNext())
//			{
//				input4 = in4.next();
//				
//				System.out.println("success: "+input4);
//			}
//			EntityUtils.consume(entity4);
//		} finally {
//			in4.close();
//			response4.close();
//		}
//		
//		//~~~~~~~~~~~~~~~~~~~~~~~~~~~FOUND NEEDLE~~~~~~~~~~~~~
//		String needle = getToken(input4);
//		System.out.println(needle);
//		String want = input4.substring(10, input4.length()-1);
//		System.out.println(want);
//		HashMap<String, JSONArray> hash2 = jsonToMap(want);
//		int index =findNeedle(hash2.get("haystack"), needle);
//		System.out.print(index);
//		
//		//~~~~~~~~~~~~~~~~~~~~~~~~~SEND INDEX~~~~~~~~~~~~~~~~~~
//		JSONObject json5 = new JSONObject();
//		json5.put("token", "RJZXdUBEzB");
//		json5.put("needle", index);
////		json5.put("needle", Integer.toString(index));
//		CloseableHttpClient httpClient5 = HttpClients.createDefault();
//		HttpPost post5 = new HttpPost("http://challenge.code2040.org/api/validateneedle");
//		StringEntity params5 = new StringEntity(json5.toString());
//		CloseableHttpResponse response5 = null;
//		Scanner in5 = null;
//		String input5="";
//		try {
//			post5.addHeader("content-type", "application/json");
//			post5.setEntity(params5);
//			response5 = httpClient5.execute(post5);
//			HttpEntity entity5 = response5.getEntity();
//			in5 = new Scanner(entity5.getContent());
//			while (in5.hasNext())
//			{
//				input5 = in5.next();
//				System.out.println("API: "+input5);
//			}
//			EntityUtils.consume(entity5);
//		} finally {
//			in5.close();
//			response5.close();
//		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~GET PREFIX ~~~~~~~~~~~~~~~
//		JSONObject json6 = new JSONObject();
//		json6.put("token", "RJZXdUBEzB");
//		CloseableHttpClient httpClient6 = HttpClients.createDefault();
//		HttpPost post6 = new HttpPost("http://challenge.code2040.org/api/prefix");
//		StringEntity params6 = new StringEntity(json6.toString());
//		CloseableHttpResponse response6 = null;
//		Scanner in6 = null;
//		String input6="";
//		try {
//			post6.addHeader("content-type", "application/json");
//			post6.setEntity(params6);
//			response6 = httpClient6.execute(post6);
//			HttpEntity entity6 = response6.getEntity();
//			in6 = new Scanner(entity6.getContent());
//			while (in6.hasNext())
//			{
//				input6 = in6.next();
//				System.out.println("API: "+input6);
//			}
//			EntityUtils.consume(entity6);
//		} finally {
//			in6.close();
//			response6.close();
//		}
//		//~~~~~~~~~~~~~~~~~~GET PREFIXED ARRAY~~~~~~~~~
//		String prefix = getToken(input6);
//		String want = input6.substring(10, input6.length()-1);
//		HashMap<String, JSONArray> hash2 = jsonToMap(want, "array");
//		String[] result = SendPost.findPrefixMatch(hash2.get("array"), prefix);
////		//~~~~~~~~~~~~~~~~~RETURN ARRAY OF MATCHES~~~~~~~~~
//		JSONObject json7 = new JSONObject();
//		json7.put("token", "RJZXdUBEzB");
//		json7.put("array", result);
//		CloseableHttpClient httpClient7 = HttpClients.createDefault();
//		HttpPost post7 = new HttpPost("http://challenge.code2040.org/api/validateprefix");
//		StringEntity params7 = new StringEntity(json7.toString());
//		CloseableHttpResponse response7 = null;
//		Scanner in7 = null;
//		String input7="";
//		try {
//			post7.addHeader("content-type", "application/json");
//			post7.setEntity(params7);
//			response7 = httpClient7.execute(post7);
//			HttpEntity entity7 = response7.getEntity();
//			in7 = new Scanner(entity7.getContent());
//			while (in7.hasNext())
//			{
//				input7 = in7.next();
//				System.out.println("API: "+input7);
//			}
//			EntityUtils.consume(entity7);
//		} finally {
//			in7.close();
//			response7.close();
//		}
		
		
		//~~~~~~~~~~~~~~~~~~~~~~~~FINAL CHALLENGE~~~~~~~~~~~~~~~~
//		JSONObject json8 = new JSONObject();
//		json8.put("token", "RJZXdUBEzB");
//		CloseableHttpClient httpClient8 = HttpClients.createDefault();
//		HttpPost post8 = new HttpPost("http://challenge.code2040.org/api/time");
//		StringEntity params8 = new StringEntity(json8.toString());
//		CloseableHttpResponse response8 = null;
//		Scanner in8 = null;
//		String input8="";
//		try {
//			post8.addHeader("content-type", "application/json");
//			post8.setEntity(params8);
//			response8 = httpClient8.execute(post8);
//			HttpEntity entity8 = response8.getEntity();
//			in8 = new Scanner(entity8.getContent());
//			while (in8.hasNext())
//			{
//				input8 = in8.next();
//				System.out.println("API: "+input8);
//			}
//			EntityUtils.consume(entity8);
//		} finally {
//			in8.close();
//			response8.close();
//		}
//		
//		
//		String want = input8.substring(10, input8.length()-1);
//		int interval = getInterval(want).get("interval");
//		String date = getKeyfromJson(want, "datestamp");
//		String OrdDate = date.substring(0,date.length()-1);
//		SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//		Date d = ISO8601DATEFORMAT.parse(date);
//		System.out.println(ISO8601DATEFORMAT.parse(date));
//		long timeInMillisSinceEpoch = d.getTime(); 
//		long timeInSecondsSinceEpoch = timeInMillisSinceEpoch / (1000);
//		long newTime = timeInSecondsSinceEpoch + interval;
//		System.out.println(timeInSecondsSinceEpoch);
//		System.out.println(newTime);
//		Date newD = new Date(newTime*1000);
//		String formatedDate = ISO8601DATEFORMAT.format(newD)+"Z";
//		System.out.println(formatedDate);
		
		//~~~~~~~~~~~~~~~~~~~~CHALLENGE COMPLETED~~~~~~~~~~~~~~
//		JSONObject json9 = new JSONObject();
//		json9.put("token", "RJZXdUBEzB");
//		json9.put("datestamp", formatedDate);
//		CloseableHttpClient httpClient9 = HttpClients.createDefault();
//		HttpPost post9 = new HttpPost("http://challenge.code2040.org/api/validatetime");
//		StringEntity params9 = new StringEntity(json9.toString());
//		CloseableHttpResponse response9 = null;
//		Scanner in9 = null;
//		String input9="";
//		try {
//			post9.addHeader("content-type", "application/json");
//			post9.setEntity(params9);
//			response9 = httpClient9.execute(post9);
//			HttpEntity entity9 = response9.getEntity();
//			in9 = new Scanner(entity9.getContent());
//			while (in9.hasNext())
//			{
//				input9 = in9.next();
//				System.out.println("API: "+input9);
//			}
//			EntityUtils.consume(entity9);
//		} finally {
//			in9.close();
//			response9.close();
//		}
		JSONObject json9 = new JSONObject();
		json9.put("token", "RJZXdUBEzB");
		CloseableHttpClient httpClient9 = HttpClients.createDefault();
		HttpPost post9 = new HttpPost("http://challenge.code2040.org/api/status");
		StringEntity params9 = new StringEntity(json9.toString());
		CloseableHttpResponse response9 = null;
		Scanner in9 = null;
		String input9="";
		try {
			post9.addHeader("content-type", "application/json");
			post9.setEntity(params9);
			response9 = httpClient9.execute(post9);
			HttpEntity entity9 = response9.getEntity();
			in9 = new Scanner(entity9.getContent());
			while (in9.hasNext())
			{
				input9 = in9.next();
				System.out.println("API: "+input9);
			}
			EntityUtils.consume(entity9);
		} finally {
			in9.close();
			response9.close();
		}
		
    }
	public static String getToken(String s) {
		 Pattern pattern = Pattern.compile("((:\".*)\"})");
		 java.util.regex.Matcher m = pattern.matcher(s);
		 if (m.find()) {
			 String tokenBlackGuy = m.group(0);
			 return tokenBlackGuy.substring(2, tokenBlackGuy.length()-2);
		 } else {
			 return "";
		 }
		 
	}
	
	public static HashMap<String, Integer> getInterval(String s) {
		HashMap<String, Integer> intervalMap = new HashMap<String, Integer>();
		try {
		    JSONObject json = new JSONObject(s.trim());
		    intervalMap.put("interval", json.getInt("interval"));
		} catch (JSONException e) {
		     e.printStackTrace();
		}
		return intervalMap;
	}
	
	public static String getNeedle(String s) {
		 Pattern pattern = Pattern.compile("((:\".*)\"})");
		 java.util.regex.Matcher m = pattern.matcher(s);
		 if (m.find()) {
			 String tokenBlackGuy = m.group(0);
			 return tokenBlackGuy.substring(1, tokenBlackGuy.length()-1);
		 } else {
			 return "";
		 }
		 
	}
	
	public static List<String> getList(String s) {
		 Pattern pattern = Pattern.compile("(\\[.*\\])");
		 java.util.regex.Matcher m = pattern.matcher(s);
		 String[] res;
		 if (m.find()) {
			 String stack = m.group(0);
			 res = stack.substring(1, stack.length()-1).split(",");
		 } else {
			 String[] empty={};
			 res = empty;
		 }
		 List<String> fin= new ArrayList<String>();
		 for (String thing: res) {
			 fin.add(thing.substring(1, thing.length()-1));
		 }
		 return fin;
	}
	
	public static String getKeyfromJson(String s, String key) throws JSONException {
		StringBuilder sb = new StringBuilder();
		try {
			JSONObject json = new JSONObject(s.trim());
			sb.append(json.getString(key));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static HashMap<String, JSONArray> jsonToMap(String t, String key) throws JSONException {

		HashMap<String, JSONArray> hashMap = new HashMap<String, JSONArray>();

		try {
		    JSONObject json = new JSONObject(t.trim());
		    hashMap.put(key, json.getJSONArray(key));
		} catch (JSONException e) {
		     e.printStackTrace();
		}
		return hashMap;
    }
	
	public static String[] findPrefixMatch(JSONArray array, String prefix) throws JSONException {
		List<String> list = new ArrayList<String>();

		if (array != null) { 
			int len = array.length();
			for (int i=0;i<len;i++){ 
				list.add(array.get(i).toString());
			} 
		}
//		System.out.println("list: "+list);
		int maxind = prefix.length();
		List<String> tempArray = new ArrayList<String>();
		for (String word: list) {
//			System.out.println("substring: "+word.substring(0, maxind));
//			if (word.substring(0, maxind)==prefix) {
			if (!word.startsWith(prefix)) {
				tempArray.add(word);
			}
		}
		System.out.println("");
		String[] result = new String[tempArray.size()];
		result = tempArray.toArray(result);
		return result;
		
	}
	
	public static int findNeedle(JSONArray haystack, String needle) throws JSONException {
//		int needle_index = -1;
//		for (int i=0; i<haystack.length(); i++) {
//        	if (haystack.get(i)==needle) {
//        		needle_index = i;
//        	}
//        }
		List<String> list = new ArrayList<String>();
		
		if (haystack != null) { 
			   int len = haystack.length();
			   for (int i=0;i<len;i++){ 
			    list.add(haystack.get(i).toString());
			   } 
			} 
		int index = -1;
		for (int i = 0; i<list.size(); i++) {
			if (list.get(i)==needle) {
				index = i;
			}
		} return index;
//		return list.indexOf(needle);
	}
	
	public static String reverse(String s) {
		StringBuilder r = new StringBuilder();
		for (int i=0; i<s.length(); i++) {
			int index=s.length()-1-i;
			r.append(s.charAt(index));
		}
		return r.toString();
	}
}
