package com.jamong.webservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jamong.webservice.domain.bbs.Bbs;
import com.jamong.webservice.domain.bbs.BbsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepo;
	/*@Autowired
	BbsRepository bbsRepo;*/
	
	@After
	public void cleanup() {
		/**
		 * 테스트 코드에 영향을 미치지 않기 위해
		 * 테스트 메소드가 끝날때 마다 repository 전체를 비우는 코드
		 **/
		postsRepo.deleteAll();
		//bbsRepo.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		// given
		postsRepo.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("jamong@tistory.com")
				.build());
		
		// when
		List<Posts> postsList = postsRepo.findAll();
		
		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("테스트 게시글"));
		assertThat(posts.getContent(), is("테스트 본문"));
	}
	
	@Test
	public void BaseTimeEntity_등록() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepo.save(Posts.builder()
				.title("테스트 게시글2")
				.content("테스트 본문2")
				.author("Admin2")
				.build());
		//when
		List<Posts> postsList = postsRepo.findAll();
		//then
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreateDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
	
	
	
	
	
	
	
	/*
	@Test
	public void bbsList() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		
		bbsRepo.save(Bbs.builder()
				.title("테스트 게시글")
				.contents("테스트 본문")
				.hit_cnt(0)
				.del_gb("N")
				.crea_dtm(date)
				.crea_id("Admin")
				.build());
		
		List<Bbs> bbsList = bbsRepo.findAll();
		
		Bbs bbs = bbsList.get(0);
		assertThat(bbs.getTitle(), is("테스트 게시글"));
		assertThat(bbs.getContents(), is("테스트 본문"));
	}
	
	@Test
	public void BaseTimeEntity() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		
		LocalDateTime now = LocalDateTime.now();
		bbsRepo.save(Bbs.builder()
				.title("테스트 제목")
				.contents("테스트 본문")
				.hit_cnt(0)
				.del_gb("N")
				.crea_dtm(date)
				.crea_id("테스트 사용자")
				.build());
		List<Bbs> bbsList = bbsRepo.findAll();
		
		Bbs bbs = bbsList.get(0);
		assertTrue(bbs.getCreateDate().isAfter(now));
		assertTrue(bbs.getModifiedDate().isAfter(now));
	}
	*/
}
