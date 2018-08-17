package otherTest.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.SecureRandom;

public class ThreeDES {
    private static String src="zhangliming";
    public static void main(String[] args){
        JDKThreeDes();
    }
    private static void JDKThreeDes() {
        try {
            //生成KEY
            KeyGenerator keyGenerator=KeyGenerator.getInstance("DESede");
            // keyGenerator.init(168);
            // 根据不同的加密方式生成不同长度的密钥
            keyGenerator.init(new SecureRandom());
            SecretKey secretKey=keyGenerator.generateKey();
            byte[] bytesKey=secretKey.getEncoded();

            //KEY转换
            DESedeKeySpec desedeKeySpec=new DESedeKeySpec(bytesKey);
            SecretKeyFactory factory=SecretKeyFactory.getInstance("DESede");
            Key convertSecretKey=factory.generateSecret(desedeKeySpec);

            //加密
            Cipher cipher=Cipher.getInstance("DESede/ECB/PKCS5Padding");
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
