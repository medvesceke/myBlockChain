
import java.util.ArrayList;
import java.util.List;


 

class Blockchain {
    public List<Block> chain;
    int difficulty;

    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(createGenesisBlock());
        this.difficulty=6;
    }

    private Block createGenesisBlock() {
        return new Block(0, "01/01/2017", "Genesis Block", "0");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Block newBlock) {
        newBlock.previousHash = getLatestBlock().hash;
        //newBlock.hash = newBlock.calculateHash();
        newBlock.mineBlock(this.difficulty);
        chain.add(newBlock);
    }
}

