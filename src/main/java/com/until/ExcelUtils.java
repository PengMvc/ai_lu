package com.until;

import com.alibaba.excel.EasyExcel;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: PengMvc
 * @Date: 2022/6/18
 */
public class ExcelUtils {

  public static void writeExcel(HttpServletResponse response, List<?> list, Class clz, String fileName, String sheetName)   {
    EasyExcel.write(getOutputStream(fileName, response), clz).sheet(sheetName).doWrite(list);
  }

  /**
   * 导出文件时为Writer生成OutputStream
   *
   * @param fileName
   * @param response
   * @return
   */
  private static OutputStream getOutputStream(String fileName, HttpServletResponse response) {
    try {
      fileName = URLEncoder.encode(fileName, "UTF-8");
      response.setContentType("application/vnd.ms-excel");
      response.setCharacterEncoding("utf8");
      response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
      response.setHeader("Pragma", "public");
      response.setHeader("Cache-Control", "no-store");
      response.addHeader("Cache-Control", "max-age=0");
      return response.getOutputStream();
    } catch (IOException e) {
      throw new RuntimeException("导出excel表格失败!", e);
    }
  }

}
