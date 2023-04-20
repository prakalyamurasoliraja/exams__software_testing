package cc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class addtocart {
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
		WebElement add=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    	add.click();
    	driver.get("https://www.saucedemo.com/cart.html");
    	WebElement check=driver.findElement(By.id("checkout"));
    	check.click();
    	WebElement fname=driver.findElement(By.id("first-name"));
    	fname.sendKeys("shadow");
    	WebElement lname=driver.findElement(By.id("last-name"));
    	lname.sendKeys("Arise");
    	WebElement code=driver.findElement(By.id("postal-code"));
    	code.sendKeys("123");
    	WebElement sub=driver.findElement(By.id("continue"));
    	sub.submit();
    	WebElement product=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
    	System.out.println("Product name: "+product.getText());
    	WebElement price=driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]"));
    	System.out.println("Price: "+price.getText());
    	String Exptitle = "Swag Labs";
    	String Atitle = driver.getTitle();
    	if(Exptitle.equals(Atitle))
    	{
    	System.out.println("Title is valid");
    	}
    	else
    	{
    	System.out.println("Title is not valid");
    	}
    	String Expurl = "https://www.saucedemo.com/checkout-step-two.html";
    	String Aurl = driver.getCurrentUrl();
    	if(Expurl.equals(Aurl))
    	{
    	System.out.println("URL is verified");
    	}
    	else
    	{
    	System.out.println("URL is not valid");
    	}

	}

}