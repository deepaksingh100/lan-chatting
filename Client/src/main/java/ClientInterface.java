import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface ClientInterface extends Remote {
	
	public void refreshList(Vector namevec, Vector idvec) throws RemoteException;

	public void setMessage(String id, String msg, String time, Vector smileynum) throws RemoteException;

	public void initialMessage(Vector msgvec, Vector sendervec, Vector timevec, Vector<Vector> smileyvec)
			throws RemoteException;

	public Vector refresh() throws RemoteException;
}
