import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

//"C:\Program Files\Java\jdk1.8.0_144\bin\javac.exe"  CloseSwingExample.java
//"C:\Program Files\Java\jdk1.8.0_144\bin\java.exe"   CloseSwingExample.java 1
//"C:\Program Files\Java\jdk1.8.0_144\bin\java.exe"   CloseSwingExample.java 0
 
/**
 * Java swing program which terminates itself by calling  EXIT_ON_CLOSE or DISPOSE_ON_CLOSE
 */
public class CloseSwingExample {
 
    public static void main(String args[]) throws InterruptedException {
		
		if (args.length < 1)
		{
			System.out.println("Usage: CloseSwingExample  1 == use DISPOSE_ON_CLOSE, will not terminate JVM if user thread running");
			System.out.println("Usage: CloseSwingExample  0 == use EXIT_ON_CLOSE, will terminate JVM even if user thread running");
			return;
		}
 
        JFrame frame = new JFrame("Sample");
		
		if (args[0].equals("1")) {
			System.out.println("Using DISPLOSE_ON_CLOSE -- will not terminate JVM if user thread running");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //won't terminate JVM if user thread running
		}
		else {
			System.out.println("Using EXIT_ON_CLOSE -- will terminate JVM even if user thread running");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
		
		frame.setSize(200, 200);
        frame.setVisible(true);
 
        Thread t = new Thread() {
 
            @Override
            public void run() {
                while (true) {
                    System.out.println("User thread is running");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CloseSwingExample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
 
        t.start();
 
    }
}