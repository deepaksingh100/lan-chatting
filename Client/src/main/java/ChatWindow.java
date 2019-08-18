import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.rmi.Naming;
import java.util.Calendar;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.Timer;

import io.github.dheid.fontchooser.FontChooser;
import io.github.dheid.fontchooser.FontDialog;

public class ChatWindow extends javax.swing.JFrame {
	ClientInterface ci;
	String name, id, tym, ip, str;
	String dname, did;
	JFrame f;
	Vector ve, smileynum, pos;
	JWindow jw;
	ChatWindow cw;
	FontChooser jf;
	int index = 0;

	public ChatWindow(final String name, final String id, final String tym, final String ip) {
		cw = this;
		initComponents();
		jTextPane1.requestFocus();
		this.name = name;
		this.id = id;
		this.tym = tym;
		this.ip = ip;
		setTitle(name);
		Font fo = new Font("Tahoma", Font.BOLD, 12);
		jList1.setFont(fo);
		jList1.setOpaque(false);
		try {
			BufferedImage img = ImageIO.read(getClass().getResourceAsStream("logo.jpg"));
			setIconImage(img);
			ci = new ClientClass(jList1, jTextPane2);
			// System.out.println(ci);
			jLabel23.setText(name);
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			String img1 = ser.getImg(id);
			ImageIcon img2;
			if (img1.equals("male.jpg") || img1.equals("female.jpg")) {
				img2 = new ImageIcon(getClass().getResource(img1));
			} else {
				img2 = ser.img(id);
			}
			Image scaledImage = img2.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
			img2 = new ImageIcon(scaledImage);
			jLabel23.setIcon(img2);
			String n = name + "       : " + tym;
			boolean ru = ser.registerUser(ci, n, id);
			if (!ru) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "You cann't login from 2 locations!!!");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("register user :" + e);
		}

