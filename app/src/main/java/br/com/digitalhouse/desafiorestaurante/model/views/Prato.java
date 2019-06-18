package br.com.digitalhouse.desafiorestaurante.model.views;

import android.os.Parcel;
import android.os.Parcelable;

public class Prato implements Parcelable {

    private String nome;
    private String descricao;
    private int fotoPrato;

    public Prato() {
    }

    public Prato(String nomePrato, String descricaoPrato, int fotoPrato) {
        this.nome = nomePrato;
        this.descricao = descricaoPrato;
        this.fotoPrato = fotoPrato;
    }


    protected Prato(Parcel in) {
        nome = in.readString();
        descricao = in.readString();
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

    public String getNomePrato() {
        return nome;
    }

    public void setNomePrato(String nomePrato) {
        this.nome = nomePrato;
    }

    public String getDescricaoPrato() {
        return descricao;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricao = descricaoPrato;
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
        dest.writeString(nome);
        dest.writeString(descricao);
        dest.writeInt(fotoPrato);
    }
}
