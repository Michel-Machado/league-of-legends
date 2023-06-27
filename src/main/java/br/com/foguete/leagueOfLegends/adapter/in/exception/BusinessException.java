package br.com.foguete.leagueOfLegends.adapter.in.exception;

public class BusinessException extends RuntimeException{
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
