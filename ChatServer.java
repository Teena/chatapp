import java.io.*;
import java.net.*;

public class ChatServer
{
	ServerSocket ser_soc=null;
	Socket soc=null;
	DataOutputStream dos=null;
	DataInputStream dis=null;
	BufferedReader br=null;
	
	ChatServer()
	{
		try
		{
			ser_soc = new ServerSocket(3000);
			System.out.println("Server Socket Created");
		
			soc = ser_soc.accept();
			dos = new DataOutputStream(soc.getOutputStream());
			dis = new DataInputStream(soc.getInputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
			
			//dos.writeUTF("Hello");
			String msg_client = dis.readUTF();
		//	System.out.println("Client said:"+msg_client);
			
			while(!msg_client.equals("bye"))
			{
				System.out.println("Client: " +msg_client);
				
				String msg_ser = br.readLine();
				dos.writeUTF(msg_ser);
				//dis.readUTF();
		
			}
			
			System.out.println("");	
			
			System.out.println("Server Shut Down....Talk to you soon!!!!");
			
			br.close();
			dos.close();
			dis.close();
			soc.close();
		}catch(Exception e1)
		{
			System.out.println("Exception at Server side : " +e1);
		}
		
	}
	
	public static void main(String args[])
	{
		ChatServer sv = new ChatServer();
	}
}