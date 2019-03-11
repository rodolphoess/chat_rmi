package chat_client;

import java.rmi.*;
import java.util.List;
 
public interface ChatInterface extends Remote{
	public String getNome() throws RemoteException;
	public void send(String msg) throws RemoteException;
	public List<ChatInterface> getClientes() throws RemoteException;
	public void addCliente(ChatInterface cliente) throws RemoteException;
	public void removeCliente(ChatInterface cliente) throws RemoteException;
	public int getNumMensagem() throws RemoteException;
	public void atualizaClientes() throws RemoteException;
}
