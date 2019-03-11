package chat_server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {
	
	public static void main(String[] argv) {
		
		try {
			if (System.getSecurityManager() == null) 
				System.setSecurityManager(new RMISecurityManager());
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			System.out.println("Digite o nome: ");
			String name=s.nextLine().trim();

	    	List<ChatInterface> clients = new ArrayList<ChatInterface>();

 
	    	Chat server = new Chat(name);	
 
	    	Naming.rebind("chat", server);
 
	    	System.out.println("Chat aberto!");
 
	    	while(true){
	    		String msg=s.nextLine().trim();
	    		server.atualizarClientes();
	    		if (!server.getClientes().isEmpty()){
	    			msg="Mensagem - " + server.getNome() + ": " + msg;

	    			clients = server.getClientes();
	    			for(ChatInterface c:clients){
	    				c.enviar(msg);
	    			}
	    		}	
	    	}
			
			
		} catch (Exception e) {
			System.out.println("Erro no chat: " + e);
		}
	}

}
