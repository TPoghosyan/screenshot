import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class Listeners extends FacebookLoginTest implements ITestListener {
    public void onTestFailure(ITestResult result) {

        Date date = new Date();
        String screenshotName = date.toString().replace(" ", "-").replace(":", "-");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File((".//src/main/resources/screenshots//" +screenshotName + ".jpg")));
        } catch (IOException e) {
            System.out.println("ioexeption");
        }
        System.out.println("screenshot is taken");
    }


}

