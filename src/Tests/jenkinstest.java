package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class jenkinstest {
	
	WebDriver driver;
	@BeforeTest
	public void showbfore(){
		System.out.println("inside the before method body");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//Utilities//ChromeDriver_L.exe");
		driver =new ChromeDriver();
		
	}
	

	
	@Test
	public void show() throws InterruptedException{
		System.out.println("inside the method body");
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		WebDriverWait wait = new WebDriverWait(driver,3);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Echo & Alexa']")));
		
		WebElement ele0 = driver.findElement(By.xpath("//div[text()='Echo & Alexa']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele0).click().build().perform();
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Echo Dot (3rd Gen)']"));
		
		String menuName = ele.getText();
		ele.click();
		System.out.println(menuName);
		
		if(driver.getPageSource().contains(menuName))
		{
			System.out.println(menuName+" Page is displayed succesfully");
		}
		
		
		
	}

	
	@AfterTest
	public void showafter(){
		System.out.println("inside the after method body");
	}
}
