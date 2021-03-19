package logic;
/**
 * Clase para realizar la gestión de los árboles binarios creados por letra en las que se almacenan los datos de la
 * palabra, la definición y su traducción
 *
 * @version 0.1.2.9
 * @Author Cristian Fandiño y Jenifer Gómez
 */


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Clase gestión para administrar los arboles binarios creados por palabras y el CRUD de las letras
 */
public class DictionaryManagement {

    private ArrayList<BinaryTree<WordDictionary>> wordsDictionary; //Crear un array dinamico que contenga los arboles de las palabras


    /**
     * Constructor de la clase DictionaryManagement en la que se inicializan los 27 arboles.
     * Son 27 porque existen en el abecedario ese número de palabras, inclyyendo la eñe
     */
    public DictionaryManagement(){
        wordsDictionary = new ArrayList(27);
        for (int i = 0; i < 27; i++){
            wordsDictionary.add(new BinaryTree<>(WordDictionary.compareLetter));
        }
    }

    /**
     * Metodo para convertir la primera letra que se ingresa en mayuscula
     * @param word Palabra a la cual se le va a convertir la primera letra en mayuscula.
     * @return String si se hace la conversión con toUpperCase
     */
    public String convertCapitalLetter(String word){
        if ( word == null || word.isEmpty() ){
            return "No fue exitoso el procedimiento";
        }else {
            return word.toUpperCase().charAt(0) + word.substring(1, word.length()).toLowerCase();
        }
    }

    /**
     *Metodo para crear una nueva palabra. Recibe un vector String en el que contiene los datos obtenidos en la interfaz o en los JTextFields
     * Para el primer dato de dataEntryCreateWord, se almacena el dato palabra
     * Para el segundo dato de dataEntryCreateWord, se almacena el dato del significado
     * Para el tercer dato de dataEntryCreateWord, se almacena el dato de la traducción
     * También, se ingresa al Metodo codeAscii que se le envia el primer dataEntryCreateWord para obtemer de la primera letra en código ASCII y agregar la palabra en su correspondiente árbol mediante esa clave
     * @param dataEntryCreateWord Array unidimensional que contiene los datos obtenidos en la interfaz para crear una nueva palabra.
     * @return String donde indica el resultado de la operación
     */
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

    /**
     * Metodo que obtiene la primera letra y convierte la letra en su respectivo código ASCII. Se da desde el 65 porque alli comienza el codigo de las letras mayusculas.
     * Se observa que tiene dentro del condicional, un comparador a 165, esto porque ese número es la letra eñe mayuscuyla.
     * @param wordFinally Entero que contiene la conversión a código ASCII de la primera letra.
     * @return int 26 si no se cumple la condición de ser 165, y se le asigna su respectivo número (del 1 al 26). Cuando si cumple, entonces retorna 26 porque la eñe se encuentra en esa posición del ArrayList.
     */
    private int codeAscii(String wordFinally) {
        int codeFinally = 0;
        if ( wordFinally.charAt(0) - 65 == 165 ){
            return codeFinally = 26;
        }else {
            return codeFinally = wordFinally.charAt(0) - 65;
        }
    }

    /**
     * En este Metodo, elimina la palabra, Nuevamente ingresa a la conversión de la primera letra en mayuscula. Luego de ello, obtiene el código ASCII para ubicar el arbol y por último eliminar este nodo, si se encuentra registrado
     * @param dataEntryDeleteWord  Array unidimensional que contiene los datos obtenidos en la interfaz para eliminar la palabra contenida.
     * @return String dando a indicar si se logro eliminar la palabra o el nodo.
     */
    public String deleteWord(String[] dataEntryDeleteWord){
        if (convertCapitalLetter(dataEntryDeleteWord[0]) == "No fue exitoso el procedimiento"){
            return "Existe un dato vacio";
        }else {
            dataEntryDeleteWord[0] = convertCapitalLetter(dataEntryDeleteWord[0]);
        }

        if ( wordsDictionary.get(codeAscii(dataEntryDeleteWord[0])).findNode(new WordDictionary(dataEntryDeleteWord[0],null,null)) == null ){
            return "Palabra no existe";
        }else {
            wordsDictionary.get(codeAscii(dataEntryDeleteWord[0])).deleteNode(wordsDictionary.get(codeAscii(dataEntryDeleteWord[0])).findNode(new WordDictionary(dataEntryDeleteWord[0],null,null)));
            return "Palabra eliminada";
        }
    }