		setSize(800, 700);
		setLocationRelativeTo(null);
		// setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		jTextPane2.setEditable(false);
		GridLayout g = new GridLayout(5, 5);
		jInternalFrame1.setLayout(g);
		setResizable(false);
		jw = new JWindow();
		// jw.setBounds(0, 400, 250, 250);
		jw.add(jInternalFrame1);
		// add(jw);
		Timer t = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ve = ci.refresh();
				} catch (Exception ex) {
				}
				// System.out.println("Timer :"+ve);
			}
		});
		t.start();
		jList1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				jw.setVisible(false);
				try {
					index = jList1.locationToIndex(e.getPoint());
					jList1.setSelectionBackground(Color.red);
					// System.out.println(index);
					dname = jList1.getModel().getElementAt(index).toString().split(":")[0];
					did = ve.get(index).toString();
					new Profile(name, dname, tym, id, did, ip, cw, ci).setVisible(true);
					cw.setVisible(false);
				} catch (Exception ex) {
					System.out.println("Exception in jlist1 :" + ex);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jList1.setSelectionBackground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jList1.setSelectionBackground(Color.WHITE);
			}

		});
		smileynum = new Vector(1, 1);
		pos = new Vector(1, 1);
	}

	public void changeimg() {
		try {
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			String img1 = ser.getImg(id);
			ImageIcon img2;
			if (img1.equals("male.jpg") || img1.equals("female.jpg")) {
				img2 = new ImageIcon(getClass().getResource(img1));
			} else {
				img2 = ser.img(id);
			}
			Image scaledImage = img2.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
			img2 = new ImageIcon(scaledImage);
			jLabel23.setIcon(img2);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jInternalFrame1 = new javax.swing.JInternalFrame();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		jLabel28 = new javax.swing.JLabel();
		jLabel29 = new javax.swing.JLabel();
		jLabel30 = new javax.swing.JLabel();
		jLabel31 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextPane1 = new javax.swing.JTextPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextPane2 = new javax.swing.JTextPane();
		jLabel23 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowIconified(java.awt.event.WindowEvent evt) {
				formWindowIconified(evt);
			}

			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});
		getContentPane().setLayout(null);

		jInternalFrame1.setClosable(true);
		jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		jInternalFrame1.setTitle("SMILEY");
		jInternalFrame1.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/13.gif"))); // NOI18N
		jInternalFrame1.setOpaque(true);
		try {
			jInternalFrame1.setSelected(true);
		} catch (java.beans.PropertyVetoException e1) {
			e1.printStackTrace();
		}
		jInternalFrame1.setVisible(true);
		jInternalFrame1.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
				jInternalFrame1InternalFrameClosing(evt);
			}

			public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
			}
		});
		jInternalFrame1.getContentPane().setLayout(new java.awt.GridLayout(5, 5));

		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1.gif"))); // NOI18N
		jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel3MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel3);

		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2.gif"))); // NOI18N
		jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel4MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel4);

		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3.gif"))); // NOI18N
		jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel5MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel5);

		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4.gif"))); // NOI18N
		jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel6MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel6);

		jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/5.gif"))); // NOI18N
		jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel7MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel7);

		jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/6.gif"))); // NOI18N
		jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel8MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel8);

		jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/7.gif"))); // NOI18N
		jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel9MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel9);

		jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/8.gif"))); // NOI18N
		jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel10MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel10);

		jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/9.gif"))); // NOI18N
		jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel11MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel11);

		jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10.gif"))); // NOI18N
		jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel12MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel12);

		jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/11.gif"))); // NOI18N
		jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel13MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel13);

		jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12.gif"))); // NOI18N
		jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel14MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel14);

		jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/13.gif"))); // NOI18N
		jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel17MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel17);

		jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/14.gif"))); // NOI18N
		jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel15MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel15);

		jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/15.gif"))); // NOI18N
		jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel16MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel16);

		jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16.gif"))); // NOI18N
		jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel22MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel22);

		jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/17.gif"))); // NOI18N
		jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel24MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel24);

		jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/18.gif"))); // NOI18N
		jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel25MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel25);

		jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/19.gif"))); // NOI18N
		jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel26MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel26);

		jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/20.gif"))); // NOI18N
		jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel27MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel27);

		jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/21.gif"))); // NOI18N
		jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel28MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel28);

		jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/22.gif"))); // NOI18N
		jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel29MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel29);

		jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/23.gif"))); // NOI18N
		jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel30MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel30);

		jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24.gif"))); // NOI18N
		jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel31MouseClicked(evt);
			}
		});
		jInternalFrame1.getContentPane().add(jLabel31);

		getContentPane().add(jInternalFrame1);
		jInternalFrame1.setBounds(70, 290, 150, 150);

		jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ONLINE USER(S)", 0, 0,
				new java.awt.Font("Tahoma", 1, 12), java.awt.Color.black)); // NOI18N

		jList1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jList1.setFixedCellHeight(25);
		jList1.setVisibleRowCount(0);
		jScrollPane3.setViewportView(jList1);

		getContentPane().add(jScrollPane3);
		jScrollPane3.setBounds(10, 20, 240, 640);
		jScrollPane3.getAccessibleContext().setAccessibleName("");

		jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENTER MESSAGE", 0, 0,
				new java.awt.Font("Tahoma", 1, 12), java.awt.Color.black)); // NOI18N

		jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jTextPane1KeyPressed(evt);
			}
		});
		jScrollPane1.setViewportView(jTextPane1);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(260, 380, 510, 210);

		jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MESSAGE BOX", 0, 0,
				new java.awt.Font("Tahoma", 1, 12), java.awt.Color.black)); // NOI18N

		jTextPane2.setEditable(false);
		jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jScrollPane2.setViewportView(jTextPane2);

		getContentPane().add(jScrollPane2);
		jScrollPane2.setBounds(260, 50, 510, 330);

		jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel23.setBorder(
				javax.swing.BorderFactory.createTitledBorder(null, "", 0, 5, null, new java.awt.Color(0, 0, 204)));
		jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel23MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel23);
		jLabel23.setBounds(290, 0, 260, 50);

		jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel19.setText("<html><a href \"style=color:black\">Profile</a></html>");
		jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel19MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel19MouseExited(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel19MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel19);
		jLabel19.setBounds(610, 0, 60, 30);

		jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel18.setText("<html><a href \"style=color:black\">Logout</a></html>");
		jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel18MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel18MouseExited(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel18MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel18);
		jLabel18.setBounds(710, 0, 60, 30);

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setText("Send-Message");
		jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(630, 610, 133, 40);

		jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel20.setText("<html><a href \"style=color:black\">Foreground</a></html>");
		jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel20MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel20MouseExited(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel20MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel20);
		jLabel20.setBounds(490, 610, 110, 40);

		jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel21.setText("<html><a href \"style=color:black\">Font</a></html>");
		jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel21MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel21MouseExited(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel21MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel21);
		jLabel21.setBounds(390, 610, 60, 40);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel2.setText("<html><a href \"style=color:black\">Smiley</a></html>");
		jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel2MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel2MouseExited(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel2);
		jLabel2.setBounds(270, 610, 60, 40);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/800_700.jpg"))); // NOI18N
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 800, 700);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		jLabel21.setVisible(true);
		String msg = jTextPane1.getText();
		System.out.println(msg + "cw");
		;
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
		String time = hs + ":" + ms + " " + ampms;
		char c = new Character((char) 2);
		if (!msg.trim().equals("") || msg.contains(c + "")) {
			try {
				ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
				ser.sendMessage(msg, name, time, smileynum);
				smileynum.removeAllElements();
				jTextPane1.setText("");
			} catch (Exception e) {
				System.out.println("Ex : " + e);
			}
		} else {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(f, "Please Enter a Message!!!");
		}
		smileynum.removeAllElements();
		pos.removeAllElements();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel2MouseEntered
		jLabel2.setText("<html><a href 'style=color:red'>Smiley</a></html>");
	}// GEN-LAST:event_jLabel2MouseEntered

	private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel2MouseExited
		jLabel2.setText("<html><a href 'style=color:black'>Smiley</a></html>");
	}// GEN-LAST:event_jLabel2MouseExited

	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel2MouseClicked
		jw.setVisible(true);
		jw.setBounds(getLocation().x + 120, getLocation().y + 530, 150, 150);
	}// GEN-LAST:event_jLabel2MouseClicked

	private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel3MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(1);
		jTextPane1.insertIcon(jLabel3.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel3MouseClicked

	private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel4MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(2);
		jTextPane1.insertIcon(jLabel4.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel4MouseClicked

	private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(3);
		jTextPane1.insertIcon(jLabel5.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel5MouseClicked

	private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel6MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(4);
		jTextPane1.insertIcon(jLabel6.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel6MouseClicked

	private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel7MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(5);
		jTextPane1.insertIcon(jLabel7.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel7MouseClicked

	private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel8MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(6);
		jTextPane1.insertIcon(jLabel8.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel8MouseClicked

	private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel9MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(7);
		jTextPane1.insertIcon(jLabel9.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel9MouseClicked

	private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel10MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(8);
		jTextPane1.insertIcon(jLabel10.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel10MouseClicked

	private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel11MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(9);
		jTextPane1.insertIcon(jLabel11.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel11MouseClicked

	private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel12MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(10);
		jTextPane1.insertIcon(jLabel12.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel12MouseClicked

	private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel13MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(11);
		jTextPane1.insertIcon(jLabel13.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel13MouseClicked

	private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel14MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(12);
		jTextPane1.insertIcon(jLabel14.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel14MouseClicked

	private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel15MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(13);
		jTextPane1.insertIcon(jLabel15.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel15MouseClicked

	private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel16MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(14);
		jTextPane1.insertIcon(jLabel16.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel16MouseClicked

	private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel17MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(15);
		jTextPane1.insertIcon(jLabel17.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel17MouseClicked

	private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel18MouseEntered
		jLabel18.setText("<html><a href 'style=color:red'>Logout</a></html>");
	}// GEN-LAST:event_jLabel18MouseEntered

	private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel18MouseExited
		jLabel18.setText("<html><a href 'style=color:black'>Logout</a></html>");
	}// GEN-LAST:event_jLabel18MouseExited

	private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel18MouseClicked
		jw.setVisible(false);
		try {
			ServerInterface ser = (ServerInterface) Naming.lookup("rmi://" + ip + "/chat");
			ser.logout(ci);
			new Login().setVisible(true);
			this.dispose();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// GEN-LAST:event_jLabel18MouseClicked

	private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel19MouseClicked
		jw.setVisible(false);
		new Profile(name, tym, id, ip, this, false, ci).setVisible(true);
		this.setVisible(false);
	}// GEN-LAST:event_jLabel19MouseClicked

	private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel19MouseExited
		jLabel19.setText("<html><a href 'style=color:black'>Profile</a></html>");
	}// GEN-LAST:event_jLabel19MouseExited

	private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel19MouseEntered
		jLabel19.setText("<html><a href 'style=color:red'>Profile</a></html>");
	}// GEN-LAST:event_jLabel19MouseEntered

	private void jInternalFrame1InternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_jInternalFrame1InternalFrameClosing
		jw.setVisible(false);
	}// GEN-LAST:event_jInternalFrame1InternalFrameClosing

	private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel21MouseEntered
		jLabel21.setText("<html><a href 'style=color:red'>Font</a></html>");
	}// GEN-LAST:event_jLabel21MouseEntered

	private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel21MouseExited
		jLabel21.setText("<html><a href 'style=color:black'>Font</a></html>");
	}// GEN-LAST:event_jLabel21MouseExited

	private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel20MouseEntered
		jLabel20.setText("<html><a href 'style=color:red'>Foreground</a></html>");
	}// GEN-LAST:event_jLabel20MouseEntered

	private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel20MouseExited
		jLabel20.setText("<html><a href 'style=color:black'>Foreground</a></html>");
	}// GEN-LAST:event_jLabel20MouseExited

	private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel21MouseClicked
		FontDialog.showDialog(this);
		/*if (!showDialog.toString().equals("")) {
			jTextPane1.setFont(showDialog);
			jTextPane2.setFont(showDialog);
		}*/
	}// GEN-LAST:event_jLabel21MouseClicked

	private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel20MouseClicked
		Color c = JColorChooser.showDialog(this, "Color Chooser", Color.red);
		jTextPane1.setForeground(c);
		jTextPane2.setForeground(c);
	}// GEN-LAST:event_jLabel20MouseClicked

	private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel23MouseClicked
		jw.setVisible(false);
		new Profile(name, tym, id, ip, this, false, ci).setVisible(true);
		this.setVisible(false);
	}// GEN-LAST:event_jLabel23MouseClicked

	private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel22MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(16);
		jTextPane1.insertIcon(jLabel22.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel22MouseClicked

	private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel24MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(17);
		jTextPane1.insertIcon(jLabel24.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel24MouseClicked

	private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel25MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(18);
		jTextPane1.insertIcon(jLabel25.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel25MouseClicked

	private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel26MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(19);
		jTextPane1.insertIcon(jLabel26.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel26MouseClicked

	private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel27MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(20);
		jTextPane1.insertIcon(jLabel27.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel27MouseClicked

	private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel28MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(21);
		jTextPane1.insertIcon(jLabel28.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel28MouseClicked

	private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel29MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(22);
		jTextPane1.insertIcon(jLabel29.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel29MouseClicked

	private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel30MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(23);
		jTextPane1.insertIcon(jLabel30.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel30MouseClicked

	private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel31MouseClicked
		jTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel21.setVisible(false);
		smileynum.add(24);
		jTextPane1.insertIcon(jLabel31.getIcon());
		try {
			jTextPane1.getStyledDocument().insertString(jTextPane1.getCaretPosition(), (char) 2 + "", null);
		} catch (Exception e) {
		}
		str = jTextPane1.getText();
	}// GEN-LAST:event_jLabel31MouseClicked

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		Toolkit.getDefaultToolkit().beep();

		int opt = JOptionPane.showOptionDialog(f, "Closing this window will cause Logout..\n Are you sure to exit!!!",
				"Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
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

	private void formWindowIconified(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowIconified
		jw.setVisible(false);
	}// GEN-LAST:event_formWindowIconified

	private void jTextPane1KeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextPane1KeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
			smileynum.removeAllElements();
			jTextPane1.setText("");
		}
	}// GEN-LAST:event_jTextPane1KeyPressed

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
			java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// new ChatWindow().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JInternalFrame jInternalFrame1;
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
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JList jList1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTextPane jTextPane1;
	private javax.swing.JTextPane jTextPane2;
	// End of variables declaration//GEN-END:variables
}
