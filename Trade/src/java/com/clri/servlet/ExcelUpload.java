/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.servlet;

import com.clri.dao.MajorCustomersDAO;
import com.clri.dao.MajorProductionsDAO;
import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.MajorCustomerilp;
import com.clri.dto.MajorCustomers;
import com.clri.dto.MajorProductions;
import com.clri.utils.CommonConstants;
import com.clri.utils.CustomUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Balamurugan
 */
public class ExcelUpload extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String TMP_DIR_PATH = "D:/MyTempFiles";
    private File tmpDir;
    private static final String DESTINATION_DIR_PATH = "D:/MySavedFiles";
    private File destinationDir;

    public ExcelUpload() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        tmpDir = new File(TMP_DIR_PATH);
        if (!tmpDir.isDirectory()) {
            throw new ServletException(TMP_DIR_PATH + " is not a directory");
        }

        destinationDir = new File(DESTINATION_DIR_PATH);
        if (!destinationDir.isDirectory()) {
            throw new ServletException(DESTINATION_DIR_PATH + " is not a directory");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //PrintWriter to send the JSON response back
        //set content type and header attributes
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

        //Set the size threshold, above which content will be stored on disk.
        fileItemFactory.setSizeThreshold(1 * 1024 * 1024); //1 MB

        //Set the temporary directory to store the uploaded files of size above threshold.
        fileItemFactory.setRepository(tmpDir);

        ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);

        String fileName = null;
        String fullName = null;
        File file = null;
        HttpSession session = request.getSession();
        String uploadType = request.getParameter("uploadType");

        try {

            //Parse the request
            List items = uploadHandler.parseRequest(request);
            Iterator iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = (FileItem) iterator.next();

                //Handle Form Fields
                if (item.isFormField()) {
                    if (item.getFieldName().trim().equalsIgnoreCase("filename")) {
                        fileName = item.getString().trim();
                    }
                } //Handle Uploaded files.
                else {

                    fullName = item.getName().trim();
                    String modifiedName = FilenameUtils.getBaseName(fullName);
                    modifiedName += new Date().getTime() + "." + FilenameUtils.getExtension(fullName);
                    //Write file to the ultimate location.
                    file = new File(destinationDir, modifiedName);
                    item.write(file);
                }

            }

            int count = 0;
            String extension = FilenameUtils.getExtension(fullName);
            if (extension.trim().equalsIgnoreCase("xlsx")) {
                count = processExcelFile(file, uploadType);
                session.setAttribute("uploadCount", count);

            } else if (extension.trim().equalsIgnoreCase("xls")) {
                //process your binary excel file
            }
            if (extension.trim().equalsIgnoreCase("csv")) {
                //process your CSV file
            }
            if (CommonConstants.CUSTOMER_UPLOAD.equalsIgnoreCase(uploadType)) {
                CustomUtils.redirect(CommonConstants.MAJOR_CUST_LIST, request, response);
            } else {
                CustomUtils.redirect(CommonConstants.MAJOR_PROD_LIST, request, response);
            }

        } catch (FileUploadException ex) {
            log("Error encountered while parsing the request", ex);
        } catch (Exception ex) {
            log("Error encountered while uploading file", ex);
        }
    }

    private int processExcelFile(File file, String uploadType) {

        int count = 0;
        Connection connection = null;
        MajorProductionsDAO majorProductionsDAO = new MajorProductionsDAO();
        MajorCustomersDAO majorCustomersDAO = new MajorCustomersDAO();
        DataBaseConnection dbcon = new DataBaseConnection();
        MajorProductions majorProductions = new MajorProductions();
        MajorCustomers majorCustomers = new MajorCustomers();
        MajorCustomerilp majorCustomerilp = new MajorCustomerilp();
        try {
            connection = dbcon.openConnection();
            // Creating Input Stream 
            FileInputStream myInput = new FileInputStream(file);

            // Create a workbook using the File System 
            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);

            // Get the first sheet from workbook 
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            /**
             * We now need something to iterate through the cells.*
             */
            Iterator<Row> rowIter = mySheet.rowIterator();
            int rowCount = 0;
            while (rowIter.hasNext()) {
                XSSFRow row = (XSSFRow) rowIter.next();
                if (rowCount != 0) {
                    if (CommonConstants.CUSTOMER_UPLOAD.equalsIgnoreCase(uploadType)) {
                        count += majorCustomersDAO.insertMajorCustomers(connection, getCustomers(row, majorCustomers));
                    } else {
                        count += majorProductionsDAO.insertMajorProductions(connection, getProductions(row, majorProductions));
                    }

                }
                rowCount++;
            }
        } catch (IOException e) {
        } finally {
            DBUtils.closeConnection(connection);
        }
        return count;

    }

    public MajorProductions getProductions(XSSFRow row, MajorProductions majorProductions) {
        String articleCode = row.getCell(0).getStringCellValue();
        String category = row.getCell(1).getStringCellValue();
        String subCategory = row.getCell(2).getStringCellValue();
        double quantity = row.getCell(3).getNumericCellValue();
        double value = row.getCell(4).getNumericCellValue();
        String year = row.getCell(5).getStringCellValue();
        majorProductions.setCategory(category);
        majorProductions.setQuantity(quantity);
        majorProductions.setValue(value);
        majorProductions.setYear(year);
        majorProductions.setSubCategory(subCategory);
        majorProductions.setArticleCode(articleCode);
        return majorProductions;
    }

    public MajorCustomers getCustomers(XSSFRow row, MajorCustomers majorCustomers) {
        String items = row.getCell(0).getStringCellValue();
        String articleCode = row.getCell(1).getRawValue();
        String country = row.getCell(2).getStringCellValue();
        double quantity = row.getCell(3).getNumericCellValue();
        double value = row.getCell(4).getNumericCellValue();
        String year = row.getCell(5).getStringCellValue();
        majorCustomers.setItems(items);
        majorCustomers.setQuantity(quantity);
        majorCustomers.setValue(value);
        majorCustomers.setYear(year);
        majorCustomers.setCountry(country);
        majorCustomers.setArticleCode(articleCode);
        return majorCustomers;
    }

}
