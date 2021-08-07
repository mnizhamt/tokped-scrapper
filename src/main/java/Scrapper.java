import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Scrapper {

    private static final String BASE_URL = "https://www.tokopedia.com/p/handphone-tablet/handphone";

    private List<String> items = new ArrayList<>();

    public void grabStoreItems() {
        try {
            Document doc = Jsoup.connect(BASE_URL).get();
            Elements groupOne = doc.select("div.css-bk6tzz");
            for (Element el : groupOne) {
                String productName = el.select("span.css-1bjwylw").html();
                String price = el.select("span.css-o5uqvq").html();
                int star = el.select("img.css-177n1u3").size();
                String img = el.select("img.fade").attr("src");
                String store = el.select("span.css-1kr22w3").html();

                // System.out.println(productName + ", Price: " + price);
                // System.out.println("Store: " + store + ", Star:" + String.valueOf(star));
                // System.out.println("Image link: " + img + "\n");

                StringBuilder sb = new StringBuilder();
                sb.append(productName).append(", ")
                        .append(price).append(", ")
                        .append(store).append(", ")
                        .append(star).append(", ")
                        .append(img);
                items.add(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            createCsvFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCsvFile() throws IOException {
        File csvOut = new File("tokped-phones.csv");
        try (PrintWriter pw = new PrintWriter(csvOut)) {
            items.stream()
                    .forEach(pw::println);
        }
//        assertTrue(csvOutputFile.exists());
    }
}
