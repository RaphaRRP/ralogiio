import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class relogio_on extends JFrame {

    private JLabel tempo;
    private JLabel data;

    public relogio_on() {
        setTitle("Relógio");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painel.setLayout(new BorderLayout());

        tempo = new JLabel();
        tempo.setFont(new Font("Arial", Font.PLAIN, 60));
        tempo.setHorizontalAlignment(SwingConstants.CENTER);
        tempo.setVerticalAlignment(SwingConstants.CENTER);
        tempo.setForeground(Color.RED);

        data = new JLabel();
        data.setFont(new Font("Arial", Font.PLAIN, 20));
        data.setHorizontalAlignment(SwingConstants.CENTER);
        data.setVerticalAlignment(SwingConstants.CENTER);
        data.setForeground(Color.WHITE);

        painel.add(tempo, BorderLayout.CENTER);
        painel.add(data, BorderLayout.SOUTH);

        painel.setBackground(Color.BLACK);



        add(painel);

        Timer temporizador = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizar();
            }
        });
        temporizador.start();
    }

    private void atualizar() {
    
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat tempoFormato = new SimpleDateFormat("HH:mm:ss");
        String hora = tempoFormato.format(calendario.getTime());

        SimpleDateFormat dataFormato = new SimpleDateFormat("EEE, MMM dd, yyyy");
        String dia = dataFormato.format(calendario.getTime());

        tempo.setText(hora);
        data.setText(dia);
    }

    public static void main(String[] args) {
        relogio_on relogio = new relogio_on();
        relogio.setVisible(true);
    }
}