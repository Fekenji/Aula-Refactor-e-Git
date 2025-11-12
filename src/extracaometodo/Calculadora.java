package extracaometodo;

/**
 * EXERCÍCIO: Extração de Método
 * 
 * PROBLEMA: O método calcularTotal() está fazendo muitas coisas e tem código duplicado.
 * 
 * TAREFA: Extraia os cálculos de desconto e imposto em métodos separados.
 * 
 * DICA: Identifique blocos de código que fazem uma coisa específica e extraia-os em métodos nomeados.
 */
public class Calculadora {
    
    public double calcularTotal(double preco, int quantidade, boolean temDesconto, boolean temImposto) {
        double subtotal = preco * quantidade;
        if (temDesconto) calcularDesconto(subtotal, quantidade);
        if (temImposto) calcularImposto(subtotal, quantidade);
        return subtotal;
    }

    public double calcularDesconto(double subtotal, int quantidade) {
        // Cálculo de desconto
        if (quantidade > 10) {
            subtotal = subtotal - (subtotal * 0.15);
        } else if (quantidade > 5) {
            subtotal = subtotal - (subtotal * 0.10);
        } else {
            subtotal = subtotal - (subtotal * 0.05);
        }
        return subtotal;
    }

    public double calcularImposto(double subtotal, int quantidade) {
        if (subtotal > 1000) {
            subtotal = subtotal + (subtotal * 0.20);
        } else if (subtotal > 500) {
            subtotal = subtotal + (subtotal * 0.15);
        } else {
            subtotal = subtotal + (subtotal * 0.10);
        }
        return subtotal;
    }
}

