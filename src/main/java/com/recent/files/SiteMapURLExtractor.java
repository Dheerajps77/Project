package com.recent.files;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.sound.sampled.AudioFormat.Encoding;

import org.apache.commons.io.FileUtils;
import org.apache.xalan.xsltc.compiler.sym;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.io.Files;
import com.investaSolutions.base.*;
import com.investaSolutions.utils.PropertiesManager;

public class SiteMapURLExtractor{

	PropertiesManager properties=PropertiesManager.getInstance();

	public ArrayList<String> getSiteXMLURL() throws IOException {
		ArrayList<String> urlList = new ArrayList<>();
		Document doc = Jsoup.connect("https://www.spinny.com/sitemap.xml").get();
		Elements urls = doc.getElementsByTag("loc");

		for (Element url : urls) {
			urlList.add(url.text());
		}

		return urlList;
	}

	public ArrayList<String> getALLSiteURL() throws IOException, InterruptedException {

		ArrayList<String> arraylist = getSiteXMLURL();
		ArrayList<String> urlList = new ArrayList<String>();
		int count = arraylist.size();
		for (int i = 0; i < count; i++) {
			String str = arraylist.get(i);
			// System.out.println(str);

			Document doc = Jsoup.connect(str).get();
			Elements urls = doc.getElementsByTag("loc");

			for (Element url : urls) {			
				urlList.add(url.text());
			}
		}
		return urlList;
	}

	public ArrayList<String> getAllSiteMapURL() throws IOException, InterruptedException {
		ArrayList<String> arraylist = getALLSiteURL();
		ArrayList<String> ab= new ArrayList<String>();
		ArrayList<String> ab1=new ArrayList<String>(); 
		int totalURLPresentCount = arraylist.size();
		System.out.println(
				"Below are total URL present under -- > https://www.spinny.com/sitemap.xml " + totalURLPresentCount);
		for (int i = 0; i < totalURLPresentCount; i++) {			
			String str = arraylist.get(i);

			String str1 = str.replace("www.spinny", "webtest.myspinny");
			
			
			if(str1.contains("https://webtest.myspinny.com/buy-used-cars/"))
			{
				ab1.add(str1);
			}
			else {
				ab.add(str1);
			}
			
			/*
			URL url=new URL(str1);
			HttpURLConnection httpURLConnections=(HttpURLConnection) url.openConnection();
			httpURLConnections.setConnectTimeout(10000);
			httpURLConnections.connect();
			int responseCode=httpURLConnections.getResponseCode();
			String responseMsg=httpURLConnections.getResponseMessage();
			*/
			/*
			if(responseCode>=200 || responseCode<=300)
			{
				ab.add(str1);
				//System.out.println(str1 + " response code is : "+responseCode);
			}
			else if(responseCode>=400)
			{
				ab.add(str1);
				//System.out.println(str1 + " response code is : "+responseCode);
			}
			*/			
			System.out.println(str1);
		}
		
		//ArrayList<String> ab2=getAllSiteMapURL();
		String pathOfFile= String.format("C:\\Users\\Dheeraj\\eclipse-workspace\\SpinnyPortal\\Test Data\\URLDetailsWithUsedCar.txt");
		FileWriter writer = new FileWriter(pathOfFile, false);
        int size = ab1.size();
        for (int i=0;i<size;i++) {
            String str = ab1.get(i).toString();
            writer.write(str);
            if(i < size-1)//This prevent creating a blank like at the end of the file**
                writer.write("\n");
        }
        
		return ab;
	}
		
		/*
		Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        String curDate =dateFormat.format(date);
	
		*
		*/
	
	public void writeFile() throws IOException, InterruptedException
	{
		
		ArrayList<String> ab=getAllSiteMapURL();
		String pathOfFile= String.format("C:\\Users\\Dheeraj\\eclipse-workspace\\SpinnyPortal\\Test Data\\URLDetails.txt");
		FileWriter writer = new FileWriter(pathOfFile, false);
        int size = ab.size();
        for (int i=0;i<size;i++) {
            String str = ab.get(i).toString();
            writer.write(str);
            if(i < size-1)//This prevent creating a blank like at the end of the file**
                writer.write("\n");
        }
	}
	
