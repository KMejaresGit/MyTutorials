/**
 * Created by Kimboy on 20/6/17.
 */
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Kimboy on 16/6/17.
 */
public class GetTableData {

    public void readExcel() throws BiffException, IOException {
        String FilePath="//Users//Kimboy//IdeaProjects//MyTutorials//src//UserAccount.xls";

        FileInputStream fs=new FileInputStream(FilePath);
        Workbook wb=Workbook.getWorkbook(fs);

        // TO get the access to the sheet
        Sheet sh=wb.getSheet("Sheet1");


        // To get the number of rows present in sheet
        int totalNoOfRows=sh.getRows();

        // To get the number of columns present in sheet
        int totalNoOfCols=sh.getColumns();

        for (int row=0; row < totalNoOfRows; row++) {

            for (int col=0; col < totalNoOfCols; col++) {
                System.out.print(sh.getCell(col, row).getContents()+ "\t");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) throws BiffException, IOException {
        GetTableData DT=new GetTableData();
        DT.readExcel();
    }
}

