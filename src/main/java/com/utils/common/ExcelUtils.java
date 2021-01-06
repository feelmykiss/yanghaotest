package com.utils.common;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ExcelUtils class
 *
 * @author yh
 * @date 2020/12/29
 */
public class ExcelUtils {
    /**
     * 生成Excel
     *
     * @param sheetTitle
     * @param headers
     * @return
     */
    @SuppressWarnings("deprecation")
    public static HSSFWorkbook createExcel(String sheetTitle, String[] headers, List<String[]> dataList, List<Map<String, String>> headerCellList) {

        int headerInfoStartIndex = 0;
        int titleRowStartIndex = 0;

        String SHEETTILE = sheetTitle;
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(SHEETTILE);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式(标题)
        HSSFCellStyle styleForTitle = ExcelUtils.setCellStyleForTitle(workbook); // 设置样式
        // 生成一个字体(标题)
        HSSFFont fontForTitle = ExcelUtils.setFontForTitle(workbook);// 设置字体
        // 把字体应用到当前的样式(标题)
        styleForTitle.setFont(fontForTitle);

        // 生成一个样式(内容)
        HSSFCellStyle styleForContent = ExcelUtils.setCellStyleForContent(workbook); // 设置样式
        // 生成一个字体(内容)
        HSSFFont fontForContent = ExcelUtils.setFontForContent(workbook);// 设置字体
        // 把字体应用到当前的样式(内容)
        styleForContent.setFont(fontForContent);

        // 产生表格标题行 从第一行开始
        HSSFRow row = sheet.createRow(0);

        // 表头多余信息放置cell
        if (headerCellList != null) {
            titleRowStartIndex += headerCellList.size();

            for (int i = 0; i < headerCellList.size(); i++) {
                // 可以是0～65535之间的任何一个
                row = sheet.createRow(headerInfoStartIndex + i);

                // 设置所有样式!
                for (int j = 0; j < headers.length; j++) {
                    HSSFCell cellTemp = row.createCell(j);
                    cellTemp.setCellStyle(styleForContent);
                }

                // 键key [ 固定键值对 ]
                HSSFCell cell1 = row.createCell(0);
                cell1.setCellStyle(styleForContent);
                HSSFRichTextString text1 = new HSSFRichTextString(headerCellList.get(i).get("key"));
                cell1.setCellValue(text1);
                // 值value [ 固定键值对 ]
                HSSFCell cell2 = row.createCell(1);
                cell2.setCellStyle(styleForContent);
                HSSFRichTextString text2 = new HSSFRichTextString(headerCellList.get(i).get("value"));
                cell2.setCellValue(text2);

                //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
                sheet.addMergedRegion(new CellRangeAddress(headerInfoStartIndex + i, headerInfoStartIndex + i, 1, headers.length - 1));
            }
        }

        // 表头放置cell
        row = sheet.createRow(headerInfoStartIndex + titleRowStartIndex);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(styleForTitle);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 数据放置cell
        if (dataList != null && dataList.size() > 0) {
            for (int i = 0; i < dataList.size(); i++) {
                String[] strArray = dataList.get(i);
                row = sheet.createRow(i + 1 + titleRowStartIndex + headerInfoStartIndex);
                for (int j = 0; j < strArray.length; j++) {
                    HSSFCell cell = row.createCell(j);
                    cell.setCellStyle(styleForContent);
                    HSSFRichTextString text = new HSSFRichTextString(strArray[j]);
                    cell.setCellValue(text);
                }
            }
        }

        return workbook;

    }

    /**
     * 设置样式(标题)
     *
     * @param workbook
     * @return
     */
    public static HSSFCellStyle setCellStyleForTitle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();

