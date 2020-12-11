package org.choucair.opensourcecms;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCategorie {

    static WebDriver driver;

    public static void main (String[] args){
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseURL = "https://s1.demo.opensourcecms.com/wordpress/wp-admin/";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {

            WebElement txtuser  =driver.findElement(By.id("user_login"));
            txtuser.click();
            txtuser.sendKeys("opensourcecms");

            WebElement txtpass = driver.findElement(By.id("user_pass"));
            txtpass.click();
            txtpass.sendKeys("opensourcecms");

            WebElement btnlogin = driver.findElement(By.id("wp-submit"));
            btnlogin.click();


            WebElement btnPost = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]"));
            btnPost.click();

            //CLick en Categories
            driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[4]/a")).click();
            //Cerrar mensaje
            WebElement txtname = driver.findElement(By.id("tag-name"));
            txtname.click();
            txtname.sendKeys("Test Categorie");

            WebElement txtdescrip = driver.findElement(By.id("tag-description"));
            txtdescrip.click();
            txtdescrip.sendKeys("Test Description");

            WebElement btnadd = driver.findElement(By.id("submit"));
            btnadd.click();

            System.out.println("Prueba Exitosa! " + driver.findElement(By.xpath("//*[@id=\"tag-6\"]/td[1]/strong/a")).getText());


        }catch (NoSuchElementException ne) {
            System.err.println("No se encontro el WebElement: " + ne.getMessage());
        }catch (WebDriverException we) {
            System.err.println("WebDriver Falló: " + we.getMessage());
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            driver.quit();
        }

    }




}
