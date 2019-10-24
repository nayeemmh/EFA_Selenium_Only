import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLcAdvise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewLcAdvise.login();

	}
	
	
public static void login() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.get("http://103.36.103.63/KANDAREEBANKING/Home");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("/html/body/form/div/div/div/div/div[2]/div[1]/input")).sendKeys("Mis");
	    driver.findElement(By.xpath("/html/body/form/div/div/div/div/div[2]/div[3]/input")).sendKeys(" ");
	    driver.findElement(By.xpath("/html/body/form/div/div/div/div/div[2]/div[8]/button")).click();
	    
	    
	    
	    // Explicit wait example
		
	 	WebDriverWait wait = new WebDriverWait(driver, 30);
	 	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-validation-field-4\"]")));
	 		
	 		
	    
		 Actions actions = new Actions(driver); 
		 WebElement element = driver.findElement(By.xpath("//*[@id=\"dockpanel\"]/div[3]"));
	     actions.moveToElement(element).perform();
	     actions.moveToElement(element).moveToElement(driver.findElement(By.xpath("//*[@id=\"dockpanel\"]/div[3]/div/ul/li[1]/a"))).click().build().perform();
		
	     
	     //  ----------  for switching the frame ------  there are frame here without name or ID ------//
	
	     // switch frame with explicit time wait for visibility for frame  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
	    
	    // simply way to switch frame
		//driver.switchTo().frame(1);
		
		// select LC receiving date 
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/span")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[4]/td[4]")).click();
		
		
		// select LC shipment date
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div[4]/div/div/span")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[4]")).click();
				
				
		//Select LC expiry date		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div[5]/div/div/span")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[7]")).click();
		
		
		// select Msg Recvd Through
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[3]/div/div")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[3]/div/div/div/ul/li[2]/a")).click();
		
		
		// Works with chromes full xpath feature only. not works with other xpath format. Don't know why

	
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[4]/div/input")).sendKeys("TestLCNumber");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[6]/div/input")).sendKeys("2126219765");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[7]/div[1]/div/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div[6]/div/input")).sendKeys("Beneficiary Name");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div[7]/div/input")).sendKeys("Beneficiary Email");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[4]/div[3]/div/input")).sendKeys("Sample Reason");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[4]/div[4]/div/textarea")).sendKeys("Sample Remarks");
		
		
		WebElement containerForRadioButton =  driver.findElement(By.id("rbNonCustomer"));
		
		if (containerForRadioButton.isSelected()) {
			System.out.println("Yes! non customer radio button is selected ");
		}

        else {
			System.out.println("No! customer radio button is selected ");
		}
		
		
		
		// selecting issue bank from search result
		driver.findElement(By.xpath("//*[@id=\"btnIssuingBankFinder\"]")).click();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		WebElement issueBankResult = driver.findElement(By.xpath("/html/body/ul/li/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr[1]"));
		actions.doubleClick(issueBankResult).perform();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//*[@id=\"btnBranchFinder\"]")).click();
		driver.switchTo().defaultContent();
		WebElement issueBranchResult = driver.findElement(By.xpath("/html/body/ul/li/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr[1]"));
		actions.doubleClick(issueBranchResult).perform();
		
		
		
	}

}


