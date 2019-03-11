package chat_client;

import java.rmi.*;
import java.util.List;

//import chat_server.ChatInterface;
 
public interface ChatInterface extends Remote{
	
	public String getNome() throws RemoteException;
	
	public List<ChatInterface> getClientes() throws RemoteException;
	
	public int getNumeroMensagem() throws RemoteException;
	
	public void enviar(String msg) throws RemoteException;
	
	public void novoCliente(ChatInterface cliente) throws RemoteException;
	
	public void removerCliente(ChatInterface cliente) throws RemoteException;
	
	public void atualizarClientes() throws RemoteException;
}
