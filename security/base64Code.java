package otherTest.security;

import org.apache.commons.codec.binary.Base64;

public class base64Code {
    private static String code="af02d2f3e1827c11ae6db8ce7183893b";
    public static void main(String[] args){
            CommonsCodecBase64();
    }

    public static void CommonsCodecBase64(){
        byte[] encode=Base64.encodeBase64(code.getBytes());
        String encodeString= new String(encode);
        System.out.println("encode="+encodeString);

        byte[] decode= Base64.decodeBase64(encode);
        String decodeString= new String(decode);
        System.out.println("decode="+decodeString);
    }
}
