/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author jumpman
 */
@WebServlet(name = "DecryController", urlPatterns = {"/decrypt"})
public class DecryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
	List<FileItem>multifiles = null;
	try {
	    multifiles = sf.parseRequest(req);
	} catch (FileUploadException ex) {
	    Logger.getLogger(EncryController.class.getName()).log(Level.SEVERE, null, ex);
	}
	for(FileItem item:multifiles){
	    
	    try {
		System.out.println("ItemName:"+item.getName());
		decryption(item.getName());
	    } catch (Exception ex) {
		Logger.getLogger(EncryController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
	}
    }
    
     private static void decryption(String imageName) {
	 System.out.println("Starting decrypting ......");
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\DolphiX People'S\\Pictures\\"+imageName);
	    String imageDecrypt=imageName.substring(5);
	    String decrypt="DECRY".concat(imageDecrypt);
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\DolphiX People'S\\Music\\img\\"+decrypt);
            byte k[] = "MukE8899NeTa6078".getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.DECRYPT_MODE, keySpec);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, enc);
            byte[] buf = new byte[1024];
            int read;

            while ((read = fileInputStream.read(buf)) != -1) {
                cipherOutputStream.write(buf, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            cipherOutputStream.close();
	    System.out.println("File Successfully Decrypted...!!!");
        } catch (Exception e) {
            System.out.println("Exception:"+e.getMessage());
        }
    }

   
}
