package screenmatch.principal;
import screenmatch.modelos.Filme;
import screenmatch.modelos.Serie;
import screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        var filme3 = new Filme("Dogville", 2003);
        Serie lost = new Serie("Lost", 2000);
        filme3.avalia(10);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme3);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        // para cada variável do tipo Titulo na minha lista, faça..
        for (Titulo item: lista){
            System.out.println(item.getNome());
            if(item instanceof Filme && filme3.getClassificacao() > 2)
            {
                //Filme filme = (Filme)item;
                System.out.println("Classificação " + ((Filme) item).getClassificacao());
            }
        }

        // outras formas de percorrer a lista
        // lista.forEach(nome -> System.out.println(nome));
        // lista.forEach(System.out::println);

        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação: ");
        System.out.println(buscaPorArtista);

        System.out.println("Lista de títulos ordenados: ");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano: ");
        System.out.println(lista);
    }
}