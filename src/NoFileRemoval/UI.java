package NoFileRemoval;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UI extends JDialog {
	private static final long serialVersionUID = 461027228703577621L;
	private final JPanel contentPanel = new JPanel();
	public JLabel lblTitle;
	public JLabel lblDescription;

	public UI() {
		setModal(true);
		setBounds(100, 100, 450, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 37, 414, 14);
		contentPanel.add(lblTitle);
		
		lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(10, 63, 414, 14);
		contentPanel.add(lblDescription);
	}
}
