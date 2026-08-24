
import java.util.LinkedList;
import java.util.List;

public class XulambsApp {

    static List<Pizza> pizzas;

    private void cabecalho() {
        System.out.println("XULAMBS PIZZA v0.1.");
        System.out.println("==================");
    }

    private int menuPrincipal() {
        cabecalho();
        System.out.println("1 - Comprar uma pizza");
        System.out.println("2 - Ver pizzas vendidas");
        System.out.println("0 - Finalizar");

        return Integer.parseInt(IO.readln("Digite sua opção:"));
    }

    private void comprarPizza() {
        cabecalho();
        System.out.println("Comprando uma pizza:");
        int adicionais = escolherIngredientes();
        Pizza novaPizza = new Pizza(adicionais);
        mostrarNota(novaPizza);
        pizzas.add(novaPizza);

    }

    int escolherIngredientes() {
        return Integer.parseInt(IO.readln("Quantos adicionais?"));
    }

    private void mostrarNota(Pizza novaPizza) {
        System.out.println("################");
        System.out.println(novaPizza.gerarCupom());
        System.out.println("################");
    }

    private void mostrarPizzas() {
        cabecalho();
        for (Pizza pizza: pizzas) {
            mostrarNota(pizza);
            IO.println();
        }
    }

    void main() {
        int opcao;
        pizzas=new LinkedList<>();
        do {
            opcao = menuPrincipal();
            switch (opcao) {
                case 1 ->
                    comprarPizza();
                case 2 ->
                    mostrarPizzas();
                case 0 ->
                    IO.println("Encerrando!!");
                default ->
                    IO.println("Opção inválida.");
            }
        } while (opcao != 0);

    }

}
