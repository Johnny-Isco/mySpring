package com.jamong.webservice.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jamong.webservice.domain.PostsRepository;
import com.jamong.webservice.domain.PostsSaveRequestDto;
import com.jamong.webservice.domain.bbs.Bbs;
import com.jamong.webservice.domain.bbs.BbsRepository;
import com.jamong.webservice.domain.bbs.dto.BbsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	/**
	 * Field를 Autowired 어노테이션으로 주입받는건 비권장방식
	 * 생성자로 Bean객체를 받도록 하면 Autowired와 동일한 효과를 볼 수 있다.
	 * 생성자는 클래스에 지정한 AllArgsConstructor가 처리해준다.
	**/
	private PostsRepository postsRepo;
	private BbsRepository bbsRepo;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepo.save(dto.toEntity());
	}
	
	
	@PostMapping("/bbs")
	public void saveBbs(@RequestBody BbsSaveRequestDto dto) {
		System.out.println(dto.getTitle());
		System.out.println(dto.getContents());
		System.out.println(dto.getCrea_id());
		bbsRepo.save(dto.toEntity());
		List<Bbs> bbsList = bbsRepo.findAll();
		
		Bbs bbs = bbsList.get(0);
		assertThat(bbs.getTitle(), is("타이틀 제목2"));
		assertThat(bbs.getContents(), is("타이틀 본문2"));
	}
}
