package org.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskProj {

public static void main(String[] args) throws Exception {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	driver.get("https://www.firstcry.com/");
	
	driver.manage().window().maximize();
	
	WebElement search = driver.findElement(By.id("search_box"));
	search.clear();
	Thread.sleep(3000);
	search.sendKeys("water bottle for kids" + Keys.ENTER);
	
	/*WebElement products = driver.findElement(By.xpath("//div[@id='maindiv']"));
	
	System.out.println(products.getText());*/
	
	System.out.println( "\n\n" + "*****Products Name******" + "\n\n");
	
	
	List<WebElement> productsname = driver.findElements(By.xpath("//div[@class='li_txt1 wifi lft']"));
	
	for(int i=0; i<productsname.size(); i++) {
		System.out.println(productsname.get(i).getText());
	}
	
	ArrayList<String> obtList = new ArrayList<String>();
	System.out.println("\n\n\n" +"*****Price Details******"  + "\n\n\n");
	
	List<WebElement> productsprice = driver.findElements(By.xpath("//div[@class='rupee fw lft']"));
	
 	for(int i=0; i<productsprice.size(); i++) {
		
          WebElement price = productsprice.get(i); 	
          String pricetext = price.getText();
 		System.out.println(pricetext);
 		obtList.add(pricetext);
	}
 	
 	ArrayList<String> sortList = new ArrayList<String>();
 	for(String s : obtList) {
 		sortList.add(s);
 	}
	Collections.sort(sortList, String.CASE_INSENSITIVE_ORDER);
	System.out.println("\n\n" +"*****Price Details In Ascending Order******"  + "\n\n\n");
	System.out.println(sortList);
	
	
}


}
