package com.ymatou.uitest.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


public class YmtDriver extends ChromeDriver{
	
	private Capabilities mycapabilities;
	
	public YmtDriver(){
		
	}
	
	
	public YmtDriver(String localserver,String sessionID){
		mystartClient(localserver);
		mystartSession(sessionID);
		// super.setSessionId(sessionID);
	}
	
	protected void mystartClient(String localserver) {
		HttpCommandExecutor delegate = null ;
		
		try {
		   URL driverserver = new URL(localserver);
		   delegate = new HttpCommandExecutor(driverserver);
	       // TODO: use a more intelligent way of testing if the server is ready.
	       delegate.getAddressOfRemoteServer().openConnection().connect();
	       super.setCommandExecutor(delegate);
		   System.out.println("Connect to the existing browser");
		    
	    } catch (Exception e) {
	    	System.out.println("Browser is not Exist");
	    }
	}
	    


	  @Override
	  protected void startClient() {
		  
		  // Do nothing
	  }
	  	  
	  protected void mystartSession(String sessionID) {
		  
		  if(!sessionID.isEmpty()){
			    super.setSessionId(sessionID);
			    }
	    
	    Command command = new Command(super.getSessionId(), DriverCommand.GET_CAPABILITIES);

	    Response response;
		try {
			response = super.getCommandExecutor().execute(command);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Can't use this Session");
			return;
		}

	    @SuppressWarnings("unchecked")
		Map<String, Object> rawCapabilities = (Map<String, Object>) response.getValue();
	    DesiredCapabilities returnedCapabilities = (DesiredCapabilities) super.getCapabilities();
	    if(returnedCapabilities == null){

	    	returnedCapabilities = new DesiredCapabilities();
	    }
	    for (Map.Entry<String, Object> entry : rawCapabilities.entrySet()) {
	      // Handle the platform later
	      if (CapabilityType.PLATFORM.equals(entry.getKey())) {
	        continue;
	      }
	      returnedCapabilities.setCapability(entry.getKey(), entry.getValue());
	    }
	    String platformString = (String) rawCapabilities.get(CapabilityType.PLATFORM);
	    Platform platform;
	    try {
	      if (platformString == null || "".equals(platformString)) {
	        platform = Platform.ANY;
	      } else {
	        platform = Platform.valueOf(platformString);
	      }
	    } catch (IllegalArgumentException e) {
	      // The server probably responded with a name matching the os.name
	      // system property. Try to recover and parse this.
	      platform = Platform.extractFromSysProperty(platformString);
	    }
	    returnedCapabilities.setPlatform(platform);
	    
	   this.mycapabilities = returnedCapabilities;	    

	  }
	  
	  @Override
	  protected void startSession(Capabilities desiredCapabilities,Capabilities requiredCapabilities) {
		  // Do Nothing
	  }
	  
	  @Override
	  public void quit() {
		    try {
		      execute(DriverCommand.QUIT);
		    } catch(Exception e) {
		      e.printStackTrace();
		    }
		  }
	  
	  public Capabilities getCapabilities() {
		    return mycapabilities;
		  }
	  
	  @Override
	  public Object executeScript(String script, Object... args) {
		    if (!mycapabilities.isJavascriptEnabled()) {
		      throw new UnsupportedOperationException(
		          "You must be using an underlying instance of WebDriver that supports executing javascript");
		    }

		    // Escape the quote marks
		    script = script.replaceAll("\"", "\\\"");

		    Iterable<Object> convertedArgs = Iterables.transform(
		        Lists.newArrayList(args), new WebElementToJsonConverter());

		    Map<String, ?> params = ImmutableMap.of(
		        "script", script,
		        "args", Lists.newArrayList(convertedArgs));

		    return execute(DriverCommand.EXECUTE_SCRIPT, params).getValue();
		  }
	  
	  @Override
	  public Object executeAsyncScript(String script, Object... args) {
		    if (!mycapabilities.isJavascriptEnabled()) {
		      throw new UnsupportedOperationException("You must be using an underlying instance of " +
		          "WebDriver that supports executing javascript");
		    }

		    // Escape the quote marks
		    script = script.replaceAll("\"", "\\\"");

		    Iterable<Object> convertedArgs = Iterables.transform(
		        Lists.newArrayList(args), new WebElementToJsonConverter());

		    Map<String, ?> params = ImmutableMap.of(
		        "script", script, "args", Lists.newArrayList(convertedArgs));

		    return execute(DriverCommand.EXECUTE_ASYNC_SCRIPT, params).getValue();
		  }

	
}
