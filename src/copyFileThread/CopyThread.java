package copyFileThread;
import java.io.File;
import java.io.IOException;
public class CopyThread implements Runnable
{
	private CopyData cp;
	private File src;
	private File dest;
	public CopyThread(CopyData cp, File src, File dest)
	{
		this.cp=cp;
		this.src=src;
		this.dest=dest;
	}
	@Override
	public void run() 
	{
		try {
			cp.copyFolder(src, dest);
			Thread.sleep(300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
