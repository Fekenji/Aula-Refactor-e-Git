package extracaodeclasses;

/**
 * EXERCÍCIO: Extração de Classes
 * 
 * PROBLEMA: A classe Relatorio tem muitas responsabilidades: formatação, cálculo e impressão.
 * 
 * TAREFA: Extraia a lógica de formatação em uma classe separada chamada FormatadorRelatorio.
 * 
 * DICA: Quando uma classe tem muitas responsabilidades, extraia grupos relacionados
 * de dados e métodos em uma nova classe.
 */
public class Relatorio {
    private String titulo;
    private String conteudo;
    private String rodape;
    private FormatadorRelatorio formatadorRelatorio = new FormatadorRelatorio();
    public Relatorio(String titulo, String conteudo, String rodape) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.rodape = rodape;
    }
    
    public void imprimir() {
        // Formatação do título
        formatadorRelatorio.formatarTitulo(titulo);
        // Formatação do conteúdo
        formatadorRelatorio.formatarConteudo(conteudo);
        // Formatação do rodapé
        formatadorRelatorio.formatarRodape(rodape);
    }
    
    public double calcularTotal(double[] valores) {
        double total = 0;
        for (double valor : valores) {
            total += valor;
        }
        return total;
    }
}

