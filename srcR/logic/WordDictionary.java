package logic;
/**
 * Clase del objeto el cual contiene los atributos de Palabra.
 * @version 0.1.2.9
 * @Author Cristian Fandiño y Jenifer Gómez
 */
import java.util.Comparator;

/**
 * Clase que contiene los atributos del objeto Palabra
 * Atributo wordDictionary que tiene la palabra
 * Atributo wordTranslate que contiene la traducción de la palabra.
 * Atributo meancyWord que contiene la definición de esa palabra.
 */
public class WordDictionary {
    String wordDictionary;
    String wordTranslate;
    String meancyWord;

    /**
     * Constructor que recibe los atributos e inicializa las variables.
     * @param wordDictionary Palabra
     * @param meancyWord Definicion de la palabra
     * @param wordTranslate Traducción de la palabra
     */
    public WordDictionary(String wordDictionary, String meancyWord, String wordTranslate) {
        this.wordDictionary = wordDictionary;
        this.meancyWord = meancyWord;
        this.wordTranslate = wordTranslate;
    }

    /**
     * Metodo que obtiene la palabra
     * @return String Palabra.
     */
    public String getWordDictionary() {
        return wordDictionary;
    }

    /**
     * Metodo que edita la palabra.
     * @param wordDictionary Contiene la palabra ya editada.
     */
    public void setWordDictionary(String wordDictionary) {
        this.wordDictionary = wordDictionary;
    }

    /**
     * Metodo que obtiene la traducción de la palabra
     * @return String con la traducción que contenga.
     */
    public String getWordTranslate() {
        return wordTranslate;
    }

    /**
     * Metodo que edita la traducción de la palabra.
     * @param wordTranslate Contiene la palabra traducida ya editada.
     */
    public void setWordTranslate(String wordTranslate) {
        this.wordTranslate = wordTranslate;
    }

    /**
     * Metodo que obtiene la definición de la palabra.
     * @return String con la definición de la palabra.
     */
    public String getMeancyWord() {
        return meancyWord;
    }

    /**
     * Metodo que edita la definición de la palabra
     * @param meancyWord la definición de la palabra ya editada,
     */
    public void setMeancyWord(String meancyWord) {
        this.meancyWord = meancyWord;
    }

    /**
     * Metodo Comparator para realizar la comparación de palabras en el arbol de acuerdo con la primera letra de la palabra. Compara las dos palabras que llegan.
     */
    public static Comparator<WordDictionary> compareLetter = (l1, l2 ) -> l1.getWordDictionary().compareTo( l2.getWordDictionary() );

    /**
     * Metodo para mostrar la información de una palabra en pantalla
     * @return String con la información y atributos de la palabra.
     */
    @Override
    public String toString() {
        return "WordDictionary{" +
                "wordDictionary='" + wordDictionary + '\'' +
                ", wordTranslate='" + wordTranslate + '\'' +
                ", meancyWord='" + meancyWord + '\'' +
                '}';
    }
}
