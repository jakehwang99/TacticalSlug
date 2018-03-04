import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PDFSort {
    public static void main(String[] args) throws IOException {

        PDFReader pdfManager = new PDFReader();
        pdfManager.setFilePath("C:\\Users\\nkenn\\Pictures\\CS_BS.pdf");
        //System.out.println(pdfManager.ToText());

        ArrayList<String> schedule = new ArrayList<String>();
        File curriculum = new File("PDFTest.txt");
        try {
            Scanner input = new Scanner(curriculum);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] words = line.split("\\s");
                for(int i = 0 ; i < words.length; i++) {
                    if (words[i].equals("AMS") || words[i].equals("CMPS") || words[i].equals("CMPE") || words[i].equals("MATH")) {
                        words[i+1] = words[i+1].replaceAll("[^0-9/ABLMJW]",  "");
                        String course = words[i] + " " + words[i+1];
                        schedule.add(course);
                    }
                }
            }
            Collections.sort(schedule);

            for(int i = 0; i < schedule.size(); i++) {
                System.out.println(schedule.get(i));
            }
        }
        catch(IOException ex) {
            System.out.println(ex.toString() + "error");
        }
    }
}
