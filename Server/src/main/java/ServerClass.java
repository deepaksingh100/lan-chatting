import static me.deepak.chat.utils.DataBaseUtil.closeConnection;
import static me.deepak.chat.utils.DataBaseUtil.createConnection;
import static me.deepak.chat.utils.DataBaseUtil.getStatement;
import static me.deepak.chat.utils.CryptoUtil.decrypt;
import static me.deepak.chat.utils.CryptoUtil.encrypt;
import static me.deepak.chat.utils.EmailUtil.sendEmail;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ServerClass extends UnicastRemoteObject implements ServerInterface {
	Vector civec = new Vector(1, 1);
	Vector namevec = new Vector(1, 1);
	Vector msgvec = new Vector(1, 1);
	Vector sendervec = new Vector(1, 1);
	Vector timevec = new Vector(1, 1);
	Vector idvec = new Vector(1, 1);
	Vector<Vector> smileyvec = new Vector<Vector>(1, 1);
	Vector<Vector> posvec = new Vector<Vector>(1, 1);

	public ServerClass() throws RemoteException {
		super();
	}

	// Message Passing related functions start

	@Override
	public boolean registerUser(ClientInterface ci, String name, String id) {
		boolean already = false;
		for (int i = 0; i < idvec.size(); i++) {
			if (idvec.elementAt(i).toString().equals(id)) {
				already = true;
				break;
			}
		}
		if (already) {

			try {
				ci.refreshList(namevec, idvec);

			} catch (Exception e) {
			}
			try {
				ci.initialMessage(msgvec, sendervec, timevec, smileyvec);

			} catch (Exception e) {
				System.out.println("Exception in registerUser :" + e);
			}
			return false;
		} else {
			civec.addElement(ci);
			namevec.addElement(name);
			idvec.addElement(id);
			for (int i = 0; i < civec.size(); i++) {
				try {
					ClientInterface c = (ClientInterface) civec.elementAt(i);
					c.refreshList(namevec, idvec);
				} catch (Exception e) {
				}
			}
			try {
				ci.initialMessage(msgvec, sendervec, timevec, smileyvec);
			} catch (Exception e) {
				System.out.println("Exception in registerUser :" + e);
			}
			return true;
		}

	}

	@Override
	public void sendMessage(String msg, String name, String time, Vector smileynum) throws RemoteException {
		msgvec.addElement(msg);
		sendervec.addElement(name);
		timevec.addElement(time);
		smileyvec.addElement(smileynum);
		// System.out.println("ServerClass : "+smileynum);
		for (int i = 0; i < civec.size(); i++) {
			ClientInterface c = (ClientInterface) civec.elementAt(i);
			c.setMessage(name, msg, time, smileynum);
		}
	}

	@Override
	public void logout(ClientInterface ci) throws RemoteException {
		for (int i = 0; i < civec.size(); i++) {
			Object ob = civec.elementAt(i);
			if (ob.equals(ci)) {
				civec.removeElementAt(i);
				namevec.removeElementAt(i);
				idvec.removeElementAt(i);
				// smileyvec.removeElementAt(i);
			}
		}
		for (int i = 0; i < civec.size(); i++) {
			ClientInterface c = (ClientInterface) civec.elementAt(i);
			try {
				c.refreshList(namevec, idvec);
				c.refresh();
			} catch (Exception e) {
				System.out.println("logout :" + e);
			}
		}
	}

	@Override
	public String sendMail(String email, String userid) throws RemoteException {
		str = getTempId();
		String s = sendEmail(email, userid, str);
		return s + ":" + str;
	}

	// Message Passing related functions start

	// DBMS related functions start

	@Override
	public void setImg(String userid, String imgname) throws RemoteException {
		Statement st;
		try {
			st = getStatement();
			st.executeUpdate("update chat set imgname='" + imgname + "'where userid='" + userid + "'");
		} catch (Exception e) {
		}

	}

	@Override
	public String getImg(String userid) throws RemoteException {
		Statement st;
		String s = "";
		try {
			st = getStatement();
			ResultSet rs = st.executeQuery("select imgname from chat where userid='" + userid + "'");
			if (rs.next())
				s = rs.getString("imgname");
		} catch (Exception e) {
		}
		return s;
	}

	@Override
	public void saveImg(String userid, ImageIcon img, File file) throws RemoteException {
		File f1 = new File("D:" + File.separator + "My Chat Application" + File.separator + userid);
		f1.mkdir();
		String s = getImg(userid);

		File f2 = new File(s);

		String str = f1 + File.separator + f2;
		BufferedImage image = null;
		// System.out.println(img);
		// reading the image

		try {
			image = new BufferedImage(img.getIconWidth(), img.getIconWidth(), BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(file);
		} catch (Exception e) {
			System.out.print(e);
		}

		// writing the image

		try {
			File f = new File(str);
			ImageIO.write(image, "jpg", f);
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	@Override
	public ImageIcon img(String userid) throws RemoteException {
		return new ImageIcon(("D:" + File.separator + "My Chat Application" + File.separator + userid + File.separator
				+ getImg(userid)));
	}

	JFrame f;

	@Override
	public File changeImg(String userid) throws RemoteException {
		return new File(("D:" + File.separator + "My Chat Application" + File.separator + userid));
	}

	@Override
	public boolean getAllEmail(String email) throws RemoteException {
		boolean d = false;
		try {
			Statement st = getStatement();
			ResultSet rs = st.executeQuery("select emailid from chat where emailid='" + email + "'");
			if (rs.next()) {
				d = true;
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return d;
	}

	@Override
	public String getEmail(String userid) throws RemoteException {
		String str = "";
		try {
			Statement st = getStatement();
			ResultSet rs = st.executeQuery("select emailid from chat where userid='" + userid + "'");
			if (rs.next()) {
				str = rs.getString("emailid");
			} else
				str = "s";
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;
	}

	@Override
	public String getPassword(String userid) throws RemoteException {
		String str = "";
		try {
			Statement st = getStatement();
			ResultSet rs = st.executeQuery("select password from chat where userid='" + userid + "'");
			if (rs.next()) {
				str = decrypt(userid, rs.getString("password"));
				System.out.println("getPassword: " + str);
			} else
				str = "s";
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;

	}

	@Override
	public String getVerifyStatus(String userid) throws RemoteException {
		String str = "";
		try {
			Statement st = getStatement();
			ResultSet rs = st.executeQuery("select verifystatus from chat where userid='" + userid + "'");
			if (rs.next()) {
				str = rs.getString("verifystatus");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;
	}

	@Override
	public int delete(String userid, String password) throws RemoteException {
		int executeUpdate = 0;
		try {
			Statement st = getStatement();
			executeUpdate = st.executeUpdate(
					"delete  from chat where userid='" + userid + "'and password='" + encrypt(userid, password) + "'");
		} catch (Exception e) {
			System.out.println(e);
		}
		return executeUpdate;
	}

	static String req = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	static int len;
	static String s = "";

	public static String getTempId() {
		len = req.length();
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i <= 10; i++) {
			int index = (int) (len * Math.random());
			sb.append(req.charAt(index));
		}
		return sb.toString();
	}

	String str;

	@Override
	public void signup(String name, String userid, String emailid, String mobile, String address, String password,
			Object day, Object month, Object year, boolean male) throws Exception {
		String url = System.getProperty("user.home") + File.separator + "mychaap";
		File f = new File(url);
		f.mkdir();
		f.setReadOnly();
		String blank = "blank";
		try {
			Runtime.getRuntime().exec("attrib +h " + f);
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			keygen.init(128);
			SecretKey key = keygen.generateKey();
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(url + File.separator + userid + ".txt"));

			out.writeObject(key);
			out.close();
		} catch (Exception e) {
		}
		String s5 = encrypt(userid, password);
		String s2 = name;
		String s1 = mobile;
		String s7 = address;
		String s3 = emailid;
		String s4 = userid;
		Object obj2 = day;
		Object obj3 = month;
		Object obj4 = year;
		boolean equals = male;
		Statement st;
		try {
			st = getStatement();
			if (equals)
				st.executeUpdate("insert into chat values('" + s2 + "','" + s4 + "','" + s3 + "','" + s1 + "','" + s7
						+ "'," + "'" + s5 + "','" + equals + "','" + blank + "','" + blank + "','" + blank + "','"
						+ blank + "','" + blank + "','" + "" + obj2 + "','" + obj3 + "','" + obj4 + "','" + blank
						+ "','" + "male.jpg" + "','" + str + "','" + "N" + "')");
			else
				st.executeUpdate("insert into chat values('" + s2 + "','" + s4 + "','" + s3 + "','" + s1 + "'," + "'"
						+ s7 + "','" + s5 + "','" + equals + "','" + blank + "','" + blank + "','" + blank + "','"
						+ blank + "','" + "" + blank + "','" + obj2 + "','" + obj3 + "','" + obj4 + "','" + blank
						+ "','" + "female.jpg" + "','" + str + "','" + "N" + "')");
		} catch (Exception e) {
			Toolkit.getDefaultToolkit().beep();
			System.out.println(e);
		}
	}

	@Override
	public String login(String userid, String password) throws Exception {
		String s1 = userid;
		String s2 = encrypt(userid, password);
		// System.out.println(s2);
		String str = "";
		try {
			Statement st = getStatement();
			ResultSet rs = st.executeQuery("select * from chat where userid='" + s1 + "' and password='" + s2 + "'");
			if (rs.next()) {
				String s3 = rs.getString("userid");
				String s4 = rs.getString("name");
				str = rs.getString("male");
				str = str + ":" + s3 + ":" + s4;
			} else
				str = "login failed";
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;
	}

	boolean b;

	@Override
	public boolean log(String userid) throws RemoteException {
		// System.out.print(userid);
		try {
			Statement st = getStatement();
			ResultSet rs = st.executeQuery("select userid from chat");
			while (rs.next()) {
				if ((rs.getString("userid")).equals(userid)) {
					System.out.print(userid);
					b = true;
				}
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	@Override
	public void changePassword(String userid, String Password) throws Exception {
		String newpass = encrypt(userid, Password);
		String id = userid;
		try {
			Statement st = getStatement();
			st.executeUpdate("update chat set password='" + newpass + "'where userid='" + id + "'");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void editProfile(String high1, String inter1, String grad1, String home1, String city1, String lang1,
			String userid, String mobile1, Object day1, Object month1, Object year1) throws RemoteException {

		try {
			Statement st = getStatement();
			if (!high1.equals(""))
				st.executeUpdate("update chat set high='" + high1 + "' where userid='" + userid + "'");
			if (!inter1.equals(""))
				st.executeUpdate("update chat set inter='" + inter1 + "' where userid='" + userid + "'");
			if (!grad1.equals(""))
				st.executeUpdate("update chat set grad='" + grad1 + "' where userid='" + userid + "'");
			if (!lang1.equals(""))
				st.executeUpdate("update chat set lang='" + lang1 + "' where userid='" + userid + "'");
			if (!mobile1.equals(""))
				st.executeUpdate("update chat set mobile='" + mobile1 + "' where userid='" + userid + "'");
			if (!home1.equals(""))
				st.executeUpdate("update chat set home='" + home1 + "' where userid='" + userid + "'");
			if (!city1.equals(""))
				st.executeUpdate("update chat set city='" + city1 + "' where userid='" + userid + "'");
			if (!day1.equals("Day"))
				st.executeUpdate("update chat set day='" + day1 + "' where userid='" + userid + "'");
			if (!month1.equals("Month"))
				st.executeUpdate("update chat set month='" + month1 + "' where userid='" + userid + "'");
			if (!year1.equals("Year"))
				st.executeUpdate("update chat set year='" + year1 + "' where userid='" + userid + "'");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public String profile(String userid) throws RemoteException {
		String str = "";
		try {
			Statement st = getStatement();
			ResultSet rs = st.executeQuery("select * from chat where userid='" + userid + "'");
			if (rs.next()) {
				String high = rs.getString("high");
				String inter = rs.getString("inter");
				String grad = rs.getString("grad");
				String home = rs.getString("home");
				String city = rs.getString("city");
				String lang = rs.getString("lang");
				String day = rs.getString("day");
				String month = rs.getString("month");
				String year = rs.getString("year");
				String emailid = rs.getString("emailid");
				String mobile = rs.getString("mobile");
				String male = rs.getString("male");
				str = high + ":" + inter + ":" + grad + ":" + home + ":" + city + ":" + lang + ":" + emailid + ":"
						+ mobile + ":" + male + ":" + day + ":" + month + ":" + year;
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;
	}

	// DBMS related functions end
	// getIP() STARTS
	@Override
	public String getIP() {
		String ip = "";
		try {
			URL whatismyip = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
			ip = in.readLine(); // you get the IP as a String
			// System.out.println("ip="+ip);
		} catch (Exception e) {
			return "-1";
		}
		return ip;
	}
	// getIP() ENDS

	public static void main(String a[]) {
		try {
			ServerClass sc = new ServerClass();
			Naming.rebind("chat", sc);
			System.out.println("Server Registered!!!");
			createConnection();
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

				@Override
				public void run() {
					closeConnection();
				}
			}));
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}
}