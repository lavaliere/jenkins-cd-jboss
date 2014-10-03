package org.sample;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jenkins.JenkinsServlet;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

@RunWith(Arquillian.class)
public class JenkinsServletTest {
   
  @ArquillianResource
  private URL base;

  @Deployment(testable = false)
  public static WebArchive createDeployment() {
     return ShrinkWrap.create(WebArchive.class)
         .addClass(JenkinsServlet.class);
  }

  @Test
  public void testHelloWorld() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
     WebClient webClient = new WebClient();
     TextPage page = webClient.getPage(base + "/JenkinsServlet");
     assertEquals("Hello World!", page.getContent());
  }

  @Test
  public void testHelloJenkins() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
     WebClient webClient = new WebClient();
     TextPage page = webClient.getPage(base + "/JenkinsServlet?name=Jenkins");
     assertEquals("Hello Jenkins", page.getContent());
  }
}
