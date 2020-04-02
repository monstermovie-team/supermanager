package edu.nf.movie.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;

/**
 * @author BoomShaGa1aGa
 * @date 2020/3/19
 */
public class UploadUtil2 {

    public static void logUpload(String url, String pathname) {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);

        try {
            FilePart filePart = new FilePart("file", new File(pathname));
            Part[] parts = {filePart};

            MultipartRequestEntity multipartRequestEntity = new MultipartRequestEntity(parts, new HttpMethodParams());
            postMethod.setRequestEntity(multipartRequestEntity);
            httpClient.executeMethod(postMethod);
            String result = postMethod.getResponseBodyAsString();

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            postMethod.releaseConnection();
        }
    }
}
