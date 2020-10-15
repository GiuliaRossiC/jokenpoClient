package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterJokenpo extends Remote{
    
    public boolean validarJogada(String jogada) throws RemoteException;
    public String retornarVencedor (String player1, String player2, String jogadaPlayer1, String jogadaPlayer2) throws RemoteException;
}
