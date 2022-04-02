package pt.isec.pa.fichaExercicios.ex15;

import java.util.HashMap;
import java.util.Map;

/*
public class Dictionary {

    private final Map<String, Map<String, String>> dict_of_dict;
    private String language;

    public Dictionary() {
        dict_of_dict = new HashMap<>();
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void add(String language, String word, String translation) {
        if(!dict_of_dict.containsKey(language))
            dict_of_dict.put(language, new HashMap<String, String>());
        dict_of_dict.get(language).put(word, translation);
    }
    public String get(String word) {
        return dict_of_dict.get(language).get(word);
    }

}
*/


/*public class Dictionary {
    private class DictionaryOneLang {
        private final Map<String, String> dictionary;

        private DictionaryOneLang() {
            dictionary = new HashMap<>();
        }

        private void add(String word, String translation) {
            dictionary.put(word, translation);
        }
        private String get(String word) { return dictionary.get(word); }

    }

    private final Map<String, DictionaryOneLang> dict_of_dict;
    private String language;

    public Dictionary() {
        dict_of_dict = new HashMap<>();
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void add(String language, String word, String translation) {
        if(!dict_of_dict.containsKey(language))
            dict_of_dict.put(language, new DictionaryOneLang());
        dict_of_dict.get(language).add(word, translation);
    }

    public String get(String word) {
        return dict_of_dict.get(language).get(word);
    }


}
*/



public class Dictionary {
    private class DictionaryOneLang extends HashMap<String, String> {

    }

    private final Map<String, DictionaryOneLang> dict_of_dict;
    private String language;

    public Dictionary() {
        dict_of_dict = new HashMap<>();
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
    public void add(String language, String word, String translation) {
        if(!dict_of_dict.containsKey(language))
            dict_of_dict.put(language, new DictionaryOneLang());
        dict_of_dict.get(language).put(word, translation);
    }

    public String get(String word) {
        return dict_of_dict.get(language).get(word);
    }

}
