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
        if(counter!=0){
            JOptionPane.showMessageDialog(null,"Te faltan "+ counter + " Transformers obligatorios por agregar");
        }

    }

    public void calculatePower( JTextArea textArea)throws Exception{
        Transformer showTransformmer= queue.peek();
        isEmptyQueue();
        if(showTransformmer.getFaction().equals("Autobot")){
            textArea.append(showTransformmer.toString()+"\n");
            showTransformmer.setPower(showTransformmer.getPower()+(showTransformmer.getPower()*10/100));
            JOptionPane.showMessageDialog(null,"Nuevo Poder"+showTransformmer.getPower()+"\n");
        }else if(showTransformmer.getFaction().equals("Decepticon")){
            showTransformmer.setPower(showTransformmer.getPower()+(showTransformmer.getPower()*20/100));
            JOptionPane.showMessageDialog(null,"Nuevo Poder"+showTransformmer.getPower()+"\n");
        }


    }
    private void isEmptyQueue()throws Exception{
        if(queue.isEmpty()){
            throw new Exception("Cola vacia");
        }
    }
    public void createNewQueue(String value, JTextArea textArea)throws Exception{
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
