package gamedata;

import Player.Player;
import hand.PokerHand;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameFile {

    public static void writeData(String filename, Player playerObj, int winAmount) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("files/" + filename));

            out.writeUTF(playerObj.getId());
            out.writeUTF(playerObj.getName());

            PokerHand pokerHand = (PokerHand) playerObj.getHand();
            out.writeUTF(pokerHand.getHandDescr());
            out.writeInt(winAmount);
            out.writeInt(playerObj.getBank());

            out.close();
        } catch (IOException e) {
            System.out.println("Error writing data");
            e.printStackTrace();
        }
    }
}