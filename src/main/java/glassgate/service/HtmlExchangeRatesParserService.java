package glassgate.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@Service
@EnableScheduling
public class HtmlExchangeRatesParserService {

    @Scheduled(fixedRate = 600000)
    @ExceptionHandler
    public Double minfinusd() {

        try {

        String htmlString = "<p>Sample Content</p>";
        Document html = Jsoup.parseBodyFragment(htmlString);
        Element body = html.body();

        Document doc;
        try {
            doc = Jsoup.connect("https://minfin.com.ua/currency/auction/usd/sell/lvov/?presort=&sort=time&order=desc" +
                    "")
                    .userAgent("Mozilla/5.0 Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .get();
            body = doc.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String firstString = "";
        String secondString = "";

        Elements paragraphs = body.getElementsByClass("au-mid-buysell");
        for (Element paragraph : paragraphs) {

            firstString = paragraph.text();

            if((firstString.split(":")[0].equals("Середній продаж")) || (firstString.split(":")[0].equals("Средняя продажа"))) {
                secondString = firstString.split(":")[1].split(" ")[1].split(" ")[0];
            }

        }

        double minfinusd = Double.parseDouble(secondString.split(",")[0] + "." + secondString.split(",")[1]);

        return minfinusd;

        } catch (ArrayIndexOutOfBoundsException e) {

            double minfinusd = 1.00;

            return minfinusd;
        }
            catch (NullPointerException e) {

            double minfinusd = 1.00;

            return minfinusd;
        }

    }

    @Scheduled(fixedRate = 600000)
    public Double minfineuro() {

        try {

            String htmlString = "<p>Sample Content</p>";
            Document html = Jsoup.parseBodyFragment(htmlString);
            Element body = html.body();

        Document doc;
        try {
            doc = Jsoup.connect("https://minfin.com.ua/currency/auction/eur/sell/lvov/?presort=&sort=time&order=desc")
                    .userAgent("Mozilla/5.0 Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .get();
            body = doc.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String firstString = "";
        String secondString = "";

        Elements paragraphs = body.getElementsByClass("au-mid-buysell");
        for (Element paragraph : paragraphs) {

            firstString = paragraph.text();

            if((firstString.split(":")[0].equals("Середній продаж")) || (firstString.split(":")[0].equals("Средняя продажа"))) {
                secondString = firstString.split(":")[1].split(" ")[1].split(" ")[0];
            }

        }

        double minfineuro = Double.parseDouble(secondString.split(",")[0] + "." + secondString.split(",")[1]);

        return minfineuro;

        } catch (ArrayIndexOutOfBoundsException e) {

            double minfineuro = 1.00;

            return minfineuro;
        }

        catch (NullPointerException e) {

            double minfineuro = 1.00;

            return minfineuro;
        }
    }

    @Scheduled(fixedRate = 600000)
    public Double goverlausd() {

        try {

            String htmlString = "<p>Sample Content</p>";
            Document html = Jsoup.parseBodyFragment(htmlString);
            Element body = html.body();

        Document doc;
        try {
            doc = Jsoup.connect("https://goverla.ua/")
                    .userAgent("Mozilla/5.0 Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .get();
            body = doc.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String firstString;
        String secondString;

        Element paragraph = body.getElementById("usd");

        firstString = paragraph.text();
        secondString = firstString.split(" ")[1];

        double goverlausd = Double.parseDouble(secondString)/100;

        return goverlausd;

        } catch (ArrayIndexOutOfBoundsException e) {

            double goverlausd = 1.00;

            return goverlausd;
        }

        catch (NullPointerException e) {

            double goverlausd = 1.00;

            return goverlausd;
        }
    }

    @Scheduled(fixedRate = 600000)
    public Double goverlaeuro() {

        try {

            String htmlString = "<p>Sample Content</p>";
            Document html = Jsoup.parseBodyFragment(htmlString);
            Element body = html.body();

        Document doc;
        try {
            doc = Jsoup.connect("https://goverla.ua/")
                    .userAgent("Mozilla/5.0 Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .get();
            body = doc.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String firstString;
        String secondString;

        Element paragraph = body.getElementById("eur");

        firstString = paragraph.text();

        secondString = firstString.split(" ")[1];

        double goverlaeuro = Double.parseDouble(secondString)/100;

        return goverlaeuro;

        } catch (ArrayIndexOutOfBoundsException e) {

            double goverlaeuro = 1.00;

            return goverlaeuro;
        }

        catch (NullPointerException e) {

            double goverlausd = 1.00;

            return goverlausd;
        }
    }

    @Scheduled(fixedRate = 600000)
    @ExceptionHandler
    public Double bankusd() {

        try {

            String htmlString = "<p>Sample Content</p>";
            Document html = Jsoup.parseBodyFragment(htmlString);
            Element body = html.body();

            Document doc;
            try {
                doc = Jsoup.connect("https://minfin.com.ua/currency/auction/usd/sell/lvov/?presort=&sort=time&order=desc" +
                        "")
                        .userAgent("Mozilla/5.0 Chrome/4.0.249.0 Safari/532.5")
                        .referrer("http://www.google.com")
                        .ignoreHttpErrors(true)
                        .get();
                body = doc.body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String firstString = "";
            String secondString = "";

            Elements paragraphs = body.getElementsByClass("au-mid-buysell");
            for (Element paragraph : paragraphs) {

                firstString = paragraph.text();

                if((firstString.split(":")[0].equals("Середній продаж")) || (firstString.split(":")[0].equals("Средняя продажа"))) {
                    secondString = firstString.split(":")[1].split(" ")[1].split(" ")[0];
                }

            }

            double bankusd = Double.parseDouble(secondString.split(",")[0] + "." + secondString.split(",")[1]);

            return bankusd;

        } catch (ArrayIndexOutOfBoundsException e) {

            double bankusd = 1.00;

            return bankusd;
        }
        catch (NullPointerException e) {

            double bankusd = 1.00;

            return bankusd;
        }

    }

    @Scheduled(fixedRate = 600000)
    public Double bankeuro() {

        try {

            String htmlString = "<p>Sample Content</p>";
            Document html = Jsoup.parseBodyFragment(htmlString);
            Element body = html.body();

            Document doc;
            try {
                doc = Jsoup.connect("https://minfin.com.ua/currency/auction/eur/sell/lvov/?presort=&sort=time&order=desc")
                        .userAgent("Mozilla/5.0 Chrome/4.0.249.0 Safari/532.5")
                        .referrer("http://www.google.com")
                        .ignoreHttpErrors(true)
                        .get();
                body = doc.body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String firstString = "";
            String secondString = "";

            Elements paragraphs = body.getElementsByClass("au-mid-buysell");
            for (Element paragraph : paragraphs) {

                firstString = paragraph.text();

                if((firstString.split(":")[0].equals("Середній продаж")) || (firstString.split(":")[0].equals("Средняя продажа"))) {
                    secondString = firstString.split(":")[1].split(" ")[1].split(" ")[0];
                }

            }

            double bankeuro = Double.parseDouble(secondString.split(",")[0] + "." + secondString.split(",")[1]);

            return bankeuro;

        } catch (ArrayIndexOutOfBoundsException e) {

            double bankeuro = 1.00;

            return bankeuro;
        }

        catch (NullPointerException e) {

            double bankeuro = 1.00;

            return bankeuro;
        }
    }
}