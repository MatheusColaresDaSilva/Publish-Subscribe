package Tabelas;

import com.mkyong.rmiclient.ClienteInterface;

public class Subscriptions {

	private ClienteInterface node;
	
	private String mensagem;

	public ClienteInterface getNode() {
		return node;
	}

	public void setNode(ClienteInterface node) {
		this.node = node;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
