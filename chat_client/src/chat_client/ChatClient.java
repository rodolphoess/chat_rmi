package chat_client;

import java.rmi.*;
import java.util.*;

import chat_server.ChatInterface;
 
public class ChatClient {
	
	String nomeCliente;
	
	public static void main (String[] argv) {
	    try {

	    		List<ChatInterface> otherClients = new ArrayList<ChatInterface>();

		    	//System.setSecurityManager(new RMISecurityManager());
		    	@SuppressWarnings("resource")
				Scanner s=new Scanner(System.in);
		    	System.out.println("Digite o nome:");
		    	String name=s.nextLine().trim();		    		    	
		    	ChatInterface cliente = new Chat(name);
 
		    	ChatInterface server = (ChatInterface)Naming.lookup("rmi://localhost:1099/ChatServer");
		    	String msg="";

		    	System.out.println("Chat aberto!");
		    	server.novoCliente(cliente);
 
		    	while(true){
		    		msg=s.nextLine().trim();
		    		msg="Mensagem "+server.getNumeroMensagem()+" - "+cliente.getNome()+": "+msg;		    		
	    			server.enviar(msg);
	    			
	    			server.atualizarClientes();
	    			
	    			otherClients = server.getClientes();
	    			for(ChatInterface c:otherClients){
	    				if(!c.equals(cliente))
	    					c.enviar(msg);
	    			}
		    	}
 
	    	}catch (Exception e) {
	    		System.out.println("Chat Erro: " + e);
	    	}
		}

}
