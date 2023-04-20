package cc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class filter {
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://www.saucedemo.com/");
		WebElement uname=driver.findElement(By.id("user-name"));
    	uname.sendKeys("standard_user");
    	WebElement pass=driver.findElement(By.id("password"));
    	pass.sendKeys("secret_sauce");
    	WebElement login=driver.findElement(By.id("login-button"));
    	login.click();
    	WebElement filter=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
    	filter.click();
    	Select sel=new Select(filter);
    	sel.selectByIndex(0);
    	WebElement atoz=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
    	System.out.println("AtoZ Product name: "+atoz.getText());
    	Select se=new Select(filter);
    	se.selectByIndex(1);
    	WebElement ztoa=driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div"));
    	System.out.println("ZtoA Product name: "+ztoa.getText());
    	Select s=new Select(filter);
    	s.selectByIndex(2);
    	WebElement lowtohigh=driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"));
    	System.out.println("lowtohigh Price: "+lowtohigh.getText());
    	Select R=new Select(filter);
    	R.selectByIndex(3);
    	WebElement hightolow=driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"));
    	System.out.println("hightolow Price: "+hightolow.getText());
	}

}