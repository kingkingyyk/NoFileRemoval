package NoFileRemoval;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class NoFileRemoval {

	public static UI ui;
	
	public static void main (String [] args) throws Exception {
    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	JOptionPane.showMessageDialog(null, "Get started by plugging your pendrive.", "NoFileRemoval", JOptionPane.INFORMATION_MESSAGE);
    	
		ui=new UI();
		ui.setLocationRelativeTo(null);
		Thread t=new Thread() {
			public void run() {
				for (int i='A';i<='Z';i++) {
					File drive=new File((char)i+":\\");
					ui.lblTitle.setText("Scanning "+drive.getPath());
					ui.lblDescription.setText("");
					if (drive.exists() && drive.canRead()) {
						File [] files=drive.listFiles();
						File blankFolder=null;
						for (int i2=0;i2<files.length;i2++) {
							if (files[i2].isDirectory() && files[i2].getPath().equals((char)i+":\\ ")){
								blankFolder=files[i2];
							}
						}
						if (blankFolder!=null) {
							files=blankFolder.listFiles();
							for (int i2=0;i2<files.length;i2++) {
								ui.lblDescription.setText("Restoring file : "+files[i2].getPath());
								files[i2].renameTo(new File(drive.getPath()+files[i2].getName()));
								String name=files[i2].getName();
								if (!name.equals("System Volume Information")) {
									try {
										Files.setAttribute(Paths.get(files[i2].getPath()), "dos:hidden", false);
									} catch (IOException e) {}
								}
							}
							blankFolder.delete();
						}
					}
				}
				JOptionPane.showMessageDialog(null, "Cleaning done!", "NoFileRemoval", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		};
		t.start();
		ui.setVisible(true);
	}
	
	
	
	
}
