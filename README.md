# chat_rmi
Chat desenvolvido com Java RMI para a disciplina de Programação Distribuída. Deve ser implementado um sistema de chat que permita dois ou mais clientes distribuídos conversarem. 

Para se conectar ao servidor, cada cliente deverá indicar o host e a porta onde o serviço de chat está em execução, juntamente com um nome de usuário. Uma vez conectado, os clientes podem postar mensagens no servidor, que irá enviá-las para todos os clientes conectados por call-back. O servidor guardará a ordem em que as mensagens chegaram até ele através de um contador, e quando essas mensagens forem enviadas para os clientes seguirão o modelo: 

<Número da mensagem> - <Nome de usuário que enviou a mensagem>: <Mensagem>
  
**Detalhes da aplicação:
  
- Para compilar o servidor
      	javac -d bin -cp src/ src/Chat.java src/ChatServer.java
- Para compilar o cliente
	      javac -d bin -cp src/ src/Chat.java src/ChatClient.java
