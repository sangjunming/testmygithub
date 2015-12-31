package cn.huntlaw.lawchat.plugin;

import java.io.File;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.server.http.XFireHttpServer;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.service.invoker.BeanInvoker;
import org.jivesoftware.openfire.XMPPServer;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




import cn.huntlaw.lawchat.plugin.service.ExtUserService;
import cn.huntlaw.lawchat.plugin.session.HibernateSessionFactory;
import cn.huntlaw.lawchat.plugin.soapws.SoapWebService;
import cn.huntlaw.lawchat.plugin.soapws.SoapWebServiceImpl;
import cn.huntlaw.lawchat.plugin.utils.Utils;


public class PluginMain implements Plugin {
	
	Logger logger = LoggerFactory.getLogger(PluginMain.class);
	private XMPPServer server;
	XFireHttpServer xfireserver;
    
    public void initializePlugin(PluginManager manager, File pluginDirectory) {
        server = XMPPServer.getInstance();
        
        logger.info("......start ext. pluginmain");
        //temp comment hibernate
        //HibernateSessionFactory.getConfiguration();
        startSoapWebSvc();
        System.out.println("Plugin launched ok");
        
    }
    

    //启动webservice
	private boolean startSoapWebSvc(){
    	
    	ObjectServiceFactory servicefactory;
    	Service service;
    	XFire xfire;
    	
    	servicefactory = new ObjectServiceFactory();
    	service = servicefactory.create(SoapWebService.class);
    	service.setInvoker(new BeanInvoker(new SoapWebServiceImpl()));
    	xfire = XFireFactory.newInstance().getXFire();
    	xfire.getServiceRegistry().register(service);
    	xfireserver = new XFireHttpServer();
    	xfireserver.setPort(8191);
    	
		try {
			xfireserver.start();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }

    
    public void destroyPlugin() {
    	//close xfire 
		if(xfireserver != null)
		{
			try {
				xfireserver.stop();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
    	
    	//close hibernate session
//    	HibernateSessionFactory.closeSession();
        System.out.println("destroy plugin and other sessions");
    }
    
        
    
}