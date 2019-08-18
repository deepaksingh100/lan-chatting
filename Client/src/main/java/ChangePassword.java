import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.rmi.Naming;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ChangePassword extends javax.swing.JFrame {
	int n = 0, c = 0, sc = 0;
	String userid, password, ip;

	public ChangePassword(String userid, String password, String ip) {
		super("My Chat Application::Change Password Window");
		initComponents();
		setSize(800, 700);
		setLocationRelativeTo(null);
		try {
			BufferedImage img = ImageIO.read(getClass().getResourceAsStream("logo.jpg"));
			setIconImage(img);
		} catch (Exception e) {
		}
		this.ip = ip;
		this.userid = userid;
		this.password = password;
		setResizable(false);
	}

	boolean flag;

	public ChangePassword(String userid, String ip, boolean flag) {
		super("My Chat Application::Create Password Window");
		initComponents();
		setSize(800, 700);
		setLocationRelativeTo(null);
		try {
			BufferedImage img = ImageIO.read(getClass().getResourceAsStream("logo.jpg"));
			setIconImage(img);
		} catch (Exception e) {
		}
		this.ip = ip;
		this.userid = userid;
		this.flag = flag;
		setResizable(false);
		jLabel6.setText("Create Password");
		jLabel1.setVisible(false);
		jPasswordField1.setVisible(false);
		jButton2.setVisible(false);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPasswordField1 = new javax.swing.JPasswordField();
		jLabel1 = new javax.swing.JLabel();
		jPasswordField2 = new javax.swing.JPasswordField();
		jLabel2 = new javax.swing.JLabel();
		jPasswordField3 = new javax.swing.JPasswordField();
		jLabel3 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(jPasswordField1);
		jPasswordField1.setBounds(330, 260, 350, 30);

		jLabel1.setFont(new java.awt.Font("Vani", 1, 20)); // NOI18N
		jLabel1.setText("Old Password");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(120, 260, 160, 30);

		jPasswordField2.setToolTipText("");
		getContentPane().add(jPasswordField2);
		jPasswordField2.setBounds(330, 310, 350, 30);

		jLabel2.setFont(new java.awt.Font("Vani", 1, 20)); // NOI18N
		jLabel2.setText("New Password");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(120, 310, 160, 34);
		getContentPane().add(jPasswordField3);
		jPasswordField3.setBounds(330, 360, 350, 30);

		jLabel3.setFont(new java.awt.Font("Vani", 1, 20)); // NOI18N
		jLabel3.setText("Confirm Password");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(120, 360, 200, 34);

		jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton2.setText("BACK");
		jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);
		jButton2.setBounds(560, 460, 90, 40);

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setText("SUBMIT");
		jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(370, 460, 90, 40);

		jLabel7.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
		jLabel7.setText("MY CHAT APPLICATION");
		getContentPane().add(jLabel7);
		jLabel7.setBounds(200, 20, 477, 71);

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(204, 0, 0));
		jLabel5.setText("<html>&copy; copyright DEEPAK 2015</html>");
		jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		getContentPane().add(jLabel5);
		jLabel5.setBounds(40, 610, 229, 31);

		jLabel6.setFont(new java.awt.Font("Vani", 1, 30)); // NOI18N
		jLabel6.setText("Change Password");
		getContentPane().add(jLabel6);
		jLabel6.setBounds(260, 180, 272, 41);

		jLabel4.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/700_430.jpg"))); // NOI18N
		jLabel4.setBorder(javax.swing.BorderFactory.createCompoundBorder());
		getContentPane().add(jLabel4);
		jLabel4.setBounds(50, 140, 700, 430);

		jLabel8.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
		jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/800_700.jpg"))); // NOI18N
		getContentPane().add(jLabel8);
		jLabel8.setBounds(0, 0, 800, 700);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		new Login().setVisible(true);
		this.dispose();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		if (flag) {
			String newpass = jPasswordField3.getText();
			String s2 = jPasswordField2.getText();
			if ((s2.equals("")) || newpass.equals("")) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Please Fill the Blank Field(s)!!!");
			} else if (!(s2.equals(newpass))) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Please Confirm The New Password Correctly!!!");
				jPasswordField3.requestFocus();
				jPasswordField3.setText("");
			}

			else {
				try {
					ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
					ser.changePassword(userid, newpass);
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(this, "Password Changed!!!");
					new Login().setVisible(true);
					this.dispose();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} else {
			String newpass = jPasswordField3.getText();
			String s1 = jPasswordField1.getText();
			String s2 = jPasswordField2.getText();
			if ((s1.equals("")) || (s2.equals("")) || newpass.equals("")) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Please Fill the Blank Field(s)!!!");
			} else if (!(s1.equals(password))) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Please Fill The Correct Old Password!!!");
				jPasswordField1.requestFocus();
				jPasswordField1.setText("");
			} else if (!(s2.equals(newpass))) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Please Confirm The New Password Correctly!!!");
				jPasswordField3.requestFocus();
				jPasswordField3.setText("");
			}

			else {
				try {
					ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
					ser.changePassword(userid, newpass);
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(this, "Password Changed!!!");
					new Login().setVisible(true);
					this.dispose();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}// GEN-LAST:event_jButton1ActionPerformed

	boolean b = true;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the Nimbus look and feel
		 */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				// new ChangePassword().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JPasswordField jPasswordField2;
	private javax.swing.JPasswordField jPasswordField3;
	// End of variables declaration//GEN-END:variables
}
