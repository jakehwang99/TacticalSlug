import java.io.IOException;
import org.jsoup.helper.Validate;

public class TacticalSlug {
    public static void main(String[] args) throws IOException {
        Download d = new Download("https://ua.soe.ucsc.edu/curriculum-charts");
        d.getPDF();
        //d.printCurriculumCharts();
        GUIView g = new GUIView();
    }
}
