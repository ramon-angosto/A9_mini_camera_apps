package com.google.zxing.client.j2se;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public final class GUIRunner extends JFrame {
    private final JLabel imageLabel = new JLabel();
    private final JTextComponent textArea = new JTextArea();

    private GUIRunner() {
        this.textArea.setEditable(false);
        this.textArea.setMaximumSize(new Dimension(400, 200));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(this.imageLabel);
        jPanel.add(this.textArea);
        setTitle("ZXing");
        setSize(400, 400);
        setDefaultCloseOperation(3);
        setContentPane(jPanel);
        setLocationRelativeTo((Component) null);
    }

    public static void main(String[] strArr) throws MalformedURLException {
        GUIRunner gUIRunner = new GUIRunner();
        gUIRunner.setVisible(true);
        gUIRunner.chooseImage();
    }

    private void chooseImage() throws MalformedURLException {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(this);
        Path path = jFileChooser.getSelectedFile().toPath();
        ImageIcon imageIcon = new ImageIcon(path.toUri().toURL());
        setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight() + 100);
        this.imageLabel.setIcon(imageIcon);
        this.textArea.setText(getDecodeText(path));
    }

    private static String getDecodeText(Path path) {
        try {
            try {
                return String.valueOf(new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageReader.readImage(path.toUri()))))).getText());
            } catch (ReaderException e) {
                return e.toString();
            }
        } catch (IOException e2) {
            return e2.toString();
        }
    }
}
