package transformers;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTransformer {
    private Queue<Transformer> queue= new LinkedList<Transformer>();
    private Queue<Transformer> queue2;
    int counter=5;

    public void enqueueTransformers(Transformer t1, JTextArea textArea){
        if(counter ==5){
            Transformer tr2=new Transformer();
            queue.add(tr2);
            textArea.append(tr2.toString()+"\n");
            queue.add(t1);
            textArea.append(t1.toString()+"\n");
            counter= 4;
        }else{
            queue.add(t1);
            textArea.append(t1.toString()+"\n");
        }
        counter--;
        if(counter>0){
            JOptionPane.showMessageDialog(null,"Te faltan "+ counter + " Transformers obligatorios por agregar");
        }

    }

    public void calculatePower( JTextArea textArea)throws Exception{
        double newPower;
        Transformer showTransformer= queue.peek();
        isEmptyQueue();
        if(showTransformer.getFaction().equals("Autobot")){
            textArea.setText("Este es el transformer: "+"\n"+showTransformer.toString()+"\n");
             newPower= (showTransformer.getPower() + (showTransformer.getPower() * 0.10));
             showTransformer.setPower(newPower);
            JOptionPane.showMessageDialog(null,"Nuevo Poder: "+showTransformer.getPower()+"\n");
        }else if(showTransformer.getFaction().equals("Decepticon")){
            textArea.setText("Este es el transformer: "+"\n"+showTransformer.toString()+"\n");
            newPower=(showTransformer.getPower() + (showTransformer.getPower() * 0.20));
            showTransformer.setPower(newPower);
            JOptionPane.showMessageDialog(null,"Nuevo Poder: "+showTransformer.getPower()+"\n");
        }
        refreshQueue(textArea);
    }

    private void isEmptyQueue()throws Exception{
        if(queue.isEmpty()){
            throw new Exception("Cola vacia");
        }
    }
    /**
     * Permite mostrar nuevamente la cola cuando la borremos para mostrar otra informacion en el text area
     * */
    private void refreshQueue(JTextArea textArea){
        textArea.append("Cola Actual: "+"\n");
        for(Transformer transformer: queue){
            textArea.append(transformer.toString()+"\n");
        }
    }

    public void createNewQueue(String value, JTextArea textArea)throws Exception{
        if(value==null){
            throw new Exception("No se puede duplicar este valor");
        }
        isEmptyQueue();
        queue2 = new LinkedList<>();
        for (Transformer transformer: queue){
            if(transformer.getFunction().equalsIgnoreCase(value)){
                queue2.add(transformer);
                textArea.append(transformer.toString()+"\n");
            }
        }
    }
}
