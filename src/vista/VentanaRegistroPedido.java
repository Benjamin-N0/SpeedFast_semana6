package vista;
import controlador.ControladorPedidos;
import modelo.Pedido;
import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {
    private JPanel panelPrincipal;
    private JTextField txtId;
    private JTextField txtDireccion;
    private JComboBox cbTipo;
    private JButton btnGuardar;
    private JLabel lblId;
    private JLabel lblDireccion;
    private JLabel lblTipo;

    private ControladorPedidos controlador;

    public VentanaRegistroPedido(ControladorPedidos controlador) {
        this.controlador = controlador;

        //configuracion de ventana regitro pedido
        setTitle("Registrar Pedido");
        setContentPane(panelPrincipal);
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //tipos de pedido para el combobox
        cbTipo.addItem("comida");
        cbTipo.addItem("encomienda");
        cbTipo.addItem("express");

        btnGuardar.addActionListener(e -> guardarPedido());
    }

    // aqui se valida y guarda el pedido
    private void guardarPedido() {

        String idTexto = txtId.getText();
        String direccion = txtDireccion.getText();

        if (idTexto.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        int id;
        try{
            id = Integer.parseInt(idTexto);

            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "El ID debe ser mayor que 0");
                return;
            }
        }catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "El ID debe ser un numero");
            return;
        }

        String tipo = cbTipo.getSelectedItem().toString();

        Pedido pedido = new Pedido(id, direccion, tipo);

        controlador.agregarPedido(pedido);

        JOptionPane.showMessageDialog(
                this,
                "Pedido registrado correctamente"
        );
        txtId.setText("");
        txtDireccion.setText("");
    }
}
