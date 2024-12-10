package utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    public static String gerarHash(String senha) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(senha, salt);
    }

    public static boolean verificarSenha(String senha, String hash) {
        return BCrypt.checkpw(senha, hash);
    }
}