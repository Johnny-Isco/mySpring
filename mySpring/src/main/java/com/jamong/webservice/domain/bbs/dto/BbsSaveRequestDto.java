package com.jamong.webservice.domain.bbs.dto;

import java.sql.Date;
import java.util.Calendar;

import com.jamong.webservice.domain.bbs.Bbs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BbsSaveRequestDto {

	private String title;
	private String contents;
	private String crea_id;
	
	public Bbs toEntity() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		return Bbs.builder()
				.title(title)
				.contents(contents)
				.hit_cnt(0)
				.del_gb("N")
				.crea_dtm(date)
				.crea_id(crea_id)
				.build();
	}
}
