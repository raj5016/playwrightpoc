package playwrightpractisesession;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import com.microsoft.playwright.BrowserContext;


public class TraceViewer {
  public static void main(String[] args) {
	  
	  /*
	   * First record the site using the command "mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://demoqa.com/"
	   * 
	   * Once record completed add the trace view script once browser context is created 
	   * 
	   * After that perform the action ,and add stop trace viewer script
	   * 
	   * After that run this code and check that trace.zip is created in project directory.
	   * 
	   * You can open the saved trace using Playwright CLI or in your browser on "trace.playwright.dev".
	   * 
	   * or 
	   * 
	   * mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"
	   * 
	   */
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
   // Start tracing before creating / navigating a page.
      context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
      
      Page page = context.newPage();
      page.navigate("https://demoqa.com/");
      page.locator("path").first().click();
      page.getByText("Text Box").click();
      page.getByPlaceholder("Full Name").click();
      page.getByPlaceholder("Full Name").fill("Raj");
      page.getByPlaceholder("Full Name").press("Tab");
      page.getByPlaceholder("name@example.com").fill("raj@123.com");
      page.getByPlaceholder("name@example.com").press("Tab");
      page.getByPlaceholder("Current Address").fill("bangalore");
      page.locator("#permanentAddress").click();
      page.locator("#permanentAddress").fill("Same");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
      
   // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
    }
  }
}
