package com.selenium.insuremetest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import java.io.File;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
	@SuppressWarnings({ "deprecation" })
	public static void main(final String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		chromeOptions.addArguments(new String[] { "--headless" });
		chromeOptions.addArguments(new String[] { "--no-sandbox" });
		chromeOptions.addArguments(new String[] { "--disable-dev-shm-usage" });
		final WebDriver driver = (WebDriver) new ChromeDriver(chromeOptions);
		driver.get("http://13.127.168.14:8084/contact.html");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.findElement(By.id("inputName")).sendKeys(new CharSequence[] { "Vikul" });
		driver.findElement(By.id("inputNumber")).sendKeys(new CharSequence[] { "9999999999" });
		driver.findElement(By.id("inputMail")).sendKeys(new CharSequence[] { "vikul@gmail.com" });
		driver.findElement(By.id("inputMessage")).sendKeys(new CharSequence[] { "Welcome to the DevOps doubt session" });
		driver.findElement(By.id("my-button")).click();
		final String message = driver.findElement(By.id("response")).getText();
		if (message.equals("Message Sent")) {
			System.out.println("Script executed Successfully");
		} else {
			System.out.println("Script failed");
		}
		Thread.sleep(3000L);
		driver.quit();
		}

}