

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ChuoiServer{
  public static void main(String[] args) throws MalformedURLException, AlreadyBoundException {
	System.out.println("Server....");
	
	int port=7777;
	try {
		LocateRegistry.createRegistry(port);
		ChuoiImpl ch= new ChuoiImpl();
		UnicastRemoteObject.exportObject(ch,port);
		Naming.bind("rmi://localhost:7777/Mychuoi", ch);
		System.out.println("Server register...");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}