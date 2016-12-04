package com.core.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FBLogoutVerify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("dharmiksameer@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("sam29884");
		driver.findElement(By.id("u_0_l")).click();
		//Actions builder = new Actions(driver);
		//builder.moveToElement(driver.findElement(By.id("userNavigationLabel"))).moveToElement(driver.findElement(By.xpath(".//span[text()='Log Out']"))).click().build().perform();
		//builder.click(driver.findElement(By.id("userNavigationLabel"))).click(driver.findElement(By.xpath(".//span[text()='Log Out']"))).build().perform();
		
		driver.findElement(By.id("userNavigationLabel")).click();
		String text = driver.findElement(By.xpath(".//span[text()='Log Out']")).getText();
		System.out.println(text);
	}

}
