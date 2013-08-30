package logic;
 
import java.rmi.Remote;
import java.rmi.RemoteException;
 
 public interface Message extends Remote {
     void sayHello(String sname, String slastname, String semail) throws RemoteException;
}