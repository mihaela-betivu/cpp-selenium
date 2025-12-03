package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PandaShopTest {
    public static void main(String[] args) throws InterruptedException {
        // pornește driver-ul de Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // 1. Deschide PandaShop
            driver.get("https://www.pandashop.md/ro/");

            Thread.sleep(3000); // lăsăm pagina să se încarce

            // 2. Verificăm că header-ul este afișat
            WebElement header = driver.findElement(By.tagName("header"));
            if (!header.isDisplayed()) {
                throw new AssertionError("Header-ul PandaShop NU este afișat!");
            }
            System.out.println("Header-ul PandaShop este afișat ✅");

            // 3. Căutăm „computer” în bara de căutare
            WebElement searchInput = driver.findElement(By.className("searchPnl-input"));
            searchInput.sendKeys("computer");
            searchInput.sendKeys(Keys.ENTER);

            Thread.sleep(3000); // doar ca să vezi rezultatele în browser
            System.out.println("Căutarea după 'computer' a fost efectuată ✅");

        } finally {
            // 4. Închidem browserul
            driver.quit();
        }
    }
}
