package kedaikopi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class KedaiKopiManager extends JFrame {
    private DefaultListModel<String> orderListModel;
    private JList<String> orderList;
    private JProgressBar progressBar;
    private Queue<String> orderQueue;
    private JButton tambahPesananBtn, prosesPesananBtn;

    public KedaiKopiManager() {
        setTitle("Manajemen Proses Kedai Kopi");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        orderQueue = new LinkedList<>();

        orderListModel = new DefaultListModel<>();
        orderList = new JList<>(orderListModel);
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        tambahPesananBtn = new JButton("Tambah Pesanan");
        prosesPesananBtn = new JButton("Proses Pesanan");

        tambahPesananBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesanan = JOptionPane.showInputDialog("Masukkan Nama Minuman:");
                if (pesanan != null && !pesanan.trim().isEmpty()) {
                    orderQueue.add(pesanan);
                    orderListModel.addElement(pesanan);
                }
            }
        });

        prosesPesananBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesAntrianPesanan();
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(orderList), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        bottomPanel.add(tambahPesananBtn);
        bottomPanel.add(prosesPesananBtn);
        bottomPanel.add(progressBar);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void prosesAntrianPesanan() {
        if (orderQueue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada pesanan dalam antrian!");
            return;
        }

        String pesanan = orderQueue.poll();
        orderListModel.remove(0);  // Hapus dari daftar

        Thread prosesThread = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50); // Simulasi waktu pembuatan kopi
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                progressBar.setValue(i);
            }
            JOptionPane.showMessageDialog(this, pesanan + " sudah selesai dibuat!");
            progressBar.setValue(0);

            // Jika ada antrian berikutnya, otomatis lanjut
            if (!orderQueue.isEmpty()) {
                prosesAntrianPesanan();
            }
        });
        prosesThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KedaiKopiManager().setVisible(true));
    }
}