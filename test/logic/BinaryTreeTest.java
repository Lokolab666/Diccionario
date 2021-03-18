package logic;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BinaryTreeTest {
    private BinaryTree<WordDictionary> wordDictionaryBinaryTree;
    private DictionaryManagement dictionaryManagement;


    private void setup(){
        wordDictionaryBinaryTree = new BinaryTree<>(WordDictionary.compareLetter);

        wordDictionaryBinaryTree.addNode(new WordDictionary("Pala", "asdadas", "word"));
        wordDictionaryBinaryTree.addNode(new WordDictionary("Arb", "asdaxxdas", "woryud"));
        wordDictionaryBinaryTree.addNode(new WordDictionary("Qwe", "zzz", "wordkjky"));
        wordDictionaryBinaryTree.addNode(new WordDictionary("Psdasfala", "xx", "woyuird"));
        wordDictionaryBinaryTree.addNode(new WordDictionary("Fage", "asdaccccdas", "yuiy"));

    }

    @Test
    void findNode() {
     /*   setup();
        assertNotNull(wordDictionaryBinaryTree.findNode(new WordDictionary("Pala", null, null)));
        wordDictionaryBinaryTree.listInOrder().forEach((num) -> System.out.println(num + "\t"));

      */

        dictionaryManagement = new DictionaryManagement();
        String[] dataEntryNewWord = {
                "Pala",
                "asdasd",
                "sdasdasdasdasd"
        };
        System.out.println(dictionaryManagement.createWord(dataEntryNewWord));


        for (int i = 0; i < dictionaryManagement.showAllLetters().length; i++){
            System.out.println(dictionaryManagement.showAllLetters()[i][0]);
            System.out.println(dictionaryManagement.showAllLetters()[i][1]);
            System.out.println(dictionaryManagement.showAllLetters()[i][2]);
        }




    }
}