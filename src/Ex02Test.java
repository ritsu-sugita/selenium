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

class Ex02Test {

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
		// (1)
		driver.get("https://rakuplus.jp/");

		// (2)
		driver.findElement(By.id("user_login")).sendKeys("ritsu.sugita@rakus-partners.co.jp");
		driver.findElement(By.id("user_pass")).sendKeys("ritsu.sugita@rakus-partners.co.jp");
		driver.findElement(By.id("wp-submit")).click();

		// (3)
		driver.get("https://rakuplus.jp/archives/10226");

		// (4)

		List<WebElement> elemList = driver.findElements(By.cssSelector("section.entry-content>div"));
		int count = 0;
		for (WebElement div : elemList) {
			// System.out.println(div.getAttribute("outerHTML"));
			if (count > 0) {

				WebElement name = div.findElement(By.className("big"));
				System.out.println(name.getText());

				WebElement kana = div.findElement(By.cssSelector(".has-text-align-center.has-text-color"));
				System.out.println(kana.getText());

				WebElement imgElem = div.findElement(By.tagName("img"));
				System.out.println(imgElem.getAttribute("outerHTML"));
			}
			count++;
		}

		Thread.sleep(500);
		driver.quit(); // ブラウザを閉じる。
	}

}
