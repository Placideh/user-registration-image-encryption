/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
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
;



/**
 *
 * @author jumpman
 */
@WebServlet(name = "EncryController", urlPatterns = {"/encrypt"})
public class EncryController extends HttpServlet {

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
		String keyName=randomString();
		item.write(new File("C:\\Users\\DolphiX People'S\\Music\\img\\"+keyName.concat(item.getName())));
		System.out.println("image from browser:"+item.getName());
		System.out.println("actual image moved:"+keyName.concat(item.getName()));
		encryption(keyName.concat(item.getName()));
	    } catch (Exception ex) {
		Logger.getLogger(EncryController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
	}
	
  }

    
     private static void encryption(String image) {
	System.out.println("staring encrypting......");
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\DolphiX People'S\\Music\\img\\"+image);
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\DolphiX People'S\\Pictures\\"+image);
            byte k[] = "MukE8899NeTa6078".getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE, keySpec);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while ((read = fileInputStream.read(buf)) != -1) {
                cipherOutputStream.write(buf, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            cipherOutputStream.close();
	    System.out.println("Encryption done..!!!!!");
            
        } catch (Exception e) {

        }
    }
     
     
      private  String randomString() {

		String characters = "0123456789";
		String str = "";
		String createdEncryCode="ENCRY";
		char[] mynewCharacters = characters.toCharArray();
		Integer generatedCodeLength =4;
		for (int i = 0; i < generatedCodeLength; i++) {
		    int index = (int) (Math.random() *10);
		    String newString = characters.substring(index, characters.length() - 1);
		    str += mynewCharacters[newString.length()];
		}
		return createdEncryCode.concat(str);
	    }
   
}
