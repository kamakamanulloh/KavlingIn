package com.putri.skripsi.kavlingin.Models;


import com.google.gson.annotations.SerializedName;


public class ResultItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("harga")
	private String harga;

	@SerializedName("lng")
	private String lng;

	@SerializedName("gbr")
	private String gbr;

	@SerializedName("nohp")
	private String nohp;

	@SerializedName("id")
	private String id;

	@SerializedName("stok")
	private String stok;

	@SerializedName("id_transaksi")
	private String idTransaksi;

	@SerializedName("judul")
	private String judul;

	@SerializedName("lat")
	private String lat;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setHarga(String harga){
		this.harga = harga;
	}

	public String getHarga(){
		return harga;
	}

	public void setLng(String lng){
		this.lng = lng;
	}

	public String getLng(){
		return lng;
	}

	public void setGbr(String gbr){
		this.gbr = gbr;
	}

	public String getGbr(){
		return gbr;
	}

	public void setNohp(String nohp){
		this.nohp = nohp;
	}

	public String getNohp(){
		return nohp;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStok(String stok){
		this.stok = stok;
	}

	public String getStok(){
		return stok;
	}

	public void setIdTransaksi(String idTransaksi){
		this.idTransaksi = idTransaksi;
	}

	public String getIdTransaksi(){
		return idTransaksi;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"nama = '" + nama + '\'' + 
			",harga = '" + harga + '\'' + 
			",lng = '" + lng + '\'' + 
			",gbr = '" + gbr + '\'' + 
			",nohp = '" + nohp + '\'' + 
			",id = '" + id + '\'' + 
			",stok = '" + stok + '\'' + 
			",id_transaksi = '" + idTransaksi + '\'' + 
			",judul = '" + judul + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}