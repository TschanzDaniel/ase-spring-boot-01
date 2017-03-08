package edu.spring.rest.security.basic.client;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.spring.rest.security.basic.domain.Author;
import edu.spring.rest.security.basic.domain.Post;



public class SpringRestClient {


	public final String REST_SERVICE_URI = "http://localhost:8080/api";

	/*
	 * Add HTTP Authorization header, using Basic-Authentication to send Post-credentials.
	 */
	private HttpHeaders getHeaders(){
		String plainCredentials="user:user";
		String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Credentials);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	/*
	 * Send a GET request to get list of all Posts.
	 */
	@SuppressWarnings("unchecked")
	private void listAllPosts(){
		System.out.println("\nTesting listAllPosts API-----------");
		RestTemplate restTemplate = new RestTemplate(); 

		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> response = restTemplate.exchange(REST_SERVICE_URI+"/posts/", HttpMethod.GET, request, List.class);
		List<LinkedHashMap<String, Object>> PostsMap = (List<LinkedHashMap<String, Object>>)response.getBody();

		if(PostsMap!=null){
			for(LinkedHashMap<String, Object> map : PostsMap){
				System.out.println("Post : id="+map.get("id")+", Title="+map.get("title")+", Slug="+map.get("slug")+", Teaser="+map.get("teaser"));;
			}
		}else{
			System.out.println("No post exist----------");
		}
	}

	/*
	 * Send a GET request to get a specific Post.
	 */
	private void getPost(){
		System.out.println("\nTesting getPost API----------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<Post> response = restTemplate.exchange(REST_SERVICE_URI+"/posts/1", HttpMethod.GET, request, Post.class);
		Post Post = response.getBody();
		System.out.println(Post);
	}

	/*
	 * Send a POST request to create a new Post.
	 */
	private void createPost() {
		System.out.println("\nTesting create Post API----------");
		RestTemplate restTemplate = new RestTemplate();
		Author author = createAuthor1();
		Post post  = createPost(author);
		HttpEntity<Object> request = new HttpEntity<Object>(post, getHeaders());
        restTemplate.postForLocation(REST_SERVICE_URI+"/posts/", request, Post.class);
	}

	/*
	 * Send a PUT request to update an existing Post.
	 */
	private void updatePost() {
		System.out.println("\nTesting update Post API----------");
		RestTemplate restTemplate = new RestTemplate();
		Author author = createAuthor2();
		Post post  = createPost(author);
		HttpEntity<Object> request = new HttpEntity<Object>(post, getHeaders());
		ResponseEntity<Post> response = restTemplate.exchange(REST_SERVICE_URI+"/posts/1", HttpMethod.PUT, request, Post.class);
		System.out.println(response.getBody());
	}

	/*
	 * Send a DELETE request to delete a specific Post.
	 */
	private void deletePost() {
		System.out.println("\nTesting delete Post API----------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		restTemplate.exchange(REST_SERVICE_URI+"/posts/3", HttpMethod.DELETE, request, Post.class);
	}

	private  Author createAuthor1() {
    	return new Author("Hans","Mustermann","Hans.Mustermann@gmail.com");
	}
	private  Author createAuthor2() {
    	return new Author("John","Doe","John.Doe@gmail.com");
	}


	private  Post createPost(Author author) {

		Post post = new Post("Spring Client Rocks!");
		post.setSlug("spring-client-rocks");
		post.setTeaser("Post Client Teaser");
		post.setBody("Post Client Body");
		post.setPostedOn(new Date());
		post.setAuthor(author);
		return post;

	}


	public static void main(String args[]){

		new SpringRestClient().run();
	}

	public void run () {

		listAllPosts();

		getPost();

		createPost();
		listAllPosts();

		updatePost();
		listAllPosts();

		deletePost();
		listAllPosts();

	}
}
