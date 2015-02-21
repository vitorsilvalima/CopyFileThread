package copyFileThread;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JProgressBar;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class CopyThreadPool 
{
	public static long recursiveCount(File srcFile)
	{
		if(srcFile.isDirectory())
		{
			long count=1;
			if(srcFile.listFiles()!=null)
			{
			   	for(File file: srcFile.listFiles())
			   	{
			   		if(file!=null)
			   		{
				   		count+=recursiveCount(file);
			    	}
			   	}
			}
		    return count;
		}
		else
		{
			return 1;
		}
	}
	public static void main(String[] args)
	{
    	File srcFolder = new File("D://");
    	File destFolder = new File("c:\\vitor-new");
    	long countFile=recursiveCount(srcFolder);
    	System.out.println("There are "+countFile +" including folders!");
    	
	}
}
