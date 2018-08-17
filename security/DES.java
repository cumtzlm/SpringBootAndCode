package otherTest.security;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;

public class DES {
    private static String src="zhangliming";

    public static void main(String[] args){
        JDKDes();
    }
    private static void JDKDes() {
        try {
            //生成KEY
            KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            SecretKey secretKey=keyGenerator.generateKey();
            byte[] bytesKey=secretKey.getEncoded();

            //KEY转换
            DESKeySpec desKeySpec=new DESKeySpec(bytesKey);
            SecretKeyFactory factory=SecretKeyFactory.getInstance("DES");
            Key convertSecretKey=factory.generateSecret(desKeySpec);

            //加密
            Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,convertSecretKey);
            byte[] result=cipher.doFinal(src.getBytes());
            System.out.println(new String(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
            result=cipher.doFinal(result);
            System.out.println(new String(result));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
