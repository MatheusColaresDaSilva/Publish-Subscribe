package com.mkyong.rmiclient;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.mkyong.rmiinterface.RMIInterface;

public class A1 implements ClienteInterface, Serializable{
	private static RMIInterface look_up;
	private static A1 a1 = new A1();
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		look_up = (RMIInterface) Naming.lookup("//localhost/I2");
		String txt = JOptionPane.showInputDialog("Mensagem");
			
		String response = look_up.subscribe(a1,txt);
		JOptionPane.showMessageDialog(null, response);
	}
}
