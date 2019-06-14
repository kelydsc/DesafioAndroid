package br.com.digitalhouse.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Prato implements Parcelable {

    //Declaração de atributos
    private String nomePrato;
    private String descricaoPrato;
    private int fotoPrato;

    //Construtor vazio
    public Prato() {
    }

    //Construtor especifico
    public Prato(String nomePrato, String descricaoPrato, int fotoPrato) {
        this.nomePrato = nomePrato;
        this.descricaoPrato = descricaoPrato;
        this.fotoPrato = fotoPrato;
    }


    protected Prato(Parcel in) {
        nomePrato = in.readString();
        descricaoPrato = in.readString();
        fotoPrato = in.readInt();
    }

    public static final Creator<Prato> CREATOR = new Creator<Prato>() {
        @Override
        public Prato createFromParcel(Parcel in) {
            return new Prato(in);
        }

        @Override
        public Prato[] newArray(int size) {
            return new Prato[size];
        }
    };

    //Getters e setters
    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }

    public int getFotoPrato() {
        return fotoPrato;
    }

    public void setFotoPrato(int fotoPrato) {
        this.fotoPrato = fotoPrato;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomePrato);
        dest.writeString(descricaoPrato);
        dest.writeInt(fotoPrato);
    }
}
