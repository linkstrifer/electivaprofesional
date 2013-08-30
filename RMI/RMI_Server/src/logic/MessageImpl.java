package logic;
 
import java.io.File;
import java.io.FileWriter;
import java.rmi.RemoteException;
import static java.rmi.server.RemoteServer.getClientHost;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

public class MessageImpl extends UnicastRemoteObject implements Message {
    public MessageImpl() throws RemoteException {        
    }
    @Override
    public void sayHello(String sname, String slastname, String semail) throws RemoteException {
        System.out.println(sname);
        System.out.println(slastname);
        System.out.println(semail);
        
        Calendar calendar = Calendar.getInstance();
        int second = calendar.get(Calendar.SECOND);
        int minute = calendar.get(Calendar.MINUTE);
        int hour = calendar.get(Calendar.HOUR);
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);

        String id = second+""+minute+""+hour+""+day+""+month+""+year;
        String names = sname;
        String lastname = slastname;
        String email = semail;
        String currentHour = hour+":"+minute;
        String date = day+"/"+month+"/"+year;
        String ip;
        try{
            ip = getClientHost();
            File log = new File("log/message_log.html");
            FileWriter writer = new FileWriter(log,true);
            
            writer.write("<p><span><b>ID</b>"+id+"</span><span class='capitalize'><b>Nombres</b>"+names+"</span><span class='capitalize'><b>Apellidos</b>"+lastname+"</span><span><b>Correo electrónico</b>"+email+"</span><span><b>Hora</b>"+currentHour+"</span><span><b>Fecha</b>"+date+"</span><span><b>Dirección IP</b>"+ip+"</span></p>");
            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}