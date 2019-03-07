package chat_client;

import java.rmi.*;
import javax.swing.*;
import java.util.Scanner;
import java.lang.Thread.*;
import java.util.ArrayList;
import java.rmi.RemoteException;

public class Cliente {

	public static void main( String args[] ) {
		try {
			final ServidorChat chat = (ServidorChat) Naming.lookup( “rmi://192.168.102.11:1098/ServidorChat” );
	
			String nome;
			String msg = “”;
			Scanner scanner = new Scanner(System.in);

			System.out.println(“Digite seu nome:”);

			nome = scanner.nextLine();
			
			Thread thread = new Thread(new Runnable() {
			int cont = chat.lerMensagem().size();
			
	@Override
	public void run() {
		try {
			while(true){
				if (chat.lerMensagem().size() > cont){
					System.out.println(chat.lerMensagem().get(chat.lerMensagem().size()-1));
					cont++;
					}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			}
	}
			}); thread.start();

		while(msg != “exit”){

			System.out.println(nome+”: “);

			msg = scanner.nextLine();

			chat.enviarMensagem(nome+”: “+msg);
			// System.out.println(chat.lerMensagem().get(cont));
		}

		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