	/*

	public ArrayList<String> getStaticURLFromSiteMap() throws IOException, InterruptedException {

		ArrayList<String> staticURLArrayList = new ArrayList<String>();
		Document doc = Jsoup.connect("https://www.spinny.com/sitemap-static.xml").get();
		Elements urls = doc.getElementsByTag("loc");

		for (Element url : urls) {
			staticURLArrayList.add(url.text());
		}
		return staticURLArrayList;
	}

	public void printALLURLsUnderStaticSiteMap() throws IOException, InterruptedException {
		try {
			ArrayList<String> arraylist = getStaticURLFromSiteMap();
			ArrayList<String> ab=new ArrayList<String>();
			int totalURLPresentCount = arraylist.size();			
			 System.out.println("Total number of URL present under -- > https://www.spinny.com/sitemap.xml is --> " + totalURLPresentCount);			
			for (int i = 0; i < totalURLPresentCount; i++) {
				String str = arraylist.get(i);
				String str1 = str.replace("www.spinny", "webtest.myspinny");
				ab.add(str1);
				System.out.println(str1);
				
				//FileWriter fileWriter = new FileWriter("C:\\Users\\Dheeraj\\Desktop\\URLDetails.txt");
			    //fileWriter.write(str1);
			}
			//FileUtils.writeLines("C:\\Users\\Dheeraj\\Desktop\\URLDetails.txt", Encoding, ab);
			
			FileWriter writer = new FileWriter("C:\\Users\\Dheeraj\\Desktop\\URLDetails.txt");
	        int size = ab.size();
	        for (int i=0;i<size;i++) {
	            String str = ab.get(i).toString();
	            writer.write(str);
	            if(i < size-1)//This prevent creating a blank like at the end of the file**
	                writer.write("\n");
	        }
	        writer.close();
		} catch (Exception e) {
			throw e;
		}
	}

	public ArrayList<String> getCarsListURLFromSiteMap() throws IOException, InterruptedException {

		// ArrayList<String> arraylist = getSiteXMLURL();
		ArrayList<String> staticURLArrayList = new ArrayList<String>();
		Document doc = Jsoup.connect("https://www.spinny.com/used-cars-list-sitemap.xml").get();
		Elements urls = doc.getElementsByTag("loc");

		for (Element url : urls) {
			// Thread.sleep(2000);
			staticURLArrayList.add(url.text());
		}
		return staticURLArrayList;
	}

	public void printALLURLsUnderCarsListSiteMap() throws IOException, InterruptedException {
		ArrayList<String> arraylist = getCarsListURLFromSiteMap();
		ArrayList<String> ab=new ArrayList<String>();
		int totalURLPresentCount = arraylist.size();
		System.out.println("Total number of URL present under -- > https://www.spinny.com/sitemap.xml is --> " + totalURLPresentCount);		
		for (int i = 0; i < totalURLPresentCount; i++) {		
			String str = arraylist.get(i);

			String str1 = str.replace("www.spinny", "webtest.myspinny");
			ab.add(str1);
			System.out.println(str1);		
		}
		
		FileWriter writer = new FileWriter("C:\\Users\\Dheeraj\\Desktop\\URLDetails.txt");
        int size = ab.size();
        for (int i=0;i<size;i++) {
            String str = ab.get(i).toString();
            writer.write(str);
            if(i < size-1)//This prevent creating a blank like at the end of the file**
                writer.write("\n");
        }
	}
	*/

	public static void main(String[] args) throws IOException, InterruptedException {

		SiteMapURLExtractor objSiteMapURLExtractor = new SiteMapURLExtractor();		
		objSiteMapURLExtractor.writeFile();		
		System.out.println("Hello...");
	}

}
