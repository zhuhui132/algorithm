//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.github.pagehelper.PageInfo;
//import com.crs.ss.job.utils.SSLUtil;
//import com.crs.utils.HttpsUtil;
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.*;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = SsJobApplication.class)
//@WebAppConfiguration
//public class SsJobApplicationTests {
//
//   @Autowired
//   private PlatformCustomerService platformCustomerService;
//
//   @Test
//   public void testHttpsExecute() throws Exception {
//      HttpPost httpPost = new HttpPost("https://47.110.222.16/api/gw/auth/oauth/token/1.0.0");
//      List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//      nvps.add(new BasicNameValuePair("grant_type", "client_credentials"));
//      nvps.add(new BasicNameValuePair("client_id", "nbd"));
//      nvps.add(new BasicNameValuePair("client_secret", "Lenovo123-"));
//
//      httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
//      httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
//      httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//
//      CloseableHttpResponse response = SSLUtil.SslHttpClientBuild().execute(httpPost);
//
//      //获取结果实体
//      HttpEntity entity = response.getEntity();
//      String body = "";
//      if (entity != null) {
//         //按指定编码转换结果实体为String类型
//         body = EntityUtils.toString(entity, "UTF-8");
//      }
//      EntityUtils.consume(entity);
//      System.out.println("结果是111---"+body);
//      //释放链接
//      response.close();
//   }
//}
