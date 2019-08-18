import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.Naming;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class EditProfile extends javax.swing.JFrame {
	String name, id, bd, ip, tym;
	ClientInterface ci;
	Icon ic;
	JFileChooser jfc = new JFileChooser();
	JLabel l = new JLabel();
	static ChatWindow cw;
	boolean b = false;
	static {
		UIManager.put("FileChooser.readOnly", Boolean.TRUE);
	}

	public EditProfile(Icon ic, String name, String tym, String id, String bd, String ip, ChatWindow cw,
			ClientInterface ci) {
		initComponents();
		jfc.setEnabled(false);
		EditProfile.cw = cw;
		this.ci = ci;
		// System.out.println(ci);
		this.name = name;
		this.tym = tym;
		this.id = id;
		this.ic = ic;
		this.ip = ip;
		this.bd = bd;
		jLabel2.setIcon(ic);
		setSize(800, 700);
		setLocationRelativeTo(null);
		jLabel1.setSize(800, 700);
		jLabel1.setLocation(0, 0);
		jLabel3.setText(name);
		int len = name.length();
		jLabel3.setBounds(260, 70, 20 * len, 30);
		jLabel7.setBounds(265 + len * 20, 75, 20, 20);
		jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
		jLabel4.setText("Born On : " + bd);
		setTitle("Edit Profile:: " + name);
		// setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);

		try {
			BufferedImage img = ImageIO.read(getClass().getResourceAsStream("logo.jpg"));
			setIconImage(img);
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			String img1 = ser.getImg(id);
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
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel23 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jTextField9 = new javax.swing.JTextField();
		jTextField10 = new javax.swing.JTextField();
		jLabel35 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox();
		jComboBox3 = new javax.swing.JComboBox();
		jComboBox4 = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});
		getContentPane().setLayout(null);

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
		jLabel23.setBounds(680, 20, 80, 30);

		jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jButton2.setText("RESET");
		jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);
		jButton2.setBounds(560, 600, 90, 40);

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jButton1.setText("SUBMIT");
		jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(330, 600, 90, 40);

		jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jTextField3KeyPressed(evt);
			}

			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextField3KeyTyped(evt);
			}
		});
		getContentPane().add(jTextField3);
		jTextField3.setBounds(280, 520, 410, 30);

		jTextField4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextField4KeyTyped(evt);
			}
		});
		getContentPane().add(jTextField4);
		jTextField4.setBounds(280, 480, 410, 30);

		jTextField6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextField6KeyTyped(evt);
			}
		});
		getContentPane().add(jTextField6);
		jTextField6.setBounds(280, 380, 410, 30);

		jTextField7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextField7KeyTyped(evt);
			}
		});
		getContentPane().add(jTextField7);
		jTextField7.setBounds(280, 340, 410, 30);

		jTextField8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		getContentPane().add(jTextField8);
		jTextField8.setBounds(280, 300, 410, 30);

		jTextField9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		getContentPane().add(jTextField9);
		jTextField9.setBounds(280, 260, 410, 30);

		jTextField10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		getContentPane().add(jTextField10);
		jTextField10.setBounds(280, 220, 410, 30);

		jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel35.setText("<html><a href='' style=\"color:black;\">Profile</a></html>");
		jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel35MouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel35MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel35MouseExited(evt);
			}
		});
		getContentPane().add(jLabel35);
		jLabel35.setBounds(470, 20, 70, 30);

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
		jLabel2.setBounds(20, 20, 200, 190);

		jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel22.setText("<html><a href='' style=\"color:black;\">Messages</a></html>");
		jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel22MouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel22MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel22MouseExited(evt);
			}
		});
		getContentPane().add(jLabel22);
		jLabel22.setBounds(570, 20, 80, 30);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		getContentPane().add(jLabel3);
		jLabel3.setBounds(260, 60, 250, 40);

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		getContentPane().add(jLabel4);
		jLabel4.setBounds(260, 110, 490, 60);

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel5.setText("<html><a href='' style=\"color:black;\">Change Profile Picture?</a></html>");
		jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel5MouseExited(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel5MouseEntered(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel5MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel5);
		jLabel5.setBounds(530, 180, 160, 30);

		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel6.setText("<html><a href='' style=\"color:black;\">Upload Profile Picture?</a></html>");
		jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel6MouseExited(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel6MouseEntered(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel6MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel6);
		jLabel6.setBounds(290, 180, 160, 30);

		jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green.gif"))); // NOI18N
		getContentPane().add(jLabel7);
		jLabel7.setBounds(560, 70, 20, 20);

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel8.setText("High School:  ");
		getContentPane().add(jLabel8);
		jLabel8.setBounds(90, 220, 110, 30);

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel9.setText("Intermediate: ");
		getContentPane().add(jLabel9);
		jLabel9.setBounds(90, 260, 110, 30);

		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel10.setText("Graduation:  ");
		getContentPane().add(jLabel10);
		jLabel10.setBounds(90, 300, 110, 30);

		jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel12.setText("Hometown:");
		getContentPane().add(jLabel12);
		jLabel12.setBounds(90, 340, 110, 30);

		jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel13.setText("Current City:");
		getContentPane().add(jLabel13);
		jLabel13.setBounds(90, 380, 110, 30);

		jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel15.setText("Birthday:");
		getContentPane().add(jLabel15);
		jLabel15.setBounds(90, 430, 110, 30);

		jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel17.setText("Languages:");
		getContentPane().add(jLabel17);
		jLabel17.setBounds(90, 480, 110, 30);

		jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel19.setText("Mobile:");
		getContentPane().add(jLabel19);
		jLabel19.setBounds(90, 520, 110, 30);

		jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "01", "02", "03", "04", "05",
				"06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jComboBox2.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jComboBox2FocusGained(evt);
			}
		});
		getContentPane().add(jComboBox2);
		jComboBox2.setBounds(310, 430, 80, 30);

		jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "JAN", "FEB", "MAR", "APR",
				"MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" }));
		jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jComboBox3.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jComboBox3FocusGained(evt);
			}
		});
		getContentPane().add(jComboBox3);
		jComboBox3.setBounds(430, 430, 80, 30);

		jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year", "1999", "1998", "1997", "1996",
				"1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983",
				"1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970",
				"1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957",
				"1956", "1955", "1954", "1953", "1952", "1951" }));
		jComboBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jComboBox4.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jComboBox4FocusGained(evt);
			}
		});
		getContentPane().add(jComboBox4);
		jComboBox4.setBounds(560, 430, 80, 30);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/800_700.jpg"))); // NOI18N
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 4, 800, 700);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel22MouseClicked
		cw.changeimg();
		cw.setVisible(true);
		this.dispose();

	}// GEN-LAST:event_jLabel22MouseClicked

	private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel22MouseExited
		jLabel22.setText("<html><a href='' style='color:black;'>Messages</a></html>");
	}// GEN-LAST:event_jLabel22MouseExited

	private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel22MouseEntered
		jLabel22.setText("<html><a href='' style='color:red;'>Messages</a></html>");
	}// GEN-LAST:event_jLabel22MouseEntered

	public class SingleRootFileSystemView extends FileSystemView {
		File root;
		File[] roots = new File[1];

		public SingleRootFileSystemView(File root) {
			super();
			this.root = root;
			roots[0] = root;
		}

		@Override
		public File createNewFolder(File containingDir) {
			File folder = new File(containingDir, "New Folder");
			folder.mkdir();
			return folder;
		}

		@Override
		public File getDefaultDirectory() {
			return root;
		}

		@Override
		public File getHomeDirectory() {
			return root;
		}

		@Override
		public File[] getRoots() {
			return roots;
		}
	}

	JFileChooser jfc1 = null;

	private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseClicked
		File f = null;
		try {
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			f = ser.changeImg(id);
		} catch (Exception e) {
		}

		// code for preview
		FileSystemView fsv = new SingleRootFileSystemView(f);
		jfc1 = new JFileChooser(fsv);
		jfc1.setEnabled(false);
		jfc1.setCurrentDirectory(f);
		l.setPreferredSize(new Dimension(200, 190));
		jfc1.setAccessory(l);
		jfc1.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(final PropertyChangeEvent evt) {
				SwingWorker<Image, Void> worker = new SwingWorker<Image, Void>() {
					@Override
					protected Image doInBackground() {

						// If selected file changes..
						if (evt.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
							// Get selected file
							File f = jfc1.getSelectedFile();

							try {
								// Create FileInputStream for file
								FileInputStream fin = new FileInputStream(f);

								// Read image from fin
								BufferedImage bim = ImageIO.read(fin);

								// Return the scaled version of image
								return bim.getScaledInstance(200, 190, BufferedImage.SCALE_FAST);

							} catch (Exception e) {
								// If there is a problem reading image,
								// it might not be a valid image or unable
								// to read
								l.setText(" Not valid image/Unable to read");
							}
						}

						return null;
					}

					@Override
					protected void done() {
						try {
							// Get the image
							Image i = get(1L, TimeUnit.NANOSECONDS);

							// If i is null, go back!
							if (i == null)
								return;

							// Set icon otherwise
							l.setIcon(new ImageIcon(i));
						} catch (Exception e) {
							// Print error occured
							l.setText(" Error occured.");
						}
					}
				};
				worker.execute();

			}
		});

		// Ends code for preview

		File file;
		String s, s1 = "";
		ServerInterface ser = null;
		int res = jfc1.showOpenDialog(EditProfile.this);
		if (res == JFileChooser.APPROVE_OPTION) {
			b = true;
			file = jfc1.getSelectedFile();
			ImageIcon img = new ImageIcon(file.getAbsolutePath());
			Rectangle rect = jLabel2.getBounds();
			Image scaledImage = img.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
			img = new ImageIcon(scaledImage);
			jLabel2.setIcon(img);
			s = file.getName();
			try {
				ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
				s1 = ser.getImg(id);
				ser.setImg(id, s);
				ser.saveImg(id, img, file);
			} catch (Exception e) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Failed to load image contents!!!");
				try {
					ser.setImg(id, s1);
					ser.saveImg(id, img, file);
				} catch (Exception ex) {
				}
				new EditProfile(ic, name, tym, id, bd, ip, cw, ci).setVisible(true);
				this.dispose();
			}
		} else {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Dialog cancelled by the user");
		}
	}// GEN-LAST:event_jLabel5MouseClicked

	private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseExited
		jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel5.setText("<html><a href='' style='color:black;'>Change Profile Picture?</a></html>");
	}// GEN-LAST:event_jLabel5MouseExited

	private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseEntered
		jLabel5.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel5.setText("<html><a href='' style='color:red;'>Change Profile Picture?</a></html>");
	}// GEN-LAST:event_jLabel5MouseEntered

	private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel35MouseClicked
		new Profile(name, tym, id, ip, cw, b, ci).setVisible(true);
		this.dispose();
	}// GEN-LAST:event_jLabel35MouseClicked

	private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel35MouseExited
		jLabel35.setText("<html><a href='' style='color:black;'>Profile</a></html>");
	}// GEN-LAST:event_jLabel35MouseExited

	private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel35MouseEntered
		jLabel35.setText("<html><a href='' style='color:red;'>Profile</a></html>");
	}// GEN-LAST:event_jLabel35MouseEntered

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		String high = jTextField10.getText();
		String inter = jTextField9.getText();
		String grad = jTextField8.getText();
		String home = jTextField7.getText();
		String city = jTextField6.getText();
		String lang = jTextField4.getText();
		String mobile = jTextField3.getText();
		int len = mobile.length();
		Object day = jComboBox2.getSelectedItem();
		Object month = jComboBox3.getSelectedItem();
		Object year = jComboBox4.getSelectedItem();

		if (len < 10 && !mobile.equals("")) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Please Enter A Valid Mobile Number!!!");
			jTextField3.setText("");
		} else if (!((high.equals("")) && (inter.equals("")) && (grad.equals("")) && (home.equals(""))
				&& (city.equals("")) && (lang.equals("")) && (mobile.equals("")) && (day.equals(""))
				&& (month.equals("")) && (year.equals("")))) {
			try {
				ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
				ser.editProfile(high, inter, grad, home, city, lang, id, mobile, day, month, year);
			} catch (Exception e) {
				System.out.println(e);
			}
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Profile Updated!!!");
			new Profile(name, tym, id, ip, cw, b, ci).setVisible(true);
			this.dispose();
		}
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		jTextField3.setText("");
		jTextField4.setText("");
		jComboBox2.setSelectedItem("Day");
		jComboBox3.setSelectedItem("Month");
		jComboBox4.setSelectedItem("Year");
		jTextField6.setText("");
		jTextField7.setText("");
		jTextField8.setText("");
		jTextField9.setText("");
		jTextField10.setText("");
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jComboBox2FocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jComboBox2FocusGained
		String s3 = jComboBox3.getSelectedItem().toString();
		String s4 = jComboBox4.getSelectedItem().toString();
		if (s3.equals("FEB")) {
			if (((s4.equals("Year")) || (s4.equals("1996")) || (s4.equals("1992")) || (s4.equals("1988"))
					|| (s4.equals("1984")) || (s4.equals("1980")) || (s4.equals("1976")) || (s4.equals("1972"))
					|| (s4.equals("1968")) || (s4.equals("1964")) || (s4.equals("1960")) || (s4.equals("1956"))
					|| (s4.equals("1952")))) {
				jComboBox2.removeAllItems();
				jComboBox2.addItem("Day");
				for (int z = 1; z <= 9; z++)
					jComboBox2.addItem("0" + z);
				for (int z = 0; z <= 9; z++)
					jComboBox2.addItem("1" + z);
				for (int z = 0; z <= 9; z++)
					jComboBox2.addItem("2" + z);
			} else if (!(s4.equals("1996") && (s4.equals("1992")) && (s4.equals("1988")) && (s4.equals("1984"))
					&& (s4.equals("1980")) && (s4.equals("1976")) && (s4.equals("1972")) && (s4.equals("1968"))
					&& (s4.equals("1964")) && (s4.equals("1960")) && (s4.equals("1956")) && (s4.equals("1952")))) {
				jComboBox2.removeAllItems();
				jComboBox2.addItem("Day");
				for (int z = 1; z <= 9; z++)
					jComboBox2.addItem("0" + z);
				for (int z = 0; z <= 9; z++)
					jComboBox2.addItem("1" + z);
				for (int z = 0; z <= 8; z++)
					jComboBox2.addItem("2" + z);
			}

		} else if ((s3.equals("APR") || s3.equals("JUN") || s3.equals("SEP") || s3.equals("NOV"))) {
			jComboBox2.removeAllItems();
			jComboBox2.addItem("Day");
			for (int z = 1; z <= 9; z++)
				jComboBox2.addItem("0" + z);
			for (int z = 0; z <= 9; z++)
				jComboBox2.addItem("1" + z);
			for (int z = 0; z <= 9; z++)
				jComboBox2.addItem("2" + z);
			jComboBox2.addItem("30");
		} else {
			jComboBox2.removeAllItems();
			jComboBox2.addItem("Day");
			for (int z = 1; z <= 9; z++)
				jComboBox2.addItem("0" + z);
			for (int z = 0; z <= 9; z++)
				jComboBox2.addItem("1" + z);
			for (int z = 0; z <= 9; z++)
				jComboBox2.addItem("2" + z);
			jComboBox2.addItem("30");
			jComboBox2.addItem("31");
		}

	}// GEN-LAST:event_jComboBox2FocusGained

	private void jComboBox3FocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jComboBox3FocusGained
		String s1 = jComboBox2.getSelectedItem().toString();
		String s4 = jComboBox4.getSelectedItem().toString();
		if (s1.equals("30")) {
			jComboBox3.removeAllItems();
			jComboBox3.addItem("Month");
			jComboBox3.addItem("JAN");
			jComboBox3.addItem("MAR");
			jComboBox3.addItem("APR");
			jComboBox3.addItem("MAY");
			jComboBox3.addItem("JUN");
			jComboBox3.addItem("JUL");
			jComboBox3.addItem("AUG");
			jComboBox3.addItem("SEP");
			jComboBox3.addItem("OCT");
			jComboBox3.addItem("NOV");
			jComboBox3.addItem("DEC");
		} else if (s1.equals("31")) {
			jComboBox3.removeAllItems();
			jComboBox3.addItem("Month");
			jComboBox3.addItem("JAN");
			jComboBox3.addItem("MAR");
			jComboBox3.addItem("MAY");
			jComboBox3.addItem("JUL");
			jComboBox3.addItem("AUG");
			jComboBox3.addItem("OCT");
			jComboBox3.addItem("DEC");
		}
		int t = 0;
		if (!s1.equals("Day"))
			t = Integer.parseInt(s1);
		if (t < 29 || s1.equals("Day")) {
			jComboBox3.removeAllItems();
			jComboBox3.addItem("Month");
			jComboBox3.addItem("JAN");
			jComboBox3.addItem("FEB");
			jComboBox3.addItem("MAR");
			jComboBox3.addItem("APR");
			jComboBox3.addItem("MAY");
			jComboBox3.addItem("JUN");
			jComboBox3.addItem("JUL");
			jComboBox3.addItem("AUG");
			jComboBox3.addItem("SEP");
			jComboBox3.addItem("OCT");
			jComboBox3.addItem("NOV");
			jComboBox3.addItem("DEC");
		}
		if (((s4.equals("Year")) || (s4.equals("1996")) || (s4.equals("1992")) || (s4.equals("1988"))
				|| (s4.equals("1984")) || (s4.equals("1980")) || (s4.equals("1976")) || (s4.equals("1972"))
				|| (s4.equals("1968")) || (s4.equals("1964")) || (s4.equals("1960")) || (s4.equals("1956"))
				|| (s4.equals("1952")))) {

			if (t > 29) {
				jComboBox3.removeAllItems();
				jComboBox3.addItem("Month");
				jComboBox3.addItem("JAN");
				jComboBox3.addItem("MAR");
				jComboBox3.addItem("APR");
				jComboBox3.addItem("MAY");
				jComboBox3.addItem("JUN");
				jComboBox3.addItem("JUL");
				jComboBox3.addItem("AUG");
				jComboBox3.addItem("SEP");
				jComboBox3.addItem("OCT");
				jComboBox3.addItem("NOV");
				jComboBox3.addItem("DEC");
			}
		}
		if (s1.equals("29")) {
			if (((s4.equals("Year")) || (s4.equals("1996")) || (s4.equals("1992")) || (s4.equals("1988"))
					|| (s4.equals("1984")) || (s4.equals("1980")) || (s4.equals("1976")) || (s4.equals("1972"))
					|| (s4.equals("1968")) || (s4.equals("1964")) || (s4.equals("1960")) || (s4.equals("1956"))
					|| (s4.equals("1952")))) {
				jComboBox3.removeAllItems();
				jComboBox3.addItem("Month");
				jComboBox3.addItem("JAN");
				jComboBox3.addItem("FEB");
				jComboBox3.addItem("MAR");
				jComboBox3.addItem("APR");
				jComboBox3.addItem("MAY");
				jComboBox3.addItem("JUN");
				jComboBox3.addItem("JUL");
				jComboBox3.addItem("AUG");
				jComboBox3.addItem("SEP");
				jComboBox3.addItem("OCT");
				jComboBox3.addItem("NOV");
				jComboBox3.addItem("DEC");
			}

			else {
				jComboBox3.removeAllItems();
				jComboBox3.addItem("Month");
				jComboBox3.addItem("JAN");
				jComboBox3.addItem("MAR");
				jComboBox3.addItem("APR");
				jComboBox3.addItem("MAY");
				jComboBox3.addItem("JUN");
				jComboBox3.addItem("JUL");
				jComboBox3.addItem("AUG");
				jComboBox3.addItem("SEP");
				jComboBox3.addItem("OCT");
				jComboBox3.addItem("NOV");
				jComboBox3.addItem("DEC");
			}
		}

	}// GEN-LAST:event_jComboBox3FocusGained

	private void jComboBox4FocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jComboBox4FocusGained
		String s1 = jComboBox2.getSelectedItem().toString();
		String s2 = jComboBox3.getSelectedItem().toString();
		if (s1.equals("29") && s2.equals("FEB")) {
			jComboBox4.removeAllItems();
			jComboBox4.addItem("Year");
			for (int i = 96; i > 51; i = i - 4) {
				jComboBox4.addItem("19" + i);
			}
		} else {
			jComboBox4.removeAllItems();
			jComboBox4.addItem("Year");
			for (int i = 99; i >= 51; i--) {
				jComboBox4.addItem("19" + i);
			}
		}

	}// GEN-LAST:event_jComboBox4FocusGained

	private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField3KeyPressed
		int keycode = evt.getKeyCode();
		if (keycode == KeyEvent.VK_BACK_SPACE || keycode == KeyEvent.VK_DELETE) {
		}
	}// GEN-LAST:event_jTextField3KeyPressed

	private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField3KeyTyped
		String s = jTextField3.getText();
		int len = s.length();
		char ch = evt.getKeyChar();
		if (!(ch >= '0' && ch <= '9') || ch == java.awt.event.KeyEvent.VK_BACK_SPACE
				|| ch == java.awt.event.KeyEvent.VK_DELETE) {
			evt.consume();
		}
		if (len >= 10) {
			evt.consume();
			Toolkit.getDefaultToolkit().beep();
		}
	}// GEN-LAST:event_jTextField3KeyTyped

	private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField7KeyTyped
		char ch = evt.getKeyChar();
		if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == ',' || ch == '.'
				|| ch == java.awt.event.KeyEvent.VK_BACK_SPACE || ch == java.awt.event.KeyEvent.VK_SPACE
				|| ch == java.awt.event.KeyEvent.VK_DELETE)) {
			evt.consume();
			Toolkit.getDefaultToolkit().beep();
		}

	}// GEN-LAST:event_jTextField7KeyTyped

	private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField6KeyTyped
		char ch = evt.getKeyChar();
		if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == ',' || ch == '.'
				|| ch == java.awt.event.KeyEvent.VK_BACK_SPACE || ch == java.awt.event.KeyEvent.VK_SPACE
				|| ch == java.awt.event.KeyEvent.VK_DELETE)) {
			evt.consume();
			Toolkit.getDefaultToolkit().beep();
		}

	}// GEN-LAST:event_jTextField6KeyTyped

	private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField4KeyTyped
		char ch = evt.getKeyChar();
		if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == ','
				|| ch == java.awt.event.KeyEvent.VK_BACK_SPACE || ch == java.awt.event.KeyEvent.VK_SPACE
				|| ch == java.awt.event.KeyEvent.VK_DELETE)) {
			evt.consume();
			Toolkit.getDefaultToolkit().beep();
		}

	}// GEN-LAST:event_jTextField4KeyTyped

	private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel6MouseClicked
		// code for preview

		l.setPreferredSize(new Dimension(200, 190));
		jfc.setCurrentDirectory(jfc.getCurrentDirectory());
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setAccessory(l);
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
		jfc.setFileFilter(filter);
		jfc.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(final PropertyChangeEvent evt) {
				SwingWorker<Image, Void> worker = new SwingWorker<Image, Void>() {
					@Override
					protected Image doInBackground() {

						// If selected file changes..
						if (evt.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
							// Get selected file
							File f = jfc.getSelectedFile();

							try {
								// Create FileInputStream for file
								FileInputStream fin = new FileInputStream(f);

								// Read image from fin
								BufferedImage bim = ImageIO.read(fin);

								// Return the scaled version of image
								return bim.getScaledInstance(200, 190, BufferedImage.SCALE_FAST);

							} catch (Exception e) {
								// If there is a problem reading image,
								// it might not be a valid image or unable
								// to read
								l.setText(" Not valid image/Unable to read");
							}
						}

						return null;
					}

					@Override
					protected void done() {
						try {
							// Get the image
							Image i = get(1L, TimeUnit.NANOSECONDS);

							// If i is null, go back!
							if (i == null)
								return;

							// Set icon otherwise
							l.setIcon(new ImageIcon(i));
						} catch (Exception e) {
							// Print error occured
							l.setText(" Error occured.");
						}
					}
				};
				worker.execute();

			}
		});

		// Ends code for preview

		File file;
		String s, s1 = "";
		ServerInterface ser = null;
		int res = jfc.showOpenDialog(EditProfile.this);
		if (res == JFileChooser.APPROVE_OPTION) {
			b = true;
			file = jfc.getSelectedFile();
			ImageIcon img = new ImageIcon(file.getAbsolutePath());
			Rectangle rect = jLabel2.getBounds();
			Image scaledImage = img.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
			img = new ImageIcon(scaledImage);
			jLabel2.setIcon(img);
			s = Math.random() + file.getName();
			try {
				ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
				s1 = ser.getImg(id);
				ser.setImg(id, s);
				ser.saveImg(id, img, file);
			} catch (Exception e) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Failed to load image contents!!!");
				try {
					ser.setImg(id, s1);
					ser.saveImg(id, img, file);
				} catch (Exception ex) {
				}
				new EditProfile(ic, name, tym, id, bd, ip, cw, ci).setVisible(true);
				this.dispose();
			}
		} else {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Dialog cancelled by the user");
		}
	}// GEN-LAST:event_jLabel6MouseClicked

	private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel6MouseExited
		jLabel6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel6.setText("<html><a href='' style='color:black;'>Upload Profile Picture?</a></html>");
	}// GEN-LAST:event_jLabel6MouseExited

	private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel6MouseEntered
		jLabel6.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel6.setText("<html><a href='' style='color:red;'>Upload Profile Picture?</a></html>");
	}// GEN-LAST:event_jLabel6MouseEntered

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

	private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel23MouseExited
		jLabel23.setText("<html><a href='' style='color:black;'>Logout</a></html>");
	}// GEN-LAST:event_jLabel23MouseExited

	private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel23MouseEntered
		jLabel23.setText("<html><a href='' style='color:red;'>Logout</a></html>");
	}// GEN-LAST:event_jLabel23MouseEntered

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

		int res = chooser.showSaveDialog(EditProfile.this);
		if (res == JFileChooser.APPROVE_OPTION) {

			// writing the image

			try {
				File file = chooser.getSelectedFile();
				ImageIO.write(image, "jpg", file);
				// System.out.println(image);
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(EditProfile.this, "The Image was Saved Successfully!", "Success!",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(EditProfile.this,
						"Oops! Something gone wrong while saving." + e.getMessage(), "Error!",
						JOptionPane.ERROR_MESSAGE);

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
			java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// new EditProfile().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JComboBox jComboBox4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel35;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	// End of variables declaration//GEN-END:variables
}
