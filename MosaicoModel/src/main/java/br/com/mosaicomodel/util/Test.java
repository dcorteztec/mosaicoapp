package br.com.mosaicomodel.util;

public class Test {

	public static void main(String[] args) {
		String s = "jÃ¡ faz um tempo desde que a Marvel e a Sony anunciaram a parceria para o desenvolvimento de um novo reboot do Homem-Aranha no Universo CinematogrÃ¡fico da Marvel. Agora, foram revelados alguns possÃ­veis tÃ­tulos."; 
        String out = null;
        try {
            out = new String(s.getBytes("ISO-8859-1"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
           
        }
        System.out.println(out);
    }
}