        // 相关设置
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        // style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        // style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        return style;
    }

    /**
     * 设置样式(内容)
     *
     * @param workbook
     * @return
     */
    public static HSSFCellStyle setCellStyleForContent(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();

        // 相关设置
        style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        // style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        // style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;
    }

    /**
     * 设置字体(标题)
     *
     * @param workbook
     * @return
     */
    public static HSSFFont setFontForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();

        // 相关设置
        font.setColor(HSSFColor.RED.index);
        // font.setFontHeightInPoints((short) 12);
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        return font;
    }

    /**
     * 设置字体(内容)
     *
     * @param workbook
     * @return
     */
    public static HSSFFont setFontForContent(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();

        // 相关设置
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

        return font;
    }

    /**
     * 输出文件
     *
     * @param response
     * @param fileName
     * @param workbook
     */
    public static void responseExcel(HttpServletResponse response, String fileName, HSSFWorkbook workbook) {
        try {
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes("gb2312"), "iso-8859-1"));
            response.setContentType("application/msexcel;charset=utf-8");
            response.flushBuffer();
            OutputStream ostream = null;
            ostream = response.getOutputStream();
            workbook.write(ostream);
            ostream.flush();
            ostream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取get返回值(反射)
     *
     * @param pojoList
     * @param memberVariable
     * @return
     */
    public static List<String[]> getMethodReflect(List<?> pojoList, String[] memberVariable) {

        List<String[]> dataList = null;
        if (pojoList != null && pojoList.size() > 0) {
            dataList = new ArrayList<>();
            for (int i = 0; i < pojoList.size(); i++) {
                Object pojo = pojoList.get(i);
                String[] strArray = new String[memberVariable.length];
                Class<?> c = pojo.getClass();
                for (int j = 0; j < memberVariable.length; j++) {
                    try {
                        if (memberVariable[j].contains("@")) {
                            String[] strArr = memberVariable[j].split("@");
                            Method m = c.getDeclaredMethod("get" + strArr[0].substring(0, 1).toUpperCase() + strArr[0].substring(1));
                            Object obj = m.invoke(pojo);
                            Class klass = obj.getClass();

                            Method m2 = klass.getDeclaredMethod("get" + strArr[1].substring(0, 1).toUpperCase() + strArr[1].substring(1));
                            Object invokeValue2 = m2.invoke(pojo);
                            convertInvokeValue(invokeValue2);
                            strArray[j] = String.valueOf(invokeValue2);
                        } else {
                            Method m = c.getDeclaredMethod("get" + memberVariable[j].substring(0, 1).toUpperCase() + memberVariable[j].substring(1));
                            Object invokeValue = m.invoke(pojo);
                            convertInvokeValue(invokeValue);
                            strArray[j] = String.valueOf(invokeValue);
                        }
                    } catch (Exception e) {
                        strArray[j] = "";
                    }
                }
                dataList.add(strArray);
            }
        }

        return dataList;

    }

    /**
     * 反射pojo中, 对特殊格式的处理
     *
     * @param invokeValue
     */
    public static void convertInvokeValue(Object invokeValue) {
        if (invokeValue instanceof java.util.Date) {
            invokeValue = new SimpleDateFormat("yyyy-MM-dd").format(invokeValue);
        }
        if (invokeValue == null) {
            invokeValue = "";
        }
    }

    /**
     * 通过Map键值获取值
     *
     * @param pojoList
     * @param memberVariable
     * @return
     */
    public static List<String[]> getMethodReflectForMap(List<Map<String, Object>> pojoList, String[] memberVariable) {

        List<String[]> dataList = null;
        if (pojoList != null && pojoList.size() > 0) {
            dataList = new ArrayList<String[]>();
            for (int i = 0; i < pojoList.size(); i++) {
                Map<String, Object> pojoMap = pojoList.get(i);
                String[] strArray = new String[memberVariable.length];
                for (int j = 0; j < memberVariable.length; j++) {
                    try {
                        strArray[j] = pojoMap.get(memberVariable[j]) == null ? "" : pojoMap.get(memberVariable[j]).toString();
                    } catch (Exception e) {
                        strArray[j] = "";
                    }
                }
                dataList.add(strArray);
            }
        }
        return dataList;
    }
}
