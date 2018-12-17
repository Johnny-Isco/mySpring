package com.jamong.webservice.domain.bbs;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jamong.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Bbs extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	private String title;
	private String contents;
	private int hit_cnt;
	private String del_gb;
	private Date crea_dtm;
	private String crea_id;
	
	@Builder
	public Bbs(String title, String contents, int hit_cnt, 
			String del_gb, Date crea_dtm, String crea_id) {
		this.title = title;
		this.contents = contents;
		this.hit_cnt = hit_cnt;
		this.del_gb = del_gb;
		this.crea_dtm = crea_dtm;
		this.crea_id = crea_id;
	}
}
