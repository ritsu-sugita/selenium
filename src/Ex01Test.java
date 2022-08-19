import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Ex01Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // ChromeDriverの作成

		driver.get("http://www.google.com/xhtml"); // get()でブラウザ起動
		Thread.sleep(5000); // 処理を停止(動作確認の為)
		// ブラウザの要素を指定 メソッド名がわかりやすいですよね。
		WebElement searchBox = driver.findElement(By.name("q"));

		searchBox.sendKeys("selenium");
		searchBox.submit();

//		WebElement elem =driver.findElement(By.cssSelector("#rso > div:nth-child(3) > div > div > div.Z26q7c.UK95Uc.uUuwM.jGGQ5e > div.yuRUbf > a > h3"));
//		System.out.println(elem.getText());

		List<WebElement> elemList = driver.findElements(By.cssSelector("div.yuRUbf"));
		for (WebElement elem : elemList) {
			System.out.println(elem.getText());
		}
//		driver.get("https://www.selenium.dev/ja/documentation/");
//		System.out.println(driver.getTitle());

		Thread.sleep(500);
		driver.quit(); // ブラウザを閉じる。

	}
}