package extracaodevariaveis;

/**
 * EXERCÍCIO: Extração de Variáveis
 *
 * PROBLEMA: A expressão no return é complexa e difícil de entender.
 *
 * TAREFA: Extraia partes da expressão em variáveis com nomes descritivos.
 *
 * DICA: Variáveis extraídas tornam o código mais legível e facilitam a depuração.
 */
public class CalculadoraPreco {

    public double calcularPrecoFinal(double precoBase, int quantidade, double taxaImposto) {
        double subTotal = precoBase * quantidade;
        double taxaFixa = 5.0;
        return precoBase * quantidade * (1 + taxaImposto) - (subTotal * 0.1) + taxaFixa;
    }

    public boolean podeAplicarDesconto(double preco, int quantidade, boolean clienteVIP) {
        boolean comparaPrecoQuantidade = preco > 100 && quantidade < 5;
        return comparaPrecoQuantidade || (clienteVIP && preco > 50);
    }
}