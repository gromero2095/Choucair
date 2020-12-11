package org.choucair.opensourcecms;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateTags {

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

            //CLick en Tags
            WebElement btntag = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[5]/a"));
            btntag.click();

            //Texto
            WebElement txtnametag = driver.findElement(By.id("tag-name"));
            txtnametag.click();
            txtnametag.sendKeys("Test Tags 02");

            WebElement txtdestag = driver.findElement(By.id("tag-description"));
            txtdestag.click();
            txtdestag.sendKeys("Test Description tag 02");
            txtdestag.submit();

            System.out.println("Prueba Exitosa!");


            /*
            btntag.click();

            WebElement btnsearch = driver.findElement(By.id("tag-search-input"));
            btnsearch.click();
            btnsearch.sendKeys(""+txtnametag.getText());

            driver.findElement(By.id("search-submit")).click();


            String finaltext = driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/table")).getText();

            System.out.println(finaltext.contains(""+txtnametag.getText())?finaltext: "Prueba Fallida!");

            */

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
