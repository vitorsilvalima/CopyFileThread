package copyFileThread;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;
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
    	File srcFolder = new File("C://vitor");
    	File destFolder = new File("c://vitor-new");
    	CopyData cD = new CopyData();
    	long countFile=recursiveCount(srcFolder);
    	System.out.println("There are "+countFile +" including folders!");
    	ExecutorService executor = Executors.newFixedThreadPool(2);
	    executor.execute(new CopyThread(cD,srcFolder,destFolder));
	    executor.execute(new CheckProgressThread(cD,countFile));
        executor.shutdown();
        while (!executor.isTerminated()) 
        {
        }
    	System.out.println("There are "+countFile +" including folders!");
    	
	}
}
