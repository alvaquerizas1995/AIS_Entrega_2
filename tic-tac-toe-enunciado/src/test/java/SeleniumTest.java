import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import es.codeurjc.ais.tictactoe.WebApp;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	
	WebDriver driver1;
	WebDriver driver2;
	
	
	@BeforeEach
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		WebApp.start();
		driver1 = new FirefoxDriver();
		driver2 = new FirefoxDriver();
	}
	@AfterEach
	public void teardown() {
		if(driver1 != null) {
			driver1.quit();
		}
		if(driver2 != null) {
			driver2.quit();
		}
	}
	

	@Test
	public void winP1() throws InterruptedException {
		driver1.get("http://localhost:8080");
		driver2.get("http://localhost:8080");
		
		driver1.findElement(By.id("nickname")).sendKeys("Jugador 1");
		driver1.findElement(By.id("startBtn")).click();
		
		driver2.findElement(By.id("nickname")).sendKeys("Jugador 2");
		driver2.findElement(By.id("startBtn")).click();
		
		
		driver1.findElement(By.id("cell-0")).click();
		driver2.findElement(By.id("cell-2")).click();
		driver1.findElement(By.id("cell-4")).click();
		driver2.findElement(By.id("cell-5")).click();
		driver1.findElement(By.id("cell-8")).click();

		String s = driver1.switchTo().alert().getText();
		String s1 ="Jugador 1 wins! Jugador 2 looses.";
		assertTrue(s.equals(s1));
		
	}
	
	@Test
	public void winP2() throws InterruptedException {

		driver1.get("http://localhost:8080");
		driver2.get("http://localhost:8080");
		
		driver1.findElement(By.id("nickname")).sendKeys("Jugador 1");
		driver1.findElement(By.id("startBtn")).click();
		
		driver2.findElement(By.id("nickname")).sendKeys("Jugador 2");
		driver2.findElement(By.id("startBtn")).click();
		
		
		driver1.findElement(By.id("cell-4")).click();
		driver2.findElement(By.id("cell-0")).click();
		driver1.findElement(By.id("cell-6")).click();
		driver2.findElement(By.id("cell-2")).click();
		driver1.findElement(By.id("cell-7")).click();
		driver2.findElement(By.id("cell-1")).click();
		
		String s = driver2.switchTo().alert().getText();
		String s1 ="Jugador 2 wins! Jugador 1 looses.";
		assertTrue(s.equals(s1));
	}
	@Test
	public void draw() throws InterruptedException {
		driver1.get("http://localhost:8080");
		driver2.get("http://localhost:8080");
		
		driver1.findElement(By.id("nickname")).sendKeys("Jugador 1");
		driver1.findElement(By.id("startBtn")).click();
		
		driver2.findElement(By.id("nickname")).sendKeys("Jugador 2");
		driver2.findElement(By.id("startBtn")).click();
		
		
		driver1.findElement(By.id("cell-4")).click();
		driver2.findElement(By.id("cell-0")).click();
		driver1.findElement(By.id("cell-6")).click();
		driver2.findElement(By.id("cell-2")).click();
		driver1.findElement(By.id("cell-1")).click();
		driver2.findElement(By.id("cell-7")).click();
		driver1.findElement(By.id("cell-3")).click();
		driver2.findElement(By.id("cell-5")).click();
		driver1.findElement(By.id("cell-8")).click();
		
		String s = driver1.switchTo().alert().getText();
		String s1 ="Draw!";
		assertTrue(s.equals(s1));
	}

}
