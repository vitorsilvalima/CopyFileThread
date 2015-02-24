package copyFileThread;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;

import javax.swing.JProgressBar;
import javax.swing.JFrame;
public class CheckProgressThread implements Runnable
{
	private CopyData cD;
	private long countFile;
	public CheckProgressThread(CopyData cD, long countFile)
	{
		this.cD=cD;
		this.countFile=countFile;
	}
	public void run() 
	{
		JFrame frame1= new JFrame();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(new Rectangle(400,400));
		JProgressBar Jp = new JProgressBar(0, (int)countFile);
		Jp.setBounds(new Rectangle(100,60));
		
		Jp.setVisible(true);
		frame1.add(Jp, BorderLayout.NORTH);
		frame1.setVisible(true);
		while(cD.getProgressCounter()<countFile)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Jp.setValue((int)cD.getProgressCounter());
			System.out.println(cD.getProgressCounter());
		}
	}
}

