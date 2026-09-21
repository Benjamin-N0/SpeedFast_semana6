package controlador;
import modelo.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ControladorPedidos {
    private List<Pedido> pedidos;

    public ControladorPedidos() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

}
