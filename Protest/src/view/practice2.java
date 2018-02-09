package view;


import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import dao.AptDaoImpl;
import entity.AptVo;
import entity.AptVo2;
import entity.JunVo;

public class practice2 {
   public static void main(String[] args) throws Exception {

      String excelFilePath = "C:\\Users\\Playdata\\Desktop\\Protest\\pro2.xls";
      FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

      Workbook workbook = new HSSFWorkbook(inputStream);
      Sheet firstSheet = workbook.getSheetAt(0);
      Iterator<Row> iterator = firstSheet.iterator();
                        
      List<String> list = new ArrayList<>();

      AptVo2 av = new AptVo2();
      JunVo jv = new JunVo();
      
      while (iterator.hasNext()) {
         Row nextRow = iterator.next();
         Iterator<Cell> celliterator = nextRow.cellIterator();

         while (celliterator.hasNext()) {
            Cell cell = celliterator.next();
            if (cell.getCellTypeEnum() == CellType.STRING) {
               String cellstr = cell.getStringCellValue();
               System.out.println(cellstr);
               list.add(cellstr);
            }
         }
         av.setSigungu(list.get(0));
         av.setBunji(list.get(1));
         av.setDanji(list.get(2));
         jv.setJunwol(list.get(3));
         av.setMyunjuk(Double.parseDouble(list.get(4)));
         jv.setGyeyak(list.get(5));
         jv.setBojeung(Integer.parseInt(list.get(6)));
         jv.setWolse(Integer.parseInt(list.get(7)));
         av.setGunchook(Integer.parseInt(list.get(8)));
         av.setDoromyung(list.get(9));
         System.out.println(av.toString());
         System.out.println("==========================");
      
      }

      workbook.close();
   }

}