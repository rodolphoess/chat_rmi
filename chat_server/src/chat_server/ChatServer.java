package chat_server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {
	
	public static void main(String[] argv) {
		
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			System.out.println("Digite o nome: ");
			String name=s.nextLine().trim();

	    	List<ChatInterface> clients = new ArrayList<ChatInterface>();

	    	LocateRegistry.createRegistry(1099);
 
	    	Chat server = new Chat(name);	
	    	
	    	Naming.rebind("rmi://localhost:1099/ChatServer", server);
 
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
			e.printStackTrace();
			System.out.println("Erro no chat: " + e);
		}
	}

}
