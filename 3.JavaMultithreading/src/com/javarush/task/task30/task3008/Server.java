package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.javarush.task.task30.task3008.MessageType.TEXT;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for(Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
            Connection value = pair.getValue();
            try {
                value.send(message);
            } catch (IOException ex) {
                ConsoleHelper.writeMessage("Message didn't send");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while(true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if(answer.getType() == MessageType.USER_NAME) {
                    if(!answer.getData().isEmpty()) {
                        if(!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for(Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                if(!pair.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while(true) {
                Message message = connection.receive(); // Хрень какая-то без этой переменной не работает.
                if(message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, (userName + ": " + message.getData())));
                } else {
                    ConsoleHelper.writeMessage("It's don't TEXT");
                }
            }
        }

        @Override
        public void run() {
            String userName = null;

            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("New connection: " + socket.getRemoteSocketAddress());
            }

            try(Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException ex) {
                ConsoleHelper.writeMessage("Error with: remote computer");
            }  finally {
                if(userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Setup port: ");
        try(ServerSocket ss = new ServerSocket(new ConsoleHelper().readInt())) {
            System.out.println("Server is started");
            while(true) {
                new Handler(ss.accept()).start();
            }
        } catch (IOException ex) {
            System.out.println("Wrong, socket crashed");
        }
    }
}
