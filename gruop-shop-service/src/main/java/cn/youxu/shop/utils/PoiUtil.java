package cn.youxu.shop.utils;

import cn.youxu.shop.annotation.Excel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PoiUtil<T> {
    public void checkFile(MultipartFile file) throws Exception {
        // 判断文件是否存在
        if (null == file) {
            throw new FileNotFoundException("文件不存在！");
        }
        // 获得文件名
        String fileName = file.getOriginalFilename();
        // 判断文件是否是excel文件
        if (!fileName.endsWith("xls") && !fileName.endsWith("xlsx")) {
            throw new IOException(fileName + "不是excel文件");
        }
    }

    public Workbook getWorkBook(MultipartFile file) {
        // 获得文件名
        String fileName = file.getOriginalFilename();
        // 创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            // 获取excel文件的io流
            InputStream is = file.getInputStream();
            // 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith("xls")) {
                // 2003
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith("xlsx")) {
                // 2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {

        }
        return workbook;
    }

    public List<T> uploadExcel(Workbook workBook, Class<T> cls) throws Exception {
        List<T> list = new ArrayList<>();
        try {
            int sheetSize = workBook.getNumberOfSheets();
            for (int i = 0; i < sheetSize; i++) {
                Sheet sheet = workBook.getSheetAt(0);
                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    } else {
                        T o = (T) cls.newInstance();
                        Field[] declaredFields = o.getClass().getDeclaredFields();
                        for (Field f : declaredFields) {
                            //获取字段上加的@Excel注解
                            Excel annotation = f.getAnnotation(Excel.class);
                            if (annotation != null) {
                                f.setAccessible(true);
                                Cell cell = row.getCell(annotation.value());
                                cell.setCellType(getCellType(annotation.cls()));
                                f.set(o, cell.getStringCellValue());
                            } else {
                                continue;
                            }
                        }
                        list.add(o);
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("Excel导入失败！");
        }
        return list;
    }

    public int getCellType(Class cls) {
        if (cls == String.class) {
            return Cell.CELL_TYPE_STRING;
        } else if (cls == Integer.class) {
            return Cell.CELL_TYPE_NUMERIC;
        } else {
            return Cell.CELL_TYPE_STRING;
        }
    }
}
