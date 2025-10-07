public class Main {
    public static void main(String[] args) {
        Blockchain myBlockchain = new Blockchain();
        myBlockchain.addBlock(new Block(1, "02/01/2017", "Second block", ""));
        myBlockchain.addBlock(new Block(2, "03/01/2017", "Third block", ""));
        myBlockchain.addBlock(new Block(3, "04/01/2017", "forth block", ""));
        myBlockchain.addBlock(new Block(4, "05/01/2017", "fifth block", ""));

        for (Block block : myBlockchain.chain) {
            System.out.println("Index: " + block.index);
            System.out.println("Timestamp: " + block.timestamp);
            System.out.println("Data: " + block.data);
            System.out.println("Previous Hash: " + block.previousHash);
            System.out.println("Hash: " + block.hash);
            System.out.println();
        }

        System.out.println("last:::"+myBlockchain.getLatestBlock().hash);
    }

    
}