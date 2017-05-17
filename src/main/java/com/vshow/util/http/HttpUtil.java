package com.vshow.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
//import com.taobao.api.ApiException;
//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Created by Alcc on 2016/3/3.
 */
public class HttpUtil {
	
	private static ContentType TYPE_PLAIN = ContentType.create("text/plain", Consts.UTF_8);
	
	/**
     * HTTP访问，使用POST方法提交参数
     * 
     * @Title sentPostParams
     * @Class HttpUtil
     * @return String
     * @param url_
     * @param postParams
     * @return
     * @throws Exception
     * @Description
     * @author zhoushifeng@telincn.com
     * @Date 2016年8月28日
     */
    public static String sentPostParams(String url_, Map<String, String> postParams) throws Exception {
	StringBuffer sb = new StringBuffer();

	// 设置超时时间为5秒
	RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).setConnectionRequestTimeout(20000).build();

	CloseableHttpClient httpclient = HttpClients.custom().build();
	try {
	    HttpPost httpPost = new HttpPost(url_);
	    httpPost.setConfig(requestConfig);
	    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

	    if (postParams != null) {
		for (Entry<String, String> e : postParams.entrySet()) {
		    builder.addTextBody(e.getKey(), e.getValue(), TYPE_PLAIN);
		}
		httpPost.setEntity(builder.build());
	    }
	    CloseableHttpResponse response = httpclient.execute(httpPost);
	    try {
		HttpEntity entity = response.getEntity();
		if (entity != null) {
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
		    String text;
		    while((text = bufferedReader.readLine()) != null) {
			sb.append(text);
		    }
		}
		EntityUtils.consume(entity);
		return sb.toString();
	    }finally {
		response.close();
	    }
	}finally {
	    httpclient.close();
	}
    }
	
    /**
     * HTTP访问，使用GET方法 访问连接
     * @param url
     * @return
     * @throws IOException
     */
    public static String httpGet(String url) throws IOException {
        StringBuffer sb = new StringBuffer();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                String text;
                while ((text = bufferedReader.readLine()) != null) {
                    sb.append(text);
                }
            }
            EntityUtils.consume(entity);
            return sb.toString();
        } finally {
            response.close();
            httpClient.close();
        }
    }

    /**
     * 使用post发送一个String类型的到目标url
     * @param url
     * @param postJson
     * @return
     * @throws IOException
     */
    public static String httpProcessOfStringEntity(String url, String postJson) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(postJson,"utf-8");
        httpPost.setEntity(stringEntity);
        HttpResponse response = httpClient.execute(httpPost);
        String resultMsg = EntityUtils.toString(response.getEntity(),"utf-8");
        httpClient.close();
        return resultMsg;
    }


    /**
     * 使用post发送多个String类型的参数
     * @param url
     * @param postJsons
     * @return
     */
    public static String httpProcessOfStringEntity(String url, String... postJsons) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        for(String postJson:postJsons){
            StringEntity stringEntity = new StringEntity(postJson,"utf-8");
            httpPost.setEntity(stringEntity);
        }
        HttpResponse response = httpClient.execute(httpPost);
        httpClient.close();
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * 使用post发送一个String类型的到目标url
     * @param url
     * @param buf
     * @param bufName
     * @return
     * @throws IOException
     */
    public static String httpProcessOfByteArray(String url, byte[] buf, String bufName) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        ByteArrayBody byteArrayBody = new ByteArrayBody(buf, bufName);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart("buffer", byteArrayBody);
        HttpEntity reqEntity = builder.build();
        post.setEntity(reqEntity);
        HttpResponse response = httpClient.execute(post);
        String resultMsg = EntityUtils.toString(response.getEntity(), "utf-8");
        httpClient.close();
        return resultMsg;
    }

    /**
     * 使用阿里大于 sdk 下发验证码
     * @return
     * @throws ApiException
     */
    public static JSONObject alihttpPost(String url,String appkey,String secret,String extend,String smsType,String receivePhone,String tempLateCode,String freeSignName,JSONObject jsonParams) throws ApiException{
    	
    	String params = JSON.toJSONString(jsonParams);
    	
    	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
    	AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
    	req.setExtend( extend );
    	req.setSmsType( smsType );
    	req.setSmsFreeSignName( freeSignName );
    	req.setSmsParamString( params );
    	req.setRecNum( receivePhone );
    	req.setSmsTemplateCode( tempLateCode );
    	AlibabaAliqinFcSmsNumSendResponse rsp = null;

		rsp = client.execute(req);

		JSONObject jobj = new JSONObject();
		jobj = JSON.parseObject(rsp.getBody());
		
		return jobj;
    }
    
}
