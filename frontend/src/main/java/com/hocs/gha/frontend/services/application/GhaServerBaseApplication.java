/**
 * 
 */
package com.hocs.gha.frontend.services.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Emilio
 * 
 */
@ApplicationPath("/services/")
public class GhaServerBaseApplication extends Application {
	/** */
	public static final String AUTH_SERVICE_PATH = "auth";
	/** */
	public static final String WORKING_AREA_SERVICE_PATH = "workingarea";
	/** */
	public static final String INSTITUTION_SERVICE_PATH = "institution";
	/** */
	public static final String ESS_SERVICE_PATH = "ess";
	/** */
	public static final String GOM_SERVICE_PATH = "gom";
}
