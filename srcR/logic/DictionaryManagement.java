package logic;

import java.util.ArrayList;

public class DictionaryManagement {

    private ArrayList<BinaryTree<WordDictionary>> wordsDictionary;

    public DictionaryManagement(){
        wordsDictionary = new ArrayList(27);
        for (int i = 0; i < 27; i++){
            wordsDictionary.add(new BinaryTree<>(WordDictionary.compareLetter));
        }
    }

    public String convertCapitalLetter(String word){
        if ( word == null || word.isEmpty() ){
            return "No fue exitoso el procedimiento";
        }else {
            return word.toUpperCase().charAt(0) + word.substring(1, word.length()).toLowerCase();
        }
    }

    public String createWord(String[] dataEntryCreateWord){

        if (convertCapitalLetter(dataEntryCreateWord[0]) == "No fue exitoso el procedimiento"){
            return "Existe un dato vacio";
        }else {
            dataEntryCreateWord[0] = convertCapitalLetter(dataEntryCreateWord[0]);
        }

            if ( !dataEntryCreateWord[0].equals("") || !dataEntryCreateWord[1].equals("") || !dataEntryCreateWord[2].equals("") ){
                WordDictionary word = new WordDictionary(dataEntryCreateWord[0], dataEntryCreateWord[1], dataEntryCreateWord[2]);
                wordsDictionary.get(codeAscii(dataEntryCreateWord[0])).addNode(word);
                return "Letra agregada con exito";
            }else {
                return "Hay datos vacios";
            }
    }

    private int codeAscii(String wordFinally) {
        int codeFinally = 0;
        if ( wordFinally.charAt(0) - 65 == 165 ){
            return codeFinally = 26;
        }else {
            return codeFinally = wordFinally.charAt(0) - 65;
        }
    }

    public String deleteWord(String[] dataEntryDeleteWord){
        if (convertCapitalLetter(dataEntryDeleteWord[0]) == "No fue exitoso el procedimiento"){
            return "Existe un dato vacio";
        }else {
            dataEntryDeleteWord[0] = convertCapitalLetter(dataEntryDeleteWord[0]);
        }
        

        if ( wordsDictionary.get(codeAscii(dataEntryDeleteWord[0])).findNode(new WordDictionary(dataEntryDeleteWord[0],null,null)) == null ){
            return "Palabra no existe";
        }else {
            wordsDictionary.get(codeAscii(dataEntryDeleteWord[0])).deleteNode(wordsDictionary.get(codeAscii(dataEntryDeleteWord[0])).findNode(new WordDictionary(dataEntryDeleteWord[0],"","")));
            return "Palabra eliminada";
        }
    }

    public String[] searchWord(String[] dataEntrySearchWord){
        String[] searchInfo = new String[3];
        if (convertCapitalLetter(dataEntrySearchWord[0]) == "No fue exitoso el procedimiento"){
            return null;
        }else {
            dataEntrySearchWord[0] = convertCapitalLetter(dataEntrySearchWord[0]);
        }

        if (!dataEntrySearchWord[0].equals("")){
            if (wordsDictionary.get(codeAscii(dataEntrySearchWord[0])).findNode(new WordDictionary(dataEntrySearchWord[0],"","")) == null){
                return null;
            }else {
                searchInfo[0] = wordsDictionary.get(codeAscii(dataEntrySearchWord[0])).findNode(new WordDictionary(dataEntrySearchWord[0],"","")).getInfo().wordDictionary;
                searchInfo[1] = wordsDictionary.get(codeAscii(dataEntrySearchWord[0])).findNode(new WordDictionary(dataEntrySearchWord[0],"","")).getInfo().meancyWord;
                searchInfo[2] = wordsDictionary.get(codeAscii(dataEntrySearchWord[0])).findNode(new WordDictionary(dataEntrySearchWord[0],"","")).getInfo().wordTranslate;
                return searchInfo;
            }
        }else {
            return null;
        }
    }

    public String[][] showAllLetters() {


    }
/*
    public boolean existWord(String[] dataEntrySearch){
        WordDictionary wordDictionary = new WordDictionary(dataEntrySearch[0], null, null);

        if (dataEntrySearch[0].equals(){
            return true;
        }else {
            return false;
        }
    }












 */




}

/*

        int i;



        arbol.insertarDato("casa", "house", "lugar donde viven personas");
        arbol.insertarDato("arbol", "tree", "un arbol");
        arbol.insertarDato("palo", "stick", "palo");

        //arbol.buscarPalabra("arbol");

         = arbol.recorrer();

        for(i = 0; i<lista.size(); i++){

        }*/

