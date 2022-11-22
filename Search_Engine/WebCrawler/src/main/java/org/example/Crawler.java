package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static javafx.scene.input.DataFormat.URL;

public class Crawler {
    private HashSet < String > urllink ;
    public Connection connection ;
    public Crawler () {

        connection = databaseConnection.getConnection();
        urllink = new HashSet<String>() ;
    }

    public void getPageTextAndLinks ( String URL , int depth ){
        if ( !urllink.contains(URL)){
            try {
                if ( urllink.add(URL)){
                    System.out.println(URL);
                }
                Document document = Jsoup.connect(URL).userAgent("Chrome").timeout(5000).get();
                String text = document.text().length()< 501 ? document.text(): document.text().substring(0,500);

                PreparedStatement preparedStatement = connection.prepareStatement("Insert into pages values ( ? ,? ,?)");
                preparedStatement.setString(1,document.title());
                preparedStatement.setString(2,URL);
                preparedStatement.setString(3,text);
                preparedStatement.executeUpdate();


//  select pagetitle , pagelink (length (pagedata) - length ( replace ( pagedata , 'java' , '' )))/ length('java')  from pages ;
// select pagetitle , pagelink from pages order by (length (pagedata) - length ( replace ( pagedata , 'java' , '' )))/ length('java')  desc ;


/*

 complete line command :-->>>

select pagetitle , pagelink ,  (length (pagedata) - length ( replace ( pagedata , 'java' , '' )))/ length('java')
as countOccurence from pages order by countOccurence desc limit 30 ;

*/

                System.out.println(text);
                depth++ ;
                if ( depth == 2 ){
                    return ;
                }

                Elements availableLinksOnPage = document.select("a[href]");
                for (Element element : availableLinksOnPage){
                    getPageTextAndLinks(element.attr("abs:href") , depth );
                }

            } catch ( IOException e ) {
                e.printStackTrace();
            } catch (SQLException sqlException) {
               sqlException.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        crawler.getPageTextAndLinks("https://en.wikipedia.org/wiki/Main_Page" , 0);
    }
}