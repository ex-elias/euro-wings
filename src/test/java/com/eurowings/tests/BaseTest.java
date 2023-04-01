package com.eurowings.tests;

import com.eurowings.steps.ActionStep;
import com.eurowings.steps.AssertStep;
import com.eurowings.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private static final String BROWSER_TITLE = "Flight status - Information - Eurowings";
    protected ActionStep actionStep;
    protected AssertStep assertStep;
    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        context.setAttribute("driver", webDriver);
        actionStep = new ActionStep(webDriver);
        assertStep = new AssertStep(webDriver);

        actionStep.openSite(PropertyReader.get("url"));
        assertStep.assertBrowserTitle(BROWSER_TITLE);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}
