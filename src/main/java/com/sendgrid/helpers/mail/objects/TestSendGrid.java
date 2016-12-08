package com.sendgrid.helpers.mail.objects;

import java.io.IOException;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;

public class TestSendGrid {

	public static void main(String[] args) {
		Email from = new Email("prashantha.sr@tcs.com");
        String subject = "Hello World from the SendGrid Java Library!";
        Email to = new Email("prashantha.sr@tcs.com");
        Content content = new Content("text/plain", "Hello, Email!");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        com.sendgrid.Request request = new com.sendgrid.Request();
        try {
          request.method = Method.POST;
          request.endpoint = "mail/send";
          request.body = mail.build();
          com.sendgrid.Response response = sg.api(request);
          System.out.println(response.statusCode);
          System.out.println(response.body);
          System.out.println(response.headers);
        } catch (IOException ex) {
          System.out.println(ex.getMessage());
        }

	}

}
