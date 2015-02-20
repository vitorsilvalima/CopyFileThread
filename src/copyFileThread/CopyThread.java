package copyFileThread;
import java.io.File;
import java.io.IOException;
public class CopyThread implements Runnable
{
	private File src;
	private File dest;
	public CopyThread(File src, File dest)
	{
		this.src=src;
		this.dest=dest;
	}
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		CopyData cp = new CopyData();
		try {
			cp.copyFolder(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
