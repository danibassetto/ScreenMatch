package screenmatch.calculos;
import screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal = 0;

    public int getTempoTotal() {
        return tempoTotal;
    }

//    public void inclui(Filme filme) {
//        tempoTotal += filme.getDuracaoEmMinutos();
//    }

//    public void inclui(Serie serie) {
//        tempoTotal += serie.getDuracaoEmMinutos();
//    }

    public void inclui(Titulo titulo){
        System.out.println("Adicionando duração em minutos de " + titulo);
        tempoTotal += titulo.getDuracaoEmMinutos();
    }


}