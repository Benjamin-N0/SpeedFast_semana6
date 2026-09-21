package vista;
import controlador.ControladorPedidos;
import modelo.Pedido;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class VentanaListaPedidos extends  JFrame{
    private JPanel PanelPrincipal;
    private JTable tabla;
    private JButton btnActualizar;

    private ControladorPedidos controlador;
    private DefaultTableModel modeloTabla;

    public VentanaListaPedidos(ControladorPedidos controlador) {

        this.controlador = controlador;

        //configuracion de ventana lista pedido
        setTitle("Lista de Pedidos");
        setContentPane(PanelPrincipal);
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //se crea el modelo de la tabla y se agregan las columnas
        modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Estado");

        tabla.setModel(modeloTabla);

        cargarPedidos();

        btnActualizar.addActionListener(e -> cargarPedidos());
    }

    private void cargarPedidos() {

        modeloTabla.setRowCount(0);

        for (Pedido pedido : controlador.getPedidos()) {

            Object[] fila = {
                    pedido.getId(),
                    pedido.getDireccion(),
                    pedido.getTipo(),
                    pedido.getEstado()
            };
            modeloTabla.addRow(fila);
        }
    }
}
