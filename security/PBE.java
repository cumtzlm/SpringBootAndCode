package otherTest.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

public class PBE {
    private static String src="zhangliming";
    public static void main(String[] args){
    PBECode();
    }
    public static void PBECode(){
        try{
            //初始化盐
            SecureRandom secureRandom=new SecureRandom();
            byte[] salt=secureRandom.generateSeed(8);
            //口令与密钥
            String password="15162130987";
            PBEKeySpec pbeKeySpec=new PBEKeySpec(password.toCharArray());
            SecretKeyFactory secretKeyFactory=SecretKeyFactory.getInstance("PBEWITHMD5andDES");
            Key key=secretKeyFactory.generateSecret(pbeKeySpec);
            //加密
            PBEParameterSpec pbeParameterSpec=new PBEParameterSpec(salt,100);
            Cipher cipher= Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.ENCRYPT_MODE,key,pbeParameterSpec);
            byte[] result=cipher.doFinal(src.getBytes());
            System.out.println(result);
            System.out.println(Base64.encodeBase64String(result));
            System.out.println(new String(result));
            //解密
            cipher.init(Cipher.DECRYPT_MODE,key,pbeParameterSpec);
            result=cipher.doFinal(result);
            System.out.println(result);
            System.out.println(new String(result));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
