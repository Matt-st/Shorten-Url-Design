package com.tinyurl.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;

@Table("url")
public class TinyUrl implements Serializable {

	 @PrimaryKeyColumn(
		      name = "short_url",type = PrimaryKeyType.PARTITIONED)
	@Column(value = "")
    @CassandraType(type = DataType.Name.VARCHAR)
	private String tinyUrl;
	
	@NotNull
	@Column(value = "long_Url")
	@CassandraType(type = DataType.Name.TEXT)
	private String longUrl;
	
	public TinyUrl(){}
	
	public TinyUrl(String longUrl){
		this.longUrl = longUrl;
	}
	
	public void setLongUrl(String longUrl){
		this.longUrl = longUrl;
	}
	
	public void setTinyUrl(String tinyUrl){
		this.tinyUrl = tinyUrl;
	}
	
	public String getTinyUrl(){
		return this.tinyUrl;
	}
	
	public String getLongUrl(){
		return this.longUrl;
	}	

}
