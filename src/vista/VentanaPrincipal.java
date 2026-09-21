package vista;

import controlador.ControladorPedidos;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private JButton btnRegistrar;
    private JButton btnLista;
    private JButton btnEntrega;
    private JPanel panelPrincipal;

    private ControladorPedidos controlador;

    public VentanaPrincipal(ControladorPedidos controlador) {
        this.controlador = controlador;

        //configuracion de ventana principal
        setTitle("SPEEDFAST v0.6.1");
        setContentPane(panelPrincipal);
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //boton para abrir ventana registro pedido
        btnRegistrar.addActionListener(e -> {VentanaRegistroPedido ventana = new VentanaRegistroPedido(controlador);

            ventana.setVisible(true);
        });

        //boton para abrir ventana de lista pedidos
        btnLista.addActionListener(e -> {VentanaListaPedidos ventana = new VentanaListaPedidos(controlador);

            ventana.setVisible(true);
        });

        //boton para abrir ventana para asignar repartidor/ entrega
        btnEntrega.addActionListener(e -> {VentanaEntrega ventana = new VentanaEntrega(controlador);

            ventana.setVisible(true);
        });
    }
}
