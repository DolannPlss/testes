package testeDeSistema;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class REQ01MantemLivroTests {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void cT01() {
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("juan");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("livro2");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("1234", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText());
	//	assertEquals(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText(), is("1234"));
	}

	@Test
	public void cT02() {
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.linkText("Lista de Livros")).click();
		driver.findElement(By.cssSelector("tr:nth-child(2) .btn-primary")).click();
		driver.findElement(By.cssSelector(".card-body")).click();
	    driver.findElement(By.id("autor")).clear();
	    driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("roberto");
		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("livro4");
		driver.findElement(By.cssSelector(".btn")).click();
		assertEquals("livro4", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).getText());
	//	assertEquals(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).getText(), is("livro4"));
	}
	@Test
	public void cT03() {
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.linkText("Lista de Livros")).click();
		driver.findElement(By.cssSelector("tr:nth-child(2) .delete")).click();
//		assertEquals("livro4", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).getText());
		assertEquals("Lista de livros", driver.findElement(By.id("paginaConsulta")).getText());
	}
}