    /**
     * Metodo que busca la palabra. Realiza las mismas condiciones (convertir primera letra en mayuscula y convertirla en su código ASCII).
     * Verifica que la palabra o el nodo exissta y sea diferente de null, para poder obtener los datos o atributos de esa palabra.
     * @param dataEntrySearchWord  Array unidimensional que contiene los datos obtenidos en la interfaz para buscar la palabra.
     * @return String[] con los atributos de la palabra para mostrarlos en la interfaz o null cuando existe un error.
     */
    public String[] searchWord(String[] dataEntrySearchWord){
        String[] searchInfo = new String[3];
        if (convertCapitalLetter(dataEntrySearchWord[0]) == "No fue exitoso el procedimiento"){
            return null;
        }else {
            dataEntrySearchWord[0] = convertCapitalLetter(dataEntrySearchWord[0]);
        }

        if (!dataEntrySearchWord[0].equals("") || !dataEntrySearchWord[1].equals("") || !dataEntrySearchWord[2].equals("")){
            if (wordsDictionary.get(codeAscii(dataEntrySearchWord[0])).findNode(new WordDictionary(dataEntrySearchWord[0],null,null)) == null){
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

    /**
     *Metodo que envia todas las palabras del diccionario.
     * En este Metodo, primero se obtiene el tamaño de todos los árboles. Despues, crea un ArrayList para poder obtener todas las letras en un solo parametro.
     * Continuando, se crea una variabla de tipo String[][] o un arreglo bidimensional en el que se almacena la palabra con sus respectivos atributos con ayuda de dos ciclos (uno anidado del otro
     * @return String[][] o arreglo bidimensional con los datos
     */
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

    /**
     * Metodo que muestra las palabras de una sola letra. Nuevamente se convierte en la primera letra en mayuscula, obtiene el código ASCII de esa letra para obtener su arbol.
     * Se crea un ArrayList o arreglo bidimensional en el que se almacenan los datos con esa primera letra, guardandolos en orden.
     * @param dataEntryShowALetter  Array unidimensional que contiene los datos obtenidos en la interfaz, en este caso contiene la letra a la cual se quiere listar las palabras.
     * @return String[][] arreglo bidimensial, con los atributos de cada palabra que comience con esa palabra.
     */
    public String[][] showALetter(String @NotNull [] dataEntryShowALetter){
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

    /**
     * Metodo para buscar una palabra a editar. Recibe la palabra a buscar, se crea un arreglo unidimensional para almacenar los datos de los atributos de la palabra.
     * Nuevamente, se convierte la primera letra en mayuscula y obtiene el código ASCII.
     * Busca la palabra con ayuda de findNode y valida que tenga la misma palabra.
     * Se almacenan esos datos para mostrarlos en la interfaz y poderlos editar.
     * @param dataEntrySearchEditWord  Array unidimensional que contiene los datos obtenidos en la interfaz. En este caso, contiene la palabra a la que se quiere editar.
     * @return String[] con los datos obtenidos de la palabra a editar
     */
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

                return searchInfo;
            }
        }
        return null;
    }

    /**
     * Metodo para enviar la palabra editada al árbol binario. Primero, convierte la primera letra en mayuscula para identificarlo más facilmente en el código ASCII
     * Verifica que no entren datos vacios.
     * Este Metodo es similar al createWord, agrega el arreglo unidimensal con los atributos correspondientes.
     * @param dataEntryEditWord  Array unidimensional que contiene los datos obtenidos en la interfaz. En este caso, contiene los atributos ya modificados de la palabra.
     * @return String mensaje en el que muestra el resultado de la operación
     */
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

    /**
     * Metodo que elimina la palabra modificada para reemplazarla por la ya creada y/o edita.
     * Convierte la primera letra en mayuscula y obtiene su codigo ASCII para hacer la eliminación.
     * @param captureDataSendEditWord  Array unidimensional que contiene los datos obtenidos en la interfaz. En este caso, contiene la palabra a la que se le quiere eliminar.
     */
    public void deleteWordInSearch(String[] captureDataSendEditWord) {
        String[] searchInfo = new String[3];
        if (convertCapitalLetter(captureDataSendEditWord[0]) != "No fue exitoso el procedimiento"){
            captureDataSendEditWord[0] = convertCapitalLetter(captureDataSendEditWord[0]);
        }

        if (!captureDataSendEditWord[0].equals("")){
            if (wordsDictionary.get(codeAscii(captureDataSendEditWord[0])).findNode(new WordDictionary(captureDataSendEditWord[0],null, null)) != null){
                wordsDictionary.get(codeAscii(captureDataSendEditWord[0])).deleteNode(wordsDictionary.get(codeAscii(captureDataSendEditWord[0])).findNode(new WordDictionary(captureDataSendEditWord[0],null,null)));
            }
        }
    }
}