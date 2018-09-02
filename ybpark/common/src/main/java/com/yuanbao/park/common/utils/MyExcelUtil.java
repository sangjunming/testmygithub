package com.yuanbao.park.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author: CrazyZhou
 * @description: excel导入读取工具类
 * @date: 2018-06-28 11:16
 * @param:
 */
public class MyExcelUtil {
    private static DecimalFormat df = new DecimalFormat("0");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static DecimalFormat nf = new DecimalFormat("0.00");

    public MyExcelUtil() {
    }

    public static ArrayList<ArrayList<Object>> readExcel(File file) {
        return file == null ? null : readExcel2007(file);
    }

    public static ArrayList<ArrayList<Object>> readExcel2007(InputStream inputStream) {
        try {
            ArrayList<ArrayList<Object>> rowList = new ArrayList();
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheetAt(0);
            int i = sheet.getFirstRowNum();

            for(int rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows(); ++i) {
                XSSFRow row = sheet.getRow(i);
                ArrayList<Object> colList = new ArrayList();
                if (row == null) {
                    if (i != sheet.getPhysicalNumberOfRows()) {
                        rowList.add(colList);
                    }
                } else {
                    ++rowCount;

                    for(int j = row.getFirstCellNum(); j <= row.getLastCellNum(); ++j) {
                        XSSFCell cell = row.getCell(j);
                        if (cell != null && cell.getCellType() != 3) {
                            Object value;
                            switch(cell.getCellType()) {
                                case 0:
                                    if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                                        value = df.format(cell.getNumericCellValue());
                                    } else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                                        value = nf.format(cell.getNumericCellValue());
                                    } else {
                                        value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                                    }
                                    break;
                                case 1:
                                    value = cell.getStringCellValue();
                                    break;
                                case 2:
                                default:
                                    value = cell.toString();
                                    break;
                                case 3:
                                    value = "";
                                    break;
                                case 4:
                                    value = cell.getBooleanCellValue();
                            }

                            colList.add(value);
                        } else if (j != row.getLastCellNum()) {
                            colList.add("");
                        }
                    }

                    rowList.add(colList);
                }
            }

            return rowList;
        } catch (Exception var11) {
            System.out.println("exception");
            return null;
        }
    }

    public static ArrayList<ArrayList<Object>> readExcel2007(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            return readExcel2007((InputStream)inputStream);
        } catch (Exception var2) {
            System.out.println("exception");
            return null;
        }
    }

    public static void writeExcel(ArrayList<ArrayList<Object>> result, String path) {
        if (result != null) {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("sheet1");

            HSSFCell cell;
            for(int i = 0; i < result.size(); ++i) {
                HSSFRow row = sheet.createRow(i);
                if (result.get(i) != null) {
                    for(int j = 0; j < ((ArrayList)result.get(i)).size(); ++j) {
                        cell = row.createCell(j);
                        cell.setCellValue(((ArrayList)result.get(i)).get(j).toString());
                    }
                }
            }

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            try {
                wb.write(os);
            } catch (IOException var10) {
                var10.printStackTrace();
            }

            byte[] content = os.toByteArray();
            File file = new File(path);
            cell = null;

            try {
                OutputStream fos = new FileOutputStream(file);
                fos.write(content);
                os.close();
                fos.close();
            } catch (Exception var9) {
                var9.printStackTrace();
            }

        }
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static void setDf(DecimalFormat df) {
        df = df;
    }

    public static SimpleDateFormat getSdf() {
        return sdf;
    }

    public static void setSdf(SimpleDateFormat sdf) {
        sdf = sdf;
    }

    public static DecimalFormat getNf() {
        return nf;
    }

    public static void setNf(DecimalFormat nf) {
        nf = nf;
    }
}

