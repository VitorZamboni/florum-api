package br.com.florum.security;

public class SecurityConstants {
    public static final String SECRET = "utfpr"; // secret utilizado para gerar o token
    public static final long EXPIRATION_TIME = 2_592_000_000L; // 1 mes = 60*60*24*1000*30
    public static final String TOKEN_PREFIX = "Bearer "; // tipo da autenticação
    public static final String HEADER_STRING = "Authorization";
}
