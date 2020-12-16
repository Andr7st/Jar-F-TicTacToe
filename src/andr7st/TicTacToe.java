package andr7st;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener {

    Random ramdom = new Random();
    JFrame frame = new JFrame("Andr7st");
    JPanel panelTitulos = new JPanel();
    JPanel panelBotones = new JPanel();
    JLabel campoTexto = new JLabel();

    //// Haciendo un arreglo de botones
    JButton botones[] = new JButton[9];
    

    boolean turnoJugador1; // Recuerda que pro defecto un valor booleanoes falso.


    public TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setSize(540,540);
        frame.setBounds(360,80,540,540);
        frame.getContentPane().setBackground(new Color(50,50,50)); //// color fondo ventana
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        ////
        campoTexto.setBackground(new Color(25,25,25));
        campoTexto.setForeground(new Color(25,255,0));
        campoTexto.setFont(new Font("Noto Sans", Font.BOLD,74));
        campoTexto.setHorizontalAlignment(JLabel.CENTER);
        campoTexto.setText("Tic-Tac-Toe");
        campoTexto.setOpaque(true);
        ////
        panelTitulos.setLayout(new BorderLayout());
        panelTitulos.setBounds(0,0,540,180);
        ////
        panelBotones.setLayout(new GridLayout(3,3));
        panelBotones.setBackground(new Color(150,150,150));

        ///Fuente para los botones
        Font fuenteBotones = new Font("Noto Sans", Font.BOLD, 112);
        

        //// Agregar el arreglo de botones

        for (int i=0; i<9; i++){

            botones[i] = new JButton();

            /// cada vez agregar el boton generado al panel de borones
            panelBotones.add(botones[i]);
            botones[i].setFont(fuenteBotones);
            botones[i].setFocusable(true);
            botones[i].addActionListener(this);
          //  botones[i].setBackground(Color.WHITE.darker());
            botones[i].setEnabled(false);//////////////////////////////////

        }


        
        panelTitulos.add(campoTexto);
        frame.add(panelTitulos,BorderLayout.NORTH); // Arriba
        frame.add(panelBotones);
        
        frame.setVisible(true);


        ///// Lamar el primer turno
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0; i<9; i++){
            //// Para saber cual boton fue el que se presionó

            if (e.getSource() == botones[i]){

                if(turnoJugador1){  // Jugador1 - X
                    if(botones[i].getText()==""){
                        botones[i].setForeground(new Color(255,2,2));
                        botones[i].setText("X");
                        turnoJugador1 = false;
                        campoTexto.setText("Turno O");
                        check();
                    }
                }
                else{
                    if(botones[i].getText()==""){
                        botones[i].setForeground(new Color(2,2,255));
                        botones[i].setText("O");
                        turnoJugador1 = true;
                        campoTexto.setText("Turno X");
                        check();

                    }
                }




            }
        }

    }

    public void firstTurn() {

        //// Agregar un retraso.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //TODO: handle exception
            e.printStackTrace();

        }

        for (int i=0; i<9; i++){
            botones[i].setEnabled(true);
        }



        //// Decir a quien le toca
        if(ramdom.nextInt(2)==0){
            turnoJugador1 = true;
            campoTexto.setText("Turno X");
        }
        else{
            turnoJugador1 = false;
            campoTexto.setText("Turno O");
        }

    }

    public void check(){

        //// Condiciones X

        if  (
            botones[0].getText()=="X" &&
            botones[1].getText()=="X" &&
            botones[2].getText()=="X" 
            )
            
            {
                xWinds(0, 1, 2);
            }

        if  (
            botones[3].getText()=="X" &&
            botones[4].getText()=="X" &&
            botones[5].getText()=="X" 
            )
            
            {
                xWinds(3,4,5);
            }

        if  (
            botones[6].getText()=="X" &&
            botones[7].getText()=="X" &&
            botones[8].getText()=="X" 
            )
            
            {
                xWinds(6, 7, 8);
            }


        if  (
            botones[0].getText()=="X" &&
            botones[3].getText()=="X" &&
            botones[6].getText()=="X" 
            )
            
            {
                xWinds(0,3,6);
            }
            
        if  (
            botones[1].getText()=="X" &&
            botones[4].getText()=="X" &&
            botones[7].getText()=="X" 
            )
            
            {
                xWinds(1,4,7);
            }

        if  (
            botones[2].getText()=="X" &&
            botones[5].getText()=="X" &&
            botones[8].getText()=="X" 
            )
            
            {
                xWinds(2,5,8);
            }

        if  (
            botones[2].getText()=="X" &&
            botones[4].getText()=="X" &&
            botones[6].getText()=="X" 
            )
            
            {
                xWinds(2,4,6);
            }


        //// Condiciones O


        if  (
            botones[0].getText()=="O" &&
            botones[1].getText()=="O" &&
            botones[2].getText()=="O" 
            )
            
            {
                oWinds(0, 1, 2);
            }

        if  (
            botones[3].getText()=="O" &&
            botones[4].getText()=="O" &&
            botones[5].getText()=="O" 
            )
            
            {
                oWinds(3,4,5);
            }

        if  (
            botones[6].getText()=="O" &&
            botones[7].getText()=="O" &&
            botones[8].getText()=="O" 
            )
            
            {
                oWinds(6, 7, 8);
            }


        if  (
            botones[0].getText()=="O" &&
            botones[3].getText()=="O" &&
            botones[6].getText()=="O" 
            )
            
            {
                oWinds(0,3,6);
            }
            
        if  (
            botones[1].getText()=="O" &&
            botones[4].getText()=="O" &&
            botones[7].getText()=="O" 
            )
            
            {
                oWinds(1,4,7);
            }

        if  (
            botones[2].getText()=="O" &&
            botones[5].getText()=="O" &&
            botones[8].getText()=="O" 
            )
            
            {
                oWinds(2,5,8);
            }

        if  (botones[2].getText()=="O" && botones[4].getText()=="O" && botones[6].getText()=="O")
            {oWinds(2,4,6);}



    }

    public void xWinds(int a, int b, int c){

        botones[a].setBackground(Color.GREEN);
        botones[b].setBackground(Color.GREEN);
        botones[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++) {
            botones[i].setEnabled(false);
        }

        campoTexto.setText("Gana X");


        ///reiniciar();


        
    }
    public void oWinds(int a, int b, int c){
        botones[a].setBackground(Color.GREEN);
        botones[b].setBackground(Color.GREEN);
        botones[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++) {
            botones[i].setEnabled(false);
        }

        campoTexto.setText("Gana O");

        

        //reiniciar();
    }


    ////
    public void reiniciar(){

            //// Agregar un retraso.
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //TODO: handle exception
                e.printStackTrace();
    
            }

        for (int i=0; i<9; i++) {
            botones[i].setText("");
            botones[i].setEnabled(true);
        }
        
        
        
        firstTurn();
    }

}
