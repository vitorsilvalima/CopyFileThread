package copyFileThread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyData 
{
	
	private long progressCounter;
	public CopyData()
	{
		progressCounter=0;
	}
	public long getProgressCounter()
	{
		return progressCounter;
	}
	 public void copyFolder(File src, File dest)throws IOException
	 {
		 	try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
	    	if(src!=null)
	    	{
		    	if(src.isDirectory()){
		    		progressCounter++;
		    		//if directory not exists, create it
		    		if(!dest.exists()){
		    		   dest.mkdir();
		    		   System.out.println("Directory copied from " 
		                              + src + "  to " + dest);
		    		}
		 
		    		//list all the directory contents
		    		String files[] = src.list();
		    		for (String file : files) 
		    		{
		    		   //construct the src and dest file structure
		    		if(file!=null && !file.equals(""))
		    			{
				    		   File srcFile = new File(src, file);
				    		   File destFile = new File(dest, file);
				    		   //recursive copy
				    		   copyFolder(srcFile,destFile);
		    			}
		    		}
		 
		    	}	    	
		    	else if(src.isFile())
		    	{
		    		OutputStream out =null;
		    		InputStream in=null;
		    		try
		    		{
		    		//if file, then copy it
		    		//Use bytes stream to support all file types
		    		in = new FileInputStream(src);
		    	        out= new FileOutputStream(dest); 
		 
		    	        byte[] buffer = new byte[1024];
		 
		    	        int length;
		    	        //copy the file content in bytes 
		    	        while ((length = in.read(buffer)) > 0){
		    	    	   out.write(buffer, 0, length);
		    	        }
		    	        progressCounter++;
		    	        in.close();
		    	        out.close();
		    	        System.out.println("File copied from " + src + " to " + dest);
		    		}
		    		finally
		    		{
		    			if(in!=null)
		    			{
		    				in.close();
		    			}
		    			if(out!=null)
		    			{
		    				out.close();
		    			}
		    		}
		    	}
	    	}
	 }
}
