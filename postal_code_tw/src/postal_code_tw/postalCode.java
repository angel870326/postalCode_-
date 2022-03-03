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
	
	public static void main(String[] args) throws Exception {
		code_city_area_raw = new ArrayList<String>();
		code_city_area = new ArrayList<String>();
		code3_city_area = new ArrayList<ArrayList<String>>();
		code3_city = new ArrayList<ArrayList<String>>();

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
		
		// code1: 
		String code1 = "\"" + code3_city.get(0).get(0) + "\"=\"" + code3_city.get(0).get(1) + "\"";
		for (int i = 1; i < code3_city.size(); i++) {
			code1 += ", \"" + code3_city.get(i).get(0) + "\"=\"" + code3_city.get(i).get(1) + "\"";
		}
		System.out.println(code1);
	

	}
	
	public static void readCSV(String file, ArrayList<String> list) throws Exception {
		CSVReader reader = new CSVReader(new FileReader(file)); 
		String [] nextLine; 
		while ((nextLine = reader.readNext()) != null) { 
		    // nextLine[] is an array of values ​​from the line
			list.add(nextLine[0].substring(0,3) + "," +  nextLine[1] + "," + nextLine[2]);
		}
		
	}

}


