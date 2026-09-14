
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    Pedido pedido;
    Pizza pizzaVazia;

    @BeforeEach
    public void setUp() {
        //Arrange
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedido.adicionarPizza(pizzaVazia);
    }

    @Test
    public void adicionaVariasPizzasCorretamente() {
        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
        //Assert
        assertEquals(2, quantidade);
    }

    @Test
    public void naoAdicionaPizzaEmPedidoFechado() {
        //Arrange
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());

        //Assert
        assertEquals(1, quantidade);
    }

    @Test 
    public void calculaValorPedidoCorretamente(){
        //Act
        double valor = pedido.precoAPagar();

        //Assert
        assertEquals(29d,valor, 0.01);
    }
    @Test
    public void calculaPrecoDePedidoComVariasPizzas(){
        //Arrange
        Pizza pizza2Ingrediente=new Pizza(2);
        pedido.adicionarPizza(pizza2Ingrediente);
        //Act
        double valor = pedido.precoAPagar();
        //Assert
        assertEquals(68d,valor, 0.01);
    }
    @Test
    public void geraRelatorioDePedido(){
        //Act
        String relatorio = pedido.relatorio();

        //Assert
        assertTrue(
            relatorio.contains("29,00")&&
            relatorio.contains("1 Pizza")&&
            relatorio.contains ("aberto")
        );
    }
}
