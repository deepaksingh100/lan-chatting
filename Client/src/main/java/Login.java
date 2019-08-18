
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.rmi.Naming;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
	String ip, sip;

	public static ChatWindow MainChat;

	public Login() {
		super("My Chat Application::Login Window");
		initComponents();
		jLabel11.setVisible(false);
		jLabel8.setVisible(false);
		try {
			ip = "127.0.0.1";// JOptionPane.showMessageDialog(null, "ip1="+ip);
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			// JOptionPane.showMessageDialog(null, "ip2="+ip);
			sip = ser.getIP();
			if (!sip.equals("-1")) {

				jLabel11.setVisible(true);
				jLabel8.setVisible(true);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		jTextField1.requestFocus();
		setSize(800, 700);
		setLocationRelativeTo(null);
		// JOptionPane.showMessageDialog(null, "sip="+sip);
		// JOptionPane.showMessageDialog(null, "ip="+ip);
		try {
			BufferedImage img = ImageIO.read(getClass().getResourceAsStream("logo.jpg"));
			setIconImage(img);
		} catch (Exception e) {
		}
		setResizable(false);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel9 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jPasswordField1 = new javax.swing.JPasswordField();
		jTextField1 = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel9.setForeground(new java.awt.Color(204, 0, 0));
		jLabel9.setText("<html>&copy; copyright DEEPAK 2015</html>");
		getContentPane().add(jLabel9);
		jLabel9.setBounds(40, 580, 210, 30);

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setText("SUBMIT");
		jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(360, 450, 100, 40);

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel8.setText("<html><a href='' style=\"color: white;\" >Signup Here</a></html>");
		jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel8MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel8MouseExited(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel8MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel8);
		jLabel8.setBounds(520, 450, 90, 40);

		jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel12.setText("<html><a href='' style=\"color: white;\" >Delete Account?</a></html>");
		jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel12MouseEntered(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel12MouseClicked(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel12MouseExited(evt);
			}
		});
		getContentPane().add(jLabel12);
		jLabel12.setBounds(530, 570, 120, 30);

		jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel7.setText("<html><a href  style=\"color: white;\">change  password?</a></html>");
		jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel7MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel7MouseExited(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel7MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel7);
		jLabel7.setBounds(350, 390, 120, 30);
		getContentPane().add(jPasswordField1);
		jPasswordField1.setBounds(350, 320, 280, 30);
		getContentPane().add(jTextField1);
		jTextField1.setBounds(350, 270, 280, 30);

		jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel11.setText("<html><a href  style=\"color: white;\">forgot  password?</a></html>");
		jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel11MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel11MouseExited(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel11MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel11);
		jLabel11.setBounds(490, 390, 130, 30);

		jLabel5.setFont(new java.awt.Font("Vani", 1, 20)); // NOI18N
		jLabel5.setText("Password");
		getContentPane().add(jLabel5);
		jLabel5.setBounds(150, 320, 120, 40);

		jLabel6.setFont(new java.awt.Font("Vani", 1, 20)); // NOI18N
		jLabel6.setText("User Id");
		getContentPane().add(jLabel6);
		jLabel6.setBounds(150, 270, 75, 40);

		jLabel4.setFont(new java.awt.Font("Vani", 1, 30)); // NOI18N
		jLabel4.setText("Login");
		getContentPane().add(jLabel4);
		jLabel4.setBounds(340, 170, 120, 50);

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/580_400.jpg"))); // NOI18N
		jLabel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
		getContentPane().add(jLabel2);
		jLabel2.setBounds(100, 150, 580, 400);

		jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
		jLabel3.setText("MY CHAT APPLICATION");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(170, 30, 460, 60);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/800_700.jpg"))); // NOI18N
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 800, 700);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel7MouseClicked
		String s1 = jTextField1.getText();
		String s2 = jPasswordField1.getText();
		String str = "";
		try {
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			String vs = ser.getVerifyStatus(s1);
			// System.out.println(vs);
			if (vs.equals("N")) {

				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Please Verify Your Emailid!!!");
			}

			else {
				str = ser.login(s1, s2);
				try {
					if (!(s1.trim().equals("") || s2.trim().equals(""))) {
						String s[] = str.split(":");

						if (s[0].equals("true")) {
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(this, "Hello...Mr. " + s[2] + "!!!");
						} else if (s[0].equals("false")) {
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(this, "Hello...Ms. " + s[2] + "!!!");
						} else {
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(this, "Login Failed!!!");
							jTextField1.requestFocus();
							jPasswordField1.setText("");
							jTextField1.setText("");
						}
						new ChangePassword(s[1], s2, ip).setVisible(true);
						this.dispose();
					} else {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(this, "Please Fill The Blank Field(s)!!!");
						jTextField1.requestFocus();
					}
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Wrong IP Address!!!" + e);
			System.out.println(e);
		}
	}// GEN-LAST:event_jLabel7MouseClicked

	private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel7MouseEntered
		jLabel7.setText("<html><a href=''style='color:red'>change password?</a></html>");
	}// GEN-LAST:event_jLabel7MouseEntered

	private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel7MouseExited
		jLabel7.setText("<html><a href=''style='color:white'>change password?</a></html>");
	}// GEN-LAST:event_jLabel7MouseExited

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		String s1 = jTextField1.getText();
		String s2 = jPasswordField1.getText();
		String str = "";
		try {
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			String vs = ser.getVerifyStatus(s1);
			// System.out.println(vs);
			if (vs.equals("N")) {

				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Please Verify Your Emailid!!!");
			}

			else {
				str = ser.login(s1, s2);

				try {
					if (!(s1.trim().equals("") || s2.trim().equals(""))) {
						String s[] = str.split(":");
						Calendar cal = Calendar.getInstance();
						int h = cal.get(Calendar.HOUR);
						int m = cal.get(Calendar.MINUTE);
						int ampmi = cal.get(Calendar.AM_PM);
						String ampms = ampmi == 0 ? "AM" : "PM";
						String hs = "" + h, ms = "" + m;
						if (h == 0) {
							h = 12;
							hs = 12 + "";
						}
						if (h < 10)
							hs = 0 + "" + h;
						if (m < 10)
							ms = 0 + "" + m;
						String tym = hs + ":" + ms + " " + ampms;
						if (s[0].equals("true")) {
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(this, "Hello...Mr. " + s[2] + "!!!");
						} else if (s[0].equals("false")) {
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(this, "Hello...Ms. " + s[2] + "!!!");
						} else {
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(this, "Login Failed!!!");
							jTextField1.requestFocus();
							jPasswordField1.setText("");
							jTextField1.setText("");
						}
						MainChat = new ChatWindow(s[2], s[1], tym, ip);
						MainChat.setVisible(true);
						this.dispose();

					} else {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(this, "Please Fill The Blank Field(s)!!!");
						jTextField1.requestFocus();
					}

				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Wrong IP Address!!!");
			// jTextField2.setText("");
			// jTextField2.requestFocus();
			// System.out.println(e);
		}
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel8MouseClicked
		new Signup(ip).setVisible(true);
		this.dispose();
	}// GEN-LAST:event_jLabel8MouseClicked

	private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel8MouseEntered
		jLabel8.setText("<html><a href=''style='color:red'>Signup Here</a></html>");
	}// GEN-LAST:event_jLabel8MouseEntered

	private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel8MouseExited
		jLabel8.setText("<html><a href=''style='color: white;'>Signup Here</a></html>");
	}// GEN-LAST:event_jLabel8MouseExited

	private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel11MouseClicked
		if (jTextField1.getText().trim().equals("")) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Please Enter your UserId!!!");
		} else {
			try {
				ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
				String email = ser.getEmail(jTextField1.getText());
				String userid = ser.getPassword(jTextField1.getText());
				String sendMail = ser.sendMail(email, userid);
				if (sendMail.split(":")[0].equals("email has sent")) {
					JOptionPane.showMessageDialog(this, "An email has sent to your emailid " + email + ","
							+ "\n which contains verification code !!!");

					new ForgotPassword(ip, jTextField1.getText(), sendMail.split(":")[1]).setVisible(true);
					this.dispose();
				} else if (sendMail.split(":")[0].equals("enter your userid")) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(this, "Please Enter Correct UserId!!!");
					jTextField1.setText("");
					jTextField1.requestFocus();
				} else if (sendMail.split(":")[0].equals("try again later")) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(this, "Please Try again later!!!");
				}
			} catch (Exception e) {
			}
		}
	}// GEN-LAST:event_jLabel11MouseClicked

	private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel11MouseExited
		jLabel11.setText("<html><a href=''style='color:white'>forgot password?</a></html>");
	}// GEN-LAST:event_jLabel11MouseExited

	private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel11MouseEntered
		jLabel11.setText("<html><a href=''style='color:red'>forgot password?</a></html>");
	}// GEN-LAST:event_jLabel11MouseEntered

	private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel12MouseEntered
		jLabel12.setText("<html><a href=''style='color:red'>Delete Account?</a></html>");
	}// GEN-LAST:event_jLabel12MouseEntered

	private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel12MouseExited
		jLabel12.setText("<html><a href=''style='color:white'>Delete Account?</a></html>");
	}// GEN-LAST:event_jLabel12MouseExited

	private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel12MouseClicked
		String s1 = jTextField1.getText();
		String s2 = jPasswordField1.getText();
		String str = "";
		try {
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			str = ser.login(s1, s2);
			// System.out.println(str);
			try {
				if (!(s1.trim().equals("") || s2.trim().equals(""))) {
					if (str.equals("login failed")) {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(this, "Either UserId OR Password OR both are incorrect!!!");
						jTextField1.requestFocus();
						jPasswordField1.setText("");
						jTextField1.setText("");
					} else {
						System.out.println(s2);
						int delete = ser.delete(s1, s2);

						if (delete == 1) {
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(this, s1 + ",Your account has been deleted!!!");
							jTextField1.setText("");
							jPasswordField1.setText("");
						} else {

							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(this, s1 + ",Please Try Again Later!!!");
							jTextField1.setText("");
							jPasswordField1.setText("");
						}
					}

				} else {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(this, "Please Fill The Blank Field(s)!!!");
					jTextField1.requestFocus();
				}

			} catch (Exception e) {
			}
		} catch (Exception e) {

		}

	}// GEN-LAST:event_jLabel12MouseClicked

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
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables
}
