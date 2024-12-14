package classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Voo {
    private final int codigoVoo;
    private LocalDate data;
    private LocalTime hora;
    private String origem;
    private String destino;
    private int codigoAviao;
    private int codigoPiloto;
    private int codigoCopiloto;
    private int codigoComissario;
    private String status; // "ativo" ou "inativo"
    private double tarifa;


    public Voo(int codigoVoo, LocalDate data, LocalTime hora, String origem, String destino, int codigoAviao,
               int codigoPiloto, int codigoCopiloto, int codigoComissario, String status, double tarifa) {
        this.codigoVoo = codigoVoo;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.destino = destino;
        this.codigoAviao = codigoAviao;
        this.codigoPiloto = codigoPiloto;
        this.codigoCopiloto = codigoCopiloto;
        this.codigoComissario = codigoComissario;
        this.status = status;
        this.tarifa = tarifa;
    }

    // Getters
    public int getCodigoVoo() {
        return codigoVoo;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public int getCodigoAviao() {
        return codigoAviao;
    }

    public int getCodigoPiloto() {
        return codigoPiloto;
    }

    public int getCodigoCopiloto() {
        return codigoCopiloto;
    }

    public int getCodigoComissario() {
        return codigoComissario;
    }

    public String getStatus() {
        return status;
    }

    public double getTarifa() {
        return tarifa;
    }
}