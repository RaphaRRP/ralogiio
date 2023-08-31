import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Relogio extends JFrame {
    private JLabel backgroundLabel, timeLabel;
    private ImageIcon manha, dia, tarde, noite;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Relogio() {
        setTitle("Relógio com Imagem de Fundo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Carregar imagens de fundo
        manha = new ImageIcon("img\\laranja.jpg");
        dia = new ImageIcon("img\\roxo.png");
        tarde = new ImageIcon("img\\manha.jfif");
        noite = new ImageIcon("img\\roxo.png");

        backgroundLabel = new JLabel();
        backgroundLabel.setLayout(new BorderLayout());
        backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);

        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));

        backgroundLabel.add(timeLabel, BorderLayout.CENTER);
        add(backgroundLabel);
        updateBackgroundImageAndTime(); // Atualizar a imagem de fundo e o horário inicial

        Timer timer = new Timer(1000, e -> {
            updateBackgroundImageAndTime(); // Atualizar a imagem e o horário a cada segundo
        });
        timer.start();
    }

    private void updateBackgroundImageAndTime() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= 6 && hour < 10) {
            backgroundLabel.setIcon(manha);
        } else if (hour >= 10 && hour < 16) {
            backgroundLabel.setIcon(dia);
        } else if (hour >= 16 && hour < 18) {
            backgroundLabel.setIcon(tarde);
        } else {
            backgroundLabel.setIcon(noite);
        }

        timeLabel.setText("<html><center>" + timeFormat.format(now) + "<br>" + dateFormat.format(now) + "</center></html>");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Relogio().setVisible(true);
        });
    }
}
