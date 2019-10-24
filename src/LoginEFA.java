import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginEFA {

	public static void main(String[] args) {
		
	   
		LoginEFA.login();
		
		
	}
	
	
	public static void login() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.get("http://103.36.103.63/KANDAREEBANKING/Home");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("/html/body/form/div/div/div/div/div[2]/div[1]/input")).sendKeys("Mis");
	    driver.findElement(By.xpath("/html/body/form/div/div/div/div/div[2]/div[3]/input")).sendKeys(" ");
	    driver.findElement(By.xpath("/html/body/form/div/div/div/div/div[2]/div[8]/button")).click();
	    
	    
		
		  Actions actions = new Actions(driver);
		  WebElement element = driver.findElement(By.xpath("//*[@id=\"dockpanel\"]/div[3]"));
		  actions.moveToElement(element).perform();
		  actions.moveToElement(element).moveToElement(driver.findElement(By.xpath("//*[@id=\"dockpanel\"]/div[3]/div/ul/li[1]/a"))).click().build().perform();
		 
		 
	    
	    
		
		  //Actions action = new Actions(driver); 
		  //WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\\\"dockpanel\\\"]/div[3]"));
		  //action.moveToElement(mainMenu).perform();
		  //action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("//*[@id=\"dockpanel\"]/div[3]/div/ul/li[1]/a"))).click().build().perform();
		  
		  
		  
		   // ---- advise new LC ---- //
		  
		  //driver.findElement(By.xpath("//*[@id=\"topbtn_LCReceiveID\"]/button[1]")).click();;
		  //driver.findElement(By.xpath("//*[@id=\"topbtn_LCReceiveID\"]/button[2]")).click();
		 

	}
	
}
