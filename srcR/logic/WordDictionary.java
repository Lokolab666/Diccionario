package logic;

import java.util.Comparator;

public class WordDictionary {
    String wordDictionary;
    String wordTranslate;
    String meancyWord;

    public WordDictionary(String wordDictionary, String meancyWord, String wordTranslate) {
        this.wordDictionary = wordDictionary;
        this.meancyWord = meancyWord;
        this.wordTranslate = wordTranslate;
    }

    public String getWordDictionary() {
        return wordDictionary;
    }

    public void setWordDictionary(String wordDictionary) {
        this.wordDictionary = wordDictionary;
    }

    public String getWordTranslate() {
        return wordTranslate;
    }

    public void setWordTranslate(String wordTranslate) {
        this.wordTranslate = wordTranslate;
    }

    public String getMeancyWord() {
        return meancyWord;
    }

    public void setMeancyWord(String meancyWord) {
        this.meancyWord = meancyWord;
    }

    public static Comparator<WordDictionary> compareLetter = (l1, l2 ) -> l1.getWordDictionary().compareTo( l2.getWordDictionary() );

    @Override
    public String toString() {
        return "WordDictionary{" +
                "wordDictionary='" + wordDictionary + '\'' +
                ", wordTranslate='" + wordTranslate + '\'' +
                ", meancyWord='" + meancyWord + '\'' +
                '}';
    }
}
