package view;

import java.io.File;
import java.io.FileInputStream;
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
import entity.SimVo;

public class AptView9 {
	public void aptv() {
		int no = 0;

		AptVo2 av2 = new AptVo2();
		JunVo jv = new JunVo();
		
		

		String excelFilePath = "C:\\Users\\Playdata\\Desktop\\Protest\\pro3.xls";
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new HSSFWorkbook(inputStream);

			for (int i = 0; i <= workbook.getNumCellStyles(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				/*int rowstart = 9;
				int rowend = sheet.getLastRowNum();	
				for(int abc = rowstart; abc <=rowend+1; abc++ ) {
				*/
				Iterator<Row> iterator = sheet.iterator();

				//System.out.println(sheet.getLastRowNum()+1);
				
				

				while (iterator.hasNext()) {
					List<String> list = new ArrayList<>();
					
					Row nextRow = iterator.next();
					Iterator<Cell> celliterator = nextRow.cellIterator();
					String[] array = new String[list.size()];
					String[] array1 = new String[list.size()];

					while (celliterator.hasNext()) {
						Cell cell = celliterator.next();
						if (cell.getCellTypeEnum() == CellType.STRING) {
							String cellstr = cell.getStringCellValue();
							System.out.println(cellstr);
							list.add(cellstr);
						} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
							double cellstr = cell.getNumericCellValue();
							int cellstr1 = (int) cellstr;
							String cellstr2 = String.valueOf(cellstr1);
							System.out.println(cellstr1);

							list.add(cellstr2);
						}
					}

					String[] strarray = list.toArray(new String[list.size()]);

					array = strarray[0].trim().split("\\s+");

					//System.out.println("=====" + list.toString());
					
					SimVo sv = new SimVo();
					sv.setSigungu(list.get(0));
					sv.setBunji(list.get(1));
					sv.setDanji(list.get(2));
					sv.setMyunjuk(Double.parseDouble(list.get(4)));
					sv.setCheung(Integer.parseInt(list.get(8)));
					sv.setGunchook(Integer.parseInt(list.get(9)));
					sv.setDoromyung(list.get(10));
					
					AptDaoImpl adi2 = new AptDaoImpl();
					List<SimVo> rs = adi2.select();
					int l = 0;
					for(SimVo sv2 : rs) {
						System.out.println(sv);
						System.out.println(sv2);
						
						if(String.valueOf(sv).equals(String.valueOf(sv2))) {
							l=1;
						}
						
					}
					System.out.println(l);
					
		if(l!=1) {
					
					av2.setNo(++no);
					jv.setNo(no);
					av2.setSigungu(list.get(0));
					
					av2.setBunji(list.get(1));
					av2.setDanji(list.get(2));
					jv.setJunwol(list.get(3));
					av2.setMyunjuk(Double.parseDouble(list.get(4)));
					jv.setGyeyak(list.get(5));

					if (strarray[6].length() > 3
							&& strarray[6].substring(strarray[6].length() - 4, strarray[6].length() - 3).equals(",")) {
						array1 = strarray[6].trim().split(",");
						String convert = array1[0] + array1[1];
						jv.setBojeung(Integer.parseInt(convert));
					} else {
						jv.setBojeung(Integer.parseInt(list.get(6)));
					}

					jv.setWolse(Integer.parseInt(list.get(7)));
					av2.setCheung(Integer.parseInt(list.get(8)));
					av2.setGunchook(Integer.parseInt(list.get(9)));

					if (list.size() == 11) {
						av2.setDoromyung(list.get(10));
					}
					System.out.println(av2.toString());
					System.out.println("==========================");

					AptDaoImpl adi = new AptDaoImpl();

					if (list.size() == 11) {
						int k = adi.insertApt2(av2.getNo(), av2.getSigungu(), av2.getBunji(),
								av2.getDanji(), av2.getMyunjuk(), av2.getCheung(), av2.getGunchook(), av2.getDoromyung());
						if (k > 0) {
							System.out.println("apt들어갔오");
						} else {
							System.out.println("apt안들어감 !");
						}

						int j = adi.insertJun(jv.getNo(), jv.getJunwol(), jv.getGyeyak(), jv.getBojeung(),
								jv.getWolse());
						if (j > 0) {
							System.out.println("jun들어갔오");
						} else {
							System.out.println("jun안들어감 !");
						}

					} else {

						int a = adi.insertApt3(av2.getNo(), av2.getSigungu(), av2.getBunji(),
								av2.getDanji(), av2.getMyunjuk(), av2.getCheung(), av2.getGunchook());
						if (a > 0) {
							System.out.println("apt들어갔오");
						} else {
							System.out.println("apt안들어감 !");
						}
						int j = adi.insertJun(jv.getNo(), jv.getJunwol(), jv.getGyeyak(), jv.getBojeung(),
								jv.getWolse());
						if (j > 0) {
							System.out.println("jun들어갔오");
						} else {
							System.out.println("jun안들어감 !");
						}
					}

					list = null;
					array = null;
		}
					workbook.close();
	
				}
			}
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AptView9 aptview = new AptView9();
		aptview.aptv();
	}

}