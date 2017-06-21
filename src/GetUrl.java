import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Kimboy on 20/6/17.
 */
public class GetUrl {

    String url ;

    public void readExcel() throws BiffException, IOException {
        String FilePath="//Users//Kimboy//IdeaProjects//MyTutorials//src//UserAccount.xls";

        FileInputStream fs=new FileInputStream(FilePath);
        Workbook wb=Workbook.getWorkbook(fs);

        // TO get the access to the sheet
        Sheet sh=wb.getSheet("Sheet1");

        url = sh.getCell(0, 1).getContents();
        //System.out.println("Url is " + url);
    }

    /*
    public static void main(String[] args) throws BiffException, IOException {
        GetUrl DT=new GetUrl();
        DT.readExcel();
        System.out.println("Url is : " + DT.url);
    }
    */


}
