import java.io.*;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.BufferedWriter;

public class PDFReader {
    private PDFParser parser;
    private PDFTextStripper pdfStripper;
    private PDDocument pdDoc ;
    private COSDocument cosDoc ;

    private String Text ;
    private String filePath;

    private File file;
    static BufferedWriter writer;


    public PDFReader() {

    }

    public String ToText() throws IOException
    {
        this.pdfStripper = null;
        this.pdDoc = null;
        this.cosDoc = null;

        File storedData = new File("PDFTest.txt");

        file = new File(filePath);
        parser = new PDFParser(new RandomAccessFile(file,"r"));

        parser.parse();
        cosDoc = parser.getDocument();
        pdfStripper = new PDFTextStripper();
        pdDoc = new PDDocument(cosDoc);
        pdDoc.getNumberOfPages();
        pdfStripper.setStartPage(1);
        pdfStripper.setEndPage(pdDoc.getNumberOfPages());

        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(storedData)));
        pdfStripper.writeText(pdDoc,writer);
        Text = pdfStripper.getText(pdDoc);
        writer.close();
        return Text;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
