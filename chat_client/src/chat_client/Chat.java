package chat_client;

import java.rmi.*;
import java.rmi.server.*;
import java.util.List;
import java.util.ArrayList;
 
public class Chat extends UnicastRemoteObject implements ChatInterface  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name;
	public ChatInterface cliente=null;
	public int numMensagem=-1;

	private List<ChatInterface> clientes = new ArrayList<ChatInterface>();
 
	public Chat(String n)  throws RemoteException { 
		this.name=n;   
	}
	public String getNome() throws RemoteException {
		return this.name;
	}

	public List<ChatInterface> getClientes() throws RemoteException{
		return clientes;
	}

	public int getNumMensagem() throws RemoteException{
		return numMensagem;
	}
 
	public void send(String s) throws RemoteException{
		System.out.println(s);
		numMensagem++;
	}	

	public void addCliente(ChatInterface cliente) throws RemoteException {
		send("["+cliente.getNome()+"] entá no chat!");
		clientes.add(cliente);
	}

	public void removeCliente(ChatInterface cliente) throws RemoteException{
		send("["+cliente.getNome()+"] saiu do chat!");
		clientes.remove(cliente);
	}

	public void atualizaClientes() throws RemoteException{
		List<ChatInterface> aux = clientes;
		for(ChatInterface c:aux){
			if(c.equals(null)){
		    	removeCliente(c);				
		    }
		 }
	}
}