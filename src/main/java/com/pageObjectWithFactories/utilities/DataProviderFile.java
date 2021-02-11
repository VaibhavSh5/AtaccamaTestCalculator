package com.pageObjectWithFactories.utilities;

import com.pageObjectWithFactories.base.AtaccamaCalculatorBase;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class DataProviderFile extends AtaccamaCalculatorBase {


    @org.testng.annotations.DataProvider(name= "getData")
    public static Object[][] getData(Method m){

        String sheetName= m.getName();
        System.out.println(sheetName);

        int rowsCount= reader.getRowCount(sheetName);
        int colsCount= reader.getColumnCount(sheetName);

        Object[][] data= new Object[rowsCount-1][colsCount];

        for(int rows=2; rows<=rowsCount; rows++){

            for(int cols=0; cols<colsCount; cols++){


                data[rows-2][cols]=reader.getCellData(sheetName, cols, rows);

            }

        }

        return data;
    }



    //DATAPROVIDER FOR GETTING THE DATA USING THE HASHTABLE:


    @org.testng.annotations.DataProvider(name="getHashTableData")
    public static Object[][] getHashTableData(Method m){

        String sheetName= m.getName();

        int rowsCount= reader.getRowCount(sheetName);
        int colsCount= reader.getColumnCount(sheetName);

        Object[][] data= new Object[rowsCount-1][1];

        Hashtable<String, String> table= null;

        for(int rows=2; rows<=rowsCount; rows++){

            table= new Hashtable<String, String>();

            for(int cols=0; cols<colsCount;cols++){


                table.put(reader.getCellData(sheetName, cols ,1),reader.getCellData(sheetName,cols, rows));
                data[rows-2][0]= table;

            }

        }


        return data;
    }


}
