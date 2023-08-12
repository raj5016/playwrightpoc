package playwrightpractisesession;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		
		  //Here with text of Login , matches with three , so it will return exception strict mode violation exception BrowserContext
		  BrowserContext browsercontext2=browser.newContext(); 
		  Page page2=browsercontext2.newPage();
		  page2.navigate("https://academy.naveenautomationlabs.com/"); 
		  Locator locator2=page2.locator("text=Login"); 
		  //locator2.click();  //if we use click it will throw exception
		  System.out.println(locator2.count()); //so it shows 3 , since it matches

		  //So here we have first() and last() , so we can use to click on first method
		  locator2.first().click(); //so it will click on first webelement
		  
		 	
		 
		//Multiple elements :
		BrowserContext browsercontext1=browser.newContext();
		Page page1=browsercontext1.newPage();
		page1.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		Locator countryOptions=page1.locator("select#Form_getForm_Country option");
		System.out.println(countryOptions.count());
		
		for (int i = 0; i < countryOptions.count(); i++) {
			String contryName=countryOptions.nth(i).textContent();
			System.out.println(contryName);
		}
		
			//or 
		List<String> OptionsTextList=countryOptions.allTextContents();
		for (String country : OptionsTextList) {
			System.out.println(country);
		}
		
			//or lamda 
		OptionsTextList.forEach(county->System.out.println(county));
			
		
	}

}
