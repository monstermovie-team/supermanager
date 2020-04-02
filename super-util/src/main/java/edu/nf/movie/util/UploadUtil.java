package edu.nf.movie.util;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class UploadUtil {
	
	public static int upload(String url, InputStream input, String fileName) {
		try(CloseableHttpClient httpClient = HttpClients.createDefault()){
			HttpPost post = new HttpPost(url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        byte[] bytes = new byte[2048];
	        int len = 0;
	        while((len=input.read(bytes, 0, bytes.length)) != -1) {
	        	baos.write(bytes);
	        }
	        builder.addBinaryBody("file", baos.toByteArray(), ContentType.MULTIPART_FORM_DATA, fileName);
	        builder.addBinaryBody(fileName, input);
	        post.setEntity(builder.build());
	        CloseableHttpResponse response = httpClient.execute(post);
	        return response.getStatusLine().getStatusCode();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void download(String url, OutputStream out) {
		try(CloseableHttpClient httpClient = HttpClients.createDefault()){
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(get);
			if(HttpStatus.SC_OK==response.getStatusLine().getStatusCode()){  
					InputStream is = response.getEntity().getContent();
					byte[] bytes = new byte[1024];
					int len = 0;
					while ((len = is.read(bytes, 0, bytes.length)) != -1) {
						out.write(bytes, 0, len);
					}
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
