import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


class Block {
    public int index;
    public String timestamp;
    public String data;
    public String previousHash;
    public String hash;
    public int nonce;

    public Block(int index, String timestamp, String data, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
        this.nonce=0;
    }

    public void mineBlock(int difficulty) {
    String target = new String(new char[difficulty]).replace('\0', '0'); // npr. "0000"
    while (!hash.substring(0, difficulty).equals(target)) {
        // Dodamo nekaj, da se hash spreminja (npr. nonce)
        nonce++;
        hash = calculateHash();
    }
    System.out.println("Block mined: " + hash);
}

   

    public String calculateHash() {
        try {
            String input = index + previousHash + timestamp + data + nonce ;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
