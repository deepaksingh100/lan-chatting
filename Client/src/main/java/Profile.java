import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.rmi.Naming;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Profile extends javax.swing.JFrame {
	String name, dname, id, did, bd, str, ip, tym;
	static ChatWindow cw;
	String[] s;
	ImageIcon ic;
	boolean b;
	ClientInterface ci;

	public Profile(String name, String tym, String id, String ip, ChatWindow cw, boolean b, ClientInterface ci) {
		super();
		initComponents();
		Profile.cw = cw;
		this.ci = ci;
		// System.out.println(ci);
		this.b = b;
		this.name = name;
		this.tym = tym;
		this.id = id;
		this.ip = ip;
		setSize(800, 700);
		setLocationRelativeTo(null);
		jLabel1.setSize(800, 700);
		jLabel1.setLocation(0, 0);
		jLabel3.setText(name);
		int len = name.length();
		jLabel3.setBounds(260, 70, 20 * len, 30);
		jLabel6.setBounds(265 + len * 20, 75, 20, 20);
		setTitle("Profile:: " + name);
		try {
			BufferedImage img = ImageIO.read(getClass().getResourceAsStream("logo.jpg"));
			setIconImage(img);
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			String img1 = ser.getImg(id);
			String s1 = ser.profile(id);
			ImageIcon img2;
			if (img1.equals("male.jpg") || img1.equals("female.jpg")) {
				img2 = new ImageIcon(getClass().getResource(img1));
			} else {
				img2 = ser.img(id);
			}
			Rectangle rect = jLabel2.getBounds();
			Image scaledImage = img2.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
			img2 = new ImageIcon(scaledImage);
			jLabel2.setIcon(img2);

			s = s1.split(":");
			jLabel4.setText("Born On : " + s[9] + "  " + s[10] + "   " + s[11]);
			bd = s[9] + "  " + s[10] + "   " + s[11];
			jLabel30.setText(s[9] + "  " + s[10] + "  " + s[11]);

			if (!s[0].equals("blank"))
				jLabel24.setText(s[0]);
			jLabel25.setText(id);
			if (!s[5].equals("blank"))
				jLabel28.setText(s[5]);
			if (!s[4].equals("blank"))
				jLabel31.setText(s[4]);
			if (!s[3].equals("blank"))
				jLabel32.setText(s[3]);
			if (!s[2].equals("blank"))
				jLabel33.setText(s[2]);
			if (!s[1].equals("blank"))
				jLabel34.setText(s[1]);
			jLabel26.setText(s[6]);
			jLabel27.setText(s[7]);
			if (s[8].equals("true"))
				jLabel29.setText("Male");
			else
				jLabel29.setText("Female");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		// setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
	}

	public Profile(String name, String dname, String tym, String id, String did, String ip, ChatWindow cw,
			ClientInterface ci) {
		super();
		initComponents();
		Profile.cw = cw;
		this.ci = ci;
		this.name = name;
		this.dname = dname;
		this.tym = tym;
		this.id = id;
		this.did = did;
		this.ip = ip;
		setSize(800, 700);
		setLocationRelativeTo(null);
		jLabel1.setSize(800, 700);
		jLabel1.setLocation(0, 0);
		jLabel3.setText(dname);
		int len = name.length();
		jLabel3.setBounds(260, 70, 20 * len + 10, 30);
		jLabel6.setBounds(300 + len * 20, 75, 20, 20);
		setTitle("Profile:: " + dname);
		try {
			BufferedImage img = ImageIO.read(getClass().getResourceAsStream("logo.jpg"));
			setIconImage(img);
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			String img1 = ser.getImg(did);
			String s1 = ser.profile(did);
			String s2 = ser.profile(id);
			ImageIcon img2;
			if (img1.equals("male.jpg") || img1.equals("female.jpg")) {
				img2 = new ImageIcon(getClass().getResource(img1));
			} else {
				img2 = ser.img(did);
			}
			Rectangle rect = jLabel2.getBounds();
			Image scaledImage = img2.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
			img2 = new ImageIcon(scaledImage);
			jLabel2.setIcon(img2);
			String s3[] = s2.split(":");
			bd = s3[9] + "  " + s3[10] + "  " + s3[11];
			s = s1.split(":");
			jLabel4.setText("Born On : " + s[9] + "  " + s[10] + "   " + s[11]);
			jLabel30.setText(s[9] + "  " + s[10] + "  " + s[11]);

			if (!s[0].equals("blank"))
				jLabel24.setText(s[0]);
			jLabel25.setText(did);
			if (!s[5].equals("blank"))
				jLabel28.setText(s[5]);
			if (!s[4].equals("blank"))
				jLabel31.setText(s[4]);
			if (!s[3].equals("blank"))
				jLabel32.setText(s[3]);
			if (!s[2].equals("blank"))
				jLabel33.setText(s[2]);
			if (!s[1].equals("blank"))
				jLabel34.setText(s[1]);
			jLabel26.setText(s[6]);
			jLabel27.setText(s[7]);
			if (s[8].equals("true"))
				jLabel29.setText("Male");
			else
				jLabel29.setText("Female");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel6 = new javax.swing.JLabel();
		jLabel34 = new javax.swing.JLabel();
		jLabel33 = new javax.swing.JLabel();
		jLabel32 = new javax.swing.JLabel();
		jLabel31 = new javax.swing.JLabel();
		jLabel30 = new javax.swing.JLabel();
		jLabel29 = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel28 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});
		getContentPane().setLayout(null);

		jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green.gif"))); // NOI18N
		getContentPane().add(jLabel6);
		jLabel6.setBounds(570, 80, 20, 20);

		jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel34);
		jLabel34.setBounds(310, 290, 390, 30);

		jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel33);
		jLabel33.setBounds(310, 320, 390, 30);

		jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel32);
		jLabel32.setBounds(310, 380, 390, 30);

		jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel31);
		jLabel31.setBounds(310, 410, 390, 30);

		jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel30);
		jLabel30.setBounds(310, 470, 390, 30);

		jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel29);
		jLabel29.setBounds(310, 500, 390, 30);

		jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel23.setText("<html><a href='' style=\"color:black;\">Logout</a></html>");
		jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel23MouseClicked(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel23MouseExited(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel23MouseEntered(evt);
			}
		});
		getContentPane().add(jLabel23);
		jLabel23.setBounds(670, 20, 80, 30);

		jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel28);
		jLabel28.setBounds(310, 530, 390, 30);

		jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel27);
		jLabel27.setBounds(310, 600, 390, 30);

		jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel26);
		jLabel26.setBounds(310, 630, 390, 30);

		jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel25);
		jLabel25.setBounds(310, 200, 390, 30);

		jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(jLabel24);
		jLabel24.setBounds(310, 260, 390, 30);

		jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel22.setText("<html><a href='' style=\"color:black;\">Messages</a></html>");
		jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel22MouseClicked(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel22MouseExited(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel22MouseEntered(evt);
			}
		});
		getContentPane().add(jLabel22);
		jLabel22.setBounds(550, 20, 90, 30);

		jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel21.setText("User Id:");
		getContentPane().add(jLabel21);
		jLabel21.setBounds(170, 200, 80, 30);

		jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel20.setText("Email:");
		getContentPane().add(jLabel20);
		jLabel20.setBounds(170, 630, 110, 30);

		jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel19.setText("Mobile:");
		getContentPane().add(jLabel19);
		jLabel19.setBounds(170, 600, 110, 30);

		jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel18.setText("Contact Information:");
		getContentPane().add(jLabel18);
		jLabel18.setBounds(20, 560, 200, 30);

		jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel17.setText("Languages:");
		getContentPane().add(jLabel17);
		jLabel17.setBounds(170, 530, 110, 30);

		jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel16.setText("Gender:");
		getContentPane().add(jLabel16);
		jLabel16.setBounds(170, 500, 110, 30);

		jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel15.setText("Birthday:");
		getContentPane().add(jLabel15);
		jLabel15.setBounds(170, 470, 110, 30);

		jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel14.setText("Basic Information:");
		getContentPane().add(jLabel14);
		jLabel14.setBounds(20, 440, 180, 30);

		jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel13.setText("Current City:");
		getContentPane().add(jLabel13);
		jLabel13.setBounds(170, 410, 110, 30);

		jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel12.setText("Hometown:");
		getContentPane().add(jLabel12);
		jLabel12.setBounds(170, 380, 110, 30);

		jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel11.setText("Places:");
		getContentPane().add(jLabel11);
		jLabel11.setBounds(20, 350, 80, 30);

		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel10.setText("Graduation:  ");
		getContentPane().add(jLabel10);
		jLabel10.setBounds(170, 320, 110, 30);

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel9.setText("Intermediate: ");
		getContentPane().add(jLabel9);
		jLabel9.setBounds(170, 290, 110, 30);

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel8.setText("High School:  ");
		getContentPane().add(jLabel8);
		jLabel8.setBounds(170, 260, 110, 30);

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel7.setText("Education:  ");
		getContentPane().add(jLabel7);
		jLabel7.setBounds(20, 230, 120, 30);

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel5.setText("<html><a href='' style=\"color:black;\">Edit Profile</a></html>");
		jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel5MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel5MouseExited(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel5MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel5);
		jLabel5.setBounds(420, 20, 110, 30);

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		getContentPane().add(jLabel4);
		jLabel4.setBounds(260, 110, 490, 60);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel3.setToolTipText("hi");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(240, 70, 170, 30);

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setToolTipText("download this image");
		jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel2MouseExited(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel2MouseEntered(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel2);
		jLabel2.setBounds(20, 10, 200, 190);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/800_700.jpg"))); // NOI18N
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 800, 700);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseExited
		jLabel5.setText("<html><a href='' style='color:black;'>Edit Profile</a></html>");
	}// GEN-LAST:event_jLabel5MouseExited

	private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseEntered
		jLabel5.setText("<html><a href='' style='color:red;'>Edit Profile</a></html>");
	}// GEN-LAST:event_jLabel5MouseEntered

	private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel22MouseExited
		jLabel22.setText("<html><a href='' style='color:black;'>Messages</a></html>");
	}// GEN-LAST:event_jLabel22MouseExited

	private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel22MouseEntered
		jLabel22.setText("<html><a href='' style='color:red;'>Messages</a></html>");
	}// GEN-LAST:event_jLabel22MouseEntered

	private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel22MouseClicked
		if (b) {
			cw.changeimg();
			cw.setVisible(true);
			this.dispose();
		} else {
			cw.setVisible(true);
			this.dispose();
		}
	}// GEN-LAST:event_jLabel22MouseClicked

	private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseClicked
		new EditProfile(ic, name, tym, id, bd, ip, cw, ci).setVisible(true);
		this.dispose();
	}// GEN-LAST:event_jLabel5MouseClicked

	private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel23MouseEntered
		jLabel23.setText("<html><a href='' style='color:red;'>Logout</a></html>");
	}// GEN-LAST:event_jLabel23MouseEntered

	private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel23MouseExited
		jLabel23.setText("<html><a href='' style='color:black;'>Logout</a></html>");
	}// GEN-LAST:event_jLabel23MouseExited

	private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel23MouseClicked
		try {
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			ser.logout(ci);
			new Login().setVisible(true);
			this.dispose();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// GEN-LAST:event_jLabel23MouseClicked

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		Toolkit.getDefaultToolkit().beep();
		int opt = JOptionPane.showOptionDialog(this,
				"Closing this window will cause Logout..\n Are you sure to exit!!!", "Question",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (opt == 0) {
			try {
				ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
				ser.logout(ci);
				System.exit(0);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}// GEN-LAST:event_formWindowClosing

	private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel2MouseEntered
		jLabel2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
	}// GEN-LAST:event_jLabel2MouseEntered

	private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel2MouseExited
		jLabel2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	}// GEN-LAST:event_jLabel2MouseExited

	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel2MouseClicked
		JFileChooser chooser = new JFileChooser(
				new File(System.getProperty("user.home")) + File.separator + "downloads") {

			@Override
			public void approveSelection() {
				File f = getSelectedFile();

				if (f.exists()) {
					Toolkit.getDefaultToolkit().beep();
					int result = JOptionPane.showConfirmDialog(this, "Do you want to overwrite the existing file?",
							"File already exists", JOptionPane.YES_NO_CANCEL_OPTION);

					switch (result) {
					case JOptionPane.YES_OPTION:
						super.approveSelection();
						return;
					case JOptionPane.NO_OPTION:
						return;
					case JOptionPane.CLOSED_OPTION:
						cancelSelection();
						return;
					case JOptionPane.CANCEL_OPTION:
						cancelSelection();
						return;
					}
				}

				super.approveSelection();
			}
		};
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Only jpg File", "jpg");
		chooser.setFileFilter(filter);

		BufferedImage image = null;
		String img = "";
		try {
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			File f1 = new File("D:" + File.separator + "My Chat Application" + File.separator + id);
			img = ser.getImg(id);

			File f2 = new File(img);
			ImageIcon img1 = ser.img(id);
			File file = new File(f1 + File.separator + f2);

			// reading the image

			try {
				image = new BufferedImage(img1.getIconWidth(), img1.getIconWidth(), BufferedImage.TYPE_INT_ARGB);
				image = ImageIO.read(file);
			} catch (Exception e) {
				System.out.print(e);
			}
		} catch (Exception e) {
		}
		chooser.setSelectedFile(new File(img));

		int res = chooser.showSaveDialog(Profile.this);
		if (res == JFileChooser.APPROVE_OPTION) {

			// writing the image

			try {
				File file = chooser.getSelectedFile();
				ImageIO.write(image, "jpg", file);
				// System.out.println(image);
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(Profile.this, "The Image was Saved Successfully!", "Success!",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(Profile.this, "Oops! Something gone wrong while saving." + e.getMessage(),
						"Error!", JOptionPane.ERROR_MESSAGE);

			}
		} else {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Dialog cancelled by the user");
		}
	}// GEN-LAST:event_jLabel2MouseClicked

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
			java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				// new Profile().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel28;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JLabel jLabel34;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	// End of variables declaration//GEN-END:variables
}
