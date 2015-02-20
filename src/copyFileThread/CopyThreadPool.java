package copyFileThread;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;


public class CopyThreadPool {

	public static void main(String[] args)
	{
    	File srcFolder = new File("c:\\vitor");
    	File destFolder = new File("c:\\vitor-new");
 
    	//make sure source exists
    	if(!srcFolder.exists()){
 
           System.out.println("Directory does not exist.");
           //just exit
           System.exit(0);
 
        }else{
 
           try{
           	System.out.println("Done");		
    		ExecutorService executor = Executors.newFixedThreadPool(4);
    		Runnable task =  CopyThread(srcFolder,destFolder);
    				
    		
    		
    		
    		
    		Runnable task = new CopyThread(src, dest)
    	            executor.execute(task);

            executor.shutdown();
            while (!executor.isTerminated()) 
            {
            }
    		JOptionPane.showMessageDialog(null, matrix.formatOutPut(), "RESULT!!!", 1);
        	   
      
          
           
           
           
           
           
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
	}

}
