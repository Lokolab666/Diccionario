package logic;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BinaryTreeTest {
    private BinaryTree<WordDictionary> wordDictionaryBinaryTree;


    private void setup(){
        wordDictionaryBinaryTree = new BinaryTree<>(WordDictionary.compareLetter);

        wordDictionaryBinaryTree.addNode(new WordDictionary("Pala", "asdadas", "word"));
    }

    @Test
    void findNode() {
        setup();
        assertNotNull(wordDictionaryBinaryTree.findNode(new WordDictionary("Pala", null, null)));
        wordDictionaryBinaryTree.listAmplitudedDown().forEach((num) -> System.out.println(num + "\t"));
    }
}