import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LcAdvise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LcAdvise.login();
		
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
		
			 
			 
		//driver.findElement(By.xpath("//*[@id=\"tabContainer\"]/div/div[1]/div/div[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"tabContainer\"]/div/div[1]/div/div[2]")).click();
	     
	     
	     //  ----------  for switching the frame ------  there are frame here without name or ID ------//
	
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//*[@id=\"topbtn_LCReceiveID\"]/button[2]")).click();
		//driver.findElement(By.xpath("//*[@id=\"noty_558146500887033800\"]/div[2]/div/div[1]/input")); --- not working with this xpath
		
		//driver.switchTo().activeElement();
		//driver.findElement(By.xpath("/html/body/ul/li/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr[8]/td[1]")).click();
		
		
		
		// ---- after clicking on search button it goes back to default content that means out of frame
        
        driver.switchTo().defaultContent(); //switches focus out of iFrame
        
        
        // ----- working with the popup dialog ------- // 
        
        driver.findElement(By.xpath("/html/body/ul/li/div/div[2]/div/div[1]/div")).click();
        driver.findElement(By.xpath("/html/body/ul/li/div/div[2]/div/div[1]/div/ul/li[2]")).click();
        driver.findElement(By.xpath("/html/body/ul/li/div/div[2]/div/div[1]/input")).sendKeys("087118040007");
        driver.findElement(By.xpath("/html/body/ul/li/div/div[2]/div/div[1]/span/button")).click();
        
        
       // ------ double click on search result ------- //
        
        
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
        
        
        WebElement searchResult = driver.findElement(By.xpath("/html/body/ul/li/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr"));
        actions.doubleClick(searchResult).perform();
        
        
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
        
        
        driver.findElement(By.xpath("//*[@id=\"button-1\"]")).click();
        
        driver.switchTo().frame(1);
       
        
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
        
        
        driver.findElement(By.xpath("//*[@id=\"btnSaveLCAdvisingRegister\"]")).click();
        
        
        //driver.findElement(By.xpath("//*[@id=\"button-0\"]")).click();
        
        
        
        
        // ------- not working with opera mini's special xpath ----- worked fine with absolute xpath ----- //
        
        //driver.findElement(By.xpath("//*[@id=\"noty_558383444568576900\"]/div[2]/div/div[1]/input")).sendKeys("Test Lc");
		
	
        // ------- getting text from any title to understand in which component is it's current working window --------- //
        
		String className = driver.findElement(By.className("dialog-header")).getText();
		System.out.println(className);
		
		// -------    driver.findElement(By.className("input-group-btn")).click();

		

	}

}
