import transformers.QueueTransformer;
import transformers.Transformer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

public class TransformerGUI {
    private JTextArea txtResponse;
    private JButton encolarButton;
    private JButton duplicarButton;
    private JTextField txtDuplicateFunction;
    private JTextField txtName;
    private JTextField txtFaccion;
    private JTextField txtPower;
    private JTextField txtFunction;
    private JPanel pGeneral;
    private JLabel t1;
    private JButton calcularPoderButton;
    Transformer newTransformer;
    QueueTransformer queueTransformer =new QueueTransformer();
    public TransformerGUI() {
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getName,getFaccion,getFunction;
                int getPower;
                txtName.grabFocus();
                getName=txtName.getText();
                getFaccion=txtFaccion.getText();
                getFunction=txtFunction.getText();
                try{
                    getPower=Integer.parseInt(txtPower.getText());
                    newTransformer =new Transformer(getName,getFaccion,getPower,getFunction);
                    queueTransformer.enqueueTransformers(newTransformer, txtResponse);
                    txtName.setText("");
                    txtFaccion.setText("");
                    txtFunction.setText("");
                    txtPower.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });
        duplicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value;
                value= txtDuplicateFunction.getText();
                try {
                    queueTransformer.createNewQueue(value,txtResponse);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Valor Incorrecto");
                    throw new RuntimeException("Valor Incorrecto");
                }
            }
        });
        calcularPoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    queueTransformer.calculatePower(txtResponse);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex);
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TransformerGUI");
        frame.setContentPane(new TransformerGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
