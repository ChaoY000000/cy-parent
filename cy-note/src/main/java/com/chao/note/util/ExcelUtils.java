package com.chao.note.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.appengine.repackaged.com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;

/**
 * Created by 15313 on 2020/11/13.
 */
public class ExcelUtils {
    //文件路径
    private String path = null;

    public ExcelUtils() {}
    public ExcelUtils(String path) {
        this.path = path;
    }

    /**
     * 作用：读取Excel表格指定列中数据
     * @param column 要读取Excel表格的哪一列，从0开始
     * @return 返回列中数据
     */
    public List<String> readColContentFromExcel(int column) {
        List<String> content = new ArrayList<String>();
        FileInputStream input = null;
        try {
            input = new FileInputStream(this.path);
            XSSFWorkbook workBook = new XSSFWorkbook(input);
            XSSFSheet sheet = workBook.getSheetAt(0);
//            HSSFWorkbook workBook = new HSSFWorkbook(input);
//            HSSFSheet sheet = workBook.getSheetAt(0);
            String cellContent = null;
            for(int i=1; i<sheet.getPhysicalNumberOfRows(); i++) {
//                HSSFCell cell = sheet.getRow(i).getCell(column);
                XSSFCell cell = sheet.getRow(i).getCell(column);
                if(cell != null) {
                    cellContent = sheet.getRow(i).getCell(column).toString();
                    if(!StringUtils.isBlank(cellContent)) {
                        content.add(cellContent);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    /**
     * 作用：向Excel表格指定列中写入数据
     * @param contents 要添加到Excel表格指定列中的数据
     * @param column 指定列
     */
    public void writeResultAtExcel(List<String> contents, int column) {
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream(this.path);
//            HSSFWorkbook workBook = new HSSFWorkbook(input);
//            HSSFSheet sheet = workBook.getSheetAt(0);
            XSSFWorkbook workBook = new XSSFWorkbook(input);
            XSSFSheet sheet = workBook.getSheetAt(0);
            for(int i=1; i<=contents.size(); i++) {
//                HSSFCell cell = sheet.getRow(i).createCell(column);
                XSSFCell cell = sheet.getRow(i).createCell(column);
                cell.setCellValue(contents.get(i-1));
                output = new FileOutputStream(path);
                workBook.write(output);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 比较firstColumn列与secondColumn列中数据，并将比对结果存入Excel表格的resultColumn列
     * @param firstColumn Excel表格的列，从0开始
     * @param secondColumn 表格的列，从0开始
     * @param resultColumn 表格的列，从0开始
     */
    public void compareColumnsContent(int firstColumn, int secondColumn, int resultColumn) {
        List<String> results = new ArrayList<String>();
        List<String> first = this.readColContentFromExcel(firstColumn);
        List<String> second = this.readColContentFromExcel(secondColumn);
        for(Iterator<String> firstColumnContent = first.iterator(); firstColumnContent.hasNext(); ) {
            String result = "Not Equal";
            String str1 = firstColumnContent.next();
            for(Iterator<String> secondColumnContent=second.iterator(); secondColumnContent.hasNext(); ) {
                String str2 = secondColumnContent.next();
                if(!StringUtils.isBlank(str2)) {
                    if(str2.equals(str1)) {
                        result = "Equal";
                        break;
                    }
                }
            }
            results.add(result);
        }
        //将比较结果写入到Excel
        this.writeResultAtExcel(results, resultColumn);
        //System.out.println(results);
    }


    public static Map<String , ExcelDTO> readExcel(String str) throws FileNotFoundException, IOException {
        File file = new File(str);
        // HSSFWorkbook 2003的excel .xls,XSSFWorkbook导入2007的excel   .xlsx
//      HSSFWorkbook workbook=new HSSFWorkbook(new FileInputStream(new File(file)));
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
        Sheet sheet = workbook.getSheetAt(0);//读取第一个 sheet
        Map<String , ExcelDTO> map = Maps.newLinkedHashMap();
        Row row = null;
        int count = sheet.getPhysicalNumberOfRows();
        //逐行处理 excel 数据
        for (int i = 1; i < count; i++) {
//            JSONObject json = new JSONObject();
            ExcelDTO excelDTO = new ExcelDTO();
            row = sheet.getRow(i);
            if (row != null) {
                Cell cell00 = row.getCell(0);
                cell00.setCellType(CellType.STRING);
                //设置取值为String
                //整数数据要转，否则会变成浮点数
                Cell cell01 = row.getCell(1);

                Cell cell10 = row.getCell(2);
                cell10.setCellType(CellType.STRING);
                Cell cell11 = row.getCell(3);

                Cell cell20 = row.getCell(4);
                cell20.setCellType(CellType.STRING);
                Cell cell21 = row.getCell(5);

                Cell cell30 = row.getCell(6);
                cell30.setCellType(CellType.STRING);
                Cell cell31 = row.getCell(7);

                excelDTO.setFirstCode(cell00.toString());
                excelDTO.setFirstAddress(cell01.toString());
                excelDTO.setSecondCode(cell10.toString());
                excelDTO.setSecondAddress(cell11.toString());
                excelDTO.setThirdCode(cell20.toString());
                excelDTO.setThirdAddress(cell21.toString());
                excelDTO.setFourthCode(cell30.toString());
                excelDTO.setFourthAddress(cell31.toString());

                String addressKey = excelDTO.getFirstAddress().trim() + excelDTO.getSecondAddress().trim() +
                        excelDTO.getThirdAddress().trim() + excelDTO.getFourthAddress().trim();
                map.put(addressKey , excelDTO);
            }
        }
        workbook.close();
//        System.out.println("list:" + list);
        System.out.println("map.size: " + map.size());
        return map;
    }


    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public static XSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values,XSSFWorkbook wb) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new XSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        XSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        XSSFCellStyle style = wb.createCellStyle();

        //声明列对象
        XSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //创建内容
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }

}


//调用工具类的测试类代码：

 class ExcelTest {
    public static void main(String[] args) {
//        ExcelUtils excel1 = new ExcelUtils("C:\\Users\\15313\\Desktop\\国美零售\\安迅物流四级地址.xlsx");
//        ExcelUtils excel2 = new ExcelUtils("C:\\Users\\15313\\Desktop\\国美零售\\gomeTest.xlsx");

        try {
            Map<String , ExcelDTO> excel1 = ExcelUtils.readExcel("C:\\Users\\Chao\\Desktop\\国美零售\\安迅物流四级地址.xlsx");
            Map<String , ExcelDTO> excel2 = ExcelUtils.readExcel("C:\\Users\\Chao\\Desktop\\国美零售\\gomeTest.xlsx");
            write(excel1 , excel2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void write(Map<String , ExcelDTO> excel1 , Map<String , ExcelDTO> excel2){
        //excel标题
        String[] title = {"在线商城" , "一级Code", "一级地址", "二级Code", "二级地址", "三级Code" , "三级地址" , "四级Code" , "四级地址"
        , ""  , "易卡" , ""  , "一级Code", "一级地址", "二级Code", "二级地址", "三级Code" , "三级地址" , "四级Code" , "四级地址"};
        //excel文件名
        String fileName = "四级地址对比表.xlsx";
        //sheet名
        String sheetName = "四级地址对比表";
        String[][] content = null;


        int i = 0;
        content = new String[excel1.size() + excel2.size()][title.length];
        for (String addressKey : excel1.keySet()) {
            ExcelDTO excelDTO1 = excel1.get(addressKey);
//            content[i][0] = null;
            content[i][1] = excelDTO1.getFirstCode();
            content[i][2] = excelDTO1.getFirstAddress();
            content[i][3] = excelDTO1.getSecondCode();
            content[i][4] = excelDTO1.getSecondAddress();
            content[i][5] = excelDTO1.getThirdCode();
            content[i][6] = excelDTO1.getThirdAddress();
            content[i][7] = excelDTO1.getFourthCode();
            content[i][8] = excelDTO1.getFourthAddress();
//            content[i][9] = null;
//            content[i][10] = null;
//            content[i][11] = null;
            ExcelDTO excelDTO2 = excel2.get(addressKey);
            if (excelDTO2 != null){
                    content[i][12] = excelDTO2.getFirstCode();
                    content[i][13] = excelDTO2.getFirstAddress();
                    content[i][14] = excelDTO2.getSecondCode();
                    content[i][15] = excelDTO2.getSecondAddress();
                    content[i][16] = excelDTO2.getThirdCode();
                    content[i][17] = excelDTO2.getThirdAddress();
                    content[i][18] = excelDTO2.getFourthCode();
                    content[i][19] = excelDTO2.getFourthAddress();
            }
            i++;
        }
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExcelUtils.getHSSFWorkbook(sheetName, title, content, null);
        FileOutputStream output = null;
        try {
            output = new FileOutputStream("C:\\Users\\Chao\\Desktop\\国美零售\\" + fileName);
            wb.write(output);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
