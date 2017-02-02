package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
/**
*文本输入输出流的基本操作
*
**/
public class dfhb {
	
	public static void CopyFile(String fromfile,String tofile){
		FileInputStream fi = null;
		FileOutputStream fo = null;
		BufferedInputStream bi = null;
		BufferedOutputStream bo = null;
		try{
			fi = new FileInputStream(fromfile);
			fo = new FileOutputStream(tofile);
			bi = new BufferedInputStream(fi,200000000);
			bo = new BufferedOutputStream(fo, 200000000);
			byte []temp = new byte[100000000];
			System.out.println("拷贝开始,请耐心等待...");
			long before = System.currentTimeMillis();
			while(bi.read(temp)!=-1){
				bo.write(temp);
			}
			bo.flush();
			long time = System.currentTimeMillis() - before;
			System.out.println("拷贝已完成!耗时:"+time/1000+"s");
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				bo.close();
				bi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static String readFIle(String from){
		FileInputStream fi = null;
		StringBuffer sb = new StringBuffer();
		try{
			File file = new File(from);
			fi = new FileInputStream(file);
			byte []s = new byte[(int) file.length()];
			while(fi.read(s)!=-1)
				sb.append(new String(s,"utf-8"));
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				fi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public static void writeToFile(String filepath,String content){
		FileOutputStream fo = null;
		try{
			fo = new FileOutputStream(filepath);
			byte []con = content.getBytes("UTF-8");
			fo.write(con);
			System.out.println("写入文本到文件完成");
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				fo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String textIIO(String filepath){
		FileReader fr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try{
			fr = new FileReader(filepath);
			br = new BufferedReader(fr);
			String temp;
			while((temp=br.readLine())!=null){
				sb.append(temp).append("\n");
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public static String textIO2(String filepath){
		FileReader fr = null;
		File file = new File(filepath);
		String result="";
		try{
			fr = new FileReader(file);
			char s[] = new char[(int) file.length()];
			int len = fr.read(s);
			result = new String(s, 0, len);
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
    public static void main(String[] args) {
    System.out.println(textIO2("src/test.txt"));
	}

}
