package remocaodeflags;

/**
 * EXERCÍCIO: Remoção de Flags
 * 
 * PROBLEMA: O código usa uma flag booleana para controlar o comportamento,
 * tornando o método difícil de entender e manter.
 * 
 * TAREFA: Remova a flag e crie métodos separados para cada comportamento.
 * 
 * DICA: Flags tornam o código menos claro. Prefira métodos separados ou polimorfismo.
 */
public class ProcessadorPedido {
    
    public void processarsemDesconto(Pedido pedido) {
        System.out.println("Valor sem desconto: " + pedido.getValor());
    }

    public void processarcomDesconto(Pedido pedido) {
        double valor = pedido.getValor();
        valor = valor * 0.9;
        System.out.println("Desconto aplicado: " + valor);
    }
}

