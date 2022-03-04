package postal_code_tw;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import au.com.bytecode.opencsv.CSVReader;

public class postalCode {

	private static ArrayList<String> code_city_area_raw; // raw
	private static ArrayList<String> code_city_area; // distinct
	private static ArrayList<ArrayList<String>> code3_city_area; // distinct
	private static ArrayList<ArrayList<String>> code3_city; // distinct
	private static ArrayList<ArrayList<String>> code3_city_area_taipei; // distinct
	private static ArrayList<ArrayList<String>> code3_city_area_newtaipei; // distinct

	
	public static void main(String[] args) throws Exception {
		code_city_area_raw = new ArrayList<String>();
		code_city_area = new ArrayList<String>();
		code3_city_area = new ArrayList<ArrayList<String>>();
		code3_city = new ArrayList<ArrayList<String>>();
		code3_city_area_taipei = new ArrayList<ArrayList<String>>();
		code3_city_area_newtaipei = new ArrayList<ArrayList<String>>();

		readCSV("src/postal_code.csv", code_city_area_raw);
		
		// code_city_area
		Collections.sort(code_city_area_raw);
		code_city_area.add(code_city_area_raw.get(0));
		for(int i = 1; i < code_city_area_raw.size()-1; i++) { // 最後一個是表頭
			int pre = i-1;
			if(!code_city_area_raw.get(i).equals(code_city_area_raw.get(pre))) {
				code_city_area.add(code_city_area_raw.get(i));
			}
		}
		
		// print code_city_area
		System.out.println("code_city_area:");
		for(int i = 0; i < code_city_area.size(); i++) {
			System.out.println(code_city_area.get(i));
		}
		
		// code3_city_area
		System.out.println("code3_city_area:");
		for(int i = 0; i < code_city_area.size(); i++) {
			String element = code_city_area.get(i);
			int split1 = element.indexOf(",");
			int split2 = element.indexOf(",", element.indexOf(",")+1);
			ArrayList<String> a = new ArrayList<String>();
			String code = element.substring(0,split1);
			String city = element.substring(split1+1,split2);
			String area = element.substring(split2+1);
			a.add(code);
			a.add(city);
			a.add(area);
			System.out.println(a);	
			code3_city_area.add(a);
		}
		
		// code3_city
		System.out.println("code3_city:");
		ArrayList<String> first = new ArrayList<String>();
		first.add(code3_city_area.get(0).get(0));
		first.add(code3_city_area.get(0).get(1));
		code3_city.add(first);
		for(int i = 1; i < code3_city_area.size(); i++) { 
			int pre = i-1;
			if(!code3_city_area.get(i).get(0).equals(code3_city_area.get(pre).get(0))) {
				ArrayList<String> a = new ArrayList<String>();
				a.add(code3_city_area.get(i).get(0));
				a.add(code3_city_area.get(i).get(1));
				code3_city.add(a);
				System.out.println(a);
			}
		}
		
		// code3_city_area_taipei
		System.out.println("Taipei:");
		for(int i = 0; i < code3_city_area.size(); i++) {
			ArrayList<String> element = code3_city_area.get(i);
			if(element.get(1).equals("臺北市")) {
				code3_city_area_taipei.add(element);
				System.out.println(element);
			}
		}
		
		// code3_city_area_newtaipei
		System.out.println("New Taipei:");
		for(int i = 0; i < code3_city_area.size(); i++) {
			ArrayList<String> element = code3_city_area.get(i);
			if(element.get(1).equals("新北市")) {
				code3_city_area_newtaipei.add(element);
				System.out.println(element);
			}
		}

		
		// code1: 郵遞區號 -> 縣市 
		String code1 = "\"" + code3_city.get(0).get(0) + "\"=\"" + code3_city.get(0).get(1) + "\"";
		for (int i = 1; i < code3_city.size(); i++) {
			code1 += ", \"" + code3_city.get(i).get(0) + "\"=\"" + code3_city.get(i).get(1) + "\"";
		}
		System.out.println(code1);
		
		// code2: 郵遞區號（臺北市） ->  鄉鎮市區
		String code2 = "\"" + code3_city_area_taipei.get(0).get(0) + "\"=\"" + code3_city_area_taipei.get(0).get(2) + "\"";
		for (int i = 1; i < code3_city_area_taipei.size(); i++) {
			code2 += ", \"" + code3_city_area_taipei.get(i).get(0) + "\"=\"" + code3_city_area_taipei.get(i).get(2) + "\"";
		}
		System.out.println(code2);
		
		// code3: 郵遞區號（新北市） ->  鄉鎮市區
		String code3 = "\"" + code3_city_area_newtaipei.get(0).get(0) + "\"=\"" + code3_city_area_newtaipei.get(0).get(2) + "\"";
		for (int i = 1; i < code3_city_area_newtaipei.size(); i++) {
			code3 += ", \"" + code3_city_area_newtaipei.get(i).get(0) + "\"=\"" + code3_city_area_newtaipei.get(i).get(2) + "\"";
		}
		System.out.println(code3);
	

	}
	
	public static void readCSV(String file, ArrayList<String> list) throws Exception {
		CSVReader reader = new CSVReader(new FileReader(file)); 
		String [] nextLine; 
		while ((nextLine = reader.readNext()) != null) { 
		    // nextLine[] is an array of values ​​from the line
			list.add(nextLine[0].substring(0,3) + "," +  nextLine[1] + "," + nextLine[2]);
		}
		reader.close();
		
	}

}


