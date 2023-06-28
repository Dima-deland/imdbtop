import com.google.common.base.Verify;
import com.google.errorprone.annotations.FormatString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class test {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/Users/dmytro/chromedriver");

        var toplimit = 5;
        Movies[] movie = new Movies[toplimit];
        WebElement[] title = new WebElement[toplimit];
        WebElement[] year = new WebElement[toplimit];
        WebElement[] rating = new WebElement[toplimit];


for (int i=0;i<toplimit;i++){
    movie[i] = new Movies();
    movie[i].Position = i+1;
//  System.out.println(movie[i].Position);
}

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.imdb.com/");

    WebElement burger = driver.findElement(By.xpath("//*[@id=\'imdbHeader-navDrawerOpen\']"));
    burger.click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    WebElement top = driver.findElement(By.linkText("Top 250 Movies"));
    top.click();

   /* WebElement newv = driver.findElement(By.linkText("Learn more"));
    System.out.println(newv.getText());

    if (newv.getText().contains("Learn more")) {


        //get titles data new version
        for (int i = 0; i < toplimit; i++) {
            title[i] = driver.findElement(By.xpath("//*[@id=\'__next\']/main/div/div[3]/section/div/div[2]/div/ul/li[" + Integer.toString(i + 1) + "]/div[2]/div/div/div[1]/a/h3"));
            movie[i].Title = title[i].getText().substring(3);
            System.out.println(movie[i].Title);
        }

        //get year data new version
        for (int i = 0; i < toplimit; i++) {
            year[i] = driver.findElement(By.xpath("//*[@id=\'__next\']/main/div/div[3]/section/div/div[2]/div/ul/li[" + Integer.toString(i + 1) + "]/div[2]/div/div/div[2]/span[1]"));
            movie[i].Year = year[i].getText();
            System.out.println(movie[i].Year);
        }

        //get rating data new version
        for (int i = 0; i < toplimit; i++) {
            rating[i] = driver.findElement(By.xpath("//*[@id=\'__next\']/main/div/div[3]/section/div/div[2]/div/ul/li[" + Integer.toString(i + 1) + "]/div[2]/div/div/span/div/span"));
            movie[i].Rating = rating[i].getText();
            System.out.println(movie[i].Rating);
        }
    }
    else
   {
*/
        //get titles data
        for (int i = 0; i < toplimit; i++) {
            title[i] = driver.findElement(By.xpath("//*[@id=\'main\']/div/span/div[1]/div/div[3]/table/tbody/tr[" + Integer.toString(i + 1) + "]/td[2]/a"));
            movie[i].Title = title[i].getText();
            System.out.println(movie[i].Title);
        }

        //get year data
        for (int i = 0; i < toplimit; i++) {
            year[i] = driver.findElement(By.xpath("//*[@id=\'main\']/div/span/div[1]/div/div[3]/table/tbody/tr[" + Integer.toString(i + 1) + "]/td[2]/span"));
            movie[i].Year = year[i].getText().substring(1, 5);
            System.out.println(movie[i].Year);
        }

        //get rating data
        for (int i = 0; i < toplimit; i++) {
            rating[i] = driver.findElement(By.xpath("//*[@id=\'main\']/div/span/div[1]/div/div[3]/table/tbody/tr[" + Integer.toString(i + 1) + "]/td[3]/strong"));
            movie[i].Rating = rating[i].getText();
            System.out.println(movie[i].Rating);
        }


   // }


    ArrayList movieslist = new ArrayList();
    for (int i=0;i<toplimit;i++) {
        movieslist.add(movie[i].Title);
    }
// Assert.assertTrue(movieslist.contains("The Godfather")

   if (movieslist.contains("The Godfather")) {
       System.out.println("The Godfather movie is in Top " +Integer.toString(toplimit) +" forever");

   }else{
       System.out.println("It couldn't happen. We didn't find The Godfather movie in top5 list. Try to rerun test ");
   }

   WebElement gflink = driver.findElement(By.partialLinkText("The Godfather"));
   gflink.click();

  WebElement mtitle = driver.findElement(By.xpath("//*[@id=\'__next\']/main/div/section[1]/section/div[3]/section/section/div[2]/div[1]/h1/span"));
   WebElement myear = driver.findElement(By.xpath("//*[@id=\'__next\']/main/div/section[1]/section/div[3]/section/section/div[2]/div[1]/ul/li[1]/a"));
   WebElement mrating = driver.findElement(By.xpath("//*[@id=\'__next\']/main/div/section[1]/section/div[3]/section/section/div[2]/div[2]/div/div[1]/a/span/div/div[2]/div[1]/span[1]"));

   String mtitlev = mtitle.getText();
   String myearv = myear.getText();
   String mratingv = mrating.getText();

   int position = movieslist.indexOf("The Godfather");
       System.out.println(position);



       //check title
        if (mtitlev.equals(movie[position].Title)) {
            System.out.println("Title is matched");

        }else{
            System.out.println(mtitlev+movie[position].Title);
        }

        //check year
        if (myearv.equals(movie[position].Year)) {
            System.out.println("Year is matched");

        }else{
            System.out.println(myearv+movie[position].Year);
        }

        //check rate
        if (mratingv.equals(movie[position].Rating)) {
            System.out.println("Rating is matched");

        }else{
           // System.out.println(movie[position].Rating);
            System.out.println(mratingv);
        }

        Verify.verify(mtitlev.equals(movie[position].Title),"Title isn't matched");

driver.quit();

    }
}
