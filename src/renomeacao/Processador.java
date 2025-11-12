package renomeacao;

/**
 * EXERCÍCIO: Renomeação
 * 
 * PROBLEMA: Os nomes das variáveis e métodos não são claros e não expressam bem sua intenção.
 * 
 * TAREFA: Renomeie as variáveis e métodos para nomes mais descritivos e expressivos.
 * 
 * DICA: Nomes devem revelar a intenção do código. Evite abreviações e nomes genéricos.
 */
public class Processador {
    
    public void repetidordeTexto(String texto, int quantRepeticoes) {
        String textoRepetido = "";
        for (int i = 0; i < quantRepeticoes; i++) {
            textoRepetido = textoRepetido + texto;
        }
        System.out.println(textoRepetido);
    }
    
    public int calc(int a, int b) {
        return a * b + a + b;
    }
}

