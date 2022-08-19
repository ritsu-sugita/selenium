import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Ex03Test {

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

		driver.get("https://www.e-procurement.metro.tokyo.lg.jp/index.jsp");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("入札情報サービス")).click();// 別タブへ

		Set<String> set = driver.getWindowHandles();// 複数タグの使用を可能に
		Iterator<String> it = set.iterator();
		String window1 = it.next();
		String window2=it.next();
		// 新しく出てきたタグのURLで新しいタグに移動
		driver.switchTo().window(window2);//.get("https://www.e-procurement.metro.tokyo.lg.jp/SrvPublish");
		//driver.switchTo().window(window2);
		driver.findElement(By.linkText("発注予定情報")).click();

		driver.findElement(By.name("StartDateYY")).sendKeys("4");
		driver.findElement(By.name("StartDateMM")).sendKeys("8");
		driver.findElement(By.name("StartDateDD")).sendKeys("19");
		driver.findElement(By.name("EndDateYY")).sendKeys("4");
		driver.findElement(By.name("EndDateMM")).sendKeys("9");
		driver.findElement(By.name("EndDateDD")).sendKeys("19");
		driver.findElement(By.linkText("検索")).click();

		WebElement elem = driver.findElement(By.cssSelector("body > div.contents > div > form > table.list-data > tbody"));
		// System.out.println(elemList);
		
		int count = 0;
		for (WebElement tr : elem.findElements(By.tagName("tr"))) {
			List<WebElement> tdList = tr.findElements(By.tagName("td"));
			for (WebElement td : tdList) {
				System.out.println(td.getText());
			}
		}
		
		Thread.sleep(500);
		//driver.quit(); // ブラウザを閉じる
	}
}
