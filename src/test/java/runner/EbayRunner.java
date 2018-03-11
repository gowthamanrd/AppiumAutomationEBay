package runner;

 
	import cucumber.api.CucumberOptions;
	import net.serenitybdd.cucumber.CucumberWithSerenity;
	import org.junit.runner.RunWith;

	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(
			features={"src/test/resources/common/features/Order_Product_ebay.feature"},
			tags={"@ebay_ShoppingEndtoEndFlowValidation"},
			glue = { "com.steps" },
			plugin = { "pretty", "html:cucumberReport/cucumber-html-report", "json:cucumberReport/cucumber-report.json" }, 
	        monochrome=true)
	public class EbayRunner {
	}


 