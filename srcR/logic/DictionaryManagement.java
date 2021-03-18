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

        if (!dataEntrySearchWord[0].equals("") || !dataEntrySearchWord[1].equals("") || !dataEntrySearchWord[2].equals("")){
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
        int aux = 0;
        int auxTwo = 0;
        int x = 0;
        for (int i = 0; i < wordsDictionary.size()-1 ; i++){
            aux = wordsDictionary.get(i).weightTree();
            auxTwo = aux + auxTwo;
        }

        ArrayList<ArrayList<WordDictionary>> getLetter = new ArrayList<ArrayList<WordDictionary>>();
        for (int i = 0; i < wordsDictionary.size()-1; i++){
            if (i == 14){
                if (!wordsDictionary.isEmpty()){
                    getLetter.add(wordsDictionary.get(26).listInOrder());
                }
            }
            if (!wordsDictionary.isEmpty()){
                getLetter.add(wordsDictionary.get(i).listInOrder());
            }
        }

        String[][] out = new String[auxTwo][3];
        for (int i = 0; i < getLetter.size(); i++){
            for (int j = 0; j < getLetter.get(i).size(); j++){
                out[x][0] = getLetter.get(i).get(j).getWordDictionary();
                out[x][1] = getLetter.get(i).get(j).getMeancyWord();
                out[x][2] = getLetter.get(i).get(j).getWordTranslate();
                x++;

            }
        }
        return out;
    }

    public String[][] showALetter(String[] dataEntryShowALetter){
        int aux = 0;
        int auxTwo = 0;
        int x = 0;

        if (convertCapitalLetter(dataEntryShowALetter[0]) == "No fue exitoso el procedimiento"){
            return null;
        }else {
            dataEntryShowALetter[0] = convertCapitalLetter(dataEntryShowALetter[0]);
        }

        if (!dataEntryShowALetter.equals("")){
            if (wordsDictionary.get(codeAscii(dataEntryShowALetter[0])).listInOrder() == null){
                return null;
            }else {
                ArrayList<WordDictionary> showInfoLetter = new ArrayList<>();
                showInfoLetter = wordsDictionary.get(codeAscii(dataEntryShowALetter[0])).listInOrder();


                String[][] out = new String[showInfoLetter.size()][3];
                for (int i = 0; i < showInfoLetter.size(); i++){
                        out[x][0] = showInfoLetter.get(i).getWordDictionary();
                        out[x][1] = showInfoLetter.get(i).getMeancyWord();
                        out[x][2] = showInfoLetter.get(i).getWordTranslate();
                        x++;
                }
                return out;
            }
        }
        return null;
    }

    public String[] searchEditWord(String[] dataEntrySearchEditWord){
        String[] searchInfo = new String[3];
        if (convertCapitalLetter(dataEntrySearchEditWord[0]) == "No fue exitoso el procedimiento"){
            return null;
        }else {
            dataEntrySearchEditWord[0] = convertCapitalLetter(dataEntrySearchEditWord[0]);
        }

        if (!dataEntrySearchEditWord[0].equals("")){
            if (wordsDictionary.get(codeAscii(dataEntrySearchEditWord[0])).findNode(new WordDictionary(dataEntrySearchEditWord[0],null, null)) == null){
                return null;
            }else {
                searchInfo[0] = wordsDictionary.get(codeAscii(dataEntrySearchEditWord[0])).findNode(new WordDictionary(dataEntrySearchEditWord[0], null, null)).getInfo().getWordDictionary();
                searchInfo[1] = wordsDictionary.get(codeAscii(dataEntrySearchEditWord[0])).findNode(new WordDictionary(dataEntrySearchEditWord[0], null, null)).getInfo().getMeancyWord();
                searchInfo[2] = wordsDictionary.get(codeAscii(dataEntrySearchEditWord[0])).findNode(new WordDictionary(dataEntrySearchEditWord[0], null, null)).getInfo().getWordTranslate();
             //   wordsDictionary.get(codeAscii(dataEntrySearchEditWord[0])).deleteNode(wordsDictionary.get(codeAscii(dataEntrySearchEditWord[0])).findNode(new WordDictionary(dataEntrySearchEditWord[0],null,null)));

                return searchInfo;
            }
        }
        return null;
    }

    public String editWord(String[] dataEntryEditWord){

        if (convertCapitalLetter(dataEntryEditWord[0]) == "No fue exitoso el procedimiento"){
            return "Existe un dato vacio";
        }else {
            dataEntryEditWord[0] = convertCapitalLetter(dataEntryEditWord[0]);
        }

        if (!dataEntryEditWord[0].equals("") || !dataEntryEditWord[1].equals("") || !dataEntryEditWord[2].equals("")){
                WordDictionary word = new WordDictionary(dataEntryEditWord[0], dataEntryEditWord[1], dataEntryEditWord[2]);
                wordsDictionary.get(codeAscii(dataEntryEditWord[0])).addNode(word);
                return "Letra editada con exito";
        }
        return "Error";
    }


    public void deleteWordInSearch(String[] captureDataSendEditWord) {
        String[] searchInfo = new String[3];
        if (convertCapitalLetter(captureDataSendEditWord[0]) == "No fue exitoso el procedimiento"){

        }else {
            captureDataSendEditWord[0] = convertCapitalLetter(captureDataSendEditWord[0]);
        }

        if (!captureDataSendEditWord[0].equals("")){
            if (wordsDictionary.get(codeAscii(captureDataSendEditWord[0])).findNode(new WordDictionary(captureDataSendEditWord[0],null, null)) == null){

            }else {
               wordsDictionary.get(codeAscii(captureDataSendEditWord[0])).deleteNode(wordsDictionary.get(codeAscii(captureDataSendEditWord[0])).findNode(new WordDictionary(captureDataSendEditWord[0],null,null)));


            }
        }


    }
}