package playwrightpractisesession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		/*
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		
		Locator links=page.locator("text=Privacy Policy");
		System.out.println(links.count());
		for (int i = 0; i < links.count(); i++) {
				System.out.println(links.nth(i).textContent());
				String linkname=links.nth(i).textContent();
				if (linkname.equals("Service Privacy Policy")) {
						links.nth(i).click();
						break;
				}
		}
	*/
		//
		
		page.navigate("https://demo.opencart.com/index.php?route=account/login");
		String header=page.locator("h2:has-text('New Customer')").textContent();
		System.out.println(header);
		
		
		//Parent <div class="cart-body"> to child here  <h2>New Customer</h2>
		String header1=page.locator("div.card-body h2:has-text('New Customer')").textContent();
		System.out.println(header1);
		
		//direct text
		String header2=page.locator("'New Customer'").textContent();
		System.out.println(header2);
		
		//button ---Parent to child
		page.locator("form button:has-text('submit')").click();
	}
	

}
