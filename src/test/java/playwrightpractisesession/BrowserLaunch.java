package playwrightpractisesession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserLaunch {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		//Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		//Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Browser browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page=browser.newPage();
		page.navigate("https://www.amazon.com");
		
		System.out.println("Page title :"+ page.title());
		System.out.println("Page Url:"+ page.url());
		
		browser.close();
		playwright.close();
		

	}

}
