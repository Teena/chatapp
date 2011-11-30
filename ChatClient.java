import java.io.*;
import java.net.*;


public class ChatClient
{
	Socket soc=null;
	DataOutputStream dos=null;
	DataInputStream dis=null;
	BufferedReader br=null;
	
	ChatClient()
	{
		
		try
		{
		
			soc = new Socket("localhost",3000);
			dos = new DataOutputStream(soc.getOutputStream());
			dis = new DataInputStream(soc.getInputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
		
			System.out.println("Connected to server you can start sending message.....");
			System.out.println("For terminating application use ----> bye");
		
		
			String msg = br.readLine();
			dos.writeUTF(msg);
		
			while(!msg.equals("bye"))
			{
				String msg_ser = dis.readUTF();
				
				System.out.println("Server: " +msg_ser);
				msg = br.readLine();
				dos.writeUTF(msg);
				
			}
			
			System.out.println("");
			System.out.println("Server Shut Down....Talk to you soon!!!!");
			
			br.close();
			dos.close();
			dis.close();
			soc.close();
		}catch(Exception e)
		{
			System.out.println(" Exception at Client side: "+e );
		}
	}
	
	public static void main(String args[])
	{
		new ChatClient();
	}
}