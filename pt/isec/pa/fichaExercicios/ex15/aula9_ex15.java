package pt.isec.pa.fichaExercicios.ex15;

public class aula9_ex15 {
    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        d.add("english", "BOOK", "Book");
        d.add("francais", "BOOK", "livre");
        d.add("portugues", "BOOK", "livro");
        d.add("english", "YEAR", "year");
        d.add("francais", "YEAR", "an");
        d.add("portugues", "YEAR", "ano");
        d.setLanguage("english");
        System.out.println(d.get("YEAR")); // year
        d.setLanguage("portugues");
        System.out.println(d.get("YEAR")); // ano
        d.setLanguage("francais");
        System.out.println(d.get("BOOK")); // livre
    }
}

/*
// Mapa de mapas
public class Dictionary {
    private final Map<String, Map<String, String>> dict_of_dict;
}
// Mapa de dicionários ( composição )
public class Dictionary {
    private class DictionaryOneLang {
        private final Map<String, String> dictionary;

    }

    private final Map<String, DictionaryOneLang> dict_of_dict
}
// Mapa de dicionários ( Herança )
public class Dictionary {
    private class DictionaryOneLang extends HashMap<String, String> {

    }
    private final Map<String, DictionaryOneLang> dict_of_dict;
}*/