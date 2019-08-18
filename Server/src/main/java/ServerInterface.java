import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import javax.swing.ImageIcon;

public interface ServerInterface extends Remote {

	public boolean registerUser(ClientInterface ci, String name, String id) throws RemoteException;

	public void sendMessage(String msg, String name, String time, Vector smileynum) throws RemoteException;

	public void logout(ClientInterface ci) throws RemoteException;

	public void signup(String name, String userid, String emailid, String mobile, String address, String password,
			Object day, Object month, Object year, boolean male) throws Exception;

	public String login(String userid, String password) throws Exception;

	public boolean log(String userid) throws RemoteException;

	public void changePassword(String userid, String Password) throws Exception;

	public void editProfile(String high, String inter, String grad, String home, String city, String lang,
			String userid, String mobile, Object day, Object month, Object year) throws RemoteException;

	public String profile(String userid) throws RemoteException;

	public void setImg(String userid, String imgname) throws RemoteException;

	public String getImg(String userid) throws RemoteException;

	public void saveImg(String userid, ImageIcon img, File file) throws RemoteException;

	public ImageIcon img(String userid) throws RemoteException;

	public File changeImg(String userid) throws RemoteException;

	public String getEmail(String userid) throws RemoteException;

	public String getPassword(String userid) throws RemoteException;

	public String sendMail(String email, String password) throws RemoteException;

	public String getVerifyStatus(String userid) throws RemoteException;

	public int delete(String userid, String password) throws RemoteException;

	public boolean getAllEmail(String email) throws RemoteException;

	public String getIP() throws RemoteException;
}
