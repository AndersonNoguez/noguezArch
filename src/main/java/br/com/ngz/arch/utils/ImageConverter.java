package br.com.ngz.arch.utils;

import br.com.voiza.demo.xml.estoque.Produto;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author anoguez
 */
public class ImageConverter {

    public static byte[] imageToByte(String image) throws IOException {        
        InputStream is = Produto.class.getResourceAsStream(image);
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        return buffer;
    }

    public void ByteToImage(byte[] bytes) throws Exception {
        byte[] imgBytes = bytes;
        try {
            FileOutputStream fos = new FileOutputStream("predator.jpg");
            fos.write(imgBytes);
            FileDescriptor fd = fos.getFD();
            fos.flush();
            fd.sync();
            fos.close();
        } catch (Exception e) {
            throw new Exception("Erro ao converter os bytes recebidos para imagem");
        }
    }

}
