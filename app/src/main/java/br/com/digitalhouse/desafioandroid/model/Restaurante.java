package br.com.digitalhouse.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Parcelable {

    //Declaração de atributos
    private String nome;
    private String endereco;
    private String horario;
    private int fotoRestaurante;
    private List<Prato> pratosCardapio = new ArrayList<>();

    //construtor vazio
    public Restaurante() {
    }

    //construtor especifico
    public Restaurante(String nome, String endereco, String horario, int fotoRestaurante,
                       List<Prato> pratosCardapio) {
        this.nome = nome;
        this.endereco = endereco;
        this.horario = horario;
        this.fotoRestaurante = fotoRestaurante;
        this.pratosCardapio = pratosCardapio;
    }

    protected Restaurante(Parcel in) {
        nome = in.readString();
        endereco = in.readString();
        horario = in.readString();
        fotoRestaurante = in.readInt();
        pratosCardapio = in.createTypedArrayList(Prato.CREATOR);
    }

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel in) {
            return new Restaurante(in);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getFotoRestaurante() {
        return fotoRestaurante;
    }

    public void setFotoRestaurante(int fotoRestaurante) {
        this.fotoRestaurante = fotoRestaurante;
    }

    public List<Prato> getPratosCardapio() {
        return pratosCardapio;
    }

    public void setPratosCardapio(List<Prato> pratosCardapio) {
        this.pratosCardapio = pratosCardapio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeString(horario);
        dest.writeInt(fotoRestaurante);
        dest.writeTypedList(pratosCardapio);
    }
}
