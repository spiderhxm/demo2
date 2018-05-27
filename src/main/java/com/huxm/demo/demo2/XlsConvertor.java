package com.huxm.demo.demo2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

public class XlsConvertor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ruleTableConvertDRL("c://development//test//drools//limit_basic2.xls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/** 
     * 将xls决策表解析为普通规则文件 
     * @throws IOException  
     */  
    public static void ruleTableConvertDRL(String ruleTablePath) throws IOException{  
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();  
        File inFile = new File(ruleTablePath);  
        File outFile = new File("c://development//test//drools//outFile.txt");  
        InputStream xlsStream = null;  
        OutputStream fos = null;  
        OutputStreamWriter osw = null;  
        BufferedWriter out = null;  
        try {  
            xlsStream = new FileInputStream(inFile);  
            String strRule = compiler.compile(xlsStream, InputType.XLS);  
            fos = new FileOutputStream(outFile);  
            osw = new OutputStreamWriter(fos);  
            out = new BufferedWriter(osw);  
            out.write(strRule);  
            out.flush();  
            System.out.println("\n" + strRule);  
        } catch (IOException e) {  
            throw new IOException("没找到文件或写入文件错误");  
        }finally{  
            xlsStream.close();  
            fos.close();  
            osw.close();  
            out.close();  
        }  
         
    }  

}
