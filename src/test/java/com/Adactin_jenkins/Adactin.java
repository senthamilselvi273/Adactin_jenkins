package com.Adactin_jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Adactin {
	
		static WebDriver driver;
		
		private static void browserLaunch() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\admin\\eclipse-workspace4\\Adactin_jenkins\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		
		private static void getURL() {
			driver.get("https://adactinhotelapp.com/");
		}

		private static void login() {
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Jivita04");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
			driver.findElement(By.xpath("//input[@id='login']")).click();
		}
		
		private static void searchAndBookHotel() throws Throwable {

			WebElement location = driver.findElement(By.xpath("//select[@id='location']"));
			Select s = new Select(location);
			s.selectByIndex(4);

			WebElement hotels = driver.findElement(By.xpath("//select[@id='hotels']"));
			Select s1 = new Select(hotels);
			s1.selectByValue("Hotel Sunshine");

			WebElement roomtype = driver.findElement(By.xpath("//select[@id='room_type']"));
			Select s2 = new Select(roomtype);
			s2.selectByVisibleText("Super Deluxe");

			WebElement no_ofrooms = driver.findElement(By.xpath("//select[@id='room_nos']"));
			Select s3 = new Select(no_ofrooms);
			s3.selectByIndex(1);

			WebElement adults = driver.findElement(By.xpath("//select[@id='adult_room']"));
			Select s4 = new Select(adults);
			s4.selectByVisibleText("2 - Two");

			WebElement childs = driver.findElement(By.xpath("//select[@id='child_room']"));
			Select s5 = new Select(childs);
			s5.selectByIndex(2);

			driver.findElement(By.xpath("//input[@id='Submit']")).click();

			driver.findElement(By.xpath("//input[@id='radiobutton_0']")).click();

			driver.findElement(By.xpath("//input[@id='continue']")).click();

			driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Rajini");
			driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Kanth");
			driver.findElement(By.xpath("//textarea[@id='address']"))
					.sendKeys("No.108, Dubai kuruku sandhu, Dubai Main road, Dubai");

			driver.findElement(By.xpath("//input[@id='cc_num']")).sendKeys("1234 5678 1234 5678");

			WebElement cctype = driver.findElement(By.xpath("//select[@id='cc_type']"));
			Select c = new Select(cctype);
			c.selectByIndex(1);

			WebElement ccmonth = driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
			Select cc = new Select(ccmonth);
			cc.selectByIndex(4);

			WebElement ccyear = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
			Select cc1 = new Select(ccyear);
			cc1.selectByValue("2030");

			driver.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys("123");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='book_now']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='my_itinerary']")).click();
			Thread.sleep(5000);

			driver.findElement(By.xpath("//input[@id='logout']")).click();
		}
		
		
		private static void browserClose() {
			driver.navigate().back();
			driver.quit();
		}
		
		public static void main(String[] args) throws Throwable {
			
			browserLaunch();
			getURL();
			login();
			searchAndBookHotel();
			browserClose();
			
		}

	}
