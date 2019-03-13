# chat_rmi
Chat desenvolvido com Java RMI para a disciplina de Programação Distribuída. Deve ser implementado um sistema de chat que permita dois ou mais clientes distribuídos conversarem. 

Para iniciar a aplicação, deverá ser aberto o Eclipse e ser realizada a importação do projeto para a IDE. Importado o projeto, ambas as aplicações, servidor e cliente(s) deverão ser executados como aplicações Java, nessa ordem. Será necessário indicar um nome para cada cliente e um nome para o servidor para assim o chat ser utilizado. Uma vez conectado, os clientes podem postar mensagens no servidor, que irá enviá-las para todos os clientes conectados por call-back. O servidor guardará a ordem em que as mensagens chegaram até ele através de um contador, e quando essas mensagens forem enviadas para os clientes seguirão o modelo: 

<Número da mensagem> - <Nome de usuário que enviou a mensagem>: Mensagem
