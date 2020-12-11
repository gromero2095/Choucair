package org.choucair.opensourcecms;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatePage {
    static WebDriver driver;

    public static void main (String[] args){
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseURL = "https://s1.demo.opensourcecms.com/wordpress/wp-admin/";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            //Login
            WebElement txtuser  =driver.findElement(By.id("user_login"));
            txtuser.click();
            txtuser.sendKeys("opensourcecms");

            WebElement txtpass = driver.findElement(By.id("user_pass"));
            txtpass.click();
            txtpass.sendKeys("opensourcecms");

            WebElement btnlogin = driver.findElement(By.id("wp-submit"));
            btnlogin.click();

            WebElement btnPage = driver.findElement(By.xpath("//*[@id=\"menu-pages\"]/a/div[3]"));
            btnPage.click();

            //CLick en Add New
            driver.findElement(By.xpath("//*[@id=\"menu-pages\"]/ul/li[3]/a")).click();
            //Cerrar mensaje
            driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div/div[5]/div/div/div/div/button")).click();

            WebElement txtTittle = driver.findElement(By.xpath("//*[@id=\"post-title-0\"]"));
            txtTittle.click();
            txtTittle.clear();
            Thread.sleep(1500);
            txtTittle.sendKeys("Page test 01");

            WebElement txtarea = driver.findElement(By.xpath("//*[@id=\"block-e8c2dfa1-cacd-41b3-8472-0320a9ab6908\"]/div[3]/div/div/div/div/div/div/p"));
            txtarea.click();
            txtarea.sendKeys("Texto de prueba");


            WebElement btnsave = driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div/div[1]/div[2]/button[1]"));
            btnsave.click();

            btnPage.click();

            System.out.println("Prueba Exitosa! ");







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
