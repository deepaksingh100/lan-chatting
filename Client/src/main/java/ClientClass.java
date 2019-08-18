import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.text.*;


public class ClientClass extends UnicastRemoteObject implements ClientInterface {
	JList l;
	JTextPane t;

	public ClientClass(JList l, JTextPane t) throws RemoteException {
		super();
		this.l = l;
		this.t = t;

	}

	int size;
	static Vector tooltip = new Vector(1, 1);
	static Vector onlineusers = new Vector(1, 1);

	@Override
	public void refreshList(Vector namevec, Vector idvec) throws RemoteException {
		l.setToolTipText(null);
		l.removeAll();
		onlineusers.clear();
		tooltip.clear();
		int j = 3;
		size = namevec.size();
		String bigString = "", element = "";
		for (int i = 0; i < size; i++) {
			element = ((namevec.elementAt(i).toString()).split(":"))[0];
			if (bigString.contains(element)) {
				continue;
			} else {
				tooltip.addElement(idvec.elementAt(i));
				onlineusers.addElement(namevec.elementAt(i));
				l.setListData(onlineusers);
				l.setToolTipText(tooltip.toString());
				bigString = bigString + ":" + element;
				ImageIcon icon = new ImageIcon(getClass().getResource("green.gif"));
				JLabel l1 = new JLabel(icon);

				l1.setBounds(190, j, 20, 20);
				try {
					l.add(l1, i);
				} catch (Exception e) {
					System.out.println("icon :" + e);
				}
				j = j + 25;
			}

		}
		// System.out.println(newv);
	}

	@Override
	public Vector refresh() throws RemoteException {
		l.setListData(onlineusers);
		return tooltip;
	}

	@Override
	public void setMessage(String name, String msg, String time, Vector smileynum) throws RemoteException {

		// System.out.println("clientClass-setMessage : "+smileynum);
		StyledDocument doc = (StyledDocument) t.getDocument();

		Style style = doc.addStyle("StyleName", null);
		StyleConstants.setForeground(style, Color.blue);
		StyleConstants.setFontSize(style, 16);
		StyleConstants.setFontFamily(style, "Tahoma");
		StyleConstants.setBold(style, true);
		StyleConstants.setUnderline(style, true);
		StyleConstants.setItalic(style, true);
		try {
			char ch = (char) 2;
			Character splitchar = new Character(ch);
			msg = msg + "    at " + time;
			String[] str = msg.split(splitchar.toString());
			doc.insertString(0, "\n", null);
			for (int i = str.length - 1; i >= 1; i--) {
				try {
					doc.insertString(0, str[i], null);
					t.insertIcon(new ImageIcon(getClass().getResource(smileynum.elementAt(i - 1) + ".gif")));
				} catch (Exception e) {
					System.out.println("Exception in doc.insertIcon() : " + e);
				}
			}
			doc.insertString(0, str[0], null);
			doc.insertString(0, name + " : ", style);
			// code for setting line spacing starts here

			StyledDocument document = t.getStyledDocument();
			MutableAttributeSet attrset = new SimpleAttributeSet();
			StyleConstants.setLineSpacing(attrset, 0.4f);
			document.setParagraphAttributes(0, document.getLength(), attrset, false);

			// code for setting line spacing ends here

		} catch (Exception e) {
			System.out.println("Exception in setMessage :" + e);
		}
	}

	@Override
	public void initialMessage(Vector msgvec, Vector sendervec, Vector timevec, Vector<Vector> smileyvec)
			throws RemoteException {
		for (int i = 0; i < msgvec.size(); i++)
			setMessage(sendervec.elementAt(i).toString(), msgvec.elementAt(i).toString(),
					timevec.elementAt(i).toString(), smileyvec.elementAt(i));
		System.out.println("ClientClass-initialMessage : " + smileyvec);
	}
}
