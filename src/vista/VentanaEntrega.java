package vista;
import controlador.ControladorPedidos;
import modelo.Pedido;
import javax.swing.*;

public class VentanaEntrega extends JFrame{
    private JPanel panelprincipal;
    private JComboBox cbRepartidor;
    private JComboBox cbPedido;
    private JButton btnIniciar;
    private JLabel lblRepatidor;

    private ControladorPedidos controlador;

    public VentanaEntrega(ControladorPedidos controlador) {

        this.controlador = controlador;

        //configuracion de ventana entrega
        setTitle("Asignar Repartidor");
        setContentPane(panelprincipal);
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //combobox con repartidores
        cbRepartidor.addItem("Pepe Grillo");
        cbRepartidor.addItem("Juan Carlos Bodoque");
        cbRepartidor.addItem("Tulio Trivinio");

        //se agregan los pedidos que esten con el estado Pendiente
        for (Pedido pedido : controlador.getPedidos()) {

            if (pedido.getEstado().equals("Pendiente")) {
                cbPedido.addItem(pedido);
            }
        }
        // Al presionar el boton se inicia la entrega
        btnIniciar.addActionListener(e -> iniciarEntrega());
    }

    // aqui se encarga de asignar el pedido al repartidor
    private void iniciarEntrega() {

        //se comprueba que existan pedidos
        if (cbPedido.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this, "No hay pedidos pendientes");
            return;
        }

        Pedido pedido = (Pedido) cbPedido.getSelectedItem();

        //se comprueba nuevamente en caso que ya se haya asignado a otro repartidor
        if (!pedido.getEstado().equals("Pendiente")) {
            JOptionPane.showMessageDialog(this, "Este pedido ya fue asignado a otro repartidor");
            return;
        }

        //se obtiene el repartidor selecionado, se cambia el estado a "En reparto" y se lanza un mensaje de inicio de entrega
        String repartidor = cbRepartidor.getSelectedItem().toString();
        pedido.setEstado("En reparto");
        JOptionPane.showMessageDialog(this, "El repartidor " + repartidor + " inició la entrega del pedido #" + pedido.getId()
        );
    }
}
