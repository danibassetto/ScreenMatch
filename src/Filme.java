public class Filme
{
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double somaDasAvaliacoes;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;

    void exibeFichaTecnica()
    {
        System.out.println("Nome do Filme: " + this.nome);
        System.out.println("Ano de lançamento: " + this.anoDeLancamento);
    }

    void avalia(double nota)
    {
        this.somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }
}