/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendsms;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Shaikan
 */
public class SendSMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 

        try {

            HttpPost request = new HttpPost("https://smsgateway.me/api/v4/message/send");
            StringEntity params =new StringEntity("[{\"phone_number\": \"XXXXXXXXX\",\"message\": \"Y los free sms\",\"device_id\":\"100800\"}]");
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", ""); //Paste snsgateway key
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            System.out.println(response);
            //handle response here...

        }catch (Exception ex) {

            //handle exception here

        } finally {
            //Deprecated
            //httpClient.getConnectionManager().shutdown(); 
        }
    }
}
