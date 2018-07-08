import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraping {

	public WebScraping() {
		
	}

	public static void main(String[] args) {
		try {
			Document document = Jsoup.connect("https://www.imdb.com/chart/top").get();


			Elements title = document.select(".titleColumn"); 
			Elements rating = document.select(".imdbRating");
			Elements year = document.select(".secondaryInfo");

			for(int i = 0; i < title.size(); i++){
				System.out.println(title.get(i).text().substring(0,title.get(i).text().length() - 7) + ", " + rating.get(i).text() + ", " + year.get(i).text().replaceAll("[()]", ""));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
