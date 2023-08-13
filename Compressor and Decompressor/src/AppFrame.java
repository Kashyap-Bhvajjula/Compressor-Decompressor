import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import Comp_decomp.*;

public class AppFrame extends JFrame implements ActionListener {

    JButton compress;
    JButton decompress;


    AppFrame()
    {

         this.setTitle("File Compressor");
         this.setSize(500, 500);
         this.setVisible(true);
         this.setLayout(null);
         this.setResizable(false);

         compress = new JButton("Select File to Compress");
         compress.setSize(200, 30);
         compress.setLocation(140, 130);
         compress.addActionListener(this);

         decompress = new JButton("Select File to Decompress");
         decompress.setSize(200,30);
         decompress.setLocation(140, 250);
         decompress.addActionListener(this);

         this.add(compress);
         this.add(decompress);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser;
        int response;
        if(e.getSource() == compress)
        {
            fileChooser = new JFileChooser();
            response = fileChooser.showSaveDialog(null);
            if(response == 0)
            {
                File file= new File(fileChooser.getSelectedFile().getAbsolutePath());

                try
                {
                   compressor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
            String fileLoc = "Location: " + fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this,  "Compression Successfull " +'\n' + fileLoc );
        }
        if(e.getSource() == decompress)
        {
            fileChooser = new JFileChooser();
            response = fileChooser.showSaveDialog(null);
            if(response == 0)
            {
                File file= new File(fileChooser.getSelectedFile().getAbsolutePath());

                try
                {
                    decompressor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
            String fileLoc = "Location: " + fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this,  "Decompression Successfull " +'\n' + fileLoc);
        }
    }
}