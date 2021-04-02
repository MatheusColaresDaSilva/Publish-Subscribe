package com.mkyong.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.mkyong.rmiclient.ClienteInterface;

public interface RMIInterface extends Remote {
	
	public String helloTo(String name) throws RemoteException;
	
	public String subscribe(ClienteServidorInterface node, String mensagem) throws RemoteException;
	//public String subscribe(String node, String tipo, String mensagem) throws RemoteException;
	
	public String provider(String name) throws RemoteException;
}