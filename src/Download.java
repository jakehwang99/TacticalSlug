import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Download {

    public String url;
    private static ArrayList<String> majorList = new ArrayList<>();
    private static ArrayList<String> urlList = new ArrayList<>();
    private static CharSequence fileType = ".pdf";

    public Download(String url) throws IOException {
        this.url = url;
    }

    public void getPDF() throws IOException {

        //Fetching all the pdf links for eventual download
        System.out.println("Fetching " + url + "...");
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            if(link.attr("abs:href").contains(fileType)) {
                majorList.add(link.text());
                urlList.add(link.attr("abs:href"));
            }
        }

        //Looks for which major and downloads the pdf file
        int temp = whichMajor();
        saveFile(urlList.get(temp), "temp/" + majorList.get(temp) + ".pdf");
    }

    //returns the position of the url link to the major curriculum chart
    private static int whichMajor(){
        Scanner scan = new Scanner(System.in);
        String isBS, major, whichBio;
        while(true) {
            System.out.println("Are you pursuing BS or BA?");
            isBS = scan.nextLine();
            if(isBS.contains("BA") || isBS.contains("BS"))
                break;
            else
                System.out.println("That was not a valid input. Please try again.");
        }

        while(true) {
            System.out.println("Which major are you pursuing?");
            major = scan.nextLine();
            if(isMajor(isBS, major) != -1) {
                System.out.println("We found that major!");
                return isMajor(isBS, major);
            } else {
                System.out.println("We could not find that major. Maybe you spelled it wrong? Please try again.");
            }
        }
    }

    //check if there is a major that exists
    private static int isMajor(String isBS, String input) {
        for(int i = 0; i < majorList.size(); i++){
            if(majorList.get(i).contains(input) && majorList.get(i).contains(isBS))
                return i;
        }
        return -1;
    }

    //downloads a file
    private static void saveFile(String url, String file) throws IOException {
        URL temp = new URL(url);
        InputStream in = temp.openStream();
        FileOutputStream fos = new FileOutputStream(new File(file));

        int length = -1;
        byte[] buffer = new byte[1024]; // buffer for portion of data from connection
        while ((length = in.read(buffer)) > -1)
            fos.write(buffer, 0, length);

        fos.close();
        in.close();
    }

    public void printCurriculumCharts(){
        System.out.println("\nLinks:");
        for(int i = 0; i < majorList.size(); i++){
            System.out.println(majorList.get(i) + ": " + urlList.get(i));
        }
    }
}
