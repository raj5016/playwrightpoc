package playwrightpractisesession;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class BrowserSpecfic {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		
		LaunchOptions lp=new LaunchOptions();
	      // Channel can be "chrome", "msedge", "chrome-beta", "msedge-beta" or "msedge-dev".
		//lp.setChannel("msedge");
		lp.setChannel("firefox");
		lp.setHeadless(false);
		
		Browser browser=playwright.firefox().launch(lp);
		
		Page page=browser.newPage();
		
		page.navigate("https://www.amazon.com");
		
		System.out.println("Get Title :"+ page.title());
		System.out.println("Get Url :"+ page.url());
		
		browser.close();
		
		playwright.close();

	}
}
