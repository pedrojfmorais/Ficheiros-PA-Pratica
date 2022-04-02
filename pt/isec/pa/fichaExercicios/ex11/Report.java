package pt.isec.pa.fichaExercicios.ex11;

import java.util.Arrays;

public class Report {

    private static final String regex = "[\\s,.!?]+";

    private String titulo;
    private String[] autores;
    private StringBuilder texto;

    public Report(String titulo){
        this.titulo = titulo;
        autores = new String[0];
        texto = new StringBuilder();
    }

    public int getNumberOfOccurrences(String word){


        String[] words = texto.toString().trim().split(regex);

        int count = 0;

        for (String w : words) {
            if(w.equals(word))
                ++count;
        }

        return count;
    }

    public int getNumberOfWords(){
        if (texto.length() == 0)
            return 0;
        return texto.toString().trim().split(regex).length;
    }

    public void capitalizeSentences(){
        boolean changeNext = true;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if(changeNext && Character.isLetter(c)){
                texto.setCharAt(i, Character.toUpperCase(c));
                changeNext = false;
            }else if(".!?".indexOf(c) >= 0)
                changeNext = true;
        }
    }

    public void addText(String text) {
        texto.append(text).append(System.lineSeparator());
    }

    public void removeAuthor(String author) {
        int i;
        for (i = 0; i < autores.length; i++) {
            if(autores[i].equals(author))
                break;
        }

        if(i == autores.length)
            return;

        for (; i < autores.length-1; i++) {
            autores[i] = autores[i+1];
        }

        autores = Arrays.copyOf(autores, autores.length-1);
    }

    public void addAuthor(String author) {

        for (String nome: autores) {
            if(nome.equals(author))
                return;
        }

        autores = Arrays.copyOf(autores, autores.length+1);
        autores[autores.length-1] = author;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(titulo).append(System.lineSeparator());
        sb.append("Autores: ").append(Arrays.toString(autores)).append(System.lineSeparator());
        sb.append(texto.toString()).append(System.lineSeparator());

        return sb.toString();
    }
}
