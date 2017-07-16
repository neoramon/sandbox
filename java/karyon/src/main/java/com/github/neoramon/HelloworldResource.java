package com.github.neoramon;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

@Singleton
@Path("/hello")
public class HelloworldResource {

  private static final Logger logger = LoggerFactory.getLogger(HelloworldResource.class);

  @Path("to/{name}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response helloTo(@PathParam("name") String name) {
    final JSONObject response = new JSONObject();
    try {
      CommandHelloWorld cmd = new CommandHelloWorld(name);
      Observable<String> sObserver = cmd.observe();
      // Observable<String> s = new CommandHelloWorld(name).observe();
      
      Subscription ss = sObserver.subscribe(new Action1<String>() {
        
      
        
        @Override
        public void call(String s) {
          try {
            response.put("Message", s);
          } catch(JSONException e) {
            throw new RuntimeException("Wow... You got an error...");
          }
        }        
        
      });
      
      
      sObserver.toBlocking().first();
      
      return Response.ok(response.toString()).build();
      
    } catch(Exception e) {
      logger.error("Error creating json response.", e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @Path("to/person")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response helloToPerson(String name) {
    JSONObject response = new JSONObject();
    try {
      response.put("Message", "Hello " + name + " from Netflix OSS");
      return Response.ok(response.toString()).build();
    } catch(JSONException e) {
      logger.error("Error creating json response.", e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response hello() {
    JSONObject response = new JSONObject();
    try {
      response.put("Message", "Hello from Netflix OSS");
      return Response.ok(response.toString()).build();
    } catch(JSONException e) {
      logger.error("Error creating json response.", e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }
}
