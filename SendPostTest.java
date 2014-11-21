package code2040;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

public class SendPostTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void testReverseEmptyString() {
		String ssadab = "";
		String expected = "";
		String actual = SendPost.reverse(ssadab);
		assertEquals(expected, actual);
	}
	@Test
	public void testReverseSingleCharacter() {
		String ssadab = "b";
		String expected = "b";
		String actual = SendPost.reverse(ssadab);
		assertEquals(expected, actual);
	}
	@Test
	public void testReverseSingleWord() {
		String ssadab = "ssadab";
		String expected = "badass";
		String actual = SendPost.reverse(ssadab);
		assertEquals(expected, actual);
	}
	@Test
	public void testReverseWordsAndSpaces() {
		String ssadab = "ssadab a ma i";
		String expected = "i am a badass";
		String actual = SendPost.reverse(ssadab);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetToken() {
		String expected = "RJZXdUBEzB";
		String result = "{\"result\":\"RJZXdUBEzB\"}";
		assertEquals(expected, SendPost.getToken(result));
	}
	
	@Test
	public void testGetTokenWithInts() {
		String expected = "RJ1Xd4BE55B";
		String result = "{\"result\":\"RJ1Xd4BE55B\"}";
		assertEquals(expected, SendPost.getToken(result));
	}
	
	@Test
	public void testCollections() {
//		success: {"result":{"haystack":["O4EyF","dBcld","8qTKb","emGlT","WkwSf","62Nm6","G9Tma","PAInX","gGfup","doU7C","T4aPl","6leGH","DScx9","CPKDV","ShF6U","3A6Ov","Wn6t8","WwsHc","tTlA4","Fr0If"],"needle":"ShF6U"}}
		String[] haystack = {"n4iGb","BZKYa","AYZO3","lKOEf","fR7qH","RoBFL","sqQ3O","OJMCt","TwDnt","FKbxr","jgF9G","0vBna","Rdgdn","GhxXw","oxAgZ","8ptJj","EfxS7","5ivOj","2Ch86","5lsTT"};
		String needle="AYZO3";
		int needle_index = -1;
		for (int i=0; i<haystack.length; i++) {
        	if (haystack[i]==needle) {
        		needle_index = i;
        	}
        }
//		System.out.print(needle_index);
	}
	
//	@Test
	public void testGetList() {
		String expected ="[\"O4EyF\",\"dBcld\",\"8qTKb\",\"emGlT\",\"WkwSf\",\"62Nm6\"]";
		Pattern pattern = Pattern.compile("(\\[.*\\])");
		 java.util.regex.Matcher m = pattern.matcher(expected);
		 if (m.find()) {
			 String b = m.group(0);
			 System.out.print(b);
		 } else {
			 System.out.print("Not found");
		 }
	}
	
//	@Test
	public void testGetliist() {
		String s = "success: {\"result\":{\"haystack\":[\"O4EyF\", \"dBcld\", \"8qTKb\",\"emGlT\"],\"needle\":\"ShF6U\"}}";
		List<String> hay = SendPost.getList(s);
		for (String i: hay) {
			continue;
//			System.out.println(i);
		}
	}
	
	@Test
	public void testGetNeedle() {
		String expected = "\"ShF6U\"";
		String result = "success: {\"result\":{\"haystack\":[\"O4EyF\", \"dBcld\", \"8qTKb\",\"emGlT\"],\"needle\":\"ShF6U\"}}";
		assertEquals(expected, SendPost.getNeedle(result));
	}
	
//	@Test
	public void Testhaystack() throws JSONException {
//		String thing2 = "success: {\"result\":{\"haystack\":[\"O4EyF\",\"dBcld\",\"DScx9\",\"CPKDV\",\"ShF6U\",\"3A6Ov\",\"Wn6t8\",\"WwsHc\",\"tTlA4\",\"Fr0If\"],\"needle\":\"ShF6U\"}}";
		String thing2 = "success: {\"result\":{\"haystack\":[\"ShF6U\",\"3A6Ov\",\"Wn6t8\"],\"needle\":\"ShF6U\"}}";
		String thing= "{\"name\":\"mkyong\", \"age\":\"29\"}";
		String thing3 = "success: {\"result\":{\"haystack\":[\"vFxJj\",\"E04c9\",\"vuyqV\",\"KGpn0\",\"I6R9l\"],\"needle\":\"KGpn0\"}}";
		String needle = SendPost.getToken(thing3);
//		List<String> haystack = SendPost.getList(thing);
		String want = thing3.substring(19, thing3.length()-1);
//		System.out.println(want);
//		System.out.println(thing);
//		System.out.println((int)thing.trim().charAt(0));
		
//		HashMap<String, String> hashy = SendPost.jsonToMap(thing);
		HashMap<String, JSONArray> hash2 = SendPost.jsonToMap(want, "haystack");
		System.out.print(hash2);
		
		System.out.print(needle);
		
//		System.out.print(hashy.values());
//		System.out.print(thing.substring(19, thing.length()-1));
//		SendPost.jsonToMap(thing.substring(19, thing.length()-1));
//		System.out.println(needle);
//		for (String thingie : haystack) {
//			System.out.println(thingie);
//		}
		System.out.print(SendPost.findNeedle(hash2.get("haystack"), needle));
	}
	
	@Test
	public void testFindNeedle() {
		List<String> test = Arrays.asList("a", "ShF6U", "c");
		String needle = "ShF6U";
//		System.out.println(SendPost.findNeedle(test, needle));
	}
	
	@Test
	public void testjsontoMapandGetKEyfromJson() throws JSONException {
		String input = "{\"result\":{\"array\":[\"528euxkv\",\"528BuL6k\",\"52877xr1\",\"869uJrIa\",\"858cRtF1\",\"858fq4vx\"],\"prefix\":\"858\"}}";
		String want =input.substring(10, input.length()-1);
		String prefix = SendPost.getToken(input);
		HashMap<String, JSONArray> hash2 = SendPost.jsonToMap(want, "array");	
//		System.out.print(prefix);
//		System.out.print(hash2.get("array"));
		String[] result = SendPost.findPrefixMatch(hash2.get("array"), prefix);
		for (String i: result) {
			System.out.print(i);
		}
		}
	

}
