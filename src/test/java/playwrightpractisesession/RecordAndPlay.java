package playwrightpractisesession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import com.microsoft.playwright.BrowserContext;


public class RecordAndPlay {
	
	/*https://playwright.dev/java/docs/codegen-intro 
	 * mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args=
	 * 																	"codegen demo.playwright.dev/todomvc"
	 */
	
	 public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://www.accuweather.com/en/in/bengaluru/204108/weather-forecast/204108");
		      page.getByText("Location").first().click();
		      page.locator(".items > a:nth-child(2)").click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hourly")).first().click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Severe Weather Eastern US on alert for dangerous thunderstorms as new week begins 2 hours ago")).click();
		      page.frameLocator("iframe[name=\"google_ads_iframe_\\/6581\\/web\\/in\\/interstitial\\/weather\\/hourly_0\"]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Close ad")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Top Stories")).first().click();
		      browser.close();
		      playwright.close();
		    }
		  }
}

