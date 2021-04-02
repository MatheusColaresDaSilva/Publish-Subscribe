package com.mkyong.rmiserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import com.mkyong.rmiclient.A1;
import com.mkyong.rmiclient.A2;
import com.mkyong.rmiclient.ClienteInterface;
import com.mkyong.rmiinterface.ClienteServidorInterface;
import com.mkyong.rmiinterface.RMIInterface;

public class I2 extends UnicastRemoteObject implements RMIInterface, ServerInterface{
	
	private static final long serialVersionUID = 1L;
	private HashMap<ClienteServidorInterface,String> subscript = new HashMap<ClienteServidorInterface,String>();
	private HashMap<ClienteServidorInterface,String> routing = new HashMap<ClienteServidorInterface,String>();
	
	private static I1 i1;
	private static I2 i2;

	protected I2() throws RemoteException {
		super();
	}

	@Override
	public String subscribe(ClienteServidorInterface node,String mensagem) throws RemoteException {

		if(node instanceof ClienteInterface) {
			System.err.println("cai aq");
			subscript.put(node, mensagem);
		}
		else if(node instanceof ServerInterface){
			System.err.println("cai ali");
			routing.put(node, mensagem);
		}
		
		
		i1 = new I1();
		i2 = new I2();
		i1.subscribe(i2, mensagem);
		System.err.println("I2:" + subscript.size());
		System.err.println("I2:" + routing.size());
		return null;
	}
	
	@Override
	public String helloTo(String name) throws RemoteException{
		System.err.println(name + " is trying to contact!");
		return "Server says hello to " + name;
	}
	
	public static void main(String[] args){
		try {
			Naming.lookup("//localhost/I1");
			Naming.bind("//localhost/I2", new I2());            
            System.err.println("Server ready");
            
        } catch (Exception e) {
        	System.err.println("Server exception: " + e.toString());
          e.printStackTrace();
        }
	}

	@Override
	public String provider(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
